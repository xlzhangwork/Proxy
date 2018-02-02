package com.xlzhang.cglib;


public class TestCGLIB {
    public static void main(String args[]){

        UserDAOCGLIB target = new UserDAOCGLIB();

        UserDAOCGLIB proxy = (UserDAOCGLIB) new ProxyFactoryCGLIB(target).getProxyInstance();

        proxy.save();
    }
}
