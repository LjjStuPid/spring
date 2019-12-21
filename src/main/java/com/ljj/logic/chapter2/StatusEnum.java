package com.ljj.logic.chapter2;

public enum StatusEnum {

    SUCCESS("SUCCESS", "成功"),;

    StatusEnum(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    private String status;

    private String desc;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static void main(String[] args) {
        System.out.println(SUCCESS.getStatus());
    }
}
