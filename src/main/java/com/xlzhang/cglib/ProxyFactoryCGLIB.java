package com.xlzhang.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactoryCGLIB implements MethodInterceptor {

    private Object target;

    public ProxyFactoryCGLIB(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        Enhancer en = new Enhancer();

        en.setSuperclass(target.getClass());

        en.setCallback(this);

        return en.create();
    }
/*
 * obj      目标类实例
 * m        目标方法的反射对象
 * args     方法的参数
 * proxy    代理类的实例
 */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("CGLIB代理开始了");

        Object returnValue = method.invoke(target,objects);

        return returnValue;
    }
}
