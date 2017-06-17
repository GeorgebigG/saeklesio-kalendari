package com.sitename.android.saeklesiokalendari.Internet;

import android.os.AsyncTask;
import android.support.annotation.Nullable;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetJsonData extends AsyncTask<Void, Void, JSONObject> {

    String url;
    JSONObject jsonObject;

    public GetJsonData(String url, @Nullable JSONObject jsonObject)
    {
        this.url = url;
        this.jsonObject = jsonObject;
    }

    @Override
    protected JSONObject doInBackground(Void... params)
    {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        StringBuffer buffer = new StringBuffer();
        JSONObject json = null;

        try
        {
            URL url = new URL(this.url);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            json = new JSONObject(buffer.toString());

        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            if (connection != null)
                connection.disconnect();
            if (reader != null)
                try
                {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        return json;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject)
    {
        super.onPostExecute(jsonObject);
        this.jsonObject = jsonObject;
    }
}