package com.example.kinmenfoodmap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class show_restaurant extends AppCompatActivity {
    private TextView name, address;
    private WebView web;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_restaurant);
        name = (TextView) findViewById(R.id.restaurant_name);
        address = (TextView) findViewById(R.id.restaurant_address);
        web = (WebView) findViewById(R.id.webview);
        web.getSettings().setJavaScriptEnabled(true);
        web.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        web.setWebViewClient(new myWebViewClient());
        //String name =  rest_name += player.getString("shopName");
        //rest_address += player.getString("address");
        Bundle bundle = this.getIntent().getExtras();
        String rest_name = bundle.getString("shopName");
        String rest_address  = bundle.getString("address");
        //System.out.println("看到這裡的bundle");
        name.setText("餐廳名稱"+rest_name);
        address.setText("地址"+rest_address);

    }

    public void return_Click(View view){
        finish();
    }

    public void onClick(View view) {
        /*ParseQuery<ParseObject> query = ParseQuery.getQuery("Shop");
        query.whereEqualTo("shopName", "浯洲金鼎燒鍋");
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject player, ParseException e) {
                if (e == null) {
                    String response="", rest_name="", rest_address="", rest_shoppic="";

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

                    rest_name += player.getString("shopName");
                    rest_address += player.getString("address");

                    rest_shoppic = player.getString("ShopPicture");

                    System.out.println(response);
                    name.setText(rest_name);
                    address.setText(rest_address);
                    url = rest_shoppic;
                } else {
                    System.out.println("error");
                }
            }
        });

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^");*/



    }

    class myWebViewClient extends WebViewClient{
        @SuppressWarnings("deprecation")
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            web.loadUrl(url);
            return true;
        }
        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request){
            web.loadUrl(request.getUrl().toString());
            return true;
        }
    }
    public void button_image(View view){

        web.loadUrl(url);
    }
}