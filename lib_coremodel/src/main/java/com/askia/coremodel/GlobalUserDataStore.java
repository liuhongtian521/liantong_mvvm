package com.askia.coremodel;

import android.text.TextUtils;


public class GlobalUserDataStore {

    private static GlobalUserDataStore mInstance = null;
    private boolean isLogin = false; //是否已登陆

    private String schoolImage = null;
    private String type;
    private String studentName;
    private String studentPhone;
    private String className;
    private String teacherName;
    private String teacherPhone;
    private String teacId;
    private String classId;
    private String gradeId;//年级
    private String majorId;//专业
    private String unique;
    private String phoneChangeFlag;
    private String schoolImagePath = null;
    private String row;
    private String col;

    private GlobalUserDataStore() {
    }

    public static synchronized GlobalUserDataStore getInstance() {
        if (mInstance == null) {
            synchronized (GlobalUserDataStore.class) {
                if (mInstance == null) {
                    mInstance = new GlobalUserDataStore();
                }
            }
        }
        return mInstance;
    }

    public boolean isTeacherOnline() {
        if (TextUtils.equals("2", type) || TextUtils.equals("4", type)) {
            return true;
        }
        return false;
    }

    public boolean isLogin() {
        return isLogin;
    }

    /*public void updateUserData(User user) {
        isLogin = true;
        this.type = user.getData().getType();
        this.studentName = user.getData().getStudentName();
        this.studentPhone = user.getData().getStudentPhone();
        this.className = user.getData().getClassName();
        this.teacherName = user.getData().getTeacherName();
        this.teacherPhone = user.getData().getTeacherPhone();
        this.teacId = user.getData().getTeacId();
        this.classId = user.getData().getClassId();
        this.gradeId = user.getData().getGradeId();
        this.majorId = user.getData().getMajorId();
        this.unique = user.getToken().getUnique();
        this.phoneChangeFlag = user.getPhoneChangeFlag();
    }*/

    public String getSchoolImage() {
        return schoolImage;
    }

    public void setSchoolImage(String schoolImage) {
        this.schoolImage = schoolImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacId() {
        return teacId;
    }

    public void setTeacId(String teacId) {
        this.teacId = teacId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    public String getPhoneChangeFlag() {
        return phoneChangeFlag;
    }

    public void setPhoneChangeFlag(String phoneChangeFlag) {
        this.phoneChangeFlag = phoneChangeFlag;
    }

    public String getSchoolImagePath() {
        return schoolImagePath;
    }

    public void setSchoolImagePath(String schoolImagePath) {
        this.schoolImagePath = schoolImagePath;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }
}
