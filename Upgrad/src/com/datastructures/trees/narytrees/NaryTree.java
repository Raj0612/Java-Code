package com.datastructures.trees.narytrees;

import java.util.ArrayList;

public class NaryTree {
    TreeNode root;

    NaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        constructTree();

    }
    static TreeNode constructTree() {
        NaryTree tree = new NaryTree();
        tree.root = new TreeNode(1);
        // TreeNode root = new TreeNode(1);
        tree.root.children.add(new TreeNode(2));
        tree.root.children.add(new TreeNode(3));
        tree.root.children.add(new TreeNode(4));
        tree.root.children.get(0).children.add(new TreeNode(5));
        tree.root.children.get(0).children.add(new TreeNode(6));
        tree.root.children.get(0).children.add(new TreeNode(7));
        tree.root.children.get(1).children.add(new TreeNode(8));
        tree.root.children.get(2).children.add(new TreeNode(9));
        tree.root.children.get(2).children.add(new TreeNode(10));
        tree.root.children.get(2).children.add(new TreeNode(11));

        /*
                              1
                         /    |    \
                        /     |     \
                       /      |      \
                      2       3       4
                    / | \     |     / | \
                   5  6  7    8    9 10  11
         */

        System.out.println("tree " + tree.root);
        return tree.root;
    }

    static TreeNode constructTree1() {
        NaryTree tree = new NaryTree();
        tree.root = new TreeNode(1);
        // TreeNode root = new TreeNode(1);
        tree.root.children.add(new TreeNode(2));
        tree.root.children.add(new TreeNode(3));
        tree.root.children.add(new TreeNode(4));
        tree.root.children.get(0).children.add(new TreeNode(5));
        tree.root.children.get(0).children.add(new TreeNode(6));
        tree.root.children.get(0).children.add(new TreeNode(7));
        tree.root.children.get(1).children.add(new TreeNode(8));
        tree.root.children.get(2).children.add(new TreeNode(9));
        tree.root.children.get(2).children.add(new TreeNode(10));
        tree.root.children.get(2).children.add(new TreeNode(11));
        tree.root.children.get(0).children.get(0).children.add(new TreeNode(12));

        /*
                              1
                         /    |    \
                        /     |     \
                       /      |      \
                      2       3       4
                    / | \     |     / | \
                   5  6  7    8    9 10  11
                  /
                 /
                12
         */

        System.out.println("tree " + tree.root);
        return tree.root;
    }

    static TreeNode constructTree3() {
        NaryTree tree = new NaryTree();
        tree.root = new TreeNode(1);
        // TreeNode root = new TreeNode(1);
        tree.root.children.add(new TreeNode(3));
        tree.root.children.add(new TreeNode(2));
        tree.root.children.add(new TreeNode(4));
        tree.root.children.get(0).children.add(new TreeNode(5));
        tree.root.children.get(0).children.add(new TreeNode(6));

        /*
                              1
                         /    |    \
                        /     |     \
                       /      |      \
                      3       2       4
                    / |
                   5  6
         */

        System.out.println("tree " + tree.root);
        return tree.root;
    }
}
    class TreeNode {
        int data;
        ArrayList<TreeNode> children;

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", children=" + children +
                    '}';
        }


        TreeNode(int data) {
            this.data = data;
            this.children = new ArrayList<TreeNode>();
        }
    }
