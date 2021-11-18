//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， 
//wi 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 👍 446 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = -1;
        Set<Integer> arrived = new HashSet<>();
        arrived.add(k - 1);
        ans[k - 1] = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int[] time : times) {
                if (arrived.contains(time[0] - 1)) {
                    arrived.add(time[1] - 1);
                    int tmp = ans[time[0] - 1] + time[2];
                    if (-1 == ans[time[1] - 1] || (-1 != ans[time[1] - 1] && tmp < ans[time[1] - 1])) {
                        ans[time[1] - 1] = tmp;
                        flag = true;
                    }
                }
            }
        }
        int max = -1;
        for (int an : ans) {
            if (-1 == an)
                return -1;
            if (an > max)
                max = an;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
