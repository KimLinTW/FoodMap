package com.example.kinmenfoodmap;

import java.util.concurrent.TimeUnit;



/*class thread2 extends Thread{
    @Override
    public void run() {
        while(userlist.size() == 0){
            try{
                System.out.println("waiting for db");
                TimeUnit.SECONDS.sleep(5);
                new HomeFragment.fetchData().start();
                if (userlist.size() > shop_amount) userlist.subList(0,shop_amount);
            }catch (Exception e){
                System.out.println("error while creating");
            }
        }
        if (userlist.size() > shop_amount){
            userlist.subList(0,shop_amount);
            System.out.println("重整user list");
        }
    }

}*/
