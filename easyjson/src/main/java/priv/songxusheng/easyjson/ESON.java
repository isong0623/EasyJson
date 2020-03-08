package priv.songxusheng.easyjson;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ESON {

    protected static boolean isDebug = false;
    public static void setDebugable(boolean b){
        isDebug = b;
    }

    public static final JSONObject getJSONObject(Object obj){
        if(!obj.getClass().isPrimitive()){
            if(obj instanceof JSONObject){
                return (JSONObject) obj;
            }
            else{
                try { return new JSONObject(String.valueOf(obj)); } catch (Exception e) {
                    if(isDebug){
                        Log.e("ESON","getJSONObject()->"+e.getMessage());
                    }
                }
            }
        }
        return new JSONObject();
    }

    public static final JSONArray getJSONArray(Object obj){
        try {
            if(obj instanceof String){
                String data = String.format("{\"JsonArray\":%s}",obj);
                return getJSONObject(data).getJSONArray("JsonArray");
            }
            return (JSONArray) obj;
        } catch (JSONException e) {
            if(isDebug){
                Log.e("ESON","getJSONArray()->"+e.getMessage());
            }
        }
        return new JSONArray();
    }

    public static final <T> T getJSONValue(Object json,String key,T defaultValue){
        try {
            Object returnValue = getJSONObject(json).get(key);
            if (defaultValue.getClass().isAssignableFrom(returnValue.getClass())) {
                return (T)returnValue;
            }
            if(defaultValue instanceof String){
                return (T) String.valueOf(returnValue);
            }
            Object reflectValue = defaultValue.getClass().getMethod("valueOf",new Class[]{String.class}).invoke(null,String.valueOf(returnValue));
            if (defaultValue.getClass().isAssignableFrom(reflectValue.getClass())){
                return (T) reflectValue;
            }
        } catch (Exception e) {
            if(isDebug){
                Log.e("ESON","getJSONValue()->"+e.getMessage());
            }
        }
        return defaultValue;
    }

    public static final<T> T getArrayValue(Object array,int index, T defaultValue){
        try {
            Object returnValue = getJSONArray(array).get(index);
            if (defaultValue.getClass().isAssignableFrom(returnValue.getClass())) {
                return (T)returnValue;
            }
            if(defaultValue instanceof String){
                return (T) String.valueOf(returnValue);
            }
            Object reflectValue = defaultValue.getClass().getMethod("valueOf",new Class[]{String.class}).invoke(null,String.valueOf(returnValue));
            if (defaultValue.getClass().isAssignableFrom(reflectValue.getClass())){
                return (T) reflectValue;
            }
        } catch (Exception e) {
            if(isDebug){
                Log.e("ESON","getArrayValue()->"+e.getMessage());
            }
        }
        return defaultValue;
    }

}