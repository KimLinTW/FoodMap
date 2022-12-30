package com.example.kinmenfoodmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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

        TextView output = (TextView) findViewById(R.id.lblOutput1);
        TextView address = (TextView) findViewById(R.id.shop_addr);
        TextView shop_name = (TextView) findViewById(R.id.shopname);

        output.setText("新增成功");

        //vvvvvvvvvvvvvvvvvvvvvv  example: add something to remoted database   vvvvvvvvvvvvvvvvvvvvvvvvvvvv
        ParseObject firstObject = new ParseObject("Shop");

        firstObject.put("shopName", shop_name.getText().toString());
        firstObject.put("address", shop_name.getText().toString());
        firstObject.put("ID", 0);
//        ParseGeoPoint currentUserLocation = new ParseGeoPoint(location.getLatitude(), location.getLongitude());
        ParseGeoPoint currentUserLocation = new ParseGeoPoint(0.2, 0.3);
        firstObject.put("latitude_longitude",currentUserLocation );
        firstObject.put("ID", 0);

        firstObject.saveInBackground(e -> {
            if (e != null){
                Log.e("MainActivity", e.getLocalizedMessage());
            }else{
                Log.d("MainActivity","Object saved.");
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