package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import pojo.person;
import pojo.typeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class jsonTest extends TypeToken<HashMap<Integer,person>> {
    //JavaBean和json的互转
    @Test
    public void test1(){
        person person = new person(1,"hhj1");
        System.out.println(person);
        //创建Gson对象实例
        Gson gson = new Gson();
        //把Java对象转化为json字符串
        String personJson = gson.toJson(person);
        System.out.println(personJson);
        //把json字符串转化为Java对象  json字符串  转换回去的Java对象类型
        pojo.person person1 = gson.fromJson(personJson, pojo.person.class);
        System.out.println(person1);
    }

    //list集合和json互转
    @Test
    public void test2(){
       List<person> list = new ArrayList<>();
       list.add(new person(2,"hhj2"));
       list.add(new person(3,"hhj3"));
       list.add(new person(4,"hhj4"));
       list.add(new person(5,"hhj5"));

        Gson gson = new Gson();
        String s = gson.toJson(list);
        System.out.println(s);

        /*要写一个类继承TypeToken,在<>里传入你要转换的类型,
        * 调用fromJson方法传入new 那个类的getType()方法
        * 这里以typeList类做演示*/
        List<person> list1 = gson.fromJson(s, new typeList().getType());
        System.out.println(list1);
        System.out.println(list1.get(0));
    }

    //map和json的互转
    @Test
    public void test3(){
        HashMap<Integer, person> personMap = new HashMap<>();

        personMap.put(1,new person(1,"hhj1"));
        personMap.put(2,new person(2,"hhj2"));
        personMap.put(3,new person(3,"hhj3"));

        Gson gson = new Gson();
        String s = gson.toJson(personMap);
        System.out.println(s);

//        HashMap<Integer,person> map = gson.fromJson(s, new jsonTest().getType());
//        System.out.println(map.get(1));

        //使用匿名内部类的方式转换
        HashMap<Integer,person> map = gson.fromJson(s,new TypeToken<HashMap<Integer,person>>(){}.getType());
        System.out.println(map.get(2));
    }
}
