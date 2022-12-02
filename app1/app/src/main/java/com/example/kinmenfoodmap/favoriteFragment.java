package com.example.kinmenfoodmap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class favoriteFragment extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        // Inflate the layout for this fragment

        Button btn1 = (Button) view.findViewById(R.id.button2);

        Button btn2 = (Button) view.findViewById(R.id.button3);
        TextView output = (TextView) view.findViewById(R.id.result_db);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText("Button 1");
                ParseQuery<ParseObject> query = ParseQuery.getQuery("FirstClass");
                query.whereEqualTo("objectId", "0mfC6T5HHR");



                System.out.println(query);
                query.getFirstInBackground(new GetCallback<ParseObject>() {
                    public void done(ParseObject player, ParseException e) {
                        System.out.println("10");
                        if (e == null) {
                            System.out.println("ok:");
                            String response;
                            response = player.getString("message");
                            System.out.println(response);
                        } else {
                            System.out.println("error");
                            // Something is wrong
                        }
                    }
                });

                query.getInBackground("0mfC6T5HHR", new GetCallback<ParseObject>() {
                    public void done(ParseObject player, ParseException e) {
                        if (e == null) {
                            // Now let's update it with some new data. In this case, only cheatMode and score
                            // will get sent to the Parse Cloud. playerName hasn't changed.
//                            player.put("yearOfBirth", 1998);
//                            player.put("emailContact", "a.wed@domain.io");

                            player.put("message","yes1");
                            player.put("objectId","123");
                            player.saveInBackground();
                        } else {
                            // Failed
                        }
                    }
                });

                /*
                query.findInBackground(new FindCallback<ParseObject>() {
                    public void done(List<ParseObject> objects, ParseException e) {
                        if (e == null) {
                            objectsWereRetrievedSuccessfully(objects);
                            System.out.println("1");
                            System.out.println(objects);
                        } else {
                            System.out.println(objects);
                            System.out.println("2");
                            output.setText("db error");
                        }
                    }


                    private void objectsWereRetrievedSuccessfully(List<ParseObject> objects) {
                        System.out.println("3");
                        System.out.println(objects);
                        output.setText(objects.toString());
                    }
                }); */



            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                output.setText("Button 2");

//      vvvvvvvvvvvvvvvvvvvvvv  example: add something to remoted database   vvvvvvvvvvvvvvvvvvvvvvvvvvvv
                ParseObject firstObject = new ParseObject("FirstClass");
                firstObject.put("message","Hey ! First message from android. Parse is now connected");
                firstObject.saveInBackground(e -> {
                    if (e != null){
                        Log.e("MainActivity", e.getLocalizedMessage());
                    }else{
                        Log.d("MainActivity","Object saved.");
                    }
                });
//      ^^^^^^^^^^^^^^^^^^^^^^  example: add something to remoted database   ^^^^^^^^^^^^^^^^^^^^^^^^^^^
            }
        });




        return view;
    }



    public void button_Click(View view){
//        TextView output = (TextView)findViewById(R.id.show_db);
    }

    @Override
    public void onClick(View view) {
        System.out.println("跳跳出來");
        TextView output = (TextView)getView().findViewById(R.id.show_db);
        // 點擊[view]顯示一些東西   問題:找不到findViewById ->  import androidx.appcompat.app.AppCompatActivity;未生效 原因: 不知道??
        // 在MainActivity.java import 有生效 -> findViewById 功能也正常
//        output_db = output_db.findViewById(R.id.show_db);
//        output_db.setText("123");
    }




}