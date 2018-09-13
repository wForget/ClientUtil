package cn.wangz.clientutil.elasticsearch;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/5.
 */
public class ElasticSearchUtil {
    private static TransportClient client = null;

    private String index = null;
    private String type = null;

    static {
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch")
                .build();
        try {
            client = new PreBuiltTransportClient(settings);
            List<Map> list = ElasticSearchProperty.transportAddressList;
            for (Map<String, Object> addr : list) {
                client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName((String) addr.get("host")), (Integer) addr.get("port")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ElasticSearchUtil(String index, String type) {
        this.index = index;
        this.type = type;
    }

    public void close() {
        if (client != null) {
            client.close();
        }
    }

    public IndexResponse index(String id, Map source) {
        return client.prepareIndex(index, type, id).setSource(source).get();
    }

    public IndexResponse indexByRoute(String route,String id, Map source) {
        return client.prepareIndex(index, type, id).setSource(source).setRouting(route).get();
    }

    public GetResponse get(String id) {
        return client.prepareGet(index, type, id)
                .setOperationThreaded(false)    //operationThreaded这个选项是使这个操作在另外一个线程中执行，或在一个正在请求的线程，也就是异步执行
                .get();
    }

    public DeleteResponse deleteById(String id) {
        return client.prepareDelete(index, type, id).get();
    }

    public UpdateResponse update(String id, Map source) {
//        UpdateRequest updateRequest = new UpdateRequest(index, type, id).doc(source);
//        client.update(updateRequest).get();
        return client.prepareUpdate(index, type, id).setDoc(source).get();
    }

    public UpdateResponse upsert(String id, Map indexSource, Map updateSource) {
//        IndexRequest indexRequest = new IndexRequest(index, type, id).source(indexSource);
//        UpdateRequest updateRequest = new UpdateRequest(index, type, id)
//                .doc(updateSource)
//                .upsert(indexRequest);
//        client.update(updateRequest).get();

       return client.prepareUpdate(index, type, id).setDoc(updateSource).setUpsert(indexSource).get();
    }

    public static void main(String[] args) {
        ElasticSearchUtil elasticSearchUtil = new ElasticSearchUtil("megacorp", "employee");
        System.out.println(elasticSearchUtil.get("1").getSourceAsString());
//        Map updateMap = new HashMap();
//        updateMap.put("age", 30);
//        elasticSearchUtil.update("1", updateMap);
//        System.out.println(elasticSearchUtil.get("1").getSourceAsString());
//
//        Map indexMap = new HashMap();
//        indexMap.put("age", 20);
//        Map updateMap = new HashMap();
//        updateMap.put("age", 40);
//        elasticSearchUtil.upsert("1", indexMap, updateMap);
//        System.out.println(elasticSearchUtil.get("1").getSourceAsString());
//
//        elasticSearchUtil.deleteById("4");
    }

}
