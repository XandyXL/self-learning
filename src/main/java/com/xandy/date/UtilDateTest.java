package com.xandy.date;

import java.util.Date;

public class UtilDateTest {


    public static void main(String[] args) {


        long timeStamp1 = System.currentTimeMillis();
        Date date1 = new Date(timeStamp1);
        long timeStamp2 = System.currentTimeMillis();
        Date date2 = new Date(timeStamp2);

        System.out.println(date1.after(date2));
        System.out.println(date1.before(date2));
        System.out.println(date1.compareTo(date2));
        System.out.println(date2.toString());



        Integer integer = null;

        System.out.println(integer == 2225);



    }
}
