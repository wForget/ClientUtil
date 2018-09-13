package cn.wangz.clientutil.kafka;

import cn.wangz.clientutil.conf.BaseConf;

/**
 * Created by hadoop on 2018/9/13.
 */
public class KafkaProducerConf extends BaseConf {

	public static String bootstrapServers = conf.getString("producer.bootstrap.servers");

	public static String acks = conf.getString("producer.acks");

	public static int retries = Integer.valueOf(conf.getInt("producer.retries"));

	public static int batchSize = Integer.valueOf(conf.getInt("producer.batch.size"));

	public static int lingerMs = Integer.valueOf(conf.getInt("producer.linger.ms"));

	public static long bufferMemory = Long.valueOf(conf.getInt("producer.buffer.memory"));

	public static int maxRequestSize = Integer.valueOf(conf.getInt("producer.max.request.size"));

	public static String compressionType = conf.getString("producer.compression.type");

	public static String keySerializer = conf.getString("producer.key.serializer");

	public static String valueSerializer = conf.getString("producer.value.serializer");

}
