package com.zdy.study.event;

import com.askia.coremodel.datamodel.face.faceserver.CompareResult;

import java.util.List;

/**
 * Create bt she:
 *
 * @date 2021/1/11
 */
public class FaceListEvent {
    private List<CompareResult.Message> data;
    private boolean type;

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public List<CompareResult.Message> getData() {
        return data;
    }

    public void setData(List<CompareResult.Message> data) {
        this.data = data;
    }

    public static class Message {
        private String userName;
        private float similar;
        private int trackId;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public float getSimilar() {
            return similar;
        }

        public void setSimilar(float similar) {
            this.similar = similar;
        }

        public int getTrackId() {
            return trackId;
        }

        public void setTrackId(int trackId) {
            this.trackId = trackId;
        }
    }

}
