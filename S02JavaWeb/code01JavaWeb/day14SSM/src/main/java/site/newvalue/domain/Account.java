package site.newvalue.domain;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 7355810572012650248L;
    private Integer id;
    private String name;
    private Double money;
    //生成get和set方法和toString方法


    public Account() {
    }

    public Account(String name, Double money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
