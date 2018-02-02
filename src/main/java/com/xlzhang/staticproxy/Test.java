package com.xlzhang.staticproxy;

/**
 * @Author: xlzhang
 * @Description:
 * @Date: Created in 20:51 2018/1/28
 * @Modified By:
 **/
public class Test {
    public static void main(String args[]){
        //先记录日志在记录时间
        Car car = new Car();
        CarTimeProxy carTimeProxy = new CarTimeProxy(car);
        CarLogProxy carLogProxy = new CarLogProxy(carTimeProxy);
        carLogProxy.move();
        //先记录时间再记录日志
        CarLogProxy carLogProxy1 = new CarLogProxy(car);
        CarTimeProxy carTimeProxy1 = new CarTimeProxy(carLogProxy1);
        carTimeProxy1.move();
    }
}
