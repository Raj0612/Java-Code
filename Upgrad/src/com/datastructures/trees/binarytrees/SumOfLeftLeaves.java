package com.datastructures.trees.binarytrees;
//Given the root of a binary tree, return the sum of all left leaves.
//A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
public class SumOfLeftLeaves {

    static int sum =0;

    public static void main(String[] args) {

       // TreeNode root = BinaryTree.constructTree4();
        //TreeNode root = constructTree();
        TreeNode root = constructTree1();
        System.out.println("sumOfLeftLeaves " +sumOfLeftLeaves(root));
       // System.out.println("sumOfLeftLeavesMorrisInOrder " +sumOfLeftLeavesMorrisInOrder(root));
        System.out.println("sumOfLeftLeavesByPreOrder " +sumOfLeftLeavesByPreOrderByUpgrad(root));
    }

    static TreeNode constructTree(){
        /*
                2
              /   \
             4      7
            / \    / \
           5   8   9  4
              /
             6
         */
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(9);
        root.right.right =  new TreeNode(4);
        return root;
    }

    static TreeNode constructTree1(){
        /*
                2
              /   \
             4      7
                   / \
                   9  4
         */
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right =  new TreeNode(4);
        return root;
    }

    public static int sumOfLeftLeavesByPreOrderByUpgrad(TreeNode root) {
        preOrder(root, false);
        return sum;
    }

    static void preOrder(TreeNode root, boolean is_left){
        if(root == null)
            return;
        if((root.left==null && root.right==null) && is_left){
            sum = sum + root.value;
            return;
        }
        preOrder(root.left, true);
        preOrder(root.right, false);
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left != null && root.left.left == null && root.left.right == null)
            return root.left.value + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
       // return 0;
    }

    public static int sumOfLeftLeavesMorrisInOrder(TreeNode root) {
        int sum = 0;
        while (root != null) {
            if (root.left == null) {
                if (root.left != null && root.left.left == null && root.left.right == null)
                    sum += root.left.value;
                root = root.right;
            } else {
                TreeNode temp = root.left;
                while (temp.right != null && temp.right != root)
                    temp = temp.right;
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else {
                    temp.right = null;
                    if (root.left != null && root.left.left == null && root.left.right == null)
                        sum += root.left.value;
                    root = root.right;
                }
            }
        }
        return sum;
    }


}
