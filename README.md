# EasyJson
很容易处理JSONObject&amp;JSONArray的工具。
Easy to process JSONObject&JSONArray.

## 如何使用ESONObject? 
## How To User ESONObject?

##### 示例代码
```
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
```
##### 示例代码输出
```
obj is equals ejb :true
{"a":["1","2"],"b":{"a":"0"},"string":"str","double":45.7565123456,"int":2,"long":12345665498765431}

2
12345665498765431
45.7565123456
45.75651

123456789
3028903829038290382
123456789

123456789//int -> string
1//long -> int
123456789//string -> int
```

## 如何使用ESONArray? 
## How To User ESONArray?

##### 示例代码
```

```
##### 示例代码输出
```

```
