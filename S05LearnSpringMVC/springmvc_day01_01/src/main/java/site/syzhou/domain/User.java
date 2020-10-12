package site.syzhou.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private int age;
    private String uname;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", uname='" + uname + '\'' +
                ", date=" + date +
                '}';
    }
}
