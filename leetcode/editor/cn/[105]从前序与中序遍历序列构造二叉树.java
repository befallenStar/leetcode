//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1700 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n <= 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int idx = 0;
        for (; idx < n; idx++)
            if (inorder[idx] == preorder[0])
                break;
        int[] left_pre = new int[idx];
        int[] left_in = new int[idx];
        int[] right_pre = new int[n - idx - 1];
        int[] right_in = new int[n - idx - 1];
        for (int i = 0; i < idx; i++) {
            left_pre[i] = preorder[i + 1];
            left_in[i] = inorder[i];
        }
        for (int i = idx + 1; i < n; i++) {
            right_pre[i - idx - 1] = preorder[i];
            right_in[i - idx - 1] = inorder[i];
        }
        root.left = buildTree(left_pre, left_in);
        root.right = buildTree(right_pre, right_in);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
