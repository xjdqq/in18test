package com.example.demo.util;

public class st extends humen{
    String cj;
    public st(String name, String sex, String cj) {
        super(name, sex);
        this.cj = cj;
    }

    @Override
    public String toString() {
        return "st{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", cj='" + cj + '\'' +
                '}';
    }

    public String getCj() {
        return cj;
    }

    public void setCj(String cj) {
        this.cj = cj;
    }
}
