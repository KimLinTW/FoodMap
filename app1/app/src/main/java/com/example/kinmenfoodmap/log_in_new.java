package com.example.kinmenfoodmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class log_in_new extends AppCompatActivity {

    private EditText txtAccount;
    private EditText txtPassword;
    private String acc = "", pass = "";

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
        ParseQuery<ParseObject> query = ParseQuery.getQuery("login");
        query.whereEqualTo("username", txtAccount);

        query.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e==null){
                    System.out.println("ok:");
                    acc += object.getString("user_name");
                    pass += object.getString("hash_pass");
                }
                else {
                    System.out.println("error");
                }
            }

        });
        if (txtAccount.getText().toString() != acc){
            System.out.println("account is null");
        }
        else if(txtPassword.getText().toString() != pass){
            System.out.println("password is wrong");
        }
        else if (txtAccount.getText().toString() == acc && txtPassword.getText().toString() == pass){
            System.out.println("welcome" + txtAccount.getText().toString());
        }
    }




    public void btn_clk(View view){
        finish();
    }
}