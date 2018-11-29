package cn.wangz.clientutil.elasticsearch;

import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;

import java.net.InetAddress;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/4.
 */
public class ElasticSearchBulkUtil {

    private static TransportClient client = null;
    private static BulkProcessor processor = null;

    private String index = null;
    private String type = null;

    static {
        //需要用户名密码
//        Settings settings = Settings.builder()
//                .put("cluster.name", "elasticsearch")
//                .put("xpack.security.user", "elastic:elastic")
//                .build();

        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch")
                .build();
        try {
            //需要用户名密码
//            client = new PreBuiltXPackTransportClient(settings);
//            List<Map> list = ElasticSearchConf.transportAddressList;
//            for (Map<String, Object> addr : list) {
//                client.addTransportAddress(
//                        new InetSocketTransportAddress(
//                                InetAddress.getByName((String) addr.get("host"))
//                                , (Integer) addr.get("port")));
//            }

            client = new PreBuiltTransportClient(settings);
            List<Map> transportAddressList = ElasticSearchConf.transportAddressList;
            for (int i = 0; i < transportAddressList.size(); i++) {
                client.addTransportAddress(
                        new InetSocketTransportAddress(
                                InetAddress.getByName((String) transportAddressList.get(i).get("host"))
                                , (Integer) transportAddressList.get(i).get("port")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        processor = BulkProcessor.builder(client, new BulkProcessor.Listener() {
            @Override
            public void beforeBulk(long l, BulkRequest bulkRequest) {

            }

            @Override
            public void afterBulk(long l, BulkRequest bulkRequest, BulkResponse bulkResponse) {

            }

            @Override
            public void afterBulk(long l, BulkRequest bulkRequest, Throwable throwable) {

            }
        }).setBulkActions(ElasticSearchConf.bulkActions)
                .setConcurrentRequests(0)
                .setFlushInterval(TimeValue.timeValueSeconds(ElasticSearchConf.flushInterval))
                .build();
    }

    public ElasticSearchBulkUtil(String index, String type) {
        this.index = index;
        this.type = type;
    }

    public void close() {
        if (processor != null) {
            processor.flush();
            processor.close();
        }
        if (client != null) {
            client.close();
        }

    }

    public void index(Map source) {
        processor.add(new IndexRequest(index, type).source(source));
    }

    public void index(String id, Map source) {
        processor.add(new IndexRequest(index, type, id).source(source));
    }

    public void indexByRoute(String route,String id, Map source) {
        processor.add(new IndexRequest(index, type, id).source(source).routing(route));
    }
    public void indexByRouteWithIndex(String route,String id, Map source, String newIndex) {
        processor.add(new IndexRequest(newIndex, type, id).source(source).routing(route));
    }

    public void update(String id, Map source) {
        processor.add(new UpdateRequest(index, type, id).doc(source));
    }

    public void upsert(String id, Map indexSource, Map updateSource) {
        processor.add(new UpdateRequest(index, type, id).doc(updateSource).upsert(indexSource));
    }

    public boolean idExists(String id) {
        return client.prepareGet(index, type, id).get().isExists();
    }
}
