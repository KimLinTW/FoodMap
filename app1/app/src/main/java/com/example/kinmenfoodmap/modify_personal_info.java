package com.example.kinmenfoodmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class modify_personal_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_personal_info);
        TextView output = (TextView) findViewById(R.id.textView12);
        output.setText("正在載入資料...");

    }
    public void Onclick(View view){
        finish();
    }

}