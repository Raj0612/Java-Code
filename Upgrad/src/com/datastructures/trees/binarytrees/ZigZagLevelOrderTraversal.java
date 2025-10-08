package com.datastructures.trees.binarytrees;

import java.util.*;

public class ZigZagLevelOrderTraversal {

    static int max_level = 0;
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static void main(String[] args) {
        TreeNode root = BinaryTree.constructTree();
        /*     1
              / \
             2   3
            /\   / \
           4  5  6  7
          / \        \
         8   9        15
       */
        System.out.println("zigzagLevelOrder " + zigzagLevelOrder(root));
        System.out.println("zigzagLevelOrderTraversal " + Arrays.toString(zigzagLevelOrderTraversal(root)));
        System.out.println("zigzagLevelOrderByPreOrder " +zigzagLevelOrderByPreOrder(root));

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
      //  Deque<TreeNode> deque = new ArrayDeque<>(Arrays.asList(root));
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        boolean isLeftToRight = true;

        while (!deque.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            for (int size = deque.size(); size > 0; --size)
                if (isLeftToRight) {
                    TreeNode node = deque.pollFirst();
                    currLevel.add(node.value);
                    if (node.left != null)
                        deque.addLast(node.left);
                    if (node.right != null)
                        deque.addLast(node.right);
                } else {
                    TreeNode node = deque.pollLast();
                    currLevel.add(node.value);
                    if (node.right != null)
                        deque.addFirst(node.right);
                    if (node.left != null)
                        deque.addFirst(node.left);
                }
            ans.add(currLevel);
            isLeftToRight = !isLeftToRight;
        }

        return ans;
    }

    public static List<List<Integer>> zigzagLevelOrderByPreOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> result1 = new ArrayList<>();

        if(root== null)
            return result;

        zigzagLevelOrderByPreOrder(root, 0);

//        for(int i= 0; i<max_level; i++){
//            ArrayList<Integer> list = map.get(i);
//            if(i%2 == 1){
//                Collections.reverse(list);
//            }
//            result.add(list);
//        }

//        Iterator<Map.Entry<Integer, ArrayList<Integer>>> itr = map.entrySet().iterator();
//        while(itr.hasNext()) {
//            Map.Entry<Integer, ArrayList<Integer>> entry = itr.next();
//            Integer key = entry.getKey();
//            System.out.println("Key " +key);
//            ArrayList<Integer> list = entry.getValue();
//            System.out.println("list " +list);
//            if(key%2 ==1){
//                Collections.reverse(list);
//            }
//            result.add(list);
//        }

        map.forEach((k,v) -> {
            Integer key = k;
            ArrayList<Integer> list = v;
            if(key%2 ==1){
                Collections.reverse(list);
            }
            result.add(list);

        });
        return result;

    }
    public static void zigzagLevelOrderByPreOrder(TreeNode root, int level) {

        if(root==null)
            return;

        if(map.containsKey(level)){
            map.get(level).add(root.value);
        }else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.value);
            map.put(level, list);
        }

        max_level = Math.max(max_level, level);

        zigzagLevelOrderByPreOrder(root.left, level+1);
        zigzagLevelOrderByPreOrder(root.right, level+1);

    }

    public static int[] zigzagLevelOrderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<Integer>();
        Queue<TreeNode> treeNodes = new LinkedList<TreeNode>();
        Stack<TreeNode> currLevelNodes = new Stack<TreeNode> ();
        treeNodes.add(root);
        int leftToRight = 1;
        while (!treeNodes.isEmpty()) {
            if (leftToRight == 1) {
                int n = treeNodes.size();
                for (int i = 0; i < n; i++) {
                    TreeNode currentNode = treeNodes.peek();
                    treeNodes.poll();
                    traversal.add(currentNode.value);
                    if (currentNode.left != null) {
                        treeNodes.add(currentNode.left);
                        currLevelNodes.push(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        treeNodes.add(currentNode.right);
                        currLevelNodes.push(currentNode.right);
                    }
                }
            } else {
                int n = treeNodes.size();
                for (int i = 0; i < n; i++) {
                    TreeNode currentNode = treeNodes.peek();
                    treeNodes.poll();
                    traversal.add(currLevelNodes.peek().value);
                    currLevelNodes.pop();
                    if (currentNode.left != null) {
                        treeNodes.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        treeNodes.add(currentNode.right);
                    }
                }
            }
            leftToRight = 1 - leftToRight;
        }
        int[] temp = new int[traversal.size()];
        for (int i = 0; i < traversal.size(); i++) {
            temp[i] = traversal.get(i);
        }
        return temp;
    }


}
