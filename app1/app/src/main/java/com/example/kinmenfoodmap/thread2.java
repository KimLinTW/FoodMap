package com.example.kinmenfoodmap;

import static com.example.kinmenfoodmap.HomeFragment.threadflag;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
//現在thread2就跟廢物一樣

 class thread2 extends Thread{

        @Override
        public void run() {
            while(MainActivity.userlist.size() == 0){
            try{
                System.out.println("waiting for db");
                TimeUnit.SECONDS.sleep(5);
                if(threadflag==0)
                {
                    System.out.println("thread是給0所以進來");//讓threas2睡一下,東西出來再叫他
                    new fetchData();
                    threadflag=1;
                }

            }catch (Exception e){
                System.out.println("error while creating");
            }
            }

            System.out.println("終於跳出來");
           // System.out.println("看看這個list是什麼"+userlist);

           // listAdapter.notifyDataSetChanged();
           new fetchData().start();

           // listAdapter.notifyDataSetChanged();

        }


    }




