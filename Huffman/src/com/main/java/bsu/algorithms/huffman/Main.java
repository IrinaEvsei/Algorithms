package com.main.java.bsu.algorithms.huffman;

import java.io.*;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = null;
        Huffman huffman = new Huffman();

        try {
            br = new BufferedReader(new FileReader("src/resources/sourceTXT.txt"));

            Node root = huffman.nodeGeneration(br);

            Map<Character, String> encryptHuffman = new HashMap<>();

            String code = "";
            // Frequently occurring value codes
            huffman.encrypt(root, code, encryptHuffman);

            // Generation an encrypted file
            huffman.generateEncryptedFile(root, encryptHuffman);

            // Reading the encoded file
            FileInputStream fileInputStream = new FileInputStream("src/resources/txtEncrypted.txt");
            ObjectInputStream objectOutputStream = new ObjectInputStream(fileInputStream);

            // A node for the Huffman's tree
            Node decodeNode = (Node) objectOutputStream.readObject();

            // Reading bits
            BitSet bitset = (BitSet) objectOutputStream.readObject();

            objectOutputStream.close();

            // Converts a bit to a string
            String bitsetToString = huffman.bitsetToString(bitset);

            FileOutputStream decryptedOutput = new FileOutputStream(new File("src/resources/txtDecrypted.txt"));
            huffman.decrypt(bitsetToString, decodeNode, decryptedOutput);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
