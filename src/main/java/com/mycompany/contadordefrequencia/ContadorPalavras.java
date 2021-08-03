/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contadordefrequencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author SISTRAM4
 */
public class ContadorPalavras {

    public static String LeArquivo() {
         StringBuilder str
            = new StringBuilder();
        try {
            File myObj = new File("arquivo.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                str.append(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return str.toString();
    }

    public static void main(String[] args) {

        String teste = LeArquivo();
        Map<String, Integer> aMap = new HashMap<>();
        String[] VetTeste=teste.split(" ");
        
        for (int i = 0; i < VetTeste.length; i++) {
            if (aMap.containsKey(VetTeste[i])) {
                aMap.put(VetTeste[i], aMap.get(VetTeste[i]) + 1);
            } else {
                aMap.put(VetTeste[i], 1);
            }
        }

        for (String key : aMap.keySet()) {
            System.out.println(key + " - " + aMap.get(key));

        }

    }

}
