package com.xlzhang.cor.handler;

/**
 * @Author: xlzhang
 * @Description:价格处理人负责处理客户折扣申请
 * @Date: Created in 14:37 2018/2/2
 * @Modified By:
 **/
public abstract class PriceHandler {
    /*
     * 直接后继，用于传递请求
     */
    protected PriceHandler successor;

    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }

    /*
     * 处理折扣申请
     */
    public abstract void processDiscount(float discount);
}
