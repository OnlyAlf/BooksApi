package com.example.alvar.books;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import static com.example.alvar.books.GlobalConstants.CONNECTION_ABORT;


public class NetworkOperations {

    public static String getJsonFromApi(String url) {

        String ret;
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        try {
            HttpResponse response;
            response = client.execute(request);
            ret = EntityUtils.toString(response.getEntity());
        }catch (Exception e){
            e.printStackTrace();
            return CONNECTION_ABORT;
        }

        return ret;
    }

}
