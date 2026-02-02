package com.datastructures.trees.binarytrees;

import java.util.Stack;
//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

public class ISSymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right =  new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right =  new TreeNode(3);
        root.right.left.right = new TreeNode(5);

        /*     1
              / \
             2   2
            /\   / \
           3  4  4  3  */


        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.right =  new TreeNode(3);
        root1.right.right =  new TreeNode(3);
        /*     1
              / \
             2   2
              \   \
               3   3  */

        System.out.println("isSymmetricNonRecursiveByStack " + isSymmetricNonRecursiveByStack(root));
        System.out.println("isSymmetric " + isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricSubTree(root.left, root.right);
    }

    public static boolean isSymmetricSubTree(TreeNode left,  TreeNode right){
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null || left.value != right.value) {
            return false;
        }
        return isSymmetricSubTree(left.left, right.right) && isSymmetricSubTree(left.right, right.left);
    }

    public static boolean isSymmetricNonRecursiveByStack(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.empty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();

            if (node1 == null && node2 == null) {
                continue;
            }

            if (node1 == null || node2 == null || node1.value != node2.value){
                return false;
            }

            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }
}
