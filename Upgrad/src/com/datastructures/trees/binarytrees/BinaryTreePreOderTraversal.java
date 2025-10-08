package com.datastructures.trees.binarytrees;

import java.util.ArrayList;

//N -> L -> R
public class BinaryTreePreOderTraversal {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.constructTree();
       // TreeNode root = BinaryTree.constructTree1();
        ArrayList<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list);
        System.out.println("Result " + list);
    }
    //O(n) -- Traversing all nodes
    //Space - O(h) - Height of the tree
    static void preOrderTraversal(TreeNode root, ArrayList list){
        if(root==null){
            return;
        }

        list.add(root.value);
        preOrderTraversal(root.left, list);
        preOrderTraversal(root.right, list);
    }

}
