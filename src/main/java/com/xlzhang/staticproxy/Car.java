package com.xlzhang.staticproxy;

import java.util.Random;

/**
 * @Author: xlzhang
 * @Description:
 * @Date: Created in 10:03 2018/1/29
 * @Modified By:
 **/
public class Car implements Moveable{
    public void move(){
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
