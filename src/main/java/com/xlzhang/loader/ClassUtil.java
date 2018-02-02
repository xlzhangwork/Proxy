package com.xlzhang.loader;

import java.lang.reflect.Method;

/**
 * @Author: xlzhang
 * @Description:
 * @Date: Created in 17:16 2018/1/31
 * @Modified By:
 **/
public class ClassUtil {
    //打印类的信息，包括成员变量成员函数
    public static void printClassMessage(Object obj){
        //要获取类的信息，首先要获取类的类类型，这里用之前第二种方式获取类类型
        Class c1 = obj.getClass();
        System.out.println("类的名称是："+c1.getName());
        //getMethods方法获取所有public函数，包括父类继承的
        //getDeclaredMethods获取所有自己声明的函数，不问访问权限
        Method[] method = c1.getMethods();// c1.getDeclaredMethods()
        for (int i = 0; i<method.length;i++){
            //得到方法的返回值类型的类类型
            Class returnType = method[i].getReturnType();
            System.out.print(returnType.getName() + " ");
            //得到方法名称
            System.out.println(method[i].getName()+ "(");
            //获取参数类型-->得到参数列表的类型的类类型
            Class[] paramTypes = method[i].getParameterTypes();

            for (Class class1:paramTypes
                 ) {
                System.out.println(class1.getName() + ",");
            }
        }
        System.out.println(c1.getTypeParameters());
    }
}
