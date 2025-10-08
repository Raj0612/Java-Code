package com.datastructures.trees.binarysearchtrees;

import com.datastructures.trees.binarysearchtrees.BinarySearchTree.TreeNode;

public class SortedArrayToBST {

    public static void main(String[] args) {
       // int [] nums = {-10, -3, 0, 5, 9};
       // int [] nums = {1, 2, 3, 4, 5, 6, 7};
        int [] nums = {1, 3, 4, 6, 7, 8, 10, 13, 14};
        TreeNode tree =sortedArrayToBST(nums);
        System.out.println("Tree " + tree);
    }

    static TreeNode sortedArrayToBST(int[] nums){
        TreeNode tree =  convertArrayToBST(nums, 0, nums.length - 1);
        return tree;
    }

    static TreeNode convertArrayToBST(int[] nums , int l , int r) {
        if(l > r)
            return null;
        if(l == r)
            return new TreeNode(nums[l]);
        int mid = (l + (r - l) / 2);
        TreeNode head = new TreeNode(nums[mid]);
        head.left = convertArrayToBST(nums , l , mid - 1);
        head.right = convertArrayToBST(nums , mid + 1 , r);
        return head;
    }
}
