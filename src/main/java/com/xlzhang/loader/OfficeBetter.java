package com.xlzhang.loader;

/**
 * @Author: xlzhang
 * @Description:
 * @Date: Created in 15:59 2018/1/31
 * @Modified By:
 **/
public class OfficeBetter {
    public static void main(String args[]){
        try {
            //动态加载类，在运行时刻加载
            Class c = Class.forName("com.xlzhang.loader.Word");
            //通过类类型，创建该类对象
            OfficeAble officeAble = (OfficeAble) c.newInstance();
            officeAble.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
