package com.askia.coremodel.datamodel.face.faceserver;

import android.content.Context;

import com.arcsoft.face.FaceEngine;
import com.arcsoft.face.enums.DetectFaceOrientPriority;
import com.arcsoft.face.enums.DetectMode;


public class FaceEngineManager {
    private static FaceEngine sFaceEngine;
    private static int MAX_DETECT_NUM = 3;

    public static FaceEngine getFaceEngineInstance() {
        if (sFaceEngine != null)
            return sFaceEngine;
        sFaceEngine = new FaceEngine();
        return sFaceEngine;
    }


    public static int activeEngine(Context context, String appid, String sdkKey) {
        int activeCode = getFaceEngineInstance().activeOnline(context, appid, sdkKey);
        return activeCode;
    }

    public static int initEngine(Context context) {
        int afCode = getFaceEngineInstance().init(context, DetectMode.ASF_DETECT_MODE_VIDEO, DetectFaceOrientPriority.ASF_OP_ALL_OUT,
                5, MAX_DETECT_NUM, FaceEngine.ASF_FACE_RECOGNITION | FaceEngine.ASF_FACE_DETECT);
        return afCode;
    }

    public static void unitEngine() {
        getFaceEngineInstance().unInit();
    }
}
