package com.main.java.bsu.algorithms.binarysearchtree;

/**
 * Created by irisha on 15.10.2017.
 */
public class TreeNode {
    private int number;
    private int countNodeLeft;
    private int countNodeRight;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int number) {
        this.setNumber(number);
    }

    public TreeNode(int number, TreeNode left, TreeNode right) {
        this.setNumber(number);
        this.setCountNodeLeft(0);
        this.setCountNodeRight(0);
        this.setLeft(left);
        this.setRight(right);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCountNodeLeft() {
        return countNodeLeft;
    }

    public void setCountNodeLeft(int countNodeLeft) {
        this.countNodeLeft = countNodeLeft;
    }

    public int getCountNodeRight() {
        return countNodeRight;
    }

    public void setCountNodeRight(int countNodeRight) {
        this.countNodeRight = countNodeRight;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TreeNode: ");
        builder.append("value="+number);
        builder.append(", count_left_node=" + countNodeLeft);
        builder.append(", count_right_node=" + countNodeRight);
        if(left!=null) {
            builder.append(", left=" + left.getNumber());
        }
        else {
            builder.append(", left= no");
        }
        if(right!=null) {
            builder.append(", right=" + right.getNumber());
        }
        else {
            builder.append(", right= no");
        }
        return builder.toString();
    }
}
