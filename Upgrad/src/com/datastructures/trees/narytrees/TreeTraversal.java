package com.datastructures.trees.narytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTraversal {

    public static void main(String[] args) {
        NaryTree tree = new NaryTree();
        TreeNode root = tree.constructTree();
        /*
                              1

                         /    |    \
                        /     |     \
                       /      |      \
                      2       3       4
                    / | \     |     / | \
                   5  6  7    8    9 10  11
         */
        // [1, 2, 5, 6, 7, 3, 8, 4, 9, 10, 11]

        //TreeNode root = NaryTree.constructTree3();
                      /*
                             1
                         /   |   \
                        /    |    \
                       /     |     \
                      3      2      4
                    /  |
                   5   6
         */

       /* TreeNode root = new TreeNode(1);
        root.children.add(new TreeNode(2));
        root.children.add(new TreeNode(3));
        root.children.add(new TreeNode(4));
        root.children.add(new TreeNode(5));*/

        /*
                             1
                         /  /  \ \
                        2   3   4  5

         */
        List<Integer> preOrderList = new ArrayList<>();
        preOrderTraversal(root, preOrderList);
        System.out.println("preOrderTraversal " + preOrderList);
         printNAryTree(root);
        List<Integer> postOrderList = new ArrayList<>();
        postOrderTraversal(root, postOrderList);
        System.out.println("postOrderTraversal " + postOrderList);
    }

    /*
    Time - O(n)
    Space - O(h) --> Height of the tree --> logn (base k) <=h < =n
     */
    static void preOrderTraversal(TreeNode root, List<Integer> result) {

        if (root == null)
            return;

        result.add(root.data);

        for (int i = 0; i < root.children.size(); i++) {
            preOrderTraversal(root.children.get(i), result);
        }
       // System.out.println("preOrderTraversal result " + result);
    }

    static void postOrderTraversal(TreeNode root, List<Integer> result) {

        if (root == null)
            return;

        if(root.children!=null){
            for(TreeNode node: root.children){
                postOrderTraversal(node, result);
            }
        }
        result.add(root.data);
       // System.out.println("postOrderTraversal result " + result);
    }


    //Stack or Queue can be used
    private static void printNAryTree(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) { // so that we can reach each level
                TreeNode node = queue.poll();
                System.out.print(node.data + " ");
                for (TreeNode item : node.children) { // for-Each loop to iterate over all childrens
                    queue.offer(item);
                }
            }
           System.out.println();
        }
    }

}
