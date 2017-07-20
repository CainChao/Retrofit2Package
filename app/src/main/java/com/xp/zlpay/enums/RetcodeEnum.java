package com.xp.zlpay.enums;

/**
 * Author YC
 * 2017/7/12 0012.
 */

public enum RetcodeEnum {
    SUCC(0,"成功"),

    FAILURE(-1,"失败");

    private int value;

    private String message;


    RetcodeEnum(int val,String msg){
        this.value = val;
        this.message = msg;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
