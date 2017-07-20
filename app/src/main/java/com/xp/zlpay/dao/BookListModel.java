package com.xp.zlpay.dao;

import java.util.List;

/**
 * Author YC
 * 2017/7/12 0012.
 */

public class BookListModel extends BaseModel {

    private showapiResBody showapi_res_body;

    public showapiResBody getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(showapiResBody showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static  class showapiResBody{
        private int total;

        private int ret_code;

        private boolean flag;

        private boolean success;

        private List<BookListInfo> bookList;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public List<BookListInfo> getBookList() {
            return bookList;
        }

        public void setBookList(List<BookListInfo> bookList) {
            this.bookList = bookList;
        }
    }
}
