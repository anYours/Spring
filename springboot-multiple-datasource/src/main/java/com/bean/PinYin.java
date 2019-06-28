package com.bean;

public class PinYin {

    Integer id;

    String py;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    @Override
    public String toString() {
        return "PinYin{" +
                "id=" + id +
                ", py='" + py + '\'' +
                '}';
    }
}
