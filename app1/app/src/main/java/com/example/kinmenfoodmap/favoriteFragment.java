package com.example.kinmenfoodmap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

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
        System.out.println("這裡嗎");
        Button btn1 = (Button) view.findViewById(R.id.button2);

        System.out.println("還是這裡嗎");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("跳出來");
            }
        });



        return view;
    }



    public void button_Click(View view){
//        TextView output = (TextView)findViewById(R.id.show_db);
    }

    @Override
    public void onClick(View view) {
        TextView output = (TextView)getView().findViewById(R.id.show_db);
        // 點擊[view]顯示一些東西   問題:找不到findViewById ->  import androidx.appcompat.app.AppCompatActivity;未生效 原因: 不知道??
        // 在MainActivity.java import 有生效 -> findViewById 功能也正常
//        output_db = output_db.findViewById(R.id.show_db);
//        output_db.setText("123");
    }
}