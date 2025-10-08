package com.datastructures.trees.binarysearchtrees;

//Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//A valid BST is defined as follows:
/*
    1) The left  subtree of a node contains only nodes with keys less than the node's key.
    2) The right subtree of a node contains only nodes with keys greater than the node's key.
    3) Both the left and right subtrees must also be binary search trees.
*/

import com.datastructures.trees.binarysearchtrees.BinarySearchTree.TreeNode;
import com.datastructures.trees.binarytrees.BinaryTree;

import java.util.ArrayList;

public class ValidateBinarySearchTree {

    static int prev;
    static boolean  result = true;
    static boolean is_first_node = true;
    static int prevNodeVal;
    public static void main(String[] args) {
       // input1();
       // input2();
        input3();
    }
    static void input1(){
        TreeNode root = BinarySearchTree.constructTree3();
        /*
               1
              / \
             /   \
            2     3
        */

        //System.out.println("input1: isValidBST " + isValidBST(root));
        prevNodeVal =0;
        prev= 0;
        result = true;
        is_first_node = true;
        System.out.println("input1: isValidBST1 " + isValidBST1(root));
        System.out.println("input1: isValidBST2 " + isValidBST2(root));
    }

    static void input2(){
        TreeNode root = BinarySearchTree.constructTree4();
        /*
               5
              / \
             /   \
            1     4
                 / \
                3   6
        */
        prev= 0;
        prevNodeVal =0;
        result = true;
        is_first_node = true;
        //System.out.println("input2: isValidBST " + isValidBST(root));
        prev= 0;
        prevNodeVal =0;
        is_first_node = true;
        System.out.println("input2: isValidBST1 " + isValidBST1(root));
      //  System.out.println("input2: isValidBST2 " + isValidBST2(root));
    }
    static void input3(){
        TreeNode root = BinarySearchTree.constructTree5();
            /*
               8
              / \
             /   \
            3     10
          /  \      \
         1    6      14
             / \     /
            4   7     13
        */
        prev= 0;
        prevNodeVal =0;
        result = true;
        is_first_node = true;
       // System.out.println("input3: isValidBST " + isValidBST(root));
        prev= 0;
        prevNodeVal =0;
        is_first_node = true;
        System.out.println("input3: isValidBST1 " + isValidBST1(root));
        System.out.println("input3: isValidBST2 " + isValidBST2(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;

        boolean left = isValidBST(root.left);
        if(!left)
            return false;
        if(is_first_node)
            is_first_node = false;
        else {
            if(root.value <= prev){
                return false;
            }
        }
        prev = root.value;
        return isValidBST(root.right);
    }

    public static boolean isValidBST1(TreeNode root) {
        inOrder1(root);
        return result;
    }

    public static void inOrder1(TreeNode root){

        if(root==null)
            return;
        inOrder1(root.left);
            if(root.value <= prev){
                result = false;
                return;
            }
        prev = root.value;
        inOrder1(root.right);
    }
    //Time: O(n)
    //Space:  O(n)
    public static boolean isValidBST2(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        inOrder2(root, list); //O(n), Space: O(h) - For recursive call
        System.out.println("list " + list);
        //O(n)
        for(int i=0; i< list.size()-1; i++){
            if(list.get(i+1) <= list.get(i))
                return false;
        }
           return true;
    }

    //Time: O(n)
    //Space:  O(n) + O(h)
    public static void inOrder2(TreeNode root, ArrayList<Integer> list){

        if(root == null)
            return;

        inOrder2(root.left, list);
        list.add(root.value);
        inOrder2(root.right, list);

    }
}
