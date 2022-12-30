package com.example.kinmenfoodmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

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

        ParseQuery<ParseObject> query = ParseQuery.getQuery("login");
        query.whereEqualTo("user_name", txtAccount.getText().toString());

        query.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject player, ParseException f) {
                if (f == null) {
                    System.out.println("ok");
                    Toast.makeText(getApplicationContext(),"帳號名稱重複",Toast.LENGTH_SHORT).show();
                } else {
                    System.out.println("error");

                    if (txtPassword.getText().toString() == null){
                        Toast.makeText(getApplicationContext(),"密碼不能空白",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        MessageDigest md = null;
                        try {
                            md = MessageDigest.getInstance("SHA-1");
                        } catch (NoSuchAlgorithmException e) {
                            e.printStackTrace();
                        }
                        byte[] password = new byte[0];
                        try {
                            String pass;
                            pass = txtPassword.getText().toString();
                            password = pass.getBytes("UTF-8");

                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        password = md.digest(password);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : password) {
                            sb.append(String.format("%02x", b));
                        }
                        System.out.println(sb);
                        String sign = sb.toString();
                        ParseObject firstObject = new ParseObject("login");
                        firstObject.put("user_name", txtAccount.getText().toString());
                        firstObject.put("hash_pass",sign);
                        firstObject.saveInBackground(e -> {
                            if (e != null){
                                Log.e("MainActivity", e.getLocalizedMessage());
                            }else{
                                Log.d("MainActivity","Object saved.");
                                Toast.makeText(getApplicationContext(),"註冊成功",Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                    }
                }
            }
        });
    }
}