package com.main.java.bsu.algorithms.binarysearchtree.main;

import java.util.Scanner;

/**
 * Created by irisha on 15.10.2017.
 */
public class Main {
    public static void main(String[] args){

        BinaryTree tree = new BinaryTree(null);
        TreeNode node = null;

        //вставка
        node = new TreeNode(5);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(2);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(3);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(4);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(1);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(6);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(13);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(8);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(9);
        tree.insert(node, tree.getRoot());

        System.out.println("Tree");
        tree.show(tree.getRoot());

        //поиск
        TreeNode nodeSearch = tree.search(1, tree.getRoot());
        System.out.println("\nNodeSearch " + nodeSearch);

//удаление
        System.out.println("\nDelete 4 (list)");
        tree.delete(4, tree.getRoot());
        tree.show(tree.getRoot());

        System.out.println("\nDelete 5 (1 subtree)");
        tree.delete(5, tree.getRoot());
        tree.show(tree.getRoot());

        System.out.println("\nDelete 3 (2 subtree)");
        tree.delete(3, tree.getRoot());
        tree.show(tree.getRoot());

        //ротация left
        tree.rotationLeft(tree.getRoot());
        System.out.println("\nTree after left rotation:");
        tree.show(tree.getRoot());

        //ротация right
        tree.rotationRight(tree.getRoot());
        System.out.println("\nTree after right rotation:");
        tree.show(tree.getRoot());

        //вставка в корень
        System.out.println("\nInsert into root.");
        tree.insertIntoRoot(12, tree.getRoot());
        tree.show(tree.getRoot());
    }
}