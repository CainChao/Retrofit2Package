package com.xp.zlpay.enums;

/**
 * Author YC
 * 2017/7/12 0012.
 */

public enum UrlListEnum {

    BOOKSLIST(1,"92-92?","健康图书列表");

    private int value;

    private String message;

    private String key;

    UrlListEnum(int val,String key,String msg){
        this.value = val;
        this.message = msg;
        this.key = key;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
