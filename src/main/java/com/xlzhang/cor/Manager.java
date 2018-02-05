package com.xlzhang.cor;

import com.xlzhang.cor.handler.PriceHandler;

/**
 * @Author: xlzhang
 * @Description:
 * @Date: Created in 14:55 2018/2/2
 * @Modified By:
 **/
public class Manager extends PriceHandler {

    public void processDiscount(float discount) {
        if(discount <= 0.3){
            System.out.format("%s批准了折扣：%.2f%n",this.getClass().getName(),discount);
        }else{
            successor.processDiscount(discount);
        }
    }
}
