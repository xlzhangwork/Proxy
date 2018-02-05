package com.xlzhang.loader;

/**
 * @Author: xlzhang
 * @Description:
 * @Date: Created in 9:29 2018/2/2
 * @Modified By:
 **/
public class PrintClass {
    public static void main(String args[]){
        String str = "war";
        ClassUtil.printClassMessage(str);
        ClassUtil.printFieldMessage(str);
        ClassUtil.printConMessage(str);
    }
}
