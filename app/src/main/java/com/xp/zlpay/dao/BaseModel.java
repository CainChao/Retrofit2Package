package com.xp.zlpay.dao;

/**
 * Author YC
 * 2017/7/11 0011.
 */

public class BaseModel {
    private int showapi_res_code;

    private String showapi_res_error;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }
}
