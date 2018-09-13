package cn.wangz.clientutil.kafka;


import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by hadoop on 2018/9/13.
 */
public class KafkaConsumerHelper {

    private static final Logger logger = Logger.getLogger(KafkaConsumerHelper.class);

    private Consumer<String, String> consumer = null;
    private final Properties props = new Properties();

    private List<String> topic = null;

    public Consumer<String, String> getConsumer() {
        return consumer;
    }

    public KafkaConsumerHelper(String toptics, String groupId) {

        props.put("bootstrap.servers", KafkaConsumerConf.bootstrapServers);
        props.put("enable.auto.commit", KafkaConsumerConf.enableAutoCommit);
        props.put("auto.commit.interval.ms", KafkaConsumerConf.autoCommitIntervalMs);
        props.put("session.timeout.ms", KafkaConsumerConf.sessionTimeoutMs);
        props.put("auto.offset.reset", KafkaConsumerConf.autoOffsetReset);
        props.put("key.deserializer", KafkaConsumerConf.keyDeserializer);
        props.put("value.deserializer", KafkaConsumerConf.valueDeserializer);
        props.put("group.id", groupId);

        if (toptics != null && toptics.length() > 0) {
            String[] topticArr = toptics.split(",");
            this.topic = Arrays.asList(topticArr);
        }

        consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(this.topic);
    }

    public ConsumerRecords<String, String> poll() {
        return consumer.poll(100);
    }

    public ConsumerRecords<String, String> poll(long timeOut) {
        return consumer.poll(timeOut);
    }

    public void close(){
        if (consumer != null){
            consumer.wakeup();
            consumer.close();
        }
    }
}
