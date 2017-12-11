package com.main.java.bsu.algorithms.search.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {

    private static final File TXT_FILE_PATH = new File("myFile.txt");

    public static void writeFile(int[] array) {
        try {
            PrintWriter writer =  new PrintWriter(new BufferedWriter(new java.io.FileWriter(TXT_FILE_PATH)));
            for (int i = 0; i < array.length; i++) {
                writer.println(array[i]);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}