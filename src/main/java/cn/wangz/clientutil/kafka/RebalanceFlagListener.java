package cn.wangz.clientutil.kafka;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by hadoop on 2018/12/11.
 */
public class RebalanceFlagListener implements ConsumerRebalanceListener {
    private static final Logger log = LoggerFactory.getLogger(RebalanceFlagListener.class);
    private AtomicBoolean rebalanceFlag;

    public RebalanceFlagListener(AtomicBoolean rebalanceFlag) {
        this.rebalanceFlag = rebalanceFlag;
    }

    public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
        Iterator iterator = partitions.iterator();

        while(iterator.hasNext()) {
            TopicPartition partition = (TopicPartition) iterator.next();
            log.info("topic {} - partition {} revoked.", partition.topic(), partition.partition());
            this.rebalanceFlag.set(true);
        }

    }

    public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
        Iterator iterator = partitions.iterator();

        while(iterator.hasNext()) {
            TopicPartition partition = (TopicPartition) iterator.next();
            log.info("topic {} - partition {} assigned.", partition.topic(), partition.partition());
        }

    }
}
