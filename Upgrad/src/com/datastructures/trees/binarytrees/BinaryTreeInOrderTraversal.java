package com.datastructures.trees.binarytrees;

import java.util.ArrayList;
//L ->N ->R
public class BinaryTreeInOrderTraversal {

    public static void main(String[] args) {

        /*       1
              /    \
             2       3
            /\      /  \
          4   5    6    7
        / \   /\  / \   / \
       8  9 10 11 12 13 14 15
         */

          /*   1
              / \
             2   3
           / \  / \
          4  5  6  7
           \
             8
         */
        TreeNode root = null;
       // root = BinaryTree.constructTree();
     //   root =  BinaryTree.constructTree1();
     //   root = BinaryTree.constructTree2();

         /*     1
              / \
             2   3
            /\   / \
           4  5  6  7
         */
        root = BinaryTree.constructTree4();
        ArrayList<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        System.out.println("Result " + list);
    }

    static void inOrderTraversal(TreeNode root, ArrayList list){
        if(root==null){
            return;
        }
        inOrderTraversal(root.left, list);
        list.add(root.value);
        inOrderTraversal(root.right, list);
    }
}
