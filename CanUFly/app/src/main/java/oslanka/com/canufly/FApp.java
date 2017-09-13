package oslanka.com.canufly;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

/**
 * Created by Administrator on 2017/9/13.
 */

public class FApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("info----ip------>",getIp(this));

    }
    public  String getIp(Context context) {
        // 获取WiFi服务
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
// 判断WiFi是否开启
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipAddress = wifiInfo.getIpAddress();
        String ip = (ipAddress & 0xFF) + "." +
                ((ipAddress >> 8) & 0xFF) + "." +
                ((ipAddress >> 16) & 0xFF) + "." +
                (ipAddress >> 24 & 0xFF);
        return ip;
    }
}
