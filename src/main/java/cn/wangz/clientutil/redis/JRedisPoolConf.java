package cn.wangz.clientutil.redis;

import cn.wangz.clientutil.conf.BaseConf;

/**
 * Created by hadoop on 2018/6/4.
 */
public class JRedisPoolConf extends BaseConf {
    public static int MAX_ACTIVE = conf.getInt("redis.maxActive");
    public static int MAX_IDLE = conf.getInt("redis.maxIdle");
    public static int MAX_WAIT = conf.getInt("redis.maxWait");
    public static boolean TEST_ON_BORROW = conf.getBoolean("redis.testOnBorrow");
    public static boolean TEST_ON_RETURN = conf.getBoolean("redis.testOnReturn");

    public static String REDIS_IP = conf.getString("redis.ip");
    public static int REDIS_PORT = conf.getInt("redis.port");
    public static int TIMEOUT = conf.getInt("redis.timeout");
    public static int REDIS_DATABASE = conf.getInt("redis.db");
}
