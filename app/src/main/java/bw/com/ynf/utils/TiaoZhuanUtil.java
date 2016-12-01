package bw.com.ynf.utils;

import android.content.Context;
import android.content.Intent;

import bw.com.ynf.activity.WebActivity;


/**
 * webView的设置跳转的一个类
 */
public class TiaoZhuanUtil {

    public static void tiaoZhuan(Context context, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }
}
