package com.example.androidjs;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class JsCallJavaVideoActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js_call_java_video);
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        //不调用自己的浏览器--自定义了浏览器
        webView.setWebViewClient(new WebViewClient());
        webView.addJavascriptInterface(new AndroidAndJsInterface(),"android");

        //加载网络的网页-本地网页
//        webView.loadUrl("https://www.baidu.com");
        webView.loadUrl("file:///android_asset/RealNetJSCallJavaActivity.htm");
    }

    class AndroidAndJsInterface{
        @JavascriptInterface
        public void playVideo(int id,String videourl,String title){
            //1.把所有的播放调起来，并且播放
            Intent i = new Intent();

            i.setDataAndType(Uri.parse("http://vfx.mtime.cn/Video/2016/10/21/mp4/161021080707964346_480.mp4"),"video/*");
            startActivity(i);
            Toast.makeText(JsCallJavaVideoActivity.this,"id: " + id + " ,videourl: " + videourl + ",title: " + title,Toast.LENGTH_SHORT).show();
        }
    }
}
