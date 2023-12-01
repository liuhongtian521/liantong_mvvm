package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

public class HttpSysCodeBean extends CBaseResponseData
{

    /**
     * result : {"dishesclassify":[{"text":"炒菜","value":"1"},{"text":"盖浇饭","value":"2"},{"text":"配菜/零食","value":"3"},{"text":"饮品","value":"4"},{"text":"其他","value":"5"}]}
     * timestamp : 1603873393728
     */

    private ResultBean result;
    private long timestamp;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static class ResultBean {
        private List<SysCodeBean> dishesclassify;
        private List<SysCodeBean> consumetype;
        private List<SysCodeBean> mealtype;

        public List<SysCodeBean> getMealtype() {
            return mealtype;
        }

        public void setMealtype(List<SysCodeBean> mealtype) {
            this.mealtype = mealtype;
        }

        public List<SysCodeBean> getConsumetype() {
            return consumetype;
        }

        public void setConsumetype(List<SysCodeBean> consumetype) {
            this.consumetype = consumetype;
        }

        public List<SysCodeBean> getDishesclassify() {
            return dishesclassify;
        }

        public void setDishesclassify(List<SysCodeBean> dishesclassify) {
            this.dishesclassify = dishesclassify;
        }

        public static class SysCodeBean {
            /**
             * text : 炒菜
             * value : 1
             */

            private String text;
            private String value;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
