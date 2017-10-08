package com.DNURT.encryption;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Permutation {

    private List<char[]> print = new ArrayList<char[]>();
    Scanner scan = new Scanner(System.in);

    public List<char[]> encryptPermutation(List<String> massOriginText,byte methodScan){
        char[] f=new char[0];
        byte[] userEnterNumber;

        userEnterNumber=userEnter();
        for(int i=0; i< massOriginText.size();i++) {
          //  String[] tmp = massOriginText.get(i).split(" ");
            f= massOriginText.get(i).toCharArray();
            for(int j=0; j<massOriginText.get(i).length();j++)
            {
                int counter=0;
                while(counter<f.length-4)
                {
                    char tmp0,tmp1,tmp2,tmp3;
                    tmp0=f[counter];
                    tmp1=f[counter+1];
                    tmp2=f[counter+2];
                    tmp3=f[counter+3];
                    if(methodScan==1){
                        f[counter+userEnterNumber[0]]=tmp0;
                        f[counter+userEnterNumber[1]]=tmp1;
                        f[counter+userEnterNumber[2]]=tmp2;
                        f[counter+userEnterNumber[3]]=tmp3;
                    }
                    if(methodScan==2){
                        f[counter-userEnterNumber[0]]=tmp0;
                        f[counter-userEnterNumber[1]]=tmp1;
                        f[counter-userEnterNumber[2]]=tmp2;
                        f[counter-userEnterNumber[3]]=tmp3;
                    }
                    counter+=4;

                }

            }
            System.out.println(f);
            print.add(f);
        }
        return print;
    }
    private byte[] userEnter() {
        byte outputStringMass=0, checkChoose=0;
        byte[] userEnterNumber= new byte[4];
        System.out.println("Please, input values from 0 to 3: ");
        String[] numberLine = new String[4];
        numberLine[0]="[0]= ";
        numberLine[1]="[1]= ";
        numberLine[2]="[2]= ";
        numberLine[3]="[3]= ";
        while(outputStringMass<numberLine.length) {
            while(checkChoose==0){
                System.out.print(numberLine[outputStringMass]);
                if(scan.hasNextByte()) {
                    byte a = scan.nextByte();
                    if(a>=0&&a<=3) {
                        userEnterNumber[outputStringMass] = a;
                        checkChoose=1;
                    }
                    else{
                        System.out.println("Wrong entry! Input numeral has to be in the rage from 0 to 3!");
                        System.out.println("Please, try again");
                    }
                }
                else {
                System.out.println("Wrong entry! Value should be from 0 to 3");
                System.out.println("Please, try again");
                System.exit(0);
                }
            }
            checkChoose=0;
            outputStringMass++;
        }
        return userEnterNumber;
    }
}
