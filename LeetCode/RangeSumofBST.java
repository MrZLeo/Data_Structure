package LeetCode;

/**
 * 938. Range Sum of BST
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 * <p>
 * The binary search tree is guaranteed to have unique values.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * Example 2:
 * <p>
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 *  
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 */
public class RangeSumofBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * use order to check whether the val is in the range of L and R.
     * optimize: use if statement to check whether val is bigger than L or smaller than R,
     *           if so, keep recursion.
     *           if no, end recursion.
     * use this way can make our program quicker because we end recursion before we search all node.
     */
    class Solution1 {
        int ret = 0;

        public int rangeSumBST(TreeNode root, int L, int R) {
            inorder(root, L, R);
            return ret;
        }

        private void inorder(TreeNode node, int L, int R) {
            if (node == null) {
                return;
            }

            if (node.val > L) {
                inorder(node.left, L, R);
            }
            if (node.val >= L && node.val <= R) {
                ret += node.val;
            }
            if (node.val < R) {
                inorder(node.right, L, R);
            }
        }

    }
}
