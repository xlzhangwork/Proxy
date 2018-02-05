package com.xlzhang.loader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: xlzhang
 * @Description:
 * @Date: Created in 10:29 2018/2/2
 * @Modified By:
 **/
public class MethodDemo1 {
    public static void main(String args[]){
        A a = new A();
        Class c = a.getClass();
        /*
         * 获取方法，名称和参数列表决定方法
         * getMethod获取的是public方法
         * getDeclaredMethods自己声明的方法
         */
        try {
            //Method m = c.getMethod("print",new Class[]{int.class,int.class});
            Method m = c.getMethod("print",int.class,int.class);
            //方法的反射操作使用m对象来进行方法的调用 和a.print调用的效果完全相同
            //a.print(10,20);
            //方法如果没有返回值返回null，有返回值返回具体返回值
            //Object obj = m.invoke(a,10,20);
            Object obj = m.invoke(a,new Object[]{10,20});
            System.out.println("===============================");
            //获取方法对象
            Method m1 = c.getMethod("print",new Class[]{String.class,String.class});
            //用方法进行反射操作
            Object obj1 = m1.invoke(a,"hello","world");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
class A{
    public void print(int a,int b){
        System.out.println(a+b);
    }
    public void print(String a,String b){
        System.out.println(a.toUpperCase() + "," + b.toUpperCase());
    }
}
