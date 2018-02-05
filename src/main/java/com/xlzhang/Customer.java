package com.xlzhang;

import com.xlzhang.cor.handler.PriceHandler;
import com.xlzhang.cor.handler.PriceHandlerFactory;

/**
 * @Author: xlzhang
 * @Description:客户，请求折扣
 * @Date: Created in 15:01 2018/2/2
 * @Modified By:
 **/
public class Customer {
    private PriceHandler priceHandler;

    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public void requestDiscount(float discount){
        priceHandler.processDiscount(discount);
    }

    /*
     * 创建PriceHandler的工厂方法
     */
    public static void main(String args[]){
        Customer customer = new Customer();
        customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());
        float discount = (float) 0.4;
        customer.requestDiscount(discount);
    }
}
