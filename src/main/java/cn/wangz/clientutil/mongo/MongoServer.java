package cn.wangz.clientutil.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;

/**
 * Created by hadoop on 2018/11/9.
 */
public class MongoServer {
    private static MongoClient client = null;

    static {
        client = new MongoClient(MongoConf.SERVER_ADDRESS);
//        client = new MongoClient(MongoConf.SERVER_ADDRESS
//                , MongoCredential.createCredential("username", "admin", "password".toCharArray())
//                , new MongoClientOptions.Builder().build());
    }

    public static MongoClient getClient() {
        return client;
    }

    public static MongoCollection<Document> getCollection(String db, String col) {
        return client.getDatabase(db).getCollection(col);
    }

    public static final UpdateOptions UPSERT_OPTIONS = new UpdateOptions();
    public static final BulkWriteOptions BULK_WRITE_OPTIONS = new BulkWriteOptions();
    static {
        UPSERT_OPTIONS.upsert(true);
        BULK_WRITE_OPTIONS.ordered(false);
    }

    public static void close() {
        if (client != null) {
            client.close();
        }
    }
}
