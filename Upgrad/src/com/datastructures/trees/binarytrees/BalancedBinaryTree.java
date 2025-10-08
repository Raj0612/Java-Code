package com.datastructures.trees.binarytrees;

//Given a binary tree, determine if it is height-balanced
//The difference between left height & right height of every subtree is <=1
/*
Input: root = [3,9,20,null,null,15,7]
Output: true

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
 */
public class BalancedBinaryTree {
    static boolean  ans = true;
    public static void main(String[] args) {
        TreeNode node = BinaryTree.heightBalancedTree();
           /*
                    3
                  /   \
                 9     20
                      /  \
                    15    7
         */
      //  TreeNode node = BinaryTree.heightBalancedTree1();
          /*
                    1
                 /     \
               2        2
             /   \
           3      3
         /  \
        4    4
         */
       // TreeNode node = BinaryTree.constructTree6();
        System.out.println("isBalanced " + isBalanced(node));
       System.out.println("isBalanced1 " + isBalanced1(node));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int height = getHeight(root);
        System.out.println("height " + height);
        return ans;
    }
    public static int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left_height = getHeight(root.left);
        int right_height = getHeight(root.right);
        if (Math.abs(left_height - right_height) >1){
            ans = false;
        }
        return 1 + Math.max(left_height, right_height);
    }


    public static boolean isBalanced1(TreeNode root) {
        if (root == null)
            return true;

        int left_tree_height = height(root.left);
        int right_tree_height = height(root.right);
        if (Math.abs(left_tree_height - right_tree_height) >1)
            return false;

        return  true;

        //return isBalanced1(root.left) && isBalanced1(root.right);
    }

    public static int height(TreeNode root) {
        if (root == null)
            return 0;

        int left_height = height(root.left);
        int right_height = height(root.right);

        return 1 + Math.max(left_height, right_height);
    }

}
