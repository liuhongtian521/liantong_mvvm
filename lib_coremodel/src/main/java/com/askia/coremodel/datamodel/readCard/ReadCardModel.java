package com.askia.coremodel.datamodel.readCard;

import android.util.Log;
import android.widget.Toast;

import com.askia.coremodel.datamodel.readCard.serial.MySeralHelper;
import com.blankj.utilcode.util.ToastUtils;

import java.io.IOException;
import java.security.InvalidParameterException;

public class ReadCardModel {
    private static ReadCardModel sReadCardModel;
    private MySeralHelper mMySeralHelper;

    public static ReadCardModel getInstance() {
        if (sReadCardModel == null)
            sReadCardModel = new ReadCardModel();
        return sReadCardModel;
    }

    public ReadCardModel() {
        mMySeralHelper = new MySeralHelper();
    }

    public void startReadCard() {
        try {
            if (!mMySeralHelper.isOpen()) {
                mMySeralHelper.open();
            }
        } catch (SecurityException e) {
            Log.e("TagSnake",Log.getStackTraceString(e));
        } catch (IOException e) {
            Log.e("TagSnake",Log.getStackTraceString(e));
        } catch (InvalidParameterException e) {
            Log.e("TagSnake",Log.getStackTraceString(e));
        }
    }

    public void stopReadCard() {
        mMySeralHelper.stopSend();
        mMySeralHelper.close();
    }
}
