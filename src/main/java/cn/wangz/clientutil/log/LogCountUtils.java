package cn.wangz.clientutil.log;

import cn.wangz.clientutil.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by hadoop on 2019/3/20.
 * 日志计数 并发送到 phoenix 中
 */
public class LogCountUtils {

    private final static Logger logger = LoggerFactory.getLogger(LogCountUtils.class);

    private static final Map<LogCountKey, AtomicLong> COUNT_MAP;
    private static final int maximumSize = 24;
    static {
        COUNT_MAP = new LinkedHashMap<LogCountKey, AtomicLong>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maximumSize;
            }
        };
    }

    public static long addAndGet(String logType, String countType, int timestamp, long value) {
        LogCountKey key = new LogCountKey(logType, countType, timestamp);
        if (!COUNT_MAP.containsKey(key)) {
            synchronized (COUNT_MAP) {
                if (!COUNT_MAP.containsKey(key)) {
                    COUNT_MAP.put(key, new AtomicLong(0L));
                }
            }
        }
        return COUNT_MAP.get(key).addAndGet(value);
    }

    private static Timer sendTimer;
    private static long period = 1800000;   // 半小时执行一次
    public static void init() {
        if (sendTimer == null) {
            synchronized (sendTimer) {
                if (sendTimer == null) {
                    sendTimer = new Timer("SendTimer");
                    sendTimer.schedule(new SendTimerTask(), period, period);
                }
            }
        }
    }

    public static void destroy() {
        if (sendTimer != null) {
            sendTimer.cancel();
        }
    }

    static class SendTimerTask extends TimerTask {

        @Override
        public void run() {
            Map<LogCountKey, Long> sendMap = new HashMap<>();
            for (Map.Entry<LogCountKey, AtomicLong> entry: COUNT_MAP.entrySet()) {
                long count = entry.getValue().getAndSet(0L);
                if (count > 0) {
                    sendMap.put(entry.getKey(), count);
                }
            }

            Connection connection = null;
            PreparedStatement statement = null;
            try {
                connection = DriverManager.getConnection("jdbc:phoenix:dmp-test01,dmp-test02,dmp-test03:2181");
                statement = connection.prepareStatement(UPSERT_SQL);
                for (Map.Entry<LogCountKey, Long> entry: sendMap.entrySet()) {
                    statement.setObject(1, entry.getKey().getLogType());
                    statement.setObject(2, entry.getKey().getCountType());
                    statement.setObject(3, entry.getKey().getTimestamp());
                    statement.setObject(4, entry.getValue());
                    statement.execute();
                }
                connection.commit();
            } catch (Exception e) {
                logger.error("LogCountUtils SendTimerTask run error, msg: {}", ExceptionUtil.stackTraceMsg(e));
                // 提交失败 把值重新加到 COUNT_MAP 中
                for (Map.Entry<LogCountKey, Long> entry: sendMap.entrySet()) {
                    AtomicLong value = COUNT_MAP.get(entry.getKey());
                    if (value != null) {
                        value.addAndGet(entry.getValue());
                    }
                }
                // rollback
                try {
                    if (connection != null) {
                        connection.rollback();
                    }
                } catch (Exception e1) {
                    logger.error("LogCountUtils SendTimerTask run rollback error, msg: {}", ExceptionUtil.stackTraceMsg(e1));
                }
            } finally {
                // close
                try {
                    if (connection != null) {
                        connection.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                } catch (Exception e) {
                    logger.error("LogCountUtils SendTimerTask run close error, msg: {}", ExceptionUtil.stackTraceMsg(e));
                }
            }
        }
    }
    private static final String UPSERT_SQL= "UPSERT INTO DMP.LOGCOUNT(LOGTYPE, COUNTTYPE, TIMESTAMP, COUNT) VALUES (?, ?, ?, 0) ON DUPLICATE KEY UPDATE COUNT = COUNT + ?";

    static class LogCountKey {
        private String logType;
        private String countType;
        private int timestamp;

        public LogCountKey(String logType, String countType, int timestamp) {
            this.logType = logType;
            this.countType = countType;
            this.timestamp = timestamp;
        }

        public String getLogType() {
            return logType;
        }

        public void setLogType(String logType) {
            this.logType = logType;
        }

        public String getCountType() {
            return countType;
        }

        public void setCountType(String countType) {
            this.countType = countType;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LogCountKey that = (LogCountKey) o;

            if (getTimestamp() != that.getTimestamp()) return false;
            if (!getLogType().equals(that.getLogType())) return false;
            return getCountType().equals(that.getCountType());
        }

        @Override
        public int hashCode() {
            int result = getLogType().hashCode();
            result = 31 * result + getCountType().hashCode();
            result = 31 * result + getTimestamp();
            return result;
        }
    }
}
