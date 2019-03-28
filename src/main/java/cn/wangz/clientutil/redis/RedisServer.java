package cn.wangz.clientutil.redis;

import cn.wangz.clientutil.util.ExceptionUtil;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

import java.util.Collections;
import java.util.UUID;

/**
 * Created by hadoop on 2018/6/4.
 */
public class RedisServer {
    private static final Logger logger = Logger.getLogger(RedisServer.class);

    private static JedisPool jedisPool = null;
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(JRedisPoolConf.MAX_ACTIVE);
        config.setMaxIdle(JRedisPoolConf.MAX_IDLE);
        config.setMaxWaitMillis(JRedisPoolConf.MAX_WAIT);
        config.setTestOnBorrow(JRedisPoolConf.TEST_ON_BORROW);
        config.setTestOnReturn(JRedisPoolConf.TEST_ON_RETURN);

        jedisPool = new JedisPool(config, JRedisPoolConf.REDIS_IP
                , JRedisPoolConf.REDIS_PORT, JRedisPoolConf.TIMEOUT, null, JRedisPoolConf.REDIS_DATABASE);
    }

    public static JedisPool getJedisPool() {
        return jedisPool;
    }

    private static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static String get(String key) {
        String result = null;
        try (Jedis jedis = getJedis()) {
            result = jedis.get(key);
        } catch (Exception e) {
            String msg = ExceptionUtil.stackTraceMsg(e);
            logger.error(msg);
        }
        return result;
    }

    public static String getset(String key, String value) {
        String result = null;
        try (Jedis jedis = getJedis()) {
            result = jedis.getSet(key, value);
        } catch (Exception e) {
            String msg = ExceptionUtil.stackTraceMsg(e);
            logger.error(msg);
        }
        return result;
    }

    public static String set(String key, String value) {
        String result = null;
        try (Jedis jedis = getJedis()) {
            result = jedis.set(key, value);
        } catch (Exception e) {
            String msg = ExceptionUtil.stackTraceMsg(e);
            logger.error(msg);
        }
        return result;
    }

    public static long del(String... keys) {
        long result = 0L;
        try (Jedis jedis = getJedis()) {
            result = jedis.del(keys);
        } catch (Exception e) {
            String msg = ExceptionUtil.stackTraceMsg(e);
            logger.error(msg);
        }
        return result;
    }

    public static String mset(String[] keyvalues) {
        String result = null;
        try (Jedis jedis = getJedis()) {
            result = jedis.mset(keyvalues);
        } catch (Exception e) {
            String msg = ExceptionUtil.stackTraceMsg(e);
            logger.error(msg);
        }
        return result;
    }

    public static long decrby(String key, long value) {
        long result = 0L;
        try (Jedis jedis = getJedis()) {
            result = jedis.decrBy(key, value);
        } catch (Exception e) {
            String msg = ExceptionUtil.stackTraceMsg(e);
            logger.error(msg);
        }
        return result;
    }

    // 订阅方法会阻塞线程，需要开启新的线程进行订阅
    public static void subscribe(JedisPubSub jedisPubSub, String... channels) {
        try (Jedis jedis = getJedis()) {
            jedis.subscribe(jedisPubSub, channels);
        } catch (Exception e) {
            String msg = ExceptionUtil.stackTraceMsg(e);
            logger.error(msg);
        }
    }

    /**
     * 获取 分布式锁
     * @param lockName  锁的 key
     * @return 成功时返回一个随机生成的id，为了正确的释放锁，失败时返回 null
     */
    public static String getLock(String lockName) {
        String result = null;
        try (Jedis jedis = getJedis()) {
            String randomId = UUID.randomUUID().toString();
            // EX seconds – 设置键key的过期时间，单位时秒。PX milliseconds – 设置键key的过期时间，单位时毫秒。NX – 只有键key不存在的时候才会设置key的值。XX – 只有键key存在的时候才会设置key的值
            String status =  jedis.set(lockName, randomId, "nx", "px", 10000);    // 10s 过期时间
            if ("OK".equals(status)) {
                result = randomId;
            }
        } catch (Exception e) {
            String msg = ExceptionUtil.stackTraceMsg(e);
            logger.error(msg);
        }
        return result;
    }

    /**
     * 释放锁
     * @param lockName 锁的名称
     * @param randomId 获取锁时返回的的id
     * @return
     */
    public static boolean releaseLock(String lockName, String randomId) {
        boolean result = false;
        // Lua 脚本
        String script = "if redis.call(\"get\",KEYS[1]) == ARGV[1] then\n" +
                        "    return redis.call(\"del\",KEYS[1])\n" +
                        "else\n" +
                        "    return 0\n" +
                        "end";
        try (Jedis jedis = getJedis()) {
            Long status = (Long) jedis.eval(script, Collections.singletonList(lockName), Collections.singletonList(randomId));
            if (status.longValue() == 1L) {
                result = true;
            }
        } catch (Exception e) {
            String msg = ExceptionUtil.stackTraceMsg(e);
            logger.error(msg);
        }
        return result;
    }

    public static void close() {
        if (jedisPool != null) {
            jedisPool.close();
        }
    }

    public void test() {
        try (Jedis jedis = getJedis()) {

        } catch (Exception e) {
            String msg = ExceptionUtil.stackTraceMsg(e);
            logger.error(msg);
        }
    }
}
