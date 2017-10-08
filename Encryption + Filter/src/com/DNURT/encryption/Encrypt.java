package com.DNURT.encryption;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class Encrypt {

    private List<char[]> print = new ArrayList<char[]>();

    public void encryptFile(byte methodScan,List<String> massOriginText,byte encryptMethodSelect) {
        System.out.println("Origin text array:");
        System.out.println(massOriginText);

        String s;
                switch (encryptMethodSelect) {
                    case 1:
                        //Caesar
                        Ceasar ces = new Ceasar();
                        print=ces.encryptCeasar(massOriginText,methodScan);
                        break;
                    case 2:
                        //Permutation
                        Permutation per = new Permutation();
                        print=per.encryptPermutation(massOriginText,methodScan);
                        break;
                    case 3:
                        //Vizhinar
                        Vizhinar encr = new Vizhinar();
                        print=encr.encryptVizhinar(massOriginText,methodScan);
                        break;
                    case 4:
                        //XOR
                        Gambling gamb = new Gambling();
                        print=gamb.encryptGambling(massOriginText,methodScan);
                        break;
                    case 5:
                        //Exit
                        System.out.println("Good luck!");
                        System.exit(0);
                        break;
                }
                if(methodScan == 1){
                    encryptFileWrite(print);
                }


    }
    private void encryptFileWrite(List<char[]> print){
        try{
            FileWriter writer = new FileWriter("resources//primaryTextDecode.txt",  false);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            for(int i = 0; i < print.size(); i++){
                writer.write(print.get(i));
                writer.write("\n");
            }
            bufferWriter.close();
            writer.close();

        } catch (IOException e) {
            System.out.print(e);
        }
    }
}
