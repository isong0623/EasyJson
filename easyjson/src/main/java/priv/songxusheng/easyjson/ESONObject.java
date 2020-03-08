package priv.songxusheng.easyjson;

import android.util.Log;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ESONObject extends JSONObject {

    public ESONObject(){
        super();
    }

    public ESONObject(Object obj){
        super(_init(obj));
    }

    private final static Map<?,?> _init(Object obj){
        JSONObject jsonObject = ESON.getJSONObject(obj);
        try {
            Field nameValuePairs = JSONObject.class.getDeclaredField("nameValuePairs");
            nameValuePairs.setAccessible(true);
            return (LinkedHashMap<String, Object>)nameValuePairs.get(jsonObject);
        } catch (Exception e) {
            if(ESON.isDebug){
                Log.e("ESONObject","_init0()->"+e.getMessage());
            }
        }

        try {
            Field nameValuePairs = JSONObject.class.getDeclaredField("map");
            nameValuePairs.setAccessible(true);
            return (Map<String, Object>)nameValuePairs.get(jsonObject);
        } catch (Exception e) {
            if(ESON.isDebug){
                Log.e("ESONObject","_init1()->"+e.getMessage());
            }
        }

        try {
            LinkedHashMap<String, Object> ret = new LinkedHashMap<String, Object>();
            Iterator<String> it = jsonObject.keys();
            while(it.hasNext()){
                String key  = it.next();
                ret.put(key, ESON.getJSONValue(jsonObject,key,new Object()));
            }
            return ret;
        } catch (Exception e) {
            if(ESON.isDebug){
                Log.e("ESONObject","_init2()->"+e.getMessage());
            }
        }
        return new LinkedHashMap<String, Object>();
    }

    public final <T> T getJSONValue(final String key,final T defaultValue){
        return ESON.getJSONValue(this,key,defaultValue);
    }

    public final <T> ESONObject putValue(final String key,T value){
        try { put(key,value); } catch (Exception e){
            if(ESON.isDebug){
                Log.e("ESONObject","putValue()->"+e.getMessage());
            }
        }
        return this;
    }

    public static final ESONObject getESONObject(Object obj){
        return new ESONObject(obj);
    }
}