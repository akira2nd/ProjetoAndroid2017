package com.example.aluno.myapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aluno on 23/03/2017.
 */
public class Connection {

    private final String USER_AGENT = "Mozilla/5.0";

    public List<Book> sendGet() throws Exception {

        String url = "https://jsonblob.com/api/jsonBlob/8a9f0e3f-4153-11e7-ae4c-6b0af4689cfb";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        // add request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //System.out.println(response.toString());
        List<Book> found = findAllItems(new JSONArray(response.toString()));
        return found;
    }

    public List<Book> findAllItems(JSONArray response) {
        List<Book> found = new LinkedList<Book>();
        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject obj = response.getJSONObject(i);
                found.add(new Book(obj.getInt("BOOK"), obj.getInt("LESSON"), obj.getString("INGLES"),obj.getString("PORTUGUES")));
            }
        } catch (JSONException e) {
            // handle exception
        }
        return found;
    }


}
