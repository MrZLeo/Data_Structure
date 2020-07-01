package LeetCode;

/**
 * @author MrZLeo
 *
 * 563. Binary Tree Tilt
 * Given a binary tree, return the tilt of the whole tree.
 *
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. 
 * Null node has tilt 0.
 *
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * Example:
 * Input:
 *          1
 *        /   \
 *       2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * Note:
 *
 * The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * All the tilt values won't exceed the range of 32-bit integer.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 */

public class BinaryTreeTilt {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    class Solution {
        private int tilt = 0;
        public int findTilt(TreeNode root) {
            preorder(root);
            return tilt;
        }

        private int Sum(TreeNode node){
            if(node == null){
                return 0;
            }

            if(node.left == null && node.right == null){
                return node.val;
            }

            return node.val + Sum(node.left) + Sum(node.right);

        }

        private int tilt(TreeNode node){
            return Math.abs(Sum(node.left) - Sum(node.right));
        }


        private void preorder(TreeNode node){
            if(node == null){
                return ;
            }

            this.tilt += tilt(node);
            preorder(node.left);
            preorder(node.right);
        }
    }
}
