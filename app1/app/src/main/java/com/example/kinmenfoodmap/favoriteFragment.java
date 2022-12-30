package com.example.kinmenfoodmap;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQuery;

public class favoriteFragment extends Fragment implements View.OnClickListener {
    private String latandlng = "";
    private static String DATABASE_TABLE = "favorite";
    private SQLiteDatabase db;
    private StdDBHelper dbHelper;
    private String sql;
    private com.example.kinmenfoodmap.show_restaurant show_restaurant;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStop() {
        super.onStop();
        db.close();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        Button showfavorite = (Button)view.findViewById(R.id.show);
        
        String[] resAddress;
        
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
                    resName += c.getString(0);
                    resName += ", ";
                    c.moveToNext();

                }
                System.out.println(str.toString());
                System.out.println(resName);
            }
        });
  /*      listfavorite.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listfavorite
            }
        });
*/
        // Inflate the layout for this fragment
/*
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            // show app
            public void onClick(View view) {
                ParseQuery<ParseObject> query = ParseQuery.getQuery("Shop");
                query.whereEqualTo("shopName", "浯洲金鼎燒鍋");
                query.getFirstInBackground(new GetCallback<ParseObject>() {
                    public void done(ParseObject player, ParseException e) {
                        if (e == null) {
                            System.out.println("ok:");
                            String response="", lat = "", lng = "";
                            response += player.getString("shopName");
                            response += "\n";
                            response += player.getInt("ID");
                            response += "\n";
                            response += player.getString("address");
                            response += "\n";
                            response += player.getString("ShopPicture");
                            response += "\n";
                            response += player.getString("closing");
                            response += "\n";
                            response += player.getString("business");
                            response += "\n";
                            response += player.getParseGeoPoint("latitude_longitude");
                            response += "\n";

                            lat += player.getParseGeoPoint("latitude_longitude").getLatitude();
                            lng += player.getParseGeoPoint("latitude_longitude").getLongitude();
                            //latlng += player.getParseGeoPoint("latitude_longitude");

                            System.out.println(response);
                            output.setText(response);
                        } else {
                            System.out.println("error");
                        }
                    }
                });
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^");
                latandlng = output.getText().toString();
                System.out.println(latandlng);
                //output.setText(response);
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
        }); */
        return view;
    }


/*
    public void buttonclllick(View view){
        System.out.println("123");
        try {
            SqlQuery("SELECT * FROM " + DATABASE_TABLE);
        }
        catch (Exception ex){
            System.out.println("錯誤" + ex.toString());
        }
    }

    private void SqlQuery(String sql) {
        String[] colNames;
        String str = "";
        Cursor c = db.rawQuery(sql, null);
        colNames = c.getColumnNames();
        for(int i = 0;i < colNames.length;i++){
            str +=colNames[i] + "\t\t";
        }
        str += "\n";
        c.moveToFirst();
        for(int i = 0;i < c.getCount();i++){
            str += c.getString(0) + "\t\t";
            str += c.getString(1) + "\n";
            c.moveToNext();
        }
        System.out.println(str.toString());
    }*/



    @Override
    public void onClick(View view) {
        System.out.println("跳跳出來");
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Shop");

        // The query will search for a ParseObject, given its objectId.
        // When the query finishes running, it will invoke the GetCallback
        // with either the object, or the exception thrown
        query.getInBackground("<PARSE_OBJECT_ID>", (object, e) -> {
            if (e == null) {
                //Object was successfully retrieved
            } else {
                // something went wrong
                System.out.println("有東西");
               // Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //TextView output = (TextView)getView().findViewById(R.id.show_db);
        // 點擊[view]顯示一些東西   問題:找不到findViewById ->  import androidx.appcompat.app.AppCompatActivity;未生效 原因: 不知道??
        // 在MainActivity.java import 有生效 -> findViewById 功能也正常
//        output_db = output_db.findViewById(R.id.show_db);
//        output_db.setText("123");
    }




}