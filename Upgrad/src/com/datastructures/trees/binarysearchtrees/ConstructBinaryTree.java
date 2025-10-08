package com.datastructures.trees.binarysearchtrees;

public class ConstructBinaryTree {

    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static TreeNode constructTree1(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

          /*
               3
              / \
             /   \
            1     4
             \
              2
        */
        return root;
    }
    static TreeNode constructTree2(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

          /*
              5
             / \
            3   6
           / \
          2   4
         /
        1
        */
        return root;
    }

    static TreeNode constructTree3(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

          /*
              4
             / \
            3   7
           / \
          1   4
        */
        return root;
    }

    static TreeNode constructTree4(){
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.left.left.left = new TreeNode(3);
        root.left.right.left = new TreeNode(5);
        root.right.left = new TreeNode(8);
        root.right.left.right = new TreeNode(10);

          /*
              7
             / \
            4   12
           / \   /
          3   6  8
         /   /    \
        1   5     10
        */
        return root;
    }

    static TreeNode constructTree5(){
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);
/*
                  50
               /     \
              30      70
             /  \    /  \
           20   40  60   80

 */
        return root;
    }


    static TreeNode constructTree6(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(9);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(6);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(14);

          /*
              10
             /   \
            8     13
           / \    /  \
          5   9  12  14
        /  \
       3    6
        */
        return root;
    }

    static TreeNode constructTree7(){
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(13);
        root.right.right.right = new TreeNode(14);

          /*
               7
             /   \
            3     10
           / \    / \
          1   4  8   13
               \       \
               6       14

        */
        return root;
    }
}



