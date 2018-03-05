package com.xandy.collection;

import java.util.ArrayList;
import java.util.List;

public class ColletcitonTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for(int i= 0;i<10;i++){
            list.add(i);
        }
        list.add(5,1);
        System.out.println(list);
        System.out.println(list.size());


    }
}
