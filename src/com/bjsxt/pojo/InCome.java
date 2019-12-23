package com.bjsxt.pojo;

public class InCome {

    private   String  ictype;

    private   Integer  amount;

    public String getIctype() {
        return ictype;
    }

    public void setIctype(String ictype) {
        this.ictype = ictype;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public InCome(String ictype, Integer amount) {
        this.ictype = ictype;
        this.amount = amount;
    }

    public InCome(){}

    @Override
    public String toString() {
        return "InCome{" +
                "ictype='" + ictype + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
