package cn.wangz.clientutil.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by hadoop on 2018/11/29.
 */
public class GsonUtil {

    private static Gson gson = null;
    private static JsonParser jsonParser = null;
    static {
        gson = new Gson();
        jsonParser = new JsonParser();
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public static String toJson(Object object) {

        return gson.toJson(object);
    }

    public static JsonObject parseJsonObject(String jsonStr) {
        return jsonParser.parse(jsonStr).getAsJsonObject();
    }

    public static JsonArray parseJsonArray(String jsonStr) {
        return jsonParser.parse(jsonStr).getAsJsonArray();
    }
}
