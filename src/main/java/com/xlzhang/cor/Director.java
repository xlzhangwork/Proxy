package com.xlzhang.cor;

import com.xlzhang.cor.handler.PriceHandler;

/**
 * @Author: xlzhang
 * @Description:
 * @Date: Created in 14:56 2018/2/2
 * @Modified By:
 **/
public class Director extends PriceHandler {

    public void processDiscount(float discount) {
        if(discount <= 0.4){
            System.out.format( "%s批准了折扣：%.2f%n",this.getClass().getName(),discount);
        }else {
            successor.processDiscount(discount);
        }
    }

    /**
     * @Author: xlzhang
     * @Description:
     * @Date: Created in 14:58 2018/2/2
     * @Modified By:
     **/
    public static class VicePresident extends PriceHandler {

        public void processDiscount(float discount) {
            if(discount <= 0.5){
                System.out.format("%s批准了折扣：%.2f%n",this.getClass().getName(),discount);
            }else {
                successor.processDiscount(discount);
            }
        }
    }

    /**
     * @Author: xlzhang
     * @Description:
     * @Date: Created in 14:45 2018/2/2
     * @Modified By:
     **/
    public static class Sales extends PriceHandler {

        @Override
        public void processDiscount(float discount) {
            if(discount <= 0.05){
                System.out.format("%s批准了折扣：%.2f%n",this.getClass().getName(),discount);
            }else {
                successor.processDiscount(discount);
            }
        }
    }
}
