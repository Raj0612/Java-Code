package com.datastructures.trees.binarytrees;

import java.util.ArrayList;
import java.util.List;
//Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
//Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
public class LeafSimilarTrees {

    public static void main(String[] args) {

        TreeNode root1 = BinaryTree.constructTreeLeafSimilar();
        /*     3
              / \
             /   \
            5     1
           /\    / \
          6  2  9   8
            / \
           7   4
         */
        TreeNode root2 = BinaryTree.constructTreeLeafSimilar1();
         /*    3
              / \
             /   \
            5     1
           /\    / \
          6  7  4   2
                   / \
                  9   8
         */

        System.out.println("leafSimilar " + leafSimilar(root1, root2));
        System.out.println("leafSimilar1 " + leafSimilar1(root1, root2));

    }

    //Time - O(n) Space - O(h)
    static boolean leafSimilar(TreeNode root1, TreeNode root2){
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        leafSimilar(root1, leaves1);
        leafSimilar(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public static void leafSimilar(TreeNode node, List<Integer> leaves) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            leaves.add(node.value);
            return;
        }

        leafSimilar(node.left, leaves);
        leafSimilar(node.right, leaves);
    }

    static boolean leafSimilar1(TreeNode root1, TreeNode root2){
        List<Integer> leaves1 = new ArrayList<>();
        preOrder(root1,leaves1);

        List<Integer> leaves2 = new ArrayList<>();
        preOrder(root2,leaves2);

        int n1 = leaves1.size();
        int n2 = leaves2.size();

        if(n1 !=n2)
            return false;

        for(int i=0; i<n1; i++){
            if(leaves1.get(i) != leaves2.get(i))
                return false;
        }

        return true;
    }

    static void preOrder(TreeNode root, List<Integer> list){
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            list.add(root.value);
        }

        leafSimilar(root.left, list);
        leafSimilar(root.right, list);
    }

}
