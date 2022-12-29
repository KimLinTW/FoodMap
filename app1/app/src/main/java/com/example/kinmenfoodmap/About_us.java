package com.example.kinmenfoodmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class About_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        //TextView output = (TextView) findViewById(R.id.textView27);
        //output.setText("組長:林廣哲 組員:林聖軒 組員:陳彥辰 組員:黃柏鈞 組員:吳柏翰");
    }
    public   void  Onclick(View view)
    {
        finish();
    }
}
