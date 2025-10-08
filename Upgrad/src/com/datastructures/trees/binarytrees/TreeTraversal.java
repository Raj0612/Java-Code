package com.datastructures.trees.binarytrees;

public class TreeTraversal {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.constructTree();
        preOrderTraversal(root);
    }


    static void preOrderTraversal(TreeNode root){

        if(root==null){
            return;
        }

        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void reversePreOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }

        System.out.println(root.value);
        preOrderTraversal(root.right);
        preOrderTraversal(root.left);
    }
}
