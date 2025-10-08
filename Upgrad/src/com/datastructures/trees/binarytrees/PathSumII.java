package com.datastructures.trees.binarytrees;

import java.util.ArrayList;
import java.util.List;
//Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
// Each path should be returned as a list of the node values, not node references.

//A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
// Upgrad video June 10
public class PathSumII {
    static  List<List<Integer>> all_paths;
    public static void main(String[] args) {
      //  input1();
        System.out.println();
        input2();
        System.out.println();
        //input3();
    }

    static void input1(){
        all_paths = new ArrayList<>();
        TreeNode root = BinaryTree.pathSumTree2();
        /*     5
              /  \
             4    8
           /      / \
         11      13   4
        / \          / \
       7  12        5   1
         */
        int sum = 22;
        System.out.println("pathSum  " + pathSum(root, sum));
        System.out.println("pathSumByUpgrad  " + pathSumByUpgrad(root, sum));
    }

    static void input2(){
          all_paths = new ArrayList<>();
        TreeNode root = BinaryTree.constructTree8();
         /*     5
              /  \
             4    7
           / \    / \
          2   3  1   6
         / \        /
        16   2      9
         */
        int sum = 27;
        System.out.println("pathSum  " + pathSum(root, sum));
        System.out.println("pathSumByUpgrad  " + pathSumByUpgrad(root, sum));
    }

    static void input3(){
        all_paths = new ArrayList<>();
        TreeNode root = BinaryTree.constructTree9();
         /*     5
              /  \
             4    7
           / \    / \
          2   3  1   6
         / \        /
        7   3     9
         */
        int sum = 13;
        System.out.println("pathSum  " + pathSum(root, sum));
        System.out.println("pathSumByUpgrad  " + pathSumByUpgrad(root, sum));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), ans);
        System.out.println("pathSum sum " + sum);
        return ans;
    }

    private static void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (root == null)
            return;
        if (root.value == sum && root.left == null && root.right == null) {
            path.add(root.value);
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(root.value);
        dfs(root.left, sum - root.value, path, ans);
        dfs(root.right, sum - root.value, path, ans);
        path.remove(path.size() - 1);
    }

    public static List<List<Integer>> pathSumByUpgrad(TreeNode root, int targetSum) {
        ArrayList<Integer> path = new ArrayList<>();
        preOrder(root, path, targetSum, 0);
        return all_paths;
    }

    static void preOrder(TreeNode root,ArrayList<Integer> path, int targetSum , int currSum){

        if(root == null)
            return;

        path.add(root.value);
        currSum = currSum + root.value;
        if (root.right == null && root.left == null) {
            if(targetSum == currSum){
                ArrayList<Integer> copyList = new ArrayList<>(path);
                all_paths.add(copyList);
                path.remove(path.size()-1);
                return;
            }

        }

        preOrder(root.left, path, targetSum, currSum);
        preOrder(root.right, path,targetSum, currSum);

        path.remove(path.size()-1);
    }
}
