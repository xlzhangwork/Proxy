package com.xlzhang.dynamicproxy;

import com.xlzhang.staticproxy.Car;
import com.xlzhang.staticproxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: xlzhang
 * @Description:
 * @Date: Created in 15:10 2018/1/29
 * @Modified By:
 **/
public class Test {

    public static void main(String args[]){
        Moveable car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Class<?> cls = car.getClass();
        /*
        *  loader   被代理类的类加载器
        *  interfaces 实现接口
        *  InvocationHandler
         */
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),h);

        m.move();
    }
}
