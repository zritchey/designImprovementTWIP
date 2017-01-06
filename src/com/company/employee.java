package com.company;
import java.io.IOException;
/**
 * Created by zachary on 1/5/2017.
 */
public class employee extends member {
    public static final int cost=2;
    public employee(String name ,boolean paid,int weight, int ssn,int cc, int pin) throws IOException{
        super(name,paid,weight,ssn,cc,pin,true);
    }

}
