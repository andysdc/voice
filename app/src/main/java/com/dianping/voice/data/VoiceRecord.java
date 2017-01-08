package com.dianping.voice.data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by wangzhengzi on 16/12/16.
 */

public class VoiceRecord {

    public Answer dialog = new Answer();

    public ArrayList<Shop> records = new ArrayList<>();
    public ArrayList<String> recordStr = new ArrayList<>();

    public void praseJson(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject otherinfo = jsonObject.optJSONObject("otherinfo");
            dialog.answer = otherinfo.optString("dialog");
            JSONArray jsonArray = jsonObject.optJSONArray("records");
            if(jsonArray != null){
                for(int i=0; i<jsonArray.length(); i++){
                    JSONObject obj = jsonArray.getJSONObject(i);
                    Shop shop = new Shop();
                    shop.shopUrl = obj.optString("shopUrl");
                    shop.picUrl = obj.optString("defaultpic");
                    shop._distance_ = obj.optString("_distance_");
                    shop.shopname = obj.optString("shopname");
                    shop.power = obj.optString("shoppower");
                    shop.avgprice = obj.optString("avgprice");
                    records.add(shop);
                }
            }
//            recordStr.add(json);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean hasRecord(){
        return true;
//        return records.size() > 0;
    }

}
