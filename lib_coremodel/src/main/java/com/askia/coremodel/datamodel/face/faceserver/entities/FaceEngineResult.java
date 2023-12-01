package com.askia.coremodel.datamodel.face.faceserver.entities;

import java.io.Serializable;

public class FaceEngineResult implements Serializable {
    private int afCode;

    public int getAfCode() {
        return afCode;
    }

    public void setAfCode(int afCode) {
        this.afCode = afCode;
    }
}
