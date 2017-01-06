package com.company;

import java.io.BufferedWriter;
import java.io.File;
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
        Scanner s=new Scanner(new File("memberList"));
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
    public static void pay(int place )throws IOException{

        Scanner sc=new Scanner(new File("member"+place));
        sc.nextLine();
        String s=sc.nextLine();
        int pin=Integer.parseInt(s.substring(s.lastIndexOf(' ')+1));
        for (int i=0;i<4;i++)
            sc.nextLine();
        s=sc.nextLine();
        int e=Integer.parseInt(s.substring(s.length()-1));
        sc.close();
        sc=new Scanner(new File("Retail"));

        sc.nextLine();
        s=sc.nextLine();
        sc.close();
        sc=new Scanner(s);
        sc.useDelimiter(",");
        sc.next();


        if(e==1) {
            sc.next();
            sc.next();
        }
        double rate=Double.parseDouble(sc.next());
        sc.close();
        System.out.println("You have been charged $"+rate+"for your membership.");


    }
    public static int find (String name) throws IOException{
        Scanner sc=new Scanner (new File("memberList"));
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

    public static void visit(int time,String name, boolean b) throws IOException{
        int i=0;
        if (b) {
            Scanner sc=new Scanner(new File("member" + find(name)));
            boolean x=false;
            while (sc.hasNextLine()){
                String s=sc.nextLine();
                x=x||s.trim().equals(("visits"));

                if (x)
                    i++;
            }
            sc.close();
            FileWriter fw = new FileWriter("member" + find(name),true);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(i+"- "+time);
            bw.close();
            fw.close();

        }

    }
   public  static boolean verification(String name) throws IOException{
       int line =find(name);
       boolean b = false;
       if (line ==-1){
           System.out.println("You do not appear to belong to our gym yet.");
       }
       else {
           Scanner sc = new Scanner(new File("member" + line));
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
