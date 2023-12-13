package com.askia.coremodel.datamodel.http.entities.consume;

public class DiscussResponseBean {

    /**
     * followCount : 16
     * publish_time : 2021-05-15 07:49:56
     * is_recommend : 1
     * roomId : 842836144994385920
     * roomName : 加快构建新发展格局
     */

    private int followCount;
    private String publish_time;
    private String is_recommend;
    private String roomId;
    private String roomName;

    public int getFollowCount() {
        return followCount;
    }

    public void setFollowCount(int followCount) {
        this.followCount = followCount;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getIs_recommend() {
        return is_recommend;
    }

    public void setIs_recommend(String is_recommend) {
        this.is_recommend = is_recommend;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
