package com.main.java.bsu.algorithms.binarysearchtree;

import java.util.Scanner;
/**
 * Created by irisha on 15.10.2017.
 */
public class Main {
    public static void main(String[] args){

        BinaryTree tree = new BinaryTree(null);
        TreeNode node = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a node: ");
        for(int i=0;i<10;i++) {
            node = new TreeNode(Integer.parseInt(scanner.nextLine()));
            tree.insert(node, tree.getRoot());
            System.out.println("Tree");
            tree.show(tree.getRoot());
        }

//        //поиск n-ого минимального
//        TreeNode findNode = tree.findNodeByNumberInTree(5, tree.getRoot());
//        System.out.println("\nFind node by number: " + findNode);

        System.out.println("Enter a position for search: ");
        //поиск
        TreeNode nodeSearch = tree.search(Integer.parseInt(scanner.nextLine()), tree.getRoot());
        System.out.println("\nNodeSearch " + nodeSearch);

        //удаление
        System.out.println("Enter a number for removing a node: ");
        tree.delete(Integer.parseInt(scanner.nextLine()), tree.getRoot());
        tree.show(tree.getRoot());

        //ротация left
        System.out.println("\nTree after left rotation:");
        tree.rotationLeft(tree.getRoot());
        tree.show(tree.getRoot());

        //вставка в корень
        System.out.println("Enter a number for insertion into root: ");
        tree.insertIntoRoot(Integer.parseInt(scanner.nextLine()), tree.getRoot());
        tree.show(tree.getRoot());
    }
}