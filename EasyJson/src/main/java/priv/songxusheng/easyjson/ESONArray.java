package priv.songxusheng.easyjson;

import android.util.Log;

import org.json.JSONArray;

import java.util.Collection;

public class ESONArray extends JSONArray {
    public ESONArray(){
        super();
    }

    public ESONArray(Collection copyFrom){
        super(copyFrom);
    }

    public ESONArray(Object object){
        super();
        JSONArray array = ESON.getJSONArray(object);
        for(int i=0,ni=array.length();i<ni;++i){
            put(ESON.getArrayValue(array,i,new Object()));
        }
    }

    public <T> T getArrayValue(int index, T defaultValue){
        return ESON.getArrayValue(this,index,defaultValue);
    }

    public <T> ESONArray putValue(T obj){
        put(obj);
        return this;
    }

    public <T> ESONArray putValue(int index, T obj){
        try { put(index,obj); } catch (Exception e) {
            if(ESON.isDebug){
                Log.e("ESONArray","putValue()->"+e.getMessage());
            }
        }
        return this;
    }

    public static final ESONArray getESONArray(Object obj){
        return new ESONArray(obj);
    }
}
