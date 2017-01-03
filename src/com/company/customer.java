package com.company;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by zachary on 1/3/2017.
 */
public class customer {
    public static int num=0;
    private final int me;
    private String name;
    private int weight;
    private final int ssn;
    private boolean employ;
    private boolean mmbr;


    public customer(String name, int weight, int ssn, boolean employ, boolean mmbr )throws IOException{
        this.name=name;
        this.weight=weight;
        this.ssn=ssn;
        this.employ=employ;
        this.mmbr=mmbr;
        FileWriter fw=new FileWriter("customer"+num);
        me=num;
        num++;

    }
    public void hire(customer c){
        c.employ=true;

    }
    public void fire(customer c){
        c.employ=false;
    }
    public void newWeight(customer c,int n ){
        c.weight=n;
    }
    public void offer(customer c){
        if(1==1);
    }
    public void verify (customer c, int control){}

}
