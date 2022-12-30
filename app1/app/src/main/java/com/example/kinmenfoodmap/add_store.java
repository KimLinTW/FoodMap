package com.example.kinmenfoodmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.io.Serializable;

public class add_store extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_store);
    }
    public void btn_add_store(View view) {

        TextView output = (TextView) findViewById(R.id.lblOutput1);//改用toast
        TextView address = (TextView) findViewById(R.id.shop_addr);
        TextView shop_name = (TextView) findViewById(R.id.shopname);



        //vvvvvvvvvvvvvvvvvvvvvv  example: add something to remoted database   vvvvvvvvvvvvvvvvvvvvvvvvvvvv
        ParseObject firstObject = new ParseObject("Shop");
        //ParseObject secObject = new ParseObject("ID");//mikey於20221230新增
        firstObject.put("shopName", shop_name.getText().toString());
        firstObject.put("address", address.getText().toString());
        //secObject.put("address", shop_name.getText().toString());//mikey於20221230更改firstObject為secObject
        firstObject.put("ID", 0);//有需要新增id嗎
//        ParseGeoPoint currentUserLocation = new ParseGeoPoint(location.getLatitude(), location.getLongitude());
        ParseGeoPoint currentUserLocation = new ParseGeoPoint(0.2, 0.3);
        firstObject.put("latitude_longitude",currentUserLocation );
       // firstObject.put("ID", 0);


        firstObject.saveInBackground(e -> {
            if (e != null){
                Toast.makeText(this,"新增失敗,請檢查是否有空欄位或是網路問題",Toast.LENGTH_SHORT).show();
                Log.e("MainActivity", e.getLocalizedMessage());
            }else{
                Toast.makeText(this,"新增成功",Toast.LENGTH_SHORT).show();
                Log.d("MainActivity","Object saved.");
                finish();
            }
        });
        //secObject.saveInBackground(e -> {
        //    if (e != null){
        //        Log.e("MainActivity", e.getLocalizedMessage());
        //    }else{
        //        Log.d("MainActivity","Object saved.");
        //    }
        //});
        //^^^^^^^^^^^^^^^^^^^^^^  example: add something to remoted database   ^^^^^^^^^^^^^^^^^^^^^^^^^^^
    }


    public void On_Click_finish(View view) {
        finish();
    }
}