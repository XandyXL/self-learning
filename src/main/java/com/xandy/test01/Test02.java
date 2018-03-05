package com.xandy.test01;


public class Test02 {

    public static void mutily2order(int n){
        System.out.println(n);
        if(n <= 5000){
           mutily2order(2*n);
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        Test02.mutily2order(1237);
    }
}
