package cn.wangz.clientutil.kudu;

import com.alibaba.fastjson.JSON;
import org.apache.kudu.client.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KuduServer {
    private KuduClient client;
    private KuduSession session;
    private Map<String, KuduTable> tableMap;

    private static KuduServer instance;

    public static KuduServer getInstance() {
        if (instance == null) {
            synchronized (KuduServer.class) {
                if (instance == null) {
                    instance = new KuduServer();
                }
            }
        }
        return instance;
    }

    private KuduServer() {
        client = new KuduClient.KuduClientBuilder(KuduConf.masterAddresses).build();
        session = client.newSession();
        session.setFlushMode(SessionConfiguration.FlushMode.MANUAL_FLUSH);
        session.setTimeoutMillis(KuduConf.timeoutMillis);
        session.setIgnoreAllDuplicateRows(KuduConf.ignoreDuplicateRows);
        session.setMutationBufferSpace(KuduConf.batchSize);
        tableMap = new HashMap<>();
    }

    private void openTable(String tableName) throws KuduException {
        if (!tableMap.containsKey(tableName)) {
            synchronized (this) {
                if (!tableMap.containsKey(tableName)) {
                    KuduTable table = client.openTable(tableName);
                    tableMap.put(tableName, table);
                }
            }
        }
    }

    public void insert(String tableName, Object value) throws Exception {
        openTable(tableName);
        KuduTable table = tableMap.get(tableName);
        List<Operation> operations = JsonKuduOperationsProducer.getInsertOperations(JSON.toJSONString(value), table);
        if (operations == null || operations.isEmpty()) return;
        for (Operation o : operations) {
            session.apply(o);
        }
        List<OperationResponse> responses = session.flush();
        if (responses != null) {
            for (OperationResponse response : responses) {
                if (response.hasRowError()) {
                    throw new Exception("Failed to flush one or more changes. Error: " + response.getRowError().toString());
                }
            }
        }
    }
}
