package cn.wangz.clientutil.kafka;

import cn.wangz.clientutil.conf.BaseConf;

/**
 * Created by hadoop on 2018/9/13.
 */
public class KafkaConsumerConf extends BaseConf {

	public static String bootstrapServers = conf.getString("consumer.bootstrap.servers");

	public static String enableAutoCommit = conf.getString("consumer.enable.auto.commit");

	public static String autoCommitIntervalMs = conf.getString("consumer.auto.commit.interval.ms");

	public static String sessionTimeoutMs = conf.getString("consumer.session.timeout.ms");

	public static String autoOffsetReset = conf.getString("consumer.auto.offset.reset");

	public static String keyDeserializer = conf.getString("consumer.key.deserializer");

	public static String valueDeserializer = conf.getString("consumer.value.deserializer");

}
