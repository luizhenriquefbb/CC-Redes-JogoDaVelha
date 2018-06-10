/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/**
 *
 * @author Alisson
 */
public class HandleJSON {

    public static Map<String, Object> jsonToMap(org.json.JSONObject json) throws org.json.JSONException {

        Map<String, Object> retMap = new HashMap<String, Object>();

        if (json != org.json.JSONObject.NULL) {
            retMap = toMap(json);
        }
        return retMap;
    }

    public static Map<String, Object> toMap(org.json.JSONObject object) throws org.json.JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while (keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if (value instanceof org.json.JSONArray) {
                value = toList((org.json.JSONArray) value);
            } else if (value instanceof org.json.JSONObject) {
                value = toMap((org.json.JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    public static List<Object> toList(org.json.JSONArray array) throws org.json.JSONException {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof org.json.JSONArray) {
                value = toList((org.json.JSONArray) value);
            } else if (value instanceof org.json.JSONObject) {
                value = toMap((org.json.JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }
    
    public static Map<String, Object> jsonToMap(String str) throws org.json.JSONException{
        return jsonToMap(new JSONObject(str.replaceAll("=", ":")));
    }

}
