package com.xp.zlpay.view;

import com.xp.zlpay.dao.BaseModel;

/**
 * Author YC
 * 2017/7/12 0012.
 */

public interface BookListView {
    /**
     * 成功获取数据
     * @param model
     * @param cmd
     */
    void netSuccess(BaseModel model, int cmd);

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
