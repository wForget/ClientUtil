package cn.wangz.clientutil.kafka;

import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * Created by hadoop on 2018/9/13.
 */
public class KafkaProducerHelper {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerHelper.class);

    private Producer<String, String> producer = null;

    private final Properties props = new Properties();

    private static KafkaProducerHelper producerInstance = null;

    public static KafkaProducerHelper getInstance(){
        if (producerInstance == null){
            synchronized (KafkaProducerHelper.class){
                if (producerInstance == null){
                    producerInstance = new KafkaProducerHelper();
                }
            }
        }

        return producerInstance;
    }

    /**
     * 获取Producer，直接调用其send方法向kafka发送数据，在代码中指定topic
     * @return
     */
    public Producer<String, String> getProducer() {
        return producer;
    }

    public Future<RecordMetadata> send(String topic, String key, String value){
        if (producer == null){
            logger.error("The producer object is null.");
            throw new NullPointerException("The producer object is null.");
        }
        if (topic == null || topic.length() < 1) {
            logger.error("the topic is invalid, null or empty string.");
            throw new IllegalArgumentException("the topic is invalid, null or empty string.");
        }
        return producer.send(new ProducerRecord<>(topic, key, value));
    }

    public Future<RecordMetadata> send(String topic, String key, String value, Callback callback){
        if (producer == null){
            logger.error("The producer object is null.");
            throw new NullPointerException("The producer object is null.");
        }
        if (topic == null || topic.length() < 1) {
            logger.error("the topic is invalid, null or empty string.");
            throw new IllegalArgumentException("the topic is invalid, null or empty string.");
        }
        return producer.send(new ProducerRecord<>(topic, key, value),callback);
    }

    public void close(){
        producer.flush();
        if (producer != null){
            producer.close();
        }
    }

    private KafkaProducerHelper(){

        props.put("bootstrap.servers", KafkaProducerConf.bootstrapServers);
        props.put("acks", KafkaProducerConf.acks);
        props.put("retries", KafkaProducerConf.retries);
        props.put("batch.size", KafkaProducerConf.batchSize);
        props.put("linger.ms", KafkaProducerConf.lingerMs);
        props.put("buffer.memory", KafkaProducerConf.bufferMemory);
        props.put("max.request.size", KafkaProducerConf.maxRequestSize);
        props.put("compression.type", KafkaProducerConf.compressionType);
        props.put("key.serializer", KafkaProducerConf.keySerializer);
        props.put("value.serializer", KafkaProducerConf.valueSerializer);

        producer = new KafkaProducer<>(props);
    }
}
