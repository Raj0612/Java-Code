package com.datastructures.trees.binarytrees;

//You are given the root of a binary tree that consists of exactly 3 nodes: the root, its left child, and its right child.
//Return true if the value of the root is equal to the sum of the values of its two children, or false otherwise.
public class RootEqualsSumOfChildren {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.constructTree3Nodes();
        /*
               10
              / \
             /   \
            6     4
        */
        System.out.println("checkTree3Nodes " + checkTree3Nodes(root));
    }

    static boolean checkTree3Nodes(TreeNode root){
        return root.value == root.left.value + root.right.value;
    }
}
