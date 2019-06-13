package com.constant;

public enum UserStatus {

        NORMAL(10, "正常"),
        TO_BE_CONFIRMED(20, "待确认"),
        REVOKE(30, "已注销");

    private int id;
    private String des;

    private UserStatus(int id, String des){
        this.id = id;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
