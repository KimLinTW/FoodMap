package com.example.kinmenfoodmap;

public class HomeListMapping {

    private String mPictueurl;
    private String mName;


    private String mAddress;

    //建構式
    //public HomeListMapping(String tortoisesSciName, String tortoisesTwName){

    public HomeListMapping(String Pictureurl ,String tortoisesSciName, String tortoisesTwName){
      mPictueurl = Pictureurl;
        mName = tortoisesSciName;
        mAddress = tortoisesTwName;
    }
    public String getmPictueurl(){
        return mPictueurl;
    }
    //方法1.傳回學名
    public String getmName(){
        return mName;
    }

    //方法2.傳回中文名
    public String getmAddress(){
        return mAddress;
    }
}
