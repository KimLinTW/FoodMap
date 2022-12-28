package com.example.kinmenfoodmap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bugreport extends AppCompatActivity implements
        DialogInterface.OnClickListener,
        AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bugreport);
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int which) {
        switch (which){
            case DialogInterface.BUTTON_POSITIVE:
                finish();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                break;
        }
    }
    public void button_Click(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("已回報").setPositiveButton("離開", this).setNegativeButton("繼續回報", this).show();
    }
    public void button2_Click(View view){
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}