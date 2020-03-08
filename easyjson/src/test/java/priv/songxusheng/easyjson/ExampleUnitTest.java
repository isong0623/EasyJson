package priv.songxusheng.easyjson;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static priv.songxusheng.easyjson.ESON.getJSONArray;
import static priv.songxusheng.easyjson.ESON.getJSONObject;

public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        //testObj();
        testArray();
    }

    void testObj(){
        //generate a json object 生成json对象
        String strJson = "{\"a\":[\"1\",\"2\"],\"b\":{\"a\":\"0\"},\"int\":2,\"string\":\"str\",\"long\":12345665498765431,\"double\":45.7565123456}";
        JSONObject obj = getJSONObject(strJson);//ESON.getJSONObject(strJson);
        ESONObject ejb = new ESONObject(strJson);//or ESONObject.getESONObject(strJson);
        //compare obj with ejb 两个对象比较
        System.out.println(String.format("obj is equals ejb :%b",obj.toString().equals(ejb.toString())));
        System.out.println(ejb.toString()+"\n");
        //get the data in ESONObject 从对象中取出数据
        int i = ejb.getJSONValue("int",0);
        System.out.println(i);
        long l = ejb.getJSONValue("long",0L);
        System.out.println(l);
        double d = ejb.getJSONValue("double",0D);
        System.out.println(d);
        float f = ejb.getJSONValue("double",0f);
        System.out.println(f+"\n");
        //insert data 插入数据
        ejb
        .putValue("int2",123456789)
        .putValue("long2",3028903829038290382L)
        .putValue("string2","123456789");
        //search again 取出插入的数据
        System.out.println(ejb.getJSONValue("int2",1));
        System.out.println(ejb.getJSONValue("long2",new Long(0L)));
        System.out.println(ejb.getJSONValue("string2",new String("-"))+"\n");
        //exceptions
        System.out.println(ejb.getJSONValue("int2","1")+"//int -> string");
        System.out.println(ejb.getJSONValue("long2",1)+"//long -> int");
        System.out.println(ejb.getJSONValue("string2",1)+"//string -> int");
    }

    void testArray(){
        String strArray = "[\"11111111111111111111111111111\",2.2,3333333333333,4444,5.555555555555]";
        JSONArray jArr = getJSONArray(strArray);
        ESONArray eArr = new ESONArray(strArray);//or ESON.getJSONArray(strArray);
        System.out.println("jArr equals eArr ? "+eArr.toString().equals(jArr.toString()));
        System.out.println(eArr.toString()+"\n");

        Object objs[] = new Object[]{"1",2.0f,3L,4,5D};//normally value
        for(int i=0,ni= eArr.length();i<ni;++i){
            System.out.println(eArr.getArrayValue(i,objs[i]));
        }

        System.out.println();//toString
        for(int i=0,ni= eArr.length();i<ni;++i){
            System.out.println(eArr.getArrayValue(i,""));
        }

        eArr.putValue("123");
        eArr.putValue(0,"456");

        System.out.println();//toInteger
        for(int i=0,ni= eArr.length();i<ni;++i){
            System.out.println(eArr.getArrayValue(i,1));
        }
    }
}