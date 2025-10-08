package com.datastructures.trees.binarysearchtrees;
//Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
//“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
/*
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
 */

import  com.datastructures.trees.binarysearchtrees.BinarySearchTree.TreeNode;
public class LowestCommonAncestor {

    public static void main(String[] args) {
        input1();
    }

    static void input1(){
        TreeNode root = BinarySearchTree.constructTree2();
         /*
               6
              / \
             /   \
            2     8
           / \   / \
          0   4  7  9
             / \
            3   5
        */

        TreeNode  result = lowestCommonAncestor(root, new TreeNode(7), new TreeNode(9));
        System.out.println("lowestCommonAncestor " + result.value);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(p.value < q.value){
                return  lca(root, p, q);
            }else
                return lca(root, q, p);
    }

    static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return null;

        if(root.value==p.value || root.value==q.value){
            return root;
        }

        if(p.value < root.value && root.value < q.value )
            return root;

        if(p.value < root.value && q.value < root.value )
            return lca(root.left, p, q);
        else
            return lca(root.right, p, q);
    }
}
