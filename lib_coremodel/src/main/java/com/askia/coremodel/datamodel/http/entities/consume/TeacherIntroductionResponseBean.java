package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

public class TeacherIntroductionResponseBean {

    /**
     * records : [{"id":"1663018150265593859","createUser":"1410414946339442689","createDept":"1300262833002422274","createTime":"2023-05-30 00:03:19","updateUser":"1410414946339442689","updateTime":"2023-05-30 00:03:19","status":1,"isDeleted":0,"tenantId":"000000","teacherCode":"1654379304946704386","teacherName":"范玉顺","sex":-1,"sexDict":"","teacherPhone":"","teacherCompany":"","teacherProfessionalField":"","teacherPost":"学院核心师资，清华大学教授","teacherClassPayHalf":-1,"teacherClassPay":-1,"teacherStatus":-1,"teacherStatusDict":"","teacherIntroduction":"1990年7月博士毕业于清华大学自动化系。现任清华大学自动化系长聘教授，博士生导师，国家CIMS工程技术研究中心副主任，现代服务技术与工程研究中心主任，网络化制造实验室主任，享受国家有突出贡献的中青年专家政府津贴。 现任国际自动控制联合会（IFAC）制造车间控制技术委员会委员（TC5.1）, 制造管理与控制建模委员会委员（TC5.2），全国自动化系统与集成标准化委员会副主任，全国信息技术标准化委员会委员，工业与信息化部高技术造船先进制造技术专家组专家，家电业智能制造创新战略联盟专家委员会主任，智能制造百人会专家委员会主任，上海交通大学兼职博导、巴黎九大兼职教授、沈阳自动化研究所客座研究员。《国际CIM杂志》编委、《计算机学报》、《计算机集成制造系统》、《信息与控制》、《航空制造技术》、《中国制造业信息化》编委、历任国家863计划现代集成制造系统技术主题专家组专家、863计划关键技术专业专家组专家、863计划车间管理专题专家组专家。 负责完成1项国家973重大基础研究项目、5项国家自然科学基金项目、4项中欧合作项目、10余项国家863高技术研究项目。已发表学术论文500余篇，出版《i时代的信息化战略管理方法》、《企业信息化整体解决方案》、《网络化制造系统及其应用实践》、《企业信息化战略规划方法与实践》、《集成化企业建模方法与系统》、《工作流管理技术基础》学术专著十二部。 获国家863计划先进个人称号，高校科技进步二等奖2次（排名第1），中国自动化学会CAA教学成果一等奖（排名第1），入选2014、2015、2016、2017爱思唯尔中国高被引学者（Most Cited Chinese Researchers）榜单。 主要研究方向：企业信息化战略管理、现代服务科学与技术、计算机集成制造系统、智能制造与工业4.0、业务流程建模与优化、大数据与智能服务平台","classesId":-1,"teacherHeadImg":"","curriculumName":"","curriculumId":""}]
     * total : 1
     * size : 10
     * current : 1
     * orders : []
     * optimizeCountSql : true
     * hitCount : false
     * searchCount : true
     * pages : 1
     */

    private int total;
    private int size;
    private int current;
    private boolean optimizeCountSql;
    private boolean hitCount;
    private boolean searchCount;
    private int pages;
    private List<RecordsBean> records;
    private List<?> orders;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public boolean isOptimizeCountSql() {
        return optimizeCountSql;
    }

    public void setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
    }

    public boolean isHitCount() {
        return hitCount;
    }

    public void setHitCount(boolean hitCount) {
        this.hitCount = hitCount;
    }

    public boolean isSearchCount() {
        return searchCount;
    }

    public void setSearchCount(boolean searchCount) {
        this.searchCount = searchCount;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<RecordsBean> getRecords() {
        return records;
    }

    public void setRecords(List<RecordsBean> records) {
        this.records = records;
    }

    public List<?> getOrders() {
        return orders;
    }

    public void setOrders(List<?> orders) {
        this.orders = orders;
    }

    public static class RecordsBean {
        /**
         * id : 1663018150265593859
         * createUser : 1410414946339442689
         * createDept : 1300262833002422274
         * createTime : 2023-05-30 00:03:19
         * updateUser : 1410414946339442689
         * updateTime : 2023-05-30 00:03:19
         * status : 1
         * isDeleted : 0
         * tenantId : 000000
         * teacherCode : 1654379304946704386
         * teacherName : 范玉顺
         * sex : -1
         * sexDict :
         * teacherPhone :
         * teacherCompany :
         * teacherProfessionalField :
         * teacherPost : 学院核心师资，清华大学教授
         * teacherClassPayHalf : -1
         * teacherClassPay : -1
         * teacherStatus : -1
         * teacherStatusDict :
         * teacherIntroduction : 1990年7月博士毕业于清华大学自动化系。现任清华大学自动化系长聘教授，博士生导师，国家CIMS工程技术研究中心副主任，现代服务技术与工程研究中心主任，网络化制造实验室主任，享受国家有突出贡献的中青年专家政府津贴。 现任国际自动控制联合会（IFAC）制造车间控制技术委员会委员（TC5.1）, 制造管理与控制建模委员会委员（TC5.2），全国自动化系统与集成标准化委员会副主任，全国信息技术标准化委员会委员，工业与信息化部高技术造船先进制造技术专家组专家，家电业智能制造创新战略联盟专家委员会主任，智能制造百人会专家委员会主任，上海交通大学兼职博导、巴黎九大兼职教授、沈阳自动化研究所客座研究员。《国际CIM杂志》编委、《计算机学报》、《计算机集成制造系统》、《信息与控制》、《航空制造技术》、《中国制造业信息化》编委、历任国家863计划现代集成制造系统技术主题专家组专家、863计划关键技术专业专家组专家、863计划车间管理专题专家组专家。 负责完成1项国家973重大基础研究项目、5项国家自然科学基金项目、4项中欧合作项目、10余项国家863高技术研究项目。已发表学术论文500余篇，出版《i时代的信息化战略管理方法》、《企业信息化整体解决方案》、《网络化制造系统及其应用实践》、《企业信息化战略规划方法与实践》、《集成化企业建模方法与系统》、《工作流管理技术基础》学术专著十二部。 获国家863计划先进个人称号，高校科技进步二等奖2次（排名第1），中国自动化学会CAA教学成果一等奖（排名第1），入选2014、2015、2016、2017爱思唯尔中国高被引学者（Most Cited Chinese Researchers）榜单。 主要研究方向：企业信息化战略管理、现代服务科学与技术、计算机集成制造系统、智能制造与工业4.0、业务流程建模与优化、大数据与智能服务平台
         * classesId : -1
         * teacherHeadImg :
         * curriculumName :
         * curriculumId :
         */

        private String id;
        private String createUser;
        private String createDept;
        private String createTime;
        private String updateUser;
        private String updateTime;
        private int status;
        private int isDeleted;
        private String tenantId;
        private String teacherCode;
        private String teacherName;
        private int sex;
        private String sexDict;
        private String teacherPhone;
        private String teacherCompany;
        private String teacherProfessionalField;
        private String teacherPost;
        private int teacherClassPayHalf;
        private int teacherClassPay;
        private int teacherStatus;
        private String teacherStatusDict;
        private String teacherIntroduction;
        private int classesId;
        private String teacherHeadImg;
        private String curriculumName;
        private String curriculumId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCreateUser() {
            return createUser;
        }

        public void setCreateUser(String createUser) {
            this.createUser = createUser;
        }

        public String getCreateDept() {
            return createDept;
        }

        public void setCreateDept(String createDept) {
            this.createDept = createDept;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateUser() {
            return updateUser;
        }

        public void setUpdateUser(String updateUser) {
            this.updateUser = updateUser;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(int isDeleted) {
            this.isDeleted = isDeleted;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getTeacherCode() {
            return teacherCode;
        }

        public void setTeacherCode(String teacherCode) {
            this.teacherCode = teacherCode;
        }

        public String getTeacherName() {
            return teacherName;
        }

        public void setTeacherName(String teacherName) {
            this.teacherName = teacherName;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getSexDict() {
            return sexDict;
        }

        public void setSexDict(String sexDict) {
            this.sexDict = sexDict;
        }

        public String getTeacherPhone() {
            return teacherPhone;
        }

        public void setTeacherPhone(String teacherPhone) {
            this.teacherPhone = teacherPhone;
        }

        public String getTeacherCompany() {
            return teacherCompany;
        }

        public void setTeacherCompany(String teacherCompany) {
            this.teacherCompany = teacherCompany;
        }

        public String getTeacherProfessionalField() {
            return teacherProfessionalField;
        }

        public void setTeacherProfessionalField(String teacherProfessionalField) {
            this.teacherProfessionalField = teacherProfessionalField;
        }

        public String getTeacherPost() {
            return teacherPost;
        }

        public void setTeacherPost(String teacherPost) {
            this.teacherPost = teacherPost;
        }

        public int getTeacherClassPayHalf() {
            return teacherClassPayHalf;
        }

        public void setTeacherClassPayHalf(int teacherClassPayHalf) {
            this.teacherClassPayHalf = teacherClassPayHalf;
        }

        public int getTeacherClassPay() {
            return teacherClassPay;
        }

        public void setTeacherClassPay(int teacherClassPay) {
            this.teacherClassPay = teacherClassPay;
        }

        public int getTeacherStatus() {
            return teacherStatus;
        }

        public void setTeacherStatus(int teacherStatus) {
            this.teacherStatus = teacherStatus;
        }

        public String getTeacherStatusDict() {
            return teacherStatusDict;
        }

        public void setTeacherStatusDict(String teacherStatusDict) {
            this.teacherStatusDict = teacherStatusDict;
        }

        public String getTeacherIntroduction() {
            return teacherIntroduction;
        }

        public void setTeacherIntroduction(String teacherIntroduction) {
            this.teacherIntroduction = teacherIntroduction;
        }

        public int getClassesId() {
            return classesId;
        }

        public void setClassesId(int classesId) {
            this.classesId = classesId;
        }

        public String getTeacherHeadImg() {
            return teacherHeadImg;
        }

        public void setTeacherHeadImg(String teacherHeadImg) {
            this.teacherHeadImg = teacherHeadImg;
        }

        public String getCurriculumName() {
            return curriculumName;
        }

        public void setCurriculumName(String curriculumName) {
            this.curriculumName = curriculumName;
        }

        public String getCurriculumId() {
            return curriculumId;
        }

        public void setCurriculumId(String curriculumId) {
            this.curriculumId = curriculumId;
        }
    }
}
