package com.datastructures.trees.binarytrees;

public class BinaryTree {
    TreeNode root;

    BinaryTree(int key) {
        root = new TreeNode(key);
    }

    BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        /* Following is the tree after above statement
           1
          / \
        null null
        */
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        /* 2 and 3 become left and right children of 1
              1
             / \
            2   3
           / \ / \
       null null null null */
        tree.root.left.left = new TreeNode(4);
        /* 4 becomes left child of 2
               1
              / \
             2   3
            / \ / \
           4 null null null
          / \
        null null
        */
        tree.root.left.right = new TreeNode(5);
         /* 5 becomes right child of 2
               1
              / \
             2   3
            / \ / \
           4  5 null null
          / \
        null null
        */

        tree.root.right.left = new TreeNode(6);
         /* 6 becomes left child of 3
               1
              / \
             2   3
            / \ / \
           4  5 6
          / \
        null null
        */
        tree.root.right.right = new TreeNode(7);
        /* 6 becomes left child of 3
               1
              / \
             2   3
            / \ / \
           4  5 6 7
          / \
        null null
        */

        tree.root.left.left.left = new TreeNode(8);
        /* 8 becomes left child of 4
               1
              / \
             2   3
            / \ / \
           4  5 6 7
          / \
        8 null
        */
        tree.root.right.right.right = new TreeNode(15);
        /* 15 becomes right child of 7
               1
              / \
             2    3
            / \  / \
           4  5  6  7
          /          \
         8           15
        */
        System.out.println("Tree " + tree.root);

        BinaryTreeTraversal treeTraversal = new BinaryTreeTraversal();
        System.out.println("PreOrder Traversal");
        BinaryTreeTraversal.preOrder(tree.root);
        System.out.println();
        System.out.println("PreOrder Reverse Traversal");
        BinaryTreeTraversal.reversePreOrder(tree.root);
        System.out.println();
        System.out.println("InOrder Traversal");
        BinaryTreeTraversal.inOrder(tree.root);
        System.out.println();
        System.out.println("PostOrder Traversal");
        BinaryTreeTraversal.postOrder(tree.root);
    }

    static TreeNode constructTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.right.right.right = new TreeNode(15);

        /*     1
              / \
             2   3
            /\   / \
           4  5  6  7
          / \        \
         8   9        10
         */

        return root;
    }

    static TreeNode constructTree1(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        /*       1
              /    \
             2       3
            /\      /  \
          4   5    6    7
        / \   /\  / \   / \
       8  9 10 11 12 13 14 15
         */

        return root;
    }

    static TreeNode constructTree2(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.right = new TreeNode(8);

        /*     1
              / \
             2   3
            /\   / \
           4  5  6  7
            \
             8
         */

        return root;
    }

    static TreeNode constructTree3(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        /*     1
              / \
             2   3
              \
               5
         */

        return root;
    }

    static TreeNode constructTree4(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        /*     1
              / \
             2   3
            /\   / \
           4  5  6  7
         */

        return root;
    }

    static TreeNode constructTree5(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(4);

        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(4);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);

        /*     1
              / \
             2   2
           / \   /  \
          3  3   3     3
        / \  /\  /\   / \
      4  4  4 4 4  4  4  4
         */

        return root;
    }

    static TreeNode constructTree6(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        /*     1
              / \
             2   2
           / \   / \
          3  3  3   3
         */

        return root;
    }

    static TreeNode constructTree7(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        /*     1
              / \
             2   3
           / \
          4   5
         */

        return root;
    }



    static TreeNode constructTree8(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(16);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(9);

        /*     5
              /  \
             4    7
           / \    / \
          2   3  1   6
         / \        /
        7   2      9
         */

        return root;
    }

    static TreeNode constructTree9(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(9);

        /*     5
              /  \
             4    7
           / \    / \
          2   3  1   6
         / \        /
        7   3     9
         */

        return root;
    }

    static TreeNode constructTree10(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.left.right = new TreeNode(7);

        /*     1
              / \
             2   3
           / \
          4   5
             /
            6
             \
              7
         */

        return root;
    }

    static TreeNode constructTreeLeafSimilar(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(8);

         /*    3
              / \
             /   \
            5     1
           /\    / \
          6  2  9   8
            /  \
           7    4
         */

        return root;
    }

    static TreeNode constructTreeLeafSimilar1(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(8);

        /*     3
              / \
             /   \
            5     1
           /\    / \
          6  7  4   2
                   / \
                  9   8
         */

        return root;
    }

    static TreeNode constructTree3Nodes(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(4);

        /*
               10
              / \
             /   \
            6     4

        */

        return root;
    }

    static TreeNode constructTree3Nodes1(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        return root;
        /*
                 1
                / \
               2   3
         */
    }

    static TreeNode heightBalancedTree(){
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(7);

        /*
                    3
                 /     \
               9        20
                       /  \
                     15    7
         */

        return tree;
    }

    static TreeNode heightBalancedTree1(){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(3);
        tree.left.left.left = new TreeNode(4);
        tree.left.left.right = new TreeNode(4);

        /*
                    1
                 /     \
               2        2
             /   \
           3      3
         /  \
        4    4
         */

        return tree;
    }
    static TreeNode checkForChildrenSumTree(){
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(8);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(2);

        return  tree;
    }

    static TreeNode pathSumTree(){
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(8);

        tree.left.left = new TreeNode(11);
        tree.left.left.left = new TreeNode(7);
        tree.left.left.right = new TreeNode(2);

        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);
        tree.right.right.right = new TreeNode(1);

         /*     5
              /  \
             4    8
           /      / \
         11      13   4
        / \           \
       7   2          1
         */

        return  tree;
    }

    static TreeNode pathSumTree2(){
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(8);

        tree.left.left = new TreeNode(11);
        tree.left.left.left = new TreeNode(7);
        tree.left.left.right = new TreeNode(12);

        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);
        tree.right.right.left = new TreeNode(5);
        tree.right.right.right = new TreeNode(1);

         /*     5
              /  \
             4    8
           /      / \
         11      13   4
        / \          / \
       7   2        5   1
         */

        return  tree;
    }

    static TreeNode constructTreeZigZagLevelOrder(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        /*
               3
              / \
             /   \
            9     20
                 /  \
               15    7
        */

        return root;
    }

    static TreeNode constructTreeLeftRightView(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(15);
        root.right.left = new TreeNode(12);
        root.right.right.left = new TreeNode(14);

          /*
               10
              / \
             /   \
            2     3
           / \   / \
          7  8  12  15
               /
              14
        */
        return root;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
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
