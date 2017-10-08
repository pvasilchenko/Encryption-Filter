package com.DNURT;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;

public class ReadFile {

    private String line;
    private  List<String> mass=new ArrayList<String>();
    private  List<String> massKey=new ArrayList<String>();


    public List<String> fileRead(byte methodScan, byte enterMethod,byte encryptMethodSelect){
        if(enterMethod == 1){
            Scanner scan = new Scanner(System.in);
            String s = "";
            System.out.println("Press "+"`"+" to finish input;");
            System.out.println("Please, enter what you want to encrypt/decode:");
            do{
                s=scan.nextLine();
                int index = 0;
                String[] c = s.split(" ");
                if(!s.equals("`")){
                    for(int i=0 ; i < c.length ; i++){
                        mass.add(c[i]);
                        index++;
                    }
                }
            }while(!s.equals("`"));
            System.out.println("Your text is:");
            System.out.print(mass);
        }

        if(enterMethod == 2)
        {
            BufferedReader readFromFile = null;
            BufferedReader readKey = null;
            try{
                if(methodScan == 1) {
                    readFromFile = new BufferedReader(new FileReader("resources//primaryTextForEncrypt.txt"));
                }
                else if(methodScan == 2) {
                    readFromFile = new BufferedReader(new FileReader("resources//primaryTextDecode.txt"));
                }
                else{
                    System.exit(0);
                }
                while((line = readFromFile.readLine())!= null) {
                    mass.add(line);
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            finally {
                if (readFromFile != null) {
                    try{
                        readFromFile.close();
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Your text is:");
            for(String originText:this.mass) {
                System.out.println(originText);
            }
        }

        System.out.println();
        return mass;
    }
    public List<String> keyReader(){
        BufferedReader readFromFile = null;
        try {
            readFromFile = new BufferedReader(new FileReader("resources//vizhinarKey.txt"));
            while ((line = readFromFile.readLine()) != null) {
                massKey.add(line);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            if (readFromFile != null) {
                try{
                    readFromFile.close();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Your key is:");
        for(String key:this.massKey) {
            System.out.println(key);
        }
        return massKey;
    }
}
