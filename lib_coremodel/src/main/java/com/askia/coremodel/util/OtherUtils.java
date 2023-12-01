package com.askia.coremodel.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import com.blankj.utilcode.util.StringUtils;

/**
 * @Class:
 * @Description: 工具类
 * @Date: 2015/11/4
 */
public class OtherUtils {

    public static final int getHeightInPx(Context context) {
        final int height = context.getResources().getDisplayMetrics().heightPixels;
        return height;
    }

    public static final int getWidthInPx(Context context) {
        final int width = context.getResources().getDisplayMetrics().widthPixels;
        return width;
    }

    public static final int getHeightInDp(Context context) {
        final float height = context.getResources().getDisplayMetrics().heightPixels;
        int heightInDp = px2dip(context, height);
        return heightInDp;
    }

    public static final int getWidthInDp(Context context) {
        final float width = context.getResources().getDisplayMetrics().widthPixels;
        int widthInDp = px2dip(context, width);
        return widthInDp;
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static String bytesToHexT(byte[] bytes, int size) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() < 2) {
                sb.append(0);
            }
            sb.append(hex);
        }
        Log.e("TagSnake", "转码数据:" + sb.toString());
        return new String(bytes, 0, size);
    }

    /**
     * 字节数组转16进制
     *
     * @param bytes 需要转换的byte数组
     * @return 转换后的Hex字符串
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        Log.e("TagSnake", bytes + "");

        if (bytes.length == 12) {
            for (int i = 0; i < bytes.length - 2; i++) {
//            sb.append(Byte2Hex(bytes[i]));
                String hex = Integer.toHexString(bytes[i] & 0xFF).substring(1);
                Log.e("TagSnake", hex + "");
//                if (hex.length() < 2) {
//                    sb.append(0);
//                }
                sb.append(hex);
            }
            return sb.toString();
        } else {
            for (int i = bytes.length - 1; i >= 0; i--) {
                String hex = Integer.toHexString(bytes[i] & 0xFF);
                Log.e("TagSnake", hex + "");
                if (hex.length() < 2) {
                    sb.append(0);
                }
                sb.append(hex);
            }
            String backnum = hexToDec(sb.toString());
            int addNum = 10 - backnum.length();
            for (int num = 0; num < addNum; num++) {
                backnum = "0" + backnum;
            }
            return backnum;
        }
    }

    public static String ByteArrayToHexString(byte[] inarray) {
        int i, j, in;
        String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A",
                "B", "C", "D", "E", "F"};
        String out = "";
        for (j = 0; j < inarray.length; ++j) {
            in = (int) inarray[j] & 0xff;
            i = (in >> 4) & 0x0f;
            out += hex[i];
            i = in & 0x0f;
            out += hex[i];
        }
        return ChangeString(out);
    }


    public static String ChangeString(String number) {

        StringBuffer s1 = new StringBuffer(number);
        int index;
        for (index = 2; index < s1.length(); index += 3) {
            s1.insert(index, ',');
        }
        String[] array = s1.toString().split(",");
        Log.e("TagSnake", s1 + ":" + array.length);
        int showString = 0;
        StringBuffer s2 = new StringBuffer();
        for (int thisIndex = array.length - 1; thisIndex > 0; thisIndex--) {
            if (array[thisIndex].length() == 1)
                s2.append("0" + array[thisIndex]);
            else
                s2.append(array[thisIndex]);
        }
        Log.e("TagSnake", s2.toString());
        showString = Integer.valueOf(String.valueOf(s2), 16);
        return "" + showString;
    }

    public static String hexToDec(String hex) {
        long mun = Long.parseLong(hex, 16);
        return Long.toString(mun, 10);
    }

    public static String Byte2Hex(byte inByte) {
        return String.format("%02x", inByte).toUpperCase();
    }

    public static Bitmap base64ToImageView(String base64Img) {
        byte[] decode = null;
        if (isBase64Img(base64Img)) {
            decode = Base64.decode(base64Img.split(",")[1], Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        }
        return null;
    }

    public static boolean isBase64Img(String imgurl) {
        if (!StringUtils.isEmpty(imgurl) && (imgurl.startsWith("data:image/png;base64,")
                || imgurl.startsWith("data:image/*;base64,") || imgurl.startsWith("data:image/jpg;base64,") || imgurl.startsWith("data:image/jpeg;base64,"))
        ) {
            return true;
        }
        return false;
    }
}
