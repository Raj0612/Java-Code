package com.datastructures.trees.binarysearchtrees;

import com.datastructures.trees.binarysearchtrees.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DepthFirstSearchPostOrder {
    static TreeNode root;

    public static void main(String[] args) {
        BinarySearchTree tree = BinarySearchTree.constructTree1();
           /*
               47
              / \
             /   \
            21    76
           / \   /  \
          18 27 52  82

        */
        root = tree.root;
        System.out.println("postOrderDFSRecursive " + postOrderDFSRecursive());
        System.out.println("postOrderDFSIterative " + postOrderDFSIterative());
    }

    static ArrayList<Integer> postOrderDFSRecursive() {
        ArrayList<Integer> results = new ArrayList<>();
        postOrderDFSRecursive(root, results);
        return results;
    }

    static void postOrderDFSRecursive(TreeNode root, ArrayList results){
        if(root.left!=null)
            postOrderDFSRecursive(root.left, results);
        if(root.right != null)
            postOrderDFSRecursive(root.right, results);

        results.add(root.value);
    }

    static ArrayList<Integer> postOrderDFSIterative(){
        ArrayList<Integer> results = new ArrayList<>();
        postOrderDFSIterative(root, results);
        return results;
    }

    static void postOrderDFSIterative(TreeNode root, ArrayList results ) {
        TreeNode currentNode = root;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);

        while (currentNode != null) {
            if (currentNode.left != null && !parentMap.containsKey(currentNode.left)) {
                parentMap.put(currentNode.left, currentNode);
                currentNode = currentNode.left;
            } else if (currentNode.right != null && !parentMap.containsKey(currentNode.right)) {
                parentMap.put(currentNode.right, currentNode);
                currentNode = currentNode.right;
            } else {
                results.add(currentNode.value);
                currentNode = parentMap.get(currentNode);
            }
        }
    }
}
