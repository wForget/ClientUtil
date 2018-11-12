package cn.wangz.clientutil.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 * Created by hadoop on 2018/11/9.
 */
public class MongoServer {
    private static MongoClient client = null;

    static {
        client = new MongoClient(MongoConf.serverAddress);
    }

    public static MongoClient getClient() {
        return client;
    }

    public static MongoCollection<Document> getCollection(String db, String col) {
        return client.getDatabase(db).getCollection(col);
    }
}
