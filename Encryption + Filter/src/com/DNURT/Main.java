package com.DNURT;

import com.DNURT.encryption.Encrypt;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        MethodChoose Choose = new MethodChoose();
        Choose.enterMethod();
    }

}
