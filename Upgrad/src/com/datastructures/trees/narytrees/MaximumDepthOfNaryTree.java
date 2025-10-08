package com.datastructures.trees.narytrees;

public class MaximumDepthOfNaryTree {
    public static void main(String[] args) {

        TreeNode root =NaryTree.constructTree1();
        System.out.println("maxDepth " + maxDepth(root));

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
    }

    static int maxDepth(TreeNode root){
        if(root == null)
            return 0;

        int max_subtree_height = 0;

        for(int i=0; i< root.children.size(); i++){
            int subtree_height = maxDepth(root.children.get(i));
            max_subtree_height = Math.max(subtree_height, max_subtree_height);
        }
        return  1+ max_subtree_height;
    }
}
