package com.datastructures.trees.binarytrees;

import java.util.ArrayList;
import java.util.List;
//We have path depends on leaf. If n leaves are there then there will be n paths
public class BinaryTreePaths {
    static  List<List<Integer>> all_paths = new ArrayList<>();
    public static void main(String[] args) {
       // input1();
        input2();
    }

    static void input1(){
        TreeNode root = BinaryTree.constructTree1();
         /*      1
              /    \
             2       3
            /\      /  \
          4   5    6    7
        / \   /\  / \   / \
       8  9 10 11 12 13 14 15
         */
        System.out.println("binaryTreePaths " + binaryTreePaths(root));
        System.out.println("binaryTreePathsByUpgrad " + binaryTreePathsByUpgrad(root));
    }

    static void input2(){
        TreeNode root = BinaryTree.constructTree4();

        /*     1
              / \
             2   3
            /\   / \
           4  5  6  7
         */
        System.out.println("binaryTreePaths " + binaryTreePaths(root));
        System.out.println("binaryTreePathsByUpgrad " + binaryTreePathsByUpgrad(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, new StringBuilder(), ans);
        return ans;
    }

    private static void dfs(TreeNode root, StringBuilder sb, List<String> ans) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            ans.add(sb.append(root.value).toString());
            return;
        }

        final int length = sb.length();
        dfs(root.left, sb.append(root.value).append("->"), ans);
        sb.setLength(length);
        dfs(root.right, sb.append(root.value).append("->"), ans);
        sb.setLength(length);
    }


    //Time: O(l * h)
    //Space:O(l * h)
    public static List<String> binaryTreePathsByUpgrad(TreeNode root) {
        List<Integer> paths = new ArrayList<>();
        preOrder(root, paths);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < all_paths.size(); i++) {
            List<Integer> one_Path = all_paths.get(i);
            String path1 = "";

            for (int j = 0; j < one_Path.size(); j++) {
                if (j == 0) {
                    path1 = path1 + one_Path.get(j);
                }else{
                    path1  = path1 + "=>" + one_Path.get(j);
                }
            }
             path1 = "";
            for (int j = 0; j < one_Path.size(); j++) {
                if(j == one_Path.size()-1) {
                    path1 = path1 + one_Path.get(j) ;
                }else {
                    path1  = path1 + one_Path.get(j)  + "=>" ;
                }
            }
            result.add(path1);
        }
        return result;
    }

    static void preOrder(TreeNode root, List<Integer> path) {

        if (root == null)
            return;

        path.add(root.value);
        if (root.right == null && root.left == null) {
            ArrayList<Integer> copyList = new ArrayList<>(path);
            all_paths.add(copyList);
            path.remove(path.size()-1);
           return;
        }

        preOrder(root.left, path);
        preOrder(root.right, path);

        path.remove(path.size()-1);

    }
}
