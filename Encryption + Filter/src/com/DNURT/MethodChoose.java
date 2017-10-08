package com.DNURT;
import com.DNURT.encryption.Encrypt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MethodChoose {

    static Scanner scan = new Scanner(System.in);

    protected byte methodScan;
    protected byte encryptMethodSelect;

    public  byte enterMethod(){
        byte itemChoose=0, checkItem;
        String[] enterMethodChoose= new String[3];
        enterMethodChoose[0]="How do you want to enter information?";
        enterMethodChoose[1]="1. Manual;";
        enterMethodChoose[2]="2. By text file";
        Arrays.stream(enterMethodChoose).forEach(System.out::println);
        while(itemChoose==0) {
            if(scan.hasNextByte()){
                checkItem=scan.nextByte();
                if(checkItem==1||checkItem==2) {
                    itemChoose=checkItem;
                }
                else{
                    System.out.println("Wrong entry! Input numeral has to be 1 or 2. Please, try again");
                }
            }
            else {
                System.out.println("Wrong entry! Please, try again");
            }
        }
        MethodChoose Choose = new MethodChoose();
        Choose.chooseMethod(itemChoose);
        return itemChoose;
    }

    private byte chooseMethod(byte enterMethod){
        byte checkChoose;
        System.out.println("Hello, User! Please write a number of one item from item list, that you want to choose:");
        String[] methodMass=new String[3];
        methodMass[0] = "1.Encrypt;";
        methodMass[1] = "2.Decode;";
        methodMass[2] = "3.Exit";
        Arrays.stream(methodMass).forEach(System.out::println);
        if(scan.hasNextByte()) {
            while(methodScan == 0){
                checkChoose=scan.nextByte();
                if(checkChoose >= 1 && checkChoose <= 3){
                    methodScan=checkChoose;
                }
                else{
                    System.out.println("Wrong entry! Input numeral has to be in the rage from 1 to 3!");
                }
            }
        }
        else {
            System.out.println("Wrong entry!");
            System.exit(0);
        }
        MethodChoose Choose = new MethodChoose();
        switch(methodScan){
            case 1:
                byte encryptMethodSelect = Choose.chooseEncryptMethod();
                ReadFile read = new ReadFile();
                List<String> massOriginText = read.fileRead(methodScan,enterMethod,encryptMethodSelect);
                Encrypt en = new Encrypt();
                en.encryptFile(methodScan,massOriginText,encryptMethodSelect);
                break;
            case 2:
                byte decodeMethodSelect = Choose.chooseEncryptMethod();
                ReadFile readD = new ReadFile();
                List <String> massOriginTextDecode = readD.fileRead(methodScan,enterMethod,decodeMethodSelect);
                Encrypt de = new Encrypt();
                de.encryptFile(methodScan,massOriginTextDecode,decodeMethodSelect);
                break;
            case 3:
                System.out.println("Good luck!");
                System.exit(0);
                break;
        }

        return methodScan;
    }

    public byte chooseEncryptMethod(){
        byte checkChoose;
        System.out.println("Choose encoding method:");
        String[] encryptMethodChoose=new String[5];
        encryptMethodChoose[0] = "1.Caesar;";
        encryptMethodChoose[1] = "2.Permutation;";
        encryptMethodChoose[2] = "3.Vizhinar's with random number generator;";
        encryptMethodChoose[3] = "4.Gambling;";
        encryptMethodChoose[4] = "5.Exit";
        Arrays.stream(encryptMethodChoose).forEach(System.out::println);
        if(scan.hasNextByte()) {
            while(encryptMethodSelect == 0){
                checkChoose = scan.nextByte();
                if(checkChoose >= 1 && checkChoose <= 5){
                    encryptMethodSelect=checkChoose;
                }
                else{
                    System.out.println("Wrong entry! Input numeral has to be in the rage from 1 to 5!");
                }
            }
        }
        else {
            System.out.println("Wrong entry!");
            System.exit(0);
        }
        return encryptMethodSelect;
    }
}
