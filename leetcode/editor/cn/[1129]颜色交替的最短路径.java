//在一个有向图中，节点分别标记为 0, 1, ..., n-1。这个图中的每条边不是红色就是蓝色，且存在自环或平行边。 
//
// red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从
//节点 i 到节点 j 的蓝色有向边。 
//
// 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，
//那么 answer[x] = -1。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
//输出：[0,1,-1]
// 
//
// 示例 2： 
//
// 输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
//输出：[0,1,-1]
// 
//
// 示例 3： 
//
// 输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
//输出：[0,-1,-1]
// 
//
// 示例 4： 
//
// 输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
//输出：[0,1,2]
// 
//
// 示例 5： 
//
// 输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
//输出：[0,1,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// red_edges.length <= 400 
// blue_edges.length <= 400 
// red_edges[i].length == blue_edges[i].length == 2 
// 0 <= red_edges[i][j], blue_edges[i][j] < n 
// 
// Related Topics 广度优先搜索 图 👍 85 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Map<Integer, List<Integer>> red = new HashMap<>();
        Map<Integer, List<Integer>> blue = new HashMap<>();
        for (int[] edge : redEdges) {
            List<Integer> tmp = red.getOrDefault(edge[0], new ArrayList<>());
            tmp.add(edge[1]);
            red.put(edge[0], tmp);
        }
        for (int[] edge : blueEdges) {
            List<Integer> tmp = blue.getOrDefault(edge[0], new ArrayList<>());
            tmp.add(edge[1]);
            blue.put(edge[0], tmp);
        }
        Queue<Integer> redq = new LinkedList<>();
        Queue<Integer> blueq = new LinkedList<>();
        redq.offer(0);
        blueq.offer(0);
        int[] redans = new int[n];
        int[] blueans = new int[n];
        Arrays.fill(redans, -1);
        Arrays.fill(blueans, -1);
        redans[0] = 0;
        blueans[0] = 0;
        int row = 0;
        while (!redq.isEmpty() || !blueq.isEmpty()) {
            Queue<Integer> redque = new LinkedList<>();
            Queue<Integer> blueque = new LinkedList<>();
            int redSize = redq.size();
            for (int i = 0; i < redSize; i++) {
                int v = redq.poll();
                List<Integer> tmp = blue.getOrDefault(v, new LinkedList<>());
                for (Integer e : tmp) {
                    if (blueans[e] == -1) {
                        blueans[e] = row + 1;
                        blueque.add(e);
                    }
                }
            }
            int blueSize = blueq.size();
            for (int i = 0; i < blueSize; i++) {
                int v = blueq.poll();
                List<Integer> tmp = red.getOrDefault(v, new LinkedList<>());
                for (Integer e : tmp) {
                    if (redans[e] == -1) {
                        redans[e] = row + 1;
                        redque.add(e);
                    }
                }
            }
            redq = redque;
            blueq = blueque;
            row++;
        }
        for (int i = 0; i < n; i++) {
            if (redans[i] >= 0 && blueans[i] >= 0) {
                ans[i] = Math.min(redans[i], blueans[i]);
            } else if (redans[i] >= 0) {
                ans[i] = redans[i];
            } else {
                ans[i] = blueans[i];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
