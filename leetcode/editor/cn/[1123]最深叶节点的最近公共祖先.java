//给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。 
//
// 回想一下： 
//
// 
// 叶节点 是二叉树中没有子节点的节点 
// 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1 
// 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。 
// 
//
// 
//
// 注意：本题与力扣 865 重复：https://leetcode-cn.com/problems/smallest-subtree-with-all-
//the-deepest-nodes/ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4]
//输出：[2,7,4]
//解释：
//我们返回值为 2 的节点，在图中用黄色标记。
//在图中用蓝色标记的是树的最深的节点。
//注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[1]
//解释：根节点是树中最深的节点，它是它本身的最近公共祖先。
// 
//
// 示例 3： 
//
// 
//输入：root = [0,1,3,null,2]
//输出：[2]
//解释：树中最深的叶节点是 2 ，最近公共祖先是它自己。 
//
// 
//
// 提示： 
//
// 
// 给你的树中将有 1 到 1000 个节点。 
// 树中每个节点的值都在 1 到 1000 之间。 
// 每个节点的值都是独一无二的。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 98 👎 0


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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root.left == null && root.right == null) return root;
        int max = maxDepth(root);
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int d = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (d < max) {
                for (int i = 0; i < size; i++) {
                    TreeNode tmp = queue.poll();
                    if (tmp.left != null)
                        queue.offer(tmp.left);
                    if (tmp.right != null)
                        queue.offer(tmp.right);
                }
                d++;
            } else {
                for (int i = 0; i < size; i++)
                    list.add(queue.poll());
            }
        }
        int size = list.size();
        TreeNode ans = list.get(0);
        for (int i = 1; i < size; i++)
            ans = lac(root, ans, list.get(i));
        return ans;
    }

    public int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) + 1;
    }

    public TreeNode lac(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q) return node;
        TreeNode left = lac(node.left, p, q);
        TreeNode right = lac(node.right, p, q);
        if (left != null && right != null) return node;
        return left != null ? left : right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
