package com.example.kinmenfoodmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
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
    c. 跟資料庫連接 (林廣哲)
    d. 把東西(喜愛店家)存在使用者的裝置上?
    e. 實作一個可以方便建立大量店家的API
    f. 紀錄店家被查看的次數 並 統計

*/