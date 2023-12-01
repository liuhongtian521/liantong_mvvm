package com.askia.coremodel.datamodel.readCard;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.nfc.Tag;
import android.util.Log;

import com.askia.coremodel.datamodel.readCard.event.ReadCardEvent;
import com.askia.coremodel.util.OtherUtils;
import com.ttsea.jrxbus2.RxBus2;

import static android.nfc.NdefRecord.createMime;

/**
 * Create bt she:
 *
 * @date 2020/9/24
 */
public class NFCService implements NfcAdapter.CreateNdefMessageCallback {
    private static Activity activity;
    private static NfcAdapter mNfcAdapter;
    private static PendingIntent pi;
    private static final int READER_FLAGS = NfcAdapter.FLAG_READER_NFC_A
            | NfcAdapter.FLAG_READER_SKIP_NDEF_CHECK | NfcAdapter.FLAG_READER_NO_PLATFORM_SOUNDS;

    public static void start(Activity context, Class className) {
        activity = context;
        //初始化NfcAdapter
        mNfcAdapter = NfcAdapter.getDefaultAdapter(context);
        //初始化PendingIntent
        // 初始化PendingIntent，当有NFC设备连接上的时候，就交给当前Activity处理
        pi = PendingIntent.getActivity(context, 0,
                new Intent(context, className).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
    }

    public static void onrem(Activity activit) {
        if (mNfcAdapter != null)
            mNfcAdapter.enableReaderMode(activity, new NfcAdapter.ReaderCallback() {
                @Override
                public void onTagDiscovered(Tag tag) {

                    String CardId = OtherUtils.bytesToHex(tag.getId());//
                    ReadCardEvent event = new ReadCardEvent();
                    event.setCardmsg(CardId);
                    RxBus2.getInstance().post(event);
                }
            }, READER_FLAGS, null);
    }


    @Override
    public NdefMessage createNdefMessage(NfcEvent event) {
        String text = ("Beam me up, Android!\n\n" +
                "Beam Time: " + System.currentTimeMillis());
        NdefMessage msg = new NdefMessage(
                new NdefRecord[]{createMime(
                        "application/vnd.com.example.android.beam", text.getBytes())
                        , NdefRecord.createApplicationRecord("com.example.android.beam")});
        return msg;
    }

}
