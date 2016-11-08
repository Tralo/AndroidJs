package com.example.androidjs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class JavaAndJsCallActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_and_js_call);
        findViews();
        initWebView();
    }
    private EditText etNumber;
    private EditText etPassword;
    private Button btnLogin;
    private WebView webView;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2016-11-08 16:42:09 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews(){
        etNumber = (EditText)findViewById( R.id.et_number );
        etPassword = (EditText)findViewById( R.id.et_password );
        btnLogin = (Button)findViewById( R.id.btn_login );

        btnLogin.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2016-11-08 16:42:09 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == btnLogin ) {
            String number = etNumber.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();
            if(TextUtils.isEmpty(number) || TextUtils.isEmpty(pass)){
                Toast.makeText(JavaAndJsCallActivity.this,"帐号或密码不能为空",Toast.LENGTH_SHORT).show();;
                return;
            }
            //登录逻辑
//            initWebView();
            login(number);
        }
    }

    private void login(String number) {
        webView.loadUrl("javascript:javaCallJs('"+ number +"')");
        setContentView(webView);
    }

    private void initWebView() {
        //1.加载网页-H5,html,自定义浏览器
        webView = new WebView(this);
        //设置支持javascript(js)
        webView.getSettings().setJavaScriptEnabled(true);
        //不调用自己的浏览器--自定义了浏览器
        webView.setWebViewClient(new WebViewClient());
        webView.addJavascriptInterface(new AndroidAndJsInterface(),"Android");

        //加载网络的网页-本地网页
//        webView.loadUrl("https://www.baidu.com");
        webView.loadUrl("file:///android_asset/JavaAndJavaScriptCall.html");
//        setContentView(webView);

        }

    class AndroidAndJsInterface{
        @JavascriptInterface
        public void showToast(){
            Toast.makeText(JavaAndJsCallActivity.this,"我是被js调用的android代码",Toast.LENGTH_SHORT).show();
        }
    }




}
