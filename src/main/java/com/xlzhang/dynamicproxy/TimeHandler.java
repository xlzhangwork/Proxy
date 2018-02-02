package com.xlzhang.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: xlzhang
 * @Description:
 * @Date: Created in 15:05 2018/1/29
 * @Modified By:
 **/
public class TimeHandler implements InvocationHandler{

    private Object target;
    public TimeHandler(Object target){
        this.target = target;
    }
    /*
    *  参数：
    *  proxy    被代理对象
    *  method   被代理对象的方法
    *  args     方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("记录日志Logger");
        Object obj = method.invoke(target);
        System.out.println("记录日志完毕");
        return obj;
    }
}
