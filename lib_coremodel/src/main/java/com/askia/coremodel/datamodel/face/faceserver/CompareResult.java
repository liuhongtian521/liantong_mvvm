package com.askia.coremodel.datamodel.face.faceserver;


import java.io.Serializable;
import java.util.List;

public class CompareResult implements Serializable {
    private float similar;
    private List<Message> data;

    public CompareResult(float similar) {
        this.similar = similar;
    }

    public float getSimilar() {
        return similar;
    }

    public void setSimilar(float similar) {
        this.similar = similar;
    }

    public CompareResult(List<Message> data) {
        this.data = data;
    }

    public List<Message> getData() {
        return data;
    }

    public void setData(List<Message> data) {
        this.data = data;
    }

    public static class Message implements Serializable {
        private String userName;
        private float similar;
        private int trackId;

        public Message(String userName, float similar) {
            this.userName = userName;
            this.similar = similar;
        }

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
