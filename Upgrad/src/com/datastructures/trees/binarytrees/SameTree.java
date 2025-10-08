package com.datastructures.trees.binarytrees;
//Given the roots of two binary trees p and q, write a function to check if they are the same or not.
//Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
/*
Input: p = [1,2,3], q = [1,2,3]
Output: true

Input: p = [1,2], q = [1,null,2]
Output: false

Input: p = [1,2,1], q = [1,1,2]
Output: false
 */
public class SameTree {
    public static void main(String[] args) {
       // input1();
        input2();
    }

    static void input1(){
        BinaryTree tree= new BinaryTree();
        BinaryTree tree1= new BinaryTree();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        /*
                1               1
               / \             / \
              2   3           2   3
        */
        tree1.root = new TreeNode(1);
        tree1.root.left = new TreeNode(2);
        tree1.root.right = new TreeNode(3);
        System.out.println("isSameTree " + isSameTree(tree.root, tree1.root));
       // System.out.println("isSameTree1 " + isSameTree1(tree.root, tree1.root));
    }

    static void input2(){
        BinaryTree tree= new BinaryTree();
        BinaryTree tree1= new BinaryTree();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(8);
        tree.root.left.left.left= new TreeNode(6);
        tree.root.left.left.right = new TreeNode(7);
        /*
                 1                 1
               /   \             /   \
              2     3           2     3
            /  \              /  \
           4    5            4    6
         /  \              /  \
       6     7            6    7
        */
        tree1.root = new TreeNode(1);
        tree1.root.left = new TreeNode(2);
        tree1.root.right = new TreeNode(3);
        tree1.root.left.left = new TreeNode(4);
        tree1.root.left.right = new TreeNode(5);
        tree1.root.left.left.left= new TreeNode(6);
        tree1.root.left.left.right = new TreeNode(7);
      System.out.println("isSameTree " + isSameTree(tree.root, tree1.root));
       // System.out.println("isSameTree1 " + isSameTree1(tree.root, tree1.root));
    }

    static void input3(){
        BinaryTree tree= new BinaryTree();
        BinaryTree tree1= new BinaryTree();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(4);
        /*
                1               1
               / \             / \
              2   4           2   3
        */
        tree1.root = new TreeNode(1);
        tree1.root.left = new TreeNode(2);
        tree1.root.right = new TreeNode(3);
         System.out.println("isSameTree " + isSameTree(tree.root, tree1.root));
        //System.out.println("isSameTree1 " + isSameTree(tree.root, tree1.root));
    }

    static void input4(){
        BinaryTree tree= new BinaryTree();
        BinaryTree tree1= new BinaryTree();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        /*
                1               1
               / \             / \
              2   3           2   3
            /  \             / \
           4    5           4   5
        */
        tree1.root = new TreeNode(1);
        tree1.root.left = new TreeNode(2);
        tree1.root.right = new TreeNode(3);
        System.out.println("isSameTree " + isSameTree(tree.root, tree1.root));
        //System.out.println("isSameTree1 " + isSameTree(tree.root, tree1.root));
    }

    static boolean isSameTree(TreeNode tree, TreeNode tree1){
        if(tree==null&&tree1==null)
            return true;
        if(tree==null||tree1==null||tree.value!=tree1.value)
            return false;
        return isSameTree(tree.left,tree1.left) && isSameTree(tree.right,tree1.right);
    }

    static boolean isSameTree1(TreeNode tree, TreeNode tree1){
        if(tree==null&&tree1==null)
            return true;
        if(tree==null||tree1==null)
            return false;
        if(tree.value!=tree1.value)
            return false;

        boolean a = isSameTree1(tree.left,tree1.left);
//        if(a==false)
//            return false;
        boolean b = isSameTree1(tree.right,tree1.right);
//        if(b==false)
//            return false;
        if(a&&b)
            return true;
        else
            return false;
    }
}
