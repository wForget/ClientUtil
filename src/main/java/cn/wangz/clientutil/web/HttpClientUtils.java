package cn.wangz.clientutil.web;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientUtils {

    public static String postUrl(String url, String body) throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(url);
            if (StringUtils.isNotBlank(body)) {
                StringEntity entity = new StringEntity(body, ContentType.APPLICATION_JSON);
                post.setEntity(entity);
            }
            CloseableHttpResponse response = httpclient.execute(post);

            try {
                int code = response.getStatusLine().getStatusCode();
                if (code != 200) {
                    return null;
                }
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    return EntityUtils.toString(responseEntity);
                } else {
                    return null;
                }
            } finally {
                response.close();
            }
        }
    }

//    public static void main(String[] args) throws Exception {
////        String url = "http://wangzhen.sndodata.com/default/event/addEvent/";
////        String data= "{\"eventName\":\"$pageview\",\"preset\":false,\"showName\":\"$pageview\",\"visible\":true}";
//
//        String url = "http://wangzhen.sndodata.com/default/eventAttr/add/";
//        String data= "{\"attributeName\":\"$is_first_day\",\"dataType\":\"BOOL\",\"eventName\":\"$pageview\",\"preset\":false,\"showName\":\"$is_first_day\",\"visible\":true}";
//        String result = HttpClientUtils.postUrl(url, data);
//        System.out.println(result);
//    }

}
