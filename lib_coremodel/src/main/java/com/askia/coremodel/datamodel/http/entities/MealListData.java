package com.askia.coremodel.datamodel.http.entities;

import java.util.List;

public class MealListData extends BaseResponseData
{


    /**
     * pageNum : 1
     * totalNum : 11
     * totalPage : 2
     * data : [{"id":"1","meal_name":"A套餐","meal_constitute":"土豆+茄子+西红柿","meal_category":"1","meal_price":15,"remark":"丝瓜中维生素含量较高，咸鸭蛋盐量过高，高血压不易使用","meal_img":null,"level":3.6666666666666665},{"id":"2","meal_name":"溜肉段","meal_constitute":null,"meal_category":"1","meal_price":12,"remark":null,"meal_img":null,"level":null},{"id":"3","meal_name":"B套餐","meal_constitute":"包子+粥+茶蛋+咸菜","meal_category":"0","meal_price":8,"remark":null,"meal_img":null,"level":null},{"id":"4","meal_name":"早餐套餐A","meal_constitute":"小米粥+咸菜+胡萝卜+香肠","meal_category":"1","meal_price":15,"remark":null,"meal_img":null,"level":null},{"id":"402881e56d3935a3016d3939faf00003","meal_name":"西红柿炒鸡蛋","meal_constitute":null,"meal_category":"1","meal_price":8,"remark":null,"meal_img":"ZGF0YTppbWFnZS9qcGVnO2Jhc2U2NCwvOWovNEFBUVNrWkpSZ0FCQVFFQWtBQ1FBQUQvMndCREFDZ2NIaU1lR1NnaklTTXRLeWd3UEdSQlBEYzNQSHRZWFVsa2tZQ1psbytBaklxZ3RPYkRvS3JhcllxTXlQL0wydTcxLy8vL204SC8vLy82LytiOS8vai8yd0JEQVNzdExUdzFQSFpCUVhiNHBZeWwrUGo0K1BqNCtQajQrUGo0K1BqNCtQajQrUGo0K1BqNCtQajQrUGo0K1BqNCtQajQrUGo0K1BqNCtQajQrUGo0K1BqL3dBQVJDQUI3QUlNREFTSUFBaEVCQXhFQi84UUFId0FBQVFVQkFRRUJBUUVBQUFBQUFBQUFBQUVDQXdRRkJnY0lDUW9MLzhRQXRSQUFBZ0VEQXdJRUF3VUZCQVFBQUFGOUFRSURBQVFSQlJJaE1VRUdFMUZoQnlKeEZES0JrYUVJSTBLeHdSVlMwZkFrTTJKeWdna0tGaGNZR1JvbEppY29LU28wTlRZM09EazZRMFJGUmtkSVNVcFRWRlZXVjFoWldtTmtaV1puYUdscWMzUjFkbmQ0ZVhxRGhJV0doNGlKaXBLVGxKV1dsNWlabXFLanBLV21wNmlwcXJLenRMVzJ0N2k1dXNMRHhNWEd4OGpKeXRMVDFOWFcxOWpaMnVIaTQrVGw1dWZvNmVyeDh2UDA5ZmIzK1BuNi84UUFId0VBQXdFQkFRRUJBUUVCQVFBQUFBQUFBQUVDQXdRRkJnY0lDUW9MLzhRQXRSRUFBZ0VDQkFRREJBY0ZCQVFBQVFKM0FBRUNBeEVFQlNFeEJoSkJVUWRoY1JNaU1vRUlGRUtSb2JIQkNTTXpVdkFWWW5MUkNoWWtOT0VsOFJjWUdSb21KeWdwS2pVMk56ZzVPa05FUlVaSFNFbEtVMVJWVmxkWVdWcGpaR1ZtWjJocGFuTjBkWFozZUhsNmdvT0VoWWFIaUltS2twT1VsWmFYbUptYW9xT2twYWFucUttcXNyTzB0YmEzdUxtNndzUEV4Y2JIeU1uSzB0UFUxZGJYMk5uYTR1UGs1ZWJuNk9ucTh2UDA5ZmIzK1BuNi85b0FEQU1CQUFJUkF4RUFQd0RSdXJrUUhHTXNSbXMyV2Q1VGxqeDZWUHFSeE92KzcvVTFTNU5JWXBOSlVpUXlOMFUxS2JjUkx1a0lBOUtCa0NSbGp3S21FY1lITEFuMnF2Sk1XNFg1VkhZVTBNUlRzSzViOHNOd3JEUHBUaFp1ZXJWVlZ5T2xQOCtSTUZHUHVEUllMbHRiTkIxNXFaWVVYb29xcEZxQUp4SXVQY1ZjVnd3eXB5S2xqRnhqb0tRMEUwMG1rTVUwM05JVzk2ak1panFhUXlRbWt6VURYQ0R2VWJYWHBSWUxsbk5GVWpjdFJSeXNMbzFibTNXV1VNM1lZcEVnalRvb3FhVHJUTTFUSlFIQ2dub0JXUGRUbWFRLzNSMHE3ZnpiSXRvNnRXWFRRbUtPdEtLYUtkbkF6VkVqcWZFcFkrMVJvcGMrMVg3YUxPTURqMXBObEpGU1czWkRuSHZVMEVoaXh6d2VvcTVjb0NnSG9hemp4a1ViZ1dIdXdPZ3FKcnB6MHFGdXVhYm1wc080OHl1M2VtNFk5NmJVc0tTeUhDS1RURVNRMk1zeUYxSUE3WjcxV1pTckZTT1J4VzNid3lSSnQzREgwNlU1YldKY25hQ1QxSm9BeGx0cFdBSWpZZzBWdkFBREZGQUVGMU9zVGdIcmpOVkd1eWVncCtvSnVuVS83UDhBVTFWS1lwTzF5bGV4RmN5bVJ4bW9hV1E1YzBsVWlHRlN4eDcyOXFqWHJtcDRlTVVNRVdraEFIQXF4RHVQUWppaUVBcmcwMzdJNlBtR1RibjE1cVMyT21ZbENDTVlyS2tQemtlOWJNdUk0bVp1UUJXTklWYVVsVGtVMElROXFTbFljMG1LQkNacTdaWGlRcnNjSEhxS3BVb3hRQnZ4VEpNTXhzRFVGeGVKQzVWdnZlZ3JMaG5rdDJMUm5yMXBrc3JTdVhjNUpvQXZIVURuaGVQclJXZG1pbFlMbXplTG1VZjd0Vm53cUVuc0t1WFArc0gwck92cE1ZUWRUeWFHdFJwNkZNbkpvcEJTMVJJNWZ1MU5GMUZSWStRVk5iOHRpa3hvMFlEd0tzTXdWU3g2Q3E4WTlLZDU2RWxHNDdjanJTS2FIcTRZNE9NR3NYWnRuWk01d1NNMXBYSmhoaWFRWTNzTURCck5nR1hwaWU0am5EbW03cWxrVDVqVVJITkFoTTBVdUtNVXhDWnBLY0JtakZBeHRGT3hSU0EzTG5PN0lHY0NzV1lIekNYYko5cTNwVURucWVsVUxpMkE2ajhhQU0wNHh4U2Q2bGtqMm1tSHJURVBBekg5S2RFU3B5S1dNWlVEMUZUeFc3TjBwRkl0VzBnWWU5U1NLRlZuUFFESnJMZWN4VHNxNElCeFQ1TDk1SWpHRnhrY21sWUxsZWVacDN5ZUFPZzlLZGIvQUg2aUFxZTJIekdtOWhMY2tZWkpxRmh6VW03TGtVdzRVNUlCOXMwSUJtS01VOVgzSDdxajhLdjI2REdUajhxVGRocEdjdkZCUE5iYklDaEh0V0VQZW1oQzVGRk54UlRFZEdldElWRERCR2FVOWFLQU0yN3N5RkxSOGdkcW9PTUVFZE90YjdWazM4SGxuZWcrUnUzb2FRRVVSNmV4clJqWXJic1IxQTRyTWpiYUFhMG95SHRqanNLWFVyb1pEZmVwQjBOSy93QjQwcURPUHJWRWppdUdIMHFXSVlRbjFwSFg1ei9zZ0Q5QlUzbG5Zb0ZJcm9RamdubW1FaXBKVjJjZCs5UkJjL3hZb0VXaDltQ3FSa0h2elZtQ0lsdDI0N0IwQnF2YjI0SExmbWFzSklKRDVTbmdkVFNMTEtOdkdSMDdWanpRdEhNeWtkOGo2VnErYUZsV0pCazkvYW81VkVqUGtjcmpCb3VUWXk5aG9xOFlnRDFvcGlMc2pGWmVPNjhVNE9DUjcwMmIvV0FlMlJRQUQvTVVDSlB2TFZlYVB6WTJqUGVwZ0NPblNnalAxb0F6WWJKdHgzOUIrdFRwQTBSZlljb2VNR3JaNlUxS1E3bVo5aE8xbUp4NlVpMnNxWXloSTlxMHBCbkNqNjFNQmdDbUJuUlc1OHNsd1JuazBqeWhPVHdmU3I4OGl4eEVuOEt5akg1cDU0Sm8yRGNpZHR6RW52U3hFTElDUlFZblE0SXBRdElwRnh4NXFqYndLRkFSc3J3d0hXa2lkaW0zb2FRQUlTU2MwaWl4RWdRYmljczNlb2J1UXh4dXc0SndNK3RSNzVINEEyclN0QzBwRzQ0VWRCVFJMZGlpWkhKeVdORlBraVZaQ0FhS3N6Tldkc1hPMy9ZQkg1bW5xZTFRM1hGNUhqKzZQNjFJdmIyNHFSa3dOTFRSU2ltQWg2K3hwaThISHBUbkp5UHJTRDd4K3RJWWhJRFpQYWczRVlCTzdwMnFPZjd0UnlxRER1STV4MW9BaFpqTkp1YzU5RnF3a1dPdjNqMVBwVU5zQjh4N2lya2ZLRDM2MEFJSXhqR09QU21tM1RQSEZUVW9BT2FBdVVsbmdNaFZjWUhjOTZXU2FGTzYvaFdWS0FzemdjQU1SVEtkZ3VhZ3VWZmhhVWxtSFhGVXJmclV4SkI2MUhVcm9OYUxMRTdxS2ZSVEZvZi8yUT09","level":null},{"id":"402881e56d3935a3016d393e826b0007","meal_name":"西红柿炒鸡蛋2","meal_constitute":null,"meal_category":"1","meal_price":8,"remark":null,"meal_img":"","level":null},{"id":"402881e56d3dc5e4016d3dc752ca0000","meal_name":"西红柿套餐A","meal_constitute":"西红柿炒鸡蛋+溜肉段","meal_category":"1","meal_price":8,"remark":null,"meal_img":"ZGF0YTppbWFnZS9qcGVnO2Jhc2U2NCwvOWovNEFBUVNrWkpSZ0FCQVFFQWtBQw==","level":null},{"id":"4028d0816d1f97b8016d1f98d9580000","meal_name":"陈皮鸡,欧耶版","meal_constitute":null,"meal_category":"1","meal_price":20,"remark":"好吃顶呱呱,欧耶!","meal_img":null,"level":null},{"id":"4028d0816d2479bb016d2482ea330001","meal_name":"左宗棠鸡鸡,欧耶版","meal_constitute":null,"meal_category":"1","meal_price":20,"remark":"好吃顶呱呱,欧耶!","meal_img":null,"level":null},{"id":"5","meal_name":"D套餐+水果","meal_constitute":"香菇鸡肉+烧油菜+汤+米饭+水果","meal_category":"2","meal_price":17,"remark":null,"meal_img":null,"level":null}]
     */

    private int pageNum;
    private int totalNum;
    private int totalPage;
    private List<DataBean> data;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {

        /**
         * id : 1
         * meal_name : A套餐
         * meal_constitute : 土豆+茄子+西红柿
         * meal_category : 1
         * meal_price : 15.0
         * remark : 丝瓜中维生素含量较高，咸鸭蛋盐量过高，高血压不易使用
         * meal_img : null
         * level : 3.6666666666666665
         */

        private String id;
        private String meal_name;
        private String meal_constitute;
        private String meal_category;
        private float meal_price;
        private String remark;
        private String meal_img;
        private float level;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMeal_name() {
            return meal_name;
        }

        public void setMeal_name(String meal_name) {
            this.meal_name = meal_name;
        }

        public String getMeal_constitute() {
            return meal_constitute;
        }

        public void setMeal_constitute(String meal_constitute) {
            this.meal_constitute = meal_constitute;
        }

        public String getMeal_category() {
            return meal_category;
        }

        public void setMeal_category(String meal_category) {
            this.meal_category = meal_category;
        }

        public float getMeal_price() {
            return meal_price;
        }

        public void setMeal_price(float meal_price) {
            this.meal_price = meal_price;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getMeal_img() {
            return meal_img;
        }

        public void setMeal_img(String meal_img) {
            this.meal_img = meal_img;
        }

        public float getLevel() {
            return level;
        }

        public void setLevel(float level) {
            this.level = level;
        }
    }
}
