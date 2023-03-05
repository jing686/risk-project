package com.zj.muiltithreading;

public class BinaryTree{
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        this.preOrder(root);
    }

    private void preOrder(TreeNode node){
        if (node == null){
            return;
        }
        System.out.println(node.getValue());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    //中序遍历
    public void inOrder(){
        this.inOrder(root);
    }

    private void inOrder(TreeNode node){
        if (node == null){
            return;
        }
        inOrder(node.getLeft());
        System.out.println(node.getValue());
        inOrder(node.getRight());
    }

    //后序遍历
    public void postOrder(){
        this.postOrder(root);
    }

    private void postOrder(TreeNode node){
        if (node == null){
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.getValue());
    }
}

class TreeNode{
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
}