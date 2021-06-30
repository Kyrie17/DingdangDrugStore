package com.dingdang.DingdangDrugstore.mbg.model;

import java.math.BigDecimal;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/4/14 14:34
 */
public class Count {
    Integer cou;
    Integer mon;
    BigDecimal amount;

    public Integer getCou() {
        return cou;
    }

    public void setCou(Integer cou) {
        this.cou = cou;
    }

    public Integer getMon() {
        return mon;
    }

    public void setMon(Integer mon) {
        this.mon = mon;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
