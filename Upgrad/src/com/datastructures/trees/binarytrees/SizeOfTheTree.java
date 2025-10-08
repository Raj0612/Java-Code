package com.datastructures.trees.binarytrees;

import java.util.ArrayDeque;
import java.util.Queue;

public class SizeOfTheTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right =  new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right =  new TreeNode(7);

        /*     1
              / \
             2   5
            /\   / \
           3  4  6  7  */

       // System.out.println("Tree Size " + size(root));
        System.out.println("Tree Size1 " + size1(root));
        //System.out.println("Tree Size WO Recursion " + findSizeOfBinaryTreeIterative(root) );
    }
    static int size(TreeNode node) {
        if (node == null)
            return 0;
        else
            return 1 + size(node.left) + size(node.right);
    }

    static int size1(TreeNode node) {
        if (node == null)
            return 0;
       int left_size = size1(node.left);
       int right_size = size1(node.right);
       return 1 + left_size+right_size;
    }

    public static int findSizeOfBinaryTreeIterative(TreeNode root) {

        int size = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            size++; // Increment size on each pop up operation
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return size;
    }
}
