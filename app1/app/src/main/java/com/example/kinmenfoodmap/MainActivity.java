package com.example.kinmenfoodmap;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.item1:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.item2:
                            selectedFragment = new SearchFragment();
                            break;
                        case R.id.item3:
                            selectedFragment = new BoxFragment();
                            break;
                        case R.id.item4:
                            selectedFragment = new LikeFragment();
                            break;
                        case R.id.item5:
                            selectedFragment = new UserFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };
}

// 到這邊 分配工作
/*

HELLO 測試GIT PUSH

1. xml設計
    a. 分頁功能
    b. 基本元件(id)
    c. 美觀

2. 主程式
    a. 實作每個元件對應的功能
    b. 跟地圖連接
    c. 跟資料庫連接 (58 林廣哲)
    d. 把東西(喜愛店家)存在使用者的裝置上?
    e. 實作一個可以方便建立大量店家的API
    f. 紀錄店家被查看的次數 並 統計

    Mikey hello!
    helloooooooo56

*/