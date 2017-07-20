package com.xp.zlpay.http;

import com.xp.zlpay.dao.BaseModel;

/**
 * Author YC
 * 2017/7/11 0011.
 */

public interface CallBackData {
    /**
     * 成功获取数据
     * @param model
     * @param cmd
     */
    void netSuccess(BaseModel model,int cmd);

    /**
     * 失败
     */
    void netFailure();

    /**
     * 异常
     * @param error
     */
    void netError(String error);

    /**
     * 后台系统抛出异常
     * @param logicError
     */
    void responeLogicError(String logicError);
}
