package com.datastructures.trees.binarytrees;

import java.util.*;

public class TopView {
    static TreeMap<Integer, pair> m = new TreeMap<>();
    public static void main(String[] args) {
        TreeNode root = BinaryTree.constructTreeLeftRightView();
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
        System.out.print("topViewUsingMap: ");
        topViewUsingMap(root);
        System.out.println();
        System.out.print("topView: ");
        topView(root);
        System.out.println();
        System.out.print("topViewUsingLevelOrder: ");
        topViewUsingLevelOrder(root);
    }

    public  static void topViewUsingMap(TreeNode root) {
        if (root == null)
            return;

        Queue<QueueObj> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int min = 0;
        int max = 0;
        // Level Order Traversal
        queue.add(new QueueObj(root, 0));
        while (!queue.isEmpty()) {
            QueueObj curr = queue.poll();

            // only include in map if this is the  first node of this specific  horizontal distance
            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node.value);
            }

            if (curr.node.left != null) {
                // min can be found only in left side due to  "-1" minimum horizontal distance of any  node from root
                min = Math.min(min, curr.hd - 1);
                queue.add(new QueueObj(curr.node.left,
                        curr.hd - 1));
            }

            if (curr.node.right != null) {
                // max can be found only in right side due  to "+1" maximum horizontal distance of  any node from root
                max = Math.max(max, curr.hd + 1);
                queue.add(new QueueObj(curr.node.right,
                        curr.hd + 1));
            }
        }

        // traversal of (horizontal distance from root)  minimum to maximum
        for (; min <= max; min++) {
            System.out.print(map.get(min) + " ");
        }
    }

    static class QueueObj {
        TreeNode node;
        int hd;

        QueueObj(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    //Time complexity: O(N * log(N)), where N is the number of nodes in the given binary tree with each insertion operation in Map requiring O(log2 N) complexity.
    //Auxiliary Space: O(N)
    static void topView(TreeNode root) {
        fillMap(root, 0, 0);

        for (Map.Entry<Integer, pair> entry :
                m.entrySet()) {
            System.out.print(entry.getValue().first + " ");
        }
    }

    static class pair {
        int first, second;
        pair() {
        }
        pair(int i, int j) {
            first = i;
            second = j;
        }
    }


    static void fillMap(TreeNode root, int d, int l) {
        if (root == null)
            return;

        if (m.get(d) == null) {
            m.put(d, new pair(root.value, l));
        }
        else if (m.get(d).second > l) {
            m.put(d, new pair(root.value, l));
        }

        fillMap(root.left, d - 1, l + 1);
        fillMap(root.right, d + 1, l + 1);
    }


    public static void topViewUsingLevelOrder(TreeNode root){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int hd = 0, l = 0, r = 0;
        Stack<Integer> left = new Stack<>();

        // ArrayList is for holding right node's data
        ArrayList<Integer> right = new ArrayList<>();
        TreeNode node = null;
        while (!q.isEmpty()) {

            Pair pair = q.poll();
            node = pair.node;
            hd = pair.hd;

            if (hd < l) {
                left.push(node.value);
                l = hd;
            }

            if (hd > r) {
                right.add(node.value);
                r = hd;
            }

            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }

        }
        while (!left.isEmpty()) {
            System.out.print(left.peek() + " ");
            left.pop();
        }
        System.out.print(root.value + " ");
        for (int d : right) {
            System.out.print(d + " ");
        }
    }



}

 class Pair {
    TreeNode node;
    int hd;

    Pair() {}
    Pair(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
