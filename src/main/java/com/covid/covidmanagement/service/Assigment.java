package com.covid.covidmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Assigment {



    public static String solution(int A, int B) {
        // write your code in Java SE 8

        Character[] charArray = new Character[A+B];


        for(int i =0 ;i<A;i++) {
            charArray[i] = 'A';
        }
        return  "";
    }


    private static String acceptRejectOffer()
    {
        String actual ="";
        Random rand = new Random(); //instance of random class
        int upperbound = 10;
        //generate random values from 0-24
        int int_raom = 0;
        int odd =0;
        int even =0;
        for(int i =0;i<10000;i++) {
            int_raom =  rand.nextInt(upperbound);
            if(int_raom %2==0) {
                even++;
            }
            else{
                odd++;
            }
        }
        if(even==odd){
            actual ="tie";

        }
        else if(even>odd)
        {
            actual ="accept";
        }
        else{
            actual = "reject";
        }

        return  actual;
    }


    public  static  void  main (String args[]){

          int accptCount = 0, rejectCount = 0;

    for(int i = 0;i < 100;i++)
    {
       String variable=   acceptRejectOffer();
       if(variable.equalsIgnoreCase("accept"))
           accptCount++;
       else
           rejectCount++;
    }

    System.out.println("accepted "+accptCount);
    System.out.println("Rejected "+rejectCount);


    }
}
