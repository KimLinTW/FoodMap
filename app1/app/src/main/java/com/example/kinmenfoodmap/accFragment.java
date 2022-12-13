package com.example.kinmenfoodmap;
//首頁的個人資料
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



public class accFragment extends Fragment {


   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_acc, container, false);
        // Inflate the layout for this fragment


        Button btn1 = (Button) view.findViewById(R.id.btn_record);
        Button btn_person = (Button) view.findViewById(R.id.btn_person);
        Button btn_discount = (Button) view.findViewById(R.id.btn_discount);
        Button btn_bug = (Button) view.findViewById(R.id.btn_bug);


        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//              跳轉頁面
               Intent intent = new Intent(getActivity(),ActivityGood.class);
               startActivity(intent);
            }
        });

        btn_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),modify_personal_info.class);
                startActivity(intent);
            }
        });

        btn_discount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),discount_show.class);
                startActivity(intent);
            }
        });
        btn_bug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), bugreport.class);
                startActivity(intent);
            }
        });




    return view;

    }

    private  void replaceFragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.menu_layout,fragment);
//        fragmentTransaction.commit();
    }
}