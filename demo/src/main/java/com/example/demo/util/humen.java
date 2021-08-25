package com.example.demo.util;

import javax.validation.constraints.NotBlank;

public class humen {
    @NotBlank(message="{test.sc}")
    String name;
    @NotBlank(message="sexkong")
    String sex;

    String langu;



    public humen(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getLangu() {
        return langu;
    }

    public void setLangu(String langu) {
        this.langu = langu;
    }

    @Override
    public String toString() {
        return "humen{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", langu='" + langu + '\'' +
                '}';
    }
}
