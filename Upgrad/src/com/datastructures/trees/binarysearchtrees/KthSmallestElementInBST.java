package com.datastructures.trees.binarysearchtrees;
//Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

import  com.datastructures.trees.binarysearchtrees.ConstructBinaryTree.TreeNode;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class KthSmallestElementInBST {

    static int count = 0;
    static int result =0;
    public static void main(String[] args) {
        input1();
        input2();
    }

    static void input1(){
        TreeNode root = ConstructBinaryTree.constructTree1();
          /*
               3
              / \
             /   \
            1     4
             \
              2
        */
        int k = 1;
        System.out.println("input1: kthSmallestBy " + kthSmallestBy(root, k));
        System.out.println("input1: kthSmallestByExtraSpace1 " + kthSmallestByExtraSpace1(root, k));
    }

    static void input2(){
        TreeNode root = ConstructBinaryTree.constructTree2();
          /*
              5
             / \
            3   6
           / \
          2   4
         /
        1
        */

        count = 0;
        result =0;
        int k = 3;

        System.out.println("input2: kthSmallestBy " + kthSmallestBy(root, k));
        System.out.println("input2: kthSmallestByExtraSpace1 " + kthSmallestByExtraSpace1(root, k));
    }

    //Time: O(n) Space: O(h)
    public static int kthSmallestBy(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }

    //Time: O(n) Space: O(h)
    public static void inOrder (TreeNode root, int k){
        if(root == null)
            return;

        inOrder(root.left, k);
        count++;
        if(count == k) {
         result = root.value;
            return;
        }
        inOrder(root.right, k);
    }

    public static int kthSmallestByExtraSpace1(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder1(root, list);
        return list.get(k-1);

    }

    public static void inOrder1(TreeNode root, ArrayList<Integer> list){
        if(root == null)
            return;

        inOrder1(root.left, list);
        list.add(root.value);
        inOrder1(root.right, list);
    }
}
