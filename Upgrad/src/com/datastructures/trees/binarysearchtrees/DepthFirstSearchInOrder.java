package com.datastructures.trees.binarysearchtrees;
import com.datastructures.trees.binarysearchtrees.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearchInOrder {
    static TreeNode root;

    public static void main(String[] args) {
        BinarySearchTree tree = BinarySearchTree.constructTree1();
        root = tree.root;
        System.out.println("inOrderDFSRecursive " + inOrderDFSRecursive());
        System.out.println("inOrderDFSIterative " + inOrderDFSIterative());
    }

    static ArrayList<Integer> inOrderDFSRecursive() {
        ArrayList<Integer> results = new ArrayList<>();
        inOrderDFSRecursive(root, results);
        return results;
    }

    static void inOrderDFSRecursive(TreeNode root, ArrayList results){
        if(root.left!=null)
            inOrderDFSRecursive(root.left, results);
        results.add(root.value);
        if(root.right != null)
            inOrderDFSRecursive(root.right, results);
    }


    static ArrayList<Integer> inOrderDFSIterative(){
        ArrayList<Integer> results = new ArrayList<>();
        inOrderDFSIterative(root, results);
        return results;
    }

    static ArrayList<Integer> inOrderDFSIterative(TreeNode root, ArrayList results ) {
        if (root == null) {
            return results;
        }
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();

        TreeNode currentNode = root;
        while (currentNode != null || nodeStack.size() > 0) {
            while (currentNode !=  null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = nodeStack.pop();
            results.add(currentNode.value);
          //  System.out.println(currentNode.value + " ");
            currentNode = currentNode.right;
        }
        return results;
    }
}
