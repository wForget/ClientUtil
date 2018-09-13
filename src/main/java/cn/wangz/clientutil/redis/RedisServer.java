package cn.wangz.clientutil.redis;

import cn.wangz.clientutil.util.ExceptionUtil;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

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

    public static void subscribe(JedisPubSub jedisPubSub, String... channels) {
        try (Jedis jedis = getJedis()) {
            jedis.subscribe(jedisPubSub, channels);
        } catch (Exception e) {
            String msg = ExceptionUtil.stackTraceMsg(e);
            logger.error(msg);
        }
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
