package com.datastructures.trees.binarytrees;

import java.util.*;
public class PrintNodesOfDistanceK {

    public static void main(String[] args) {
        TreeNode node = BinaryTree.constructTree();
          /*   1
              / \
             2   3
            /\   / \
           4  5  6  7
          /          \
         8            15
         */

        System.out.println("levelOrderTraversal " + levelOrderTraversal(node, 3));
        System.out.println("levelOrderTraversal " + levelOrderTraversalByQueue1(node, 3));
        System.out.println();
        printNodesAtDistanceByPreOrder(node, 3);
    }

    public static List<Integer> levelOrderTraversal(TreeNode root, int distance) {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>(Arrays.asList(root));
        int level = 1;
        List<Integer> currLevel = new ArrayList<>();
        while (!queue.isEmpty()) {

            for (int size = queue.size(); size > 0; --size) {
                TreeNode node = queue.poll();
                if(level == distance)
                    currLevel.add(node.value);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            level++;
        }

        return currLevel;
    }

    public static List<Integer> levelOrderTraversalByQueue1(TreeNode root, int distance) {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>(Arrays.asList(root));
        int level = 1;
        List<Integer> currLevel = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if(level == distance)
                    currLevel.add(node.value);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);

                size--;
            }
            level++;
        }

        return currLevel;
    }

    public static void printNodesAtDistanceByPreOrder(TreeNode root, int distance) {

        if(root == null || distance < 1)
            return ;

        if(distance ==1){
            System.out.print(root.value + " ");
            return;
        }

        printNodesAtDistanceByPreOrder(root.left, distance - 1);
        printNodesAtDistanceByPreOrder(root.right, distance - 1);
    }
}
