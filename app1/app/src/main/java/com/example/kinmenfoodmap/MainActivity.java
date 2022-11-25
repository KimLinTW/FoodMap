package com.example.kinmenfoodmap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import android.widget.TextView;


import com.parse.Parse;
import com.parse.ParseObject;
import com.example.kinmenfoodmap.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.menu.setOnItemSelectedListener(item -> {

            switch (item.getItemId())
            {
                case R.id.item1:
                    replaceFragment(new HomeFragment());
                    break;
                case  R.id.item2:
                    replaceFragment(new searchFragment());
                    break;
                case  R.id.item3:
                    replaceFragment(new SurpriseFragment());
                    break;
                case  R.id.item4:
                    replaceFragment(new favoriteFragment());
                    break;
                case  R.id.item5:
                    replaceFragment(new accFragment());
                    break;

            }



        return  true;
        });


    }

    private  void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.menu_layout,fragment);
        fragmentTransaction.commit();
    }



}

// 到這邊 分配工作
/*
1. xml設計
    a. 分頁功能 ------------------------------- Done
    b. 基本元件(id)
    c. 美觀

2. 主程式
    a. 實作每個元件對應的功能
    b. 跟地圖連接
    c. 跟資料庫連接 (58 林廣哲)
    d. 把東西(喜愛店家)存在使用者的裝置上?
    e. 實作一個可以方便建立大量店家的API
    f. 紀錄店家被查看的次數 並 統計

*/