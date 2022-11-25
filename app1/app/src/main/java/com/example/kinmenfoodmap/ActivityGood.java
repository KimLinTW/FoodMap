package com.example.kinmenfoodmap;
//測試用的FragmentToActivity

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class ActivityGood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good);
    }

    public   void  Onclick(View view)
    {
        finish();
    }
}