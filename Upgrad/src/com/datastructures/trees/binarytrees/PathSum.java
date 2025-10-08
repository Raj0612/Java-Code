package com.datastructures.trees.binarytrees;

import java.util.LinkedList;
//Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
//A leaf is a node with no children.
public class PathSum {
    // Upgrad video June 10
    public static void main(String[] args) {
        input1();
       // input2();
    }

    static void input1(){
        TreeNode root = BinaryTree.pathSumTree();
         /*     5
              /  \
             4    8
           /      / \
         11      13   4
        / \           \
       7   2          1
         */
        int sum = 22;
        System.out.println("hasPathSum  " + hasPathSum(root, sum));
        System.out.println("hasPathSumWORecursion  " + hasPathSumWORecursion(root, sum));
        System.out.println("hasPathSumUpgrad  " + hasPathSumUpgrad(root, sum));
    }

    static void input2(){
        TreeNode root = BinaryTree.constructTree8();
          /*    5
              /  \
             4    7
           / \    / \
          2   3  1   6
         / \        /
        7   3     9
         */
        int sum = 13;
        System.out.println("hasPathSum  " + hasPathSum(root, sum));
        System.out.println("hasPathSumWORecursion  " + hasPathSumWORecursion(root, sum));
        System.out.println("hasPathSumUpgrad  " + hasPathSumUpgrad(root, sum));
    }

    //Time - O(n)  Space - O(h)
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (sum - root.value ==0 && root.left == null && root.right == null)
            return true;
        return  hasPathSum(root.left, sum - root.value) ||
                        hasPathSum(root.right, sum - root.value);
    }

    // Time - O(n)
    // Space - O(h)
    public static boolean hasPathSumUpgrad(TreeNode root, int sum) {
        return preOrder(root, sum, 0);
    }

    static boolean preOrder(TreeNode root, int targetSum, int currSum){
        if(root ==null)
            return false;
        currSum = currSum + root.value;

        if(root.left == null && root.left ==null){
            if(currSum == targetSum)
                return true;
        }

        return ( preOrder(root.left, targetSum, currSum) || preOrder(root.right, targetSum,currSum ));

    }

    public static boolean hasPathSumWORecursion(TreeNode root, int sum) {
        if(root == null)
            return false;

        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> values = new LinkedList<Integer>();

        nodes.add(root);
        values.add(root.value);

        while(!nodes.isEmpty()){
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();

            if(curr.left == null && curr.right == null && sumValue==sum){
                return true;
            }

            if(curr.left != null){
                nodes.add(curr.left);
                values.add(sumValue+curr.left.value);
            }

            if(curr.right != null){
                nodes.add(curr.right);
                values.add(sumValue+curr.right.value);
            }
        }

        return false;
    }
}
