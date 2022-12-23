package com.example.kinmenfoodmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class add_store extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_store);
    }
    public void btn_add_store(View view) {
        TextView output = (TextView) findViewById(R.id.lblOutput);
        output.setText("新增成功");
    }

    public void On_Click_finish(View view) {
        finish();
    }
}