package com.example.kinmenfoodmap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQuery;

public class favoriteFragment extends Fragment {
    private String latandlng = "";
    private static String DATABASE_TABLE = "favorite";
    private SQLiteDatabase db;
    private StdDBHelper dbHelper;
    private String sql;
    private com.example.kinmenfoodmap.show_restaurant show_restaurant;
    public static FavoriteAdapter listAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStop() {
        super.onStop();
        try {
            db.close();
        }catch (Exception e){
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        Button showfavorite = (Button)view.findViewById(R.id.show);
        TextView output = (TextView)view.findViewById(R.id.rest_list);

        showfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("123");
                try{
                    Context context = getActivity();
                    dbHelper = new StdDBHelper(context);
                    db = dbHelper.getWritableDatabase();
                    SqlQuery("SELECT * FROM " + DATABASE_TABLE, context);
                }
                catch (Exception ex){
                    System.out.println(ex.toString());
                }
            }
            private void SqlQuery(String sql, Context context) {
                String[] colNames;
                String str = "";
                String resName = "";
                Cursor c = db.rawQuery(sql, null);
                colNames = c.getColumnNames();
                for(int i = 0;i < colNames.length;i++){
                    str += colNames[i] + "\t\t";
                }
                str += "\n";
                c.moveToFirst();
                for(int i = 0;i < c.getCount();i++){
                    str += c.getString(0) + "\t\t";
                    str += c.getString(1) + "\n";
                    resName += i+1 + ".";
                    resName += c.getString(0);
                    resName += "\n";
                    c.moveToNext();
                }
                System.out.println(str.toString());
                System.out.println(resName);
                output.setText(resName);
            }
        });


        // Inflate the layout for this fragment
/*
      vvvvvvvvvvvvvvvvvvvvvv  example: add something to remoted database   vvvvvvvvvvvvvvvvvvvvvvvvvvvv
                ParseObject firstObject = new ParseObject("FirstClass");
                firstObject.put("message","Hey ! First message from android. Parse is now connected");
                firstObject.saveInBackground(e -> {
                    if (e != null){
                        Log.e("MainActivity", e.getLocalizedMessage());
                    }else{
                        Log.d("MainActivity","Object saved.");
                    }
                });
      ^^^^^^^^^^^^^^^^^^^^^^  example: add something to remoted database   ^^^^^^^^^^^^^^^^^^^^^^^^^^^
            }
        });
*/
        return view;
    }

    private static class FavoriteAdapter {
    }
}