package cn.wangz.clientutil.redis.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by hadoop on 2018/11/6.
 */
public class PubsubDemo {

    private final String ip;
    private final int port;
    private final String channel;
    private final JedisPool jedisPool;

    public PubsubDemo(String ip, int port, String channel) {
        this.ip = ip;
        this.port = port;
        this.channel = channel;
        JedisPoolConfig config = new JedisPoolConfig();
        jedisPool = new JedisPool(config, ip, port);    // 初始化JedisPool
    }

    /**
     * Subscribe 订阅线程
     * 订阅 channel，并打印接收到的消息
     */
    class Subscribe implements Runnable {

        @Override
        public void run() {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.subscribe(new JedisPubSub() {
                    @Override
                    public void onMessage(String channel, String message) {
                        System.out.println("receive message[ channel: " + channel + ", message: " + message + "]");
                    }
                }, channel);
            } finally {
                if (jedis != null) {
                    jedis.close();
                }
            }
        }
    }

    /**
     * Publish 发布线程
     * 向 channel 中每秒发送一个递增的数
     */
    class Publish implements Runnable {

        @Override
        public void run() {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                int i = 0;
                while (true) {
                    jedis.publish(channel, String.valueOf(i++));
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (jedis != null) {
                    jedis.close();
                }
            }
        }
    }

    // 启动方法
    public void run() throws Exception {
        // 启动一个 Subscribe 订阅线程
        Thread subscribeThread = new Thread(new Subscribe(), "SubscribeThread");
        subscribeThread.start();

        // 启动一个 Publish 发布线程
        Thread publishThread = new Thread(new Publish(), "PublishThread");
        publishThread.start();

        publishThread.join();
        subscribeThread.join();
    }


    public static void main(String[] args) throws Exception {
        final String ip = "192.168.1.153";
        final int port = 6380;
        final String channel = "testChannel";

        PubsubDemo pubsub = new PubsubDemo(ip, port, channel);
        pubsub.run();
    }
}
