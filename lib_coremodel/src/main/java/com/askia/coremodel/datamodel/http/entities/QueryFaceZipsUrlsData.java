package com.askia.coremodel.datamodel.http.entities;

import com.askia.coremodel.datamodel.http.entities.consume.CBaseResponseData;

import java.util.List;

public class QueryFaceZipsUrlsData extends CBaseResponseData
{
    /**
     * result : {"flag":"1","imageList":[{"timeStamp":"20210104143204","url":"http://172.16.75.249:9000/syerzhong//ZipForConsume/20210104143204.zip"}]}
     * timestamp : 1609741924508
     */

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }


    public static class ResultBean {
        /**
         * flag : 1
         * imageList : [{"timeStamp":"20210104143204","url":"http://172.16.75.249:9000/syerzhong//ZipForConsume/20210104143204.zip"}]
         */

        private String flag;
        private String transmitCode;
        private List<ImageListBean> imageList;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "flag='" + flag + '\'' +
                    ", transmitCode='" + transmitCode + '\'' +
                    ", imageList=" + imageList +
                    '}';
        }

        public String getTransmitCode() {
            return transmitCode;
        }

        public void setTransmitCode(String transmitCode) {
            this.transmitCode = transmitCode;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public List<ImageListBean> getImageList() {
            return imageList;
        }

        public void setImageList(List<ImageListBean> imageList) {
            this.imageList = imageList;
        }

        public static class ImageListBean {
            /**
             * timeStamp : 20210104143204
             * url : http://172.16.75.249:9000/syerzhong//ZipForConsume/20210104143204.zip
             */

            private String timeStamp;
            private String url;

            public String getTimeStamp() {
                return timeStamp;
            }

            public void setTimeStamp(String timeStamp) {
                this.timeStamp = timeStamp;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
