package com.bjsxt.pojo;

public class VN {

    private   Integer  value;

    private   String  name;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VN(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
    public VN(){}

    @Override
    public String toString() {
        return "VN{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
