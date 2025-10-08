package com.datastructures.trees.binarytrees;

public class BinaryTreeTraversal {

    static void preOrder(TreeNode root){
        if(root ==null)
            return;
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void reversePreOrder(TreeNode root){
        if(root ==null)
            return;
        System.out.print(root.value + " ");
        reversePreOrder(root.right);
        reversePreOrder(root.left);
    }

    static void inOrder(TreeNode root){
        if(root ==null)
            return;
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    static void postOrder(TreeNode root){
        if(root ==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }
}
