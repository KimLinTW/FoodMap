package com.example.kinmenfoodmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseObject;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sign_in_new extends AppCompatActivity {

    private EditText txtAccount;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_new);
        txtAccount = (EditText) findViewById(R.id.txtsignin_Account);
        txtPassword = (EditText) findViewById(R.id.txtsignin_Password);
    }

    public void signin_btn1_Click(View view){
        finish();
    }

    public void signin_btn2_Click(View view){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] password = new byte[0];
        try {
            password = txtPassword.getText().toString().getBytes("UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        password = md.digest(password);
        StringBuilder sb = new StringBuilder();
        for (byte b : password) {
            sb.append(String.format("%02x", b));
        }

        ParseObject firstObject = new ParseObject("login");
        firstObject.put("message",password);
        firstObject.saveInBackground(e -> {
            if (e != null){
                Log.e("MainActivity", e.getLocalizedMessage());
            }else{
                Log.d("MainActivity","Object saved.");
            }
        });
    }

}