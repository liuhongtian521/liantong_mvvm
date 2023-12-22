package com.askia.coremodel.datamodel.http.entities.consume;

import java.io.Serializable;

public class Remark implements Serializable {


    /**
     * displayTime : 2021-05-12 02:30:10
     * createTime : 2021-05-12 02:27:07
     * contName : 李克强对2021年中国品牌日活动作出重要批示强调 努力提高产品和服务的质量与综合竞争力 使更多中国品牌成为国内外市场值得信赖的选择
     * id : 841667742388977664
     * cmStruId : 833057630787207168
     */

    private String displayTime;
    private String createTime;
    private String contName;
    private String id;
    private String cmStruId;

    public String getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(String displayTime) {
        this.displayTime = displayTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCmStruId() {
        return cmStruId;
    }

    public void setCmStruId(String cmStruId) {
        this.cmStruId = cmStruId;
    }
}
