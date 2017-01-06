package com.company;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by zachary on 1/3/2017.
 */
public class customer  {
public static final int cost=0;

    private FileWriter fw=new FileWriter("walk-in",true);
    private BufferedWriter bw=new BufferedWriter(fw);


    public customer()throws IOException{
        Scanner s=new Scanner("walk-in");
        if (!s.hasNextLine()){
            bw.append("name\t\t\t\t , time ");
        }
        s.close();

    }
    public void update (String name,int time)throws IOException {
        bw.append(name + "," + time);

    }
    public void close() throws IOException{
        bw.close();
        fw.close();
    }



}
