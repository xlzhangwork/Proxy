package com.xlzhang.staticproxy;

/**
 * @Author: xlzhang
 * @Description:
 * @Date: Created in 11:52 2018/1/29
 * @Modified By:
 **/
public class CarLogProxy implements Moveable {
    private Moveable m;
    public CarLogProxy(Moveable m){
        super();
        this.m = m;
    }

    public void move() {
        System.out.println("日志开始");
        m.move();
        System.out.println("日志结束");
    }
}
