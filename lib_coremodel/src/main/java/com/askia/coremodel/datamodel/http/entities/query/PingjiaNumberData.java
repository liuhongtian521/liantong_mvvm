package com.askia.coremodel.datamodel.http.entities.query;

import java.util.List;

/**
 * Create bt she:
 *
 * @date 2020/11/4
 */
public class PingjiaNumberData extends QBaseResponseData {

    private List<DataBean> result;

    public static class DataBean {

        private String commentLeavel;
        private String amount;

        public String getCommentLeavel() {
            return commentLeavel;
        }

        public void setCommentLeavel(String commentLeavel) {
            this.commentLeavel = commentLeavel;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
    }
}
