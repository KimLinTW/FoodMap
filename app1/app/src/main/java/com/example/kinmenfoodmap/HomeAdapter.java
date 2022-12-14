package com.example.kinmenfoodmap;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class HomeAdapter extends ArrayAdapter<HomeListMapping> {
    public HomeAdapter(Activity context, ArrayList<HomeListMapping>homeListAdapters) {
        super(context,0,homeListAdapters );
    }
    @Override
    //改寫getView()方法
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        //listItemView可能會是空的，例如App剛啟動時，沒有預先儲存的view可使用
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.home_list_itemlayout, parent, false);
        }

        //找到data，並在View上設定正確的data
        HomeListMapping currentName = getItem(position);
        //用來接照片的網址

       // ((UrlImageView)findViewById(R.id.thumbnail)).setImageUrl("http://foo.bar.png");
       // TextView shopimage_view = listItemView.findViewById(R.id.shop_imageView);
        //shopimage_view.setText(currentName.getmPictueurl());

        //用來接商店名稱
        TextView name_view = listItemView.findViewById(R.id.name_view);
        name_view.setText(currentName.getmName());


        //用來接商店地址
        TextView address_view = listItemView.findViewById(R.id.address_view);
        address_view.setText(currentName.getmAddress());

        return listItemView;
    }
}
