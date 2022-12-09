package com.example.kinmenfoodmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class log_in_new extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_new);
    }
    Button go_to_sign = (Button)findViewById(R.id.go_sign_in);





    public void btn_clk(View view){
        finish();
    }
}