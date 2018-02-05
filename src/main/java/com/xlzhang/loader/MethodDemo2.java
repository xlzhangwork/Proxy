package com.xlzhang.loader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Author: xlzhang
 * @Description:
 * @Date: Created in 11:14 2018/2/2
 * @Modified By:
 **/
public class MethodDemo2 {
    public static void main(String args[]){
        ArrayList list = new ArrayList();

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("Hello");
        //list1.add(20);这个是错误的
        Class c1 = list.getClass();
        Class c2 = list1.getClass();
        /*c1和c2是相等的，这说明编译之后（也就是运行时）集合的泛型是去泛型化的，虽然c2限定了String，但是依旧和c1相等
         * java中集合的泛型是防止错误输入的，只在编译阶段有效，绕过编译就无效了
         * 验证：我们可以通过方法的反射绕过编译来操作
         * 反射操作都是编译之后的操作，也就是运行时的操作
        */
        System.out.println(c1 == c2);
        try {
            Method m1 = c1.getMethod("add",Object.class);
            Method m2 = c2.getMethod("add",Object.class);
            m1.invoke(list,20);
            m1.invoke(list,"Hello1");
            m2.invoke(list1,10);//绕过了编译操作就绕过了泛型
            m2.invoke(list1,"Hello2");
            System.out.println(list.size());
            System.out.println(list1.size());
            System.out.println(list1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
