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
        int i = ejb.getJSONValue("int",0);//or ESON.getJSONValue(obj,"int",0);
        System.out.println(i);
        long l = ejb.getJSONValue("long",0L);//or ESON.getJSONValue(obj,"long",0L);
        System.out.println(l);
        double d = ejb.getJSONValue("double",0D);//or ESON.getJSONValue(obj,"double",0D);
        System.out.println(d);
        float f = ejb.getJSONValue("double",0f);//or ESON.getJSONValue(obj,"double",0f);
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

        System.out.println();//toInteger
        for(int i=0,ni= eArr.length();i<ni;++i){
            System.out.println(eArr.getArrayValue(i,1));
        }
```
##### 示例代码输出
```
jArr equals eArr ? true
["11111111111111111111111111111",2.2,3333333333333,4444,5.555555555555]

11111111111111111111111111111
2.2
3333333333333
4444
5.555555555555

11111111111111111111111111111
2.2
3333333333333
4444
5.555555555555

1
1
1
4444
1
```
## 其他
## Others
```
ESON.setDebugable(true);//print the ESON Exception default false  打印ESON异常日志 默认false
```
