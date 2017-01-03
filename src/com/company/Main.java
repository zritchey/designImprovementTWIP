package com.company;

public class Main {

    public static void main(String[] args) {
      long d=System.nanoTime();
        for(int x=0;x<3;x++){
            System.out.println("hi");



        }
        System.out.println(((double)System.nanoTime()-(double)d)*(Math.pow(10.0,-9)));
        System.out.println(d);
    }
}
