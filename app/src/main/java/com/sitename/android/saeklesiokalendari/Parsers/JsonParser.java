package com.sitename.android.saeklesiokalendari.Parsers;

import com.sitename.android.saeklesiokalendari.Internet.GetJsonData;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

    String url = "https://restapi.rustaronline.com/v1.00/api/hotels?agentid=test.test&agentpassword=TestP@ssw0rd";
    JSONObject jsonObject = null;

    public JsonParser() {
        GetJsonData data = new GetJsonData(url, jsonObject);
    }
}
