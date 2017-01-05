package com.company;



/**
 * Created by zachary on 1/3/2017.
 */
public class customer {

    private String name;




    public customer(String name, )throws IOException{
        this.name=name;
        this.weight=weight;
        this.ssn=ssn;

         fw=new FileWriter("customer"+num);
        me=num;
        num++;


    }
    public void update (){

    }
    public void visit()
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
        if(status(c)==2&&!c.mmbr){
            System.out.println(would you like to );
        }
        else if(status(c)==0){
            
        }

    }
    public int status(customer c){
        int i=0;
        if (c.employ)
            i=2;
        else if (c.mmbr)
            i=1;
       return i;
    }
    public void verify (customer c, int control){}

}
