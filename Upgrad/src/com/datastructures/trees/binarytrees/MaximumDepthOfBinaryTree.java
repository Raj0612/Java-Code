package com.datastructures.trees.binarytrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//Given the root of a binary tree, return its maximum depth.
//A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        //TreeNode root = BinaryTree.constructTree4();  //3
         /*    1
              / \
             2   3
            /\   / \
           4  5  6  7
         */
        TreeNode root = BinaryTree.constructTree3();
        root.left.left = new TreeNode(4);
       root.left.right.left = new TreeNode(7);
         /*     1
              / \
             2   3
              \
               5
               /
              7
         */

        System.out.println("maxDepth " + maxDepth(root));
        System.out.println("maxDepth1 " + maxDepth1(root));
        System.out.println("maxDepthNonRecursiveByQueue " + maxDepthNonRecursiveByQueue(root));
        System.out.println("maxDepthNonRecursiveStack " + maxDepthNonRecursiveStack(root));
        System.out.println("maxDepthNonRecursiveByStack " + maxDepthNonRecursiveByStack(root));
    }

    static int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    static int maxDepth1(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return Math.max(left, right) + 1;
    }

    static int maxDepthNonRecursiveByQueue(TreeNode root) {
        if (root == null) return 0;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return depth;
    }

    static int maxDepthNonRecursiveStack(TreeNode root) {
        return Math.max(maxDepthNonRecursiveStack(root, true), maxDepthNonRecursiveStack(root, false));
    }
    static int maxDepthNonRecursiveStack(TreeNode root, boolean left) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int depth = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (left && node.left != null)
                stack.add(node.left);
            if (left && node.left == null && node.right != null)
                stack.add(node.right);
            if (!left && node.right != null)
                stack.add(node.right);
            if (!left && node.right == null && node.left != null)
                stack.add(node.left);
            depth++;
        }
        return depth;
    }

    static int maxDepthNonRecursiveByStack(TreeNode root) {
        if (root == null) return 0;

        int depth = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = stack.pop();
                if (node.left != null)
                    stack.push(node.left);
                if (node.right != null)
                    stack.push(node.right);
            }
        }
        return depth;
    }
}
