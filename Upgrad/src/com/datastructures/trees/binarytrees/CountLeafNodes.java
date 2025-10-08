package com.datastructures.trees.binarytrees;

import java.util.Stack;

public class CountLeafNodes {

    public static void main(String[] args) {
         /*    1
              / \
             2   3
            /\   / \
           4  5  6  7
          / \        \
         8   9        15
         */

        TreeNode root = BinaryTree.constructTree();

        System.out.println("countLeaves " + countLeaves(root));
       // System.out.println("countLeaves1 " + countLeaves1(root));
        System.out.println("countLeafNodesWORecursion " + countLeafNodesWORecursion(root));
    }

    static int countLeaves(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left ==null && node.right==null) {
            return 1;
        } else {
            return countLeaves(node.left) + countLeaves(node.right);
        }
    }

    static int countLeaves1(TreeNode node) {
        if (node == null)
            return 0;

        int left_count = countLeaves1(node.left);
        int right_count = countLeaves1(node.right);
        int count = 0;
        if (node.left == null && node.right == null) {
            count = 1;
        }
        return count + right_count + left_count;
    }

    static int countLeafNodesWORecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode node = (TreeNode) stack.pop();
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
            if (node.left ==null && node.right==null)
                count++;
        }
        return count;
    }

}

