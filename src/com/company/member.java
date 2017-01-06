package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by zr162 on 1/5/17.
 */
public class member  {



    private FileWriter fw;
    public static final int cost=1;
    public member(String name ,boolean paid,int weight, int ssn, int cc, int pin)throws IOException{
        new member ( name , paid, weight,  ssn,  cc,  pin, false);
    }
    public member (String name ,boolean paid,int weight, int ssn,int cc, int pin,boolean employ)throws IOException{
        Scanner s=new Scanner("memberList");
        int me=0;
        if (s.hasNextLine()){

            me++;
        }
        s.close();

        fw=new FileWriter("memberList",true);
        fw.write(me +" "+name+"\n");
        fw.close();
        fw=new FileWriter("member"+me);
        BufferedWriter bw=new BufferedWriter(fw);
        int j=0, i=0;
        if (paid)
            j=1;
        if (employ)
            i=1;
        bw.write("Name: "+name+"\nPin #: "+pin+"\nWeight(lbs): "+weight+"\nSocialSecurity: "+ssn+"\nCredit: "+cc+"\nPaid:"+j+"\nEmployee: "+i+"\n\n\tvisits\n");
        fw.close();




    }
    public static int find (String name){
        Scanner sc=new Scanner ("memberList");
        int i=-1;
        while (sc.hasNextLine() ){
            String s=sc.nextLine();
            if (s.substring(s.indexOf(' ')).replaceAll(" ","").equalsIgnoreCase(name.replaceAll(" ",""))){
                i=Integer.parseInt(s.substring(0,s.indexOf(' ')));
                break;
            }
        }
        sc.close();
        return i;
    }

    public static void visit(int time,String name) throws IOException{
        int i=0;
        if (verification(name)) {
            Scanner sc=new Scanner("member" + find(name));
            FileWriter fw = new FileWriter("member" + find(name),true);
            BufferedWriter bw=new BufferedWriter(fw);

        }

    }
   public  static boolean verification(String name){
       int line =find(name);
       boolean b = false;
       if (line ==-1){
           System.out.println("You do not appear to belong to our gym yet.");
       }
       else {
           Scanner sc = new Scanner("member" + line);
           sc.nextLine();
           String l = sc.nextLine();
           sc.close();
           int pin = Integer.parseInt(l.substring(l.lastIndexOf(' ') + 1));
           sc=new Scanner(System.in);
           for(int j=0;j<3;j++) {
               System.out.print("Please enter your pin number: ");
               int i=sc.nextInt();
               b= pin==i;
               if(b){
                   System.out.println("You have been verified");
                   break;
               }
               System.out.println("This was incorrect\n\n");
           }
       }
       return b;
   }
}
