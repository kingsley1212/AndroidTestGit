package com.bai.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.net.URISyntaxException;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WebView web;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView text = (TextView) findViewById(R.id.text);
        web = (WebView) findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("http://192.168.1.127/oz_chat/oz_main/public/wap/html/mortgage/mortgage/test.html");
        if (Build.VERSION.SDK_INT >= 19) {
            web.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }
        web.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                if (shouldOverrideUrlLoadingByApp(view, url)) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
    }
    /**
     * 根据url的scheme处理跳转第三方app的业务
     */
    private boolean shouldOverrideUrlLoadingByApp(WebView view, String url) {
//        if (url.startsWith("http") || url.startsWith("https") || url.startsWith("ftp")) {
//            //不处理http, https, ftp的请求
//            return false;
//        }
        Intent intent;
        try {
            intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
        } catch (URISyntaxException e) {
//            XLLog.e(TAG, "URISyntaxException: " + e.getLocalizedMessage());
            return false;
        }
        intent.setComponent(null);
        try {
            Main2Activity.this.startActivity(intent);
        } catch (ActivityNotFoundException e) {
//            XLLog.e(TAG, "ActivityNotFoundException: " + e.getLocalizedMessage());
            return false;
        }
        return true;
    }
}
