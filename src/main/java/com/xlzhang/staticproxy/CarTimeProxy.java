package com.xlzhang.staticproxy;

/**
 * @Author: xlzhang
 * @Description:
 * @Date: Created in 11:44 2018/1/29
 * @Modified By:
 **/
public class CarTimeProxy implements Moveable{
    private Moveable m;
    public CarTimeProxy(Moveable m){
        super();
        this.m = m;
    }

    public void move() {
        System.out.println("汽车开始行驶");
        long starttime = System.currentTimeMillis();
        m.move();
        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶，行驶时间:" + (endtime-starttime) + "ms");
    }
}
