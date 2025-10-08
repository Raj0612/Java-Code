package com.datastructures.trees.binarysearchtrees;

import com.datastructures.trees.binarysearchtrees.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearchPreOrder {

    static TreeNode root;

    public static void main(String[] args) {
        BinarySearchTree tree = BinarySearchTree.constructTree();
        root = tree.root;
        System.out.println("preOrderDFSRecursive " + preOrderDFSRecursive());
        System.out.println("preOrderDFSIterative " + preOrderDFSIterative());
    }

    static ArrayList<Integer> preOrderDFSRecursive() {
        ArrayList<Integer> results = new ArrayList<>();
        preOrderDFSRecursive(root, results);
        return results;
    }

    static void preOrderDFSRecursive(TreeNode root, ArrayList results){
        results.add(root.value);
        if(root.left!=null)
            preOrderDFSRecursive(root.left, results);
        if(root.right!=null)
            preOrderDFSRecursive(root.right, results);
    }

    static ArrayList<Integer> preOrderDFSIterative() {
        ArrayList<Integer> results = new ArrayList<>();
        preOrderDFSIterative(results);
        return results;
    }
    static ArrayList<Integer> preOrderDFSIterative(ArrayList results) {
        if (root == null) {
            return results;
        }
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);
        while (nodeStack.empty() == false) {
            TreeNode currentNode = nodeStack.peek();
            results.add(currentNode.value);
            nodeStack.pop();
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
            }
        }
        return results;
    }
}