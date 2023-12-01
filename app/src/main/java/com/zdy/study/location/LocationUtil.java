package com.zdy.study.location;


import android.location.LocationManager;
import android.os.Build;

public class LocationUtil {

    //GPS开关是否打开
    public static boolean isGpsEnable(LocationManager mLocationManager) {
        return mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public static void startLocationService() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
             } else {
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

}
