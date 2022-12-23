package com.example.kinmenfoodmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class log_in_new extends AppCompatActivity {

    private EditText txtAccount;
    private EditText txtPassword;
    private String acc = "", pass = "";
    private String passres = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_new);

        txtAccount = (EditText) findViewById(R.id.txtAccount);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
    }

    public void signbtn(View view){
        Intent intent = new Intent(this, Sign_in_new.class);
        startActivity(intent);
    }

    public void logbtn(View view){
        acc = txtAccount.getText().toString();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("login");
        query.whereEqualTo("user_name", acc);
        System.out.println(acc);

        query.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException n) {
                if (n==null){
                    System.out.println("ok:");
                    passres += object.getString("hash_pass");
                    System.out.println(passres);

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
                    pass = sb.toString();
                    System.out.println("!"+pass + "!");
                    System.out.println(pass.getClass().getSimpleName());
                    System.out.println("!"+ passres + "!");
                    System.out.println(passres.getClass().getSimpleName());

                    if (pass.equals(passres)){
                        System.out.println("登入成功");
//            Toast.makeText(null, "登入成功", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        System.out.println("密碼錯誤");
//            Toast.makeText(null, "密碼錯誤", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    System.out.println("error");
                    System.out.println("帳號錯誤");
//                    Toast.makeText(null, "帳號錯誤", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    public void btn_clk(View view){
        finish();
    }
}