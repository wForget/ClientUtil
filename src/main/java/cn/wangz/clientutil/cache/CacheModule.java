package cn.wangz.clientutil.cache;

import cn.wangz.clientutil.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 缓存在内存中
 */
public class CacheModule {

    private static final Logger logger = LoggerFactory.getLogger(CacheModule.class);

    /**
     * @param key 唯一标识
     * @param interval 过期时间
     * @param callable 过期调用 callable
     * @return
     */
    public Object get(String key, long interval, Callable callable) {
        CacheItem item = CACHE_MAP.get(key);
        if (item == null) {
            synchronized (CACHE_MAP) {
                if (!CACHE_MAP.containsKey(key)) {
                    item = new CacheItem();
                    CACHE_MAP.put(key, item);
                }
            }
        }
        if (System.currentTimeMillis() - item.getTime() > interval) { // 超时更新
            if (item.getSemaphore().getAndDecrement() == 1) {
                item.setTime(System.currentTimeMillis());
                Object value = null;
                try {
                    value = callable.call();
                } catch (Exception e) {
                    String msg = ExceptionUtil.stackTraceMsg(e);
                    logger.error("CacheModule callable call error, msg: {}", msg);
                }
                if (value != null) {
                    item.setValue(value);
                }
                item.getSemaphore().set(1);
            }
        }
        return item.getValue();
    }

    private static Map<String, CacheItem> CACHE_MAP = new ConcurrentHashMap<>();

    static class CacheItem {
        private Long time = 0L;
        private AtomicInteger semaphore = new AtomicInteger(1);
        private Object value = null;

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }

        public AtomicInteger getSemaphore() {
            return semaphore;
        }

        public void setSemaphore(AtomicInteger semaphore) {
            this.semaphore = semaphore;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}
