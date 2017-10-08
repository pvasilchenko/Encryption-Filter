package com.DNURT.encryption;

import com.DNURT.ReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gambling {

    private List<Integer> index = new ArrayList<Integer>();
    private List<Character> key = new ArrayList<Character>();
    private char[] keyMass = new char[0];

    private Random rand = new Random();

    private char[] upper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
            'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private char[] lower = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j','k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private List<char[]> print = new ArrayList<char[]>();

    public List<char[]> encryptGambling(List<String> massOriginText,byte methodScan) {
        int keyInd=-1;
        int textLength=0;

        for (int k = 0; k < massOriginText.size(); k++) {
            for (int z = 0; z < massOriginText.get(k).length(); z++) {
                textLength++;
            }
        }
            getKey(methodScan, textLength);
            char[] c = new char[0];
            System.out.println("Encrypt text is:");
            for (int i = 0; i < massOriginText.size(); i++) {
                c = massOriginText.get(i).toCharArray();
                for (int j = 0; j < massOriginText.get(i).length(); j++) {
                    int counter = 0;

                    while (counter < c.length) {

                        int symbNumber = 0, rezSymbNumber = 0;
                        byte upperInd, lowerInd, l = 0, u = 0;
                        for (upperInd = 0; upperInd < upper.length; upperInd++) {
                            if (c[counter] == upper[upperInd]) {
                                symbNumber = upperInd;
                                u = 1;
                                break;
                            }
                        }
                        for (lowerInd = 0; lowerInd < lower.length; lowerInd++) {
                            if (c[counter] == lower[lowerInd]) {
                                symbNumber = lowerInd;
                                l = 1;
                                break;
                            }
                        }
                        keyInd++;
                        if(keyInd==4){
                            keyInd-=4;
                        }
                        if (methodScan == 1) {
                            rezSymbNumber = (symbNumber + index.get(keyInd)) % upper.length;
                        } else if (methodScan == 2) {
                            rezSymbNumber = (symbNumber - index.get(keyInd)) % upper.length;
                            if(rezSymbNumber<0){
                                rezSymbNumber+=26;
                            }
                        }

                        if (u != 0) {
                            c[counter] = upper[rezSymbNumber];
                        } else if (l != 0) {
                            c[counter] = lower[rezSymbNumber];
                        }

                        counter++;
                    }
                }
                print.add(c);
                System.out.print(c);
            }
            return print;
        }
    private void getKey(byte methodScan, int textLenth){
        if(methodScan == 1){
            int ind;
            for(int j=0; j < textLenth ; j++){
                ind = rand.nextInt(upper.length);
                index.add(ind);
                key.add(lower[ind]);
            }
            System.out.println("Your key is:");
            System.out.println(key);
            Vizhinar viz = new Vizhinar();
            viz.keySave(key);
        }
        else if(methodScan == 2) {
            List<String> tmpKey = new ArrayList<String>();
            ReadFile reader = new ReadFile();
            tmpKey = reader.keyReader();
            for (int i = 0; i < tmpKey.size(); i++)
                keyMass = tmpKey.get(i).toCharArray();
            int counter = 0;
            while (counter < keyMass.length) {
                int symbNumber = 0;
                byte ind;
                for (ind = 0; ind < lower.length; ind++) {
                    if (keyMass[counter] == lower[ind]) {
                        symbNumber = ind;
                        break;
                    }
                }
                index.add(symbNumber);
                counter++;
            }
        }
    }
}
