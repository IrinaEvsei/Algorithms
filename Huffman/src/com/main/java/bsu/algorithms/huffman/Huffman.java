package com.main.java.bsu.algorithms.huffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.*;

public class Huffman {

    private String txtToFile;

    public void generateEncryptedFile(Node root, Map<Character, String> encryptHuffman) throws IOException {
        FileOutputStream bw = new FileOutputStream(new File("src/resources/txtEncrypted.txt"));
        ObjectOutputStream object = new ObjectOutputStream(bw);

        object.writeObject(root);

        StringBuffer codewords = new StringBuffer();
        for (char d : txtToFile.toCharArray()) {
            String charCode = encryptHuffman.get((char) d);
            codewords.append(charCode);
        }

        String txtEncrypted = codewords.toString();
        BitSet bitset = stringToBitset(txtEncrypted);
        object.writeObject(bitset);

        object.close();
        bw.close();
    }

    public BitSet stringToBitset(String codeword) {
        BitSet bitset = new BitSet();

        for (int i = 0; i < codeword.length(); i++) {
            if (codeword.charAt(i) == '0') {
                bitset.set(i, false);
            } else {
                bitset.set(i, true);
            }
        }

        return bitset;
    }

    public String bitsetToString(BitSet bitset) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bitset.size(); i++) {
            if (bitset.get(i)) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        return sb.toString();
    }

    public Node nodeGeneration(BufferedReader br) throws IOException {
        List<Node> nodes = new ArrayList<>();
        Comparator comp = new Compare();

        int[] freq = new int[256];
        int c;

        StringBuffer sb = new StringBuffer();

        // Calculates the frequency of each value
        while ((c = br.read()) != -1) {
            if (c != 32) {
                freq[c]++;
                sb.append((char) c);
            }
        }

        setCreateFile(sb.toString());

        // Creating a node with a frequency and value
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                Node node = new Node((char) i, BigDecimal.valueOf(freq[i]));
                nodes.add(node);
            }
        }

        Collections.sort(nodes, comp);

        // Leaves the root
        while (nodes.size() > 1) {
            Node node1 = nodes.remove(nodes.size() - 1);
            Node node2 = nodes.remove(nodes.size() - 1);

            BigDecimal twoNodesFrequency = node1.getFrequency().add(node2.getFrequency());

            Node node12 = new Node(' ', twoNodesFrequency);
            node12.setRight(node1);
            node12.setLeft(node2);

            nodes.add(node12);

            Collections.sort(nodes, comp);
        }

        // Huffman's Tree
        Node root = nodes.get(0);

        return root;
    }

    public void encrypt(Node root, String code, Map<Character, String> map) {
        if (root.getRight() != null) {
            if (root.getRight().getValue() == ' ') {
                encrypt(root.getRight(), code + "0", map);
            } else {
                map.put(root.getRight().getValue(), code + "0");
            }
        }
        if (root.getLeft() != null) {
            if (root.getLeft().getValue() == ' ') {
                encrypt(root.getLeft(), code + "1", map);
            } else {
                map.put(root.getLeft().getValue(), code + "1");
            }
        }
    }

    public void decrypt(String code, Node root, FileOutputStream decryptOutput) throws IOException {
        Node node = root;
        for (char c : code.toCharArray()) {
            if (c == '0') {
                if (node.getRight().getValue() == ' ') {
                    node = node.getRight();
                } else {
                    decryptOutput.write(node.getRight().getValue());
                    node = root;
                }
            }

            if (c == '1') {
                if (node.getLeft().getValue() == ' ') {
                    node = node.getLeft();
                } else {
                    decryptOutput.write(node.getLeft().getValue());
                    node = root;
                }
            }
        }
    }

    public String getCreateFile() {
        return txtToFile;
    }

    public void setCreateFile(String txtToFile) {
        this.txtToFile = txtToFile;
    }

}