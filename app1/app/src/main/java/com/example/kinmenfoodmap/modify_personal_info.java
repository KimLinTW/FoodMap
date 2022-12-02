package com.example.kinmenfoodmap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class modify_personal_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_personal_info);
        TextView output = (TextView) findViewById(R.id.textView12);
        output.setText("DD");
    }
    public void Onclick(View view){
        finish();
    }

}