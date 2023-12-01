package com.askia.coremodel.datamodel.readCard.serial;

import android.util.Log;

import com.askia.coremodel.datamodel.readCard.event.ReadCardEvent;
import com.askia.coremodel.util.OtherUtils;
import com.ttsea.jrxbus2.RxBus2;

public class MySeralHelper extends SerialHelper
{
    @Override
    protected void onDataReceived(final ComBean ComRecData,final int size) {
        Log.e("TagSnake", "进入数据监听事件中。。。adsadsa" + ComRecData.bRec);
        String rfid = OtherUtils.bytesToHexT(ComRecData.bRec,size);
        Log.e("TagSnake", "进入数据监听事件中。。。" + rfid.trim());//.d("进入数据监听事件中。。。" + rfid);
        ReadCardEvent event = new ReadCardEvent();
        event.setCardmsg(rfid);
        RxBus2.getInstance().post(event);
    }
}
