package com.xlzhang.loader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: xlzhang
 * @Description:
 * @Date: Created in 17:16 2018/1/31
 * @Modified By:
 **/
public class ClassUtil {
/**
 * @Author: xlzhang
 * @Description:打印成员函数信息
 * @Param:
 * @Date: 10:04 2018/2/2
 */
    public static void printClassMessage(Object obj){
        //要获取类的信息，首先要获取类的类类型，这里用之前第二种方式获取类类型
        Class cl = obj.getClass();
        System.out.println("类的名称是："+cl.getName());
        //getMethods方法获取所有public函数，包括父类继承的
        //getDeclaredMethods获取所有自己声明的函数，不问访问权限
        Method[] method = cl.getMethods();// c1.getDeclaredMethods()
        for (int i = 0; i<method.length;i++){
            //得到方法的返回值类型的类类型
            Class returnType = method[i].getReturnType();
            System.out.print(returnType.getName() + " ");
            System.out.println("\n==================================");
            //得到方法名称
            System.out.println(method[i].getName()+ "(");
            System.out.println("\n==================================");
            //获取参数类型-->得到参数列表的类型的类类型
            Class[] paramTypes = method[i].getParameterTypes();

            for (Class class1:paramTypes
                 ) {
                System.out.println(class1.getName() + ",");
            }
            System.out.println("\n==================================");
        }
        System.out.println(cl.getTypeParameters());
    }
/**
 * @Author: xlzhang
 * @Description:获取成员变量信息
 * @Param:
 * @Date: 10:02 2018/2/2
 */
    public static void printFieldMessage(Object obj) {
    /*
     * 成员变量也是对象
     * java.lang.reflect.Field
     * Field类封装了关于成员变量的操作
     * getFields方法获取的是所有public的成员变量信息
     * getDeclaredFields方法获取的是该类自己声明的成员变量的信息
     */
        //Field[] fs = c1.getFields();
        Class cl = obj.getClass();
        Field[] fs = cl.getDeclaredFields();
        for (Field field:fs){
            //得到成员变量类型的类类型
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            //得到成员变量的名称
            String fieldName = field.getName();
            System.out.println(typeName + " " + fieldName);
        }
    }
/**
 * @Author: xlzhang
 * @Description:
 * @Param: 打印对象构造函数信息
 * @Date: 10:04 2018/2/2
 */
    public static void printConMessage(Object obj){
        Class cl = obj.getClass();
        /*
         * 构造函数也是对象
         * java.lang.Constructor中封装了构造函数的信息
         * getConstructors获取所有public的构造函数
         */
        //Constructor[] cs = cl.getConstructors();
        Constructor[] cs = cl.getDeclaredConstructors();//获取所有自己声明的构造函数
        for (Constructor constructor:cs) {
            System.out.print(constructor.getName() + "(");
            //获取构造函数的参数列表-->得到的是参数列表的类类型
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class param:paramTypes) {
                System.out.print(param.getName() + ",");
            }
            System.out.println(")");
        }
    }
}
