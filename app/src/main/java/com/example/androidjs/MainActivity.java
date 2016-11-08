package com.example.androidjs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnJavaAndJs;
    private Button btnJsCallJava;
    private Button btnJsCallPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2016-11-08 16:33:59 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        btnJavaAndJs = (Button)findViewById( R.id.btn_java_and_js );
        btnJsCallJava = (Button)findViewById( R.id.btn_js_call_java );
        btnJsCallPhone = (Button)findViewById( R.id.btn_js_call_phone );

        btnJavaAndJs.setOnClickListener(this);
        btnJsCallJava.setOnClickListener(this);
        btnJsCallPhone.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2016-11-08 16:33:59 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == btnJavaAndJs ) {
            Intent i = new Intent(this,JavaAndJsCallActivity.class);
            startActivity(i);

        } else if ( v == btnJsCallJava ) {
            // Handle clicks for btnJsCallJava
            Intent i = new Intent(this,JsCallJavaVideoActivity.class);
            startActivity(i);
        } else if ( v == btnJsCallPhone ) {
            Intent i = new Intent(this,JsCallJavaPhoneActivity.class);
            startActivity(i);
        }
    }



}
