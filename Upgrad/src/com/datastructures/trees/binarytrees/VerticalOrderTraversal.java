package com.datastructures.trees.binarytrees;

import java.util.*;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
       // TreeNode root = BinaryTree.constructTreeLeftRightView();
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

        TreeNode root = BinaryTree.constructTree();
        /*     1
              / \
             2   3
            /\   / \
           4  5  6  7
          / \        \
         8   9        15
         */
        System.out.println("verticalTraversal " + verticalTraversal(root));
        System.out.println("verticalTraversalByQueue " + verticalTraversalByQueue(root));
        System.out.println("findVertical " + findVertical(root));
    }

    //Time -  O(n log n/k) ==> O(n log n), where K = width(tree)
    //Space - O(n)
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, List<int[]>> xToSortedPairs = new TreeMap<>(); // {x: {(-y, val)}}

        dfs(root, 0, 0, xToSortedPairs);

        for (List<int[]> pairs : xToSortedPairs.values()) {
            Collections.sort(pairs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<Integer> vals = new ArrayList<>();
            for (int[] pair : pairs)
                vals.add(pair[1]);
            ans.add(vals);
        }

        return ans;
    }

    private static void dfs(TreeNode root, int x, int y, TreeMap<Integer, List<int[]>> xToSortedPairs) {
        if (root == null)
            return;

        xToSortedPairs.putIfAbsent(x, new ArrayList<>());
        xToSortedPairs.get(x).add(new int[] {y, root.value});
        dfs(root.left, x - 1, y + 1, xToSortedPairs);
        dfs(root.right, x + 1, y + 1, xToSortedPairs);
    }

    //Time Complexity: O(N*logN*logN*logN)
    //Space Complexity: O(N)
    public static List < List < Integer >> findVertical(TreeNode root) {
        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
        Queue < Tuple > q = new LinkedList < Tuple > ();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.hd;
            int y = tuple.vd;


            if (!map.containsKey(x)) {
                map.put(x, new TreeMap < > ());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue < > ());
            }
            map.get(x).get(y).offer(node.value);

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue< Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }

    public static List < List < Integer >> verticalTraversalByQueue(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;

        Map<Integer, List<Tuple>> map = new HashMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));
        int minHd = 0;
        int maxHd =0;
        while(!queue.isEmpty()){
            Tuple curr = queue.remove();
            map.putIfAbsent(curr.hd, new ArrayList<>());
            minHd = Math.min(minHd, curr.hd);
            maxHd = Math.max(maxHd, curr.hd);

            map.get(curr.hd).add(curr);
            if(curr.node.left!=null){
               Tuple tuple = new Tuple(curr.node.left, curr.hd-1, curr.vd+1);
               queue.offer(tuple);
            }
            if(curr.node.right!=null){
                Tuple tuple = new Tuple(curr.node.right, curr.hd+1, curr.vd+1);
                queue.offer(tuple);
            }
        }
        //System.out.println("verticalTraversalByQueue map " + map);
        int index = 0;
        for(int i= minHd; i<= maxHd; i++){
            Collections.sort(map.get(i), (a,b) ->{
                if(a.vd == b.vd){
                    return a.node.value - b.node.value;
                }else{
                    return a.vd - b.vd;
                }
            });
         //   System.out.println("verticalTraversalByQueue map1 " + map);
            result.add(new ArrayList<>());
            for(Tuple tuple: map.get(i)){
                result.get(index).add(tuple.node.value);
            }

            index ++;
        }
        return  result;
    }

    static class Tuple {
        TreeNode node;
        int hd;
        int vd;
        public Tuple(TreeNode _node, int _row, int _col) {
            node = _node;
            hd = _row;
            vd = _col;
        }
    }
}
