package com.datastructures.trees.binarysearchtrees;

//Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
public class SearchInBST {

    static ConstructBinaryTree.TreeNode root;

    public static void main(String[] args) {

        input1();
        System.out.println();
        input2();
        System.out.println();
    }

    static void input1(){
        ConstructBinaryTree.TreeNode root = ConstructBinaryTree.constructTree3();
        int val = 2;
        ConstructBinaryTree.TreeNode result = searchBSTNode(root, val);
        System.out.println("result " + result);
    }

    static void input2(){
        ConstructBinaryTree.TreeNode root = ConstructBinaryTree.constructTree3();
        int val = 9;
        ConstructBinaryTree.TreeNode result = searchBSTNode(root, val);
        System.out.println("result " + result);
    }
    static boolean searchBST(ConstructBinaryTree.TreeNode root, int val){
        if(root == null)
            return false;

        if(val == root.value)
            return true;

        if(val<root.value)
           return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }
    //Time: O(n)
    //Space:  O(h) . If h is logn(Balanced Tree) Then Time is: O(logn)
    static ConstructBinaryTree.TreeNode searchBSTNode(ConstructBinaryTree.TreeNode root, int val){
        if(root == null || val == root.value)
            return root;

        if(val<root.value)
            return searchBSTNode(root.left, val);
        else
            return searchBSTNode(root.right, val);
    }

}
