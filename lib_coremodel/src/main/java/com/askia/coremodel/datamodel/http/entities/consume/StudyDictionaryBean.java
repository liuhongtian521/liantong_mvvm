package com.askia.coremodel.datamodel.http.entities.consume;

public class StudyDictionaryBean {


    /**
     * id : -1
     * tenantId :
     * parentId : -1
     * code : CLASS_MATERIAL_TAG
     * dictKey : 1
     * dictValue : 党史学习
     * sort : 1
     * remark : 党史学习
     * isSealed : -1
     * isDeleted : -1
     * status : -1
     */

    private int id;
    private String tenantId;
    private int parentId;
    private String code;
    private String dictKey;
    private String dictValue;
    private int sort;
    private String remark;
    private int isSealed;
    private int isDeleted;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getIsSealed() {
        return isSealed;
    }

    public void setIsSealed(int isSealed) {
        this.isSealed = isSealed;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
