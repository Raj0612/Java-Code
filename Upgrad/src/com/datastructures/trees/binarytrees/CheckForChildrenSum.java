package com.datastructures.trees.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class CheckForChildrenSum {

    public static void main(String[] args) {

        TreeNode root = BinaryTree.checkForChildrenSumTree();

    }

    static int isSumProperty(TreeNode node){
        int left_data = 0, right_data = 0;
        if (node == null
                || (node.left == null && node.right == null))
            return 1;
        else {
            if (node.left != null)
                left_data = node.left.value;

            if (node.right != null)
                right_data = node.right.value;

            if ((node.value == left_data + right_data)
                    && (isSumProperty(node.left) != 0)
                    && isSumProperty(node.right) != 0)
                return 1;
            else
                return 0;
        }

    }


    /* returns 1 if children sum property holds
    for the given node and both of its children*/
    static int isSumPropertyByQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                if (!queue.isEmpty())
                        queue.offer(null);
                continue;
            }

            int sum = 0;

            // Calculating sum =node->left->data+node->right->data
            if (curr.left != null) {
                queue.offer(curr.left);
                sum += curr.left.value;
            }

            if (curr.right != null) {
                queue.offer(curr.right);
                sum += curr.right.value;
            }

            // Sum==0 means its a Leaf Node so true/valid
            if (sum != curr.value && sum != 0)
                return 0;
        }

        return 1;
    }
}
