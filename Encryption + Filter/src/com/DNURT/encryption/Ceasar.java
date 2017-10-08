package com.DNURT.encryption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ceasar{



    private List<char[]> print = new ArrayList<char[]>();

    public List<char[]> encryptCeasar(List<String> massOriginText, byte methodScan){
        short shift;
        shift=ceasarShift();
        char[] c = new char[0];
        System.out.println("Encrypt text is:");
        for(int i=0; i< massOriginText.size();i++) {
            //  String[] tmp = massOriginText.get(i).split(" ");
            c= massOriginText.get(i).toCharArray();
            for(int j=0; j<massOriginText.get(i).length();j++) {
                int counter=0;
                while(counter<c.length) {
                    char tmp=' ';
                    if(methodScan==1){
                        tmp=(char)((int)c[counter]+shift);
                    }
                    else if(methodScan==2){
                        tmp=(char)((int)c[counter]-shift);
                    }
                    c[counter]=tmp;
                    counter++;
                }
            }
            print.add(c);
            System.out.println(c);
        }
    return print;
    }

    private short ceasarShift(){
        short shift1,shift=0;
        byte checkChoose;
        Scanner sc=new Scanner(System.in);
        System.out.println("Input shift variable, which has to be in a range from 0 to 224:");
        while(shift==0){
            if(sc.hasNextShort()){
                shift1=sc.nextShort();
                if(shift1>=0&&shift1<=224){
                    shift=shift1;
                }
                else {
                    System.out.println("Variable has to be in the range from 0 to 224!");
                }
            }
            else {
                System.out.println("Wrong entry!");
            }
        }

        return shift;
    }
}
