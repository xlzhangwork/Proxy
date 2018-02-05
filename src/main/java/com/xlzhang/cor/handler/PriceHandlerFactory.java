package com.xlzhang.cor.handler;

import com.xlzhang.cor.CEO;
import com.xlzhang.cor.Director;
import com.xlzhang.cor.Manager;

/**
 * @Author: xlzhang
 * @Description:
 * @Date: Created in 17:20 2018/2/2
 * @Modified By:
 **/
public class PriceHandlerFactory {
    public static PriceHandler createPriceHandler(){
        PriceHandler sales = new Director.Sales();
        PriceHandler manager = new Manager();
        PriceHandler director = new Director();
        PriceHandler vicePresident = new Director.VicePresident();
        PriceHandler ceo = new CEO();

        sales.setSuccessor(manager);
        manager.setSuccessor(director);
        director.setSuccessor(vicePresident);
        vicePresident.setSuccessor(ceo);

        return sales;
    }
}
