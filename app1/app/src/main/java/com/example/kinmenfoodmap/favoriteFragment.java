package com.example.kinmenfoodmap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link favoriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class favoriteFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public favoriteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment favoriteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static favoriteFragment newInstance(String param1, String param2) {
        favoriteFragment fragment = new favoriteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }



    public void button_Click(View view){
//        TextView output = (TextView)findViewById(R.id.show_db);
    }

    @Override
    public void onClick(View view) {
        TextView output = (TextView)findViewById(R.id.show_db);
        // 點擊[view]顯示一些東西   問題:找不到findViewById ->  import androidx.appcompat.app.AppCompatActivity;未生效 原因: 不知道??
        // 在MainActivity.java import 有生效 -> findViewById 功能也正常
//        output_db = output_db.findViewById(R.id.show_db);
//        output_db.setText("123");
    }
}