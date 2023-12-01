package com.zdy.study.event;

import com.arcsoft.face.FaceFeature;

import java.io.Serializable;

// 客屏检测到了人脸
public class DetectFaceEvent implements Serializable
{
    private FaceFeature faceFeature;
    private FaceImage faceImage;

    public FaceImage getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(FaceImage faceImage) {
        this.faceImage = faceImage;
    }

    public FaceFeature getFaceFeature() {
        return faceFeature;
    }

    public void setFaceFeature(FaceFeature faceFeature) {
        this.faceFeature = faceFeature;
    }

    public static class FaceImage implements Serializable
    {
        private String base64;

        public String getBase64() {
            return base64;
        }

        public void setBase64(String base64) {
            this.base64 = base64;
        }

        /*  private byte[] nv21;
        private int width;
        private int height;


        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public byte[] getNv21() {
            return nv21;
        }

        public void setNv21(byte[] nv21) {
            this.nv21 = nv21;
        }*/
    }

}
