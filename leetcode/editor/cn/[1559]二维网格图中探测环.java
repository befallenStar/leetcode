//给你一个二维字符网格数组 grid ，大小为 m x n ，你需要检查 grid 中是否存在 相同值 形成的环。 
//
// 一个环是一条开始和结束于同一个格子的长度 大于等于 4 的路径。对于一个给定的格子，你可以移动到它上、下、左、右四个方向相邻的格子之一，可以移动的前提是这
//两个格子有 相同的值 。 
//
// 同时，你也不能回到上一次移动时所在的格子。比方说，环 (1, 1) -> (1, 2) -> (1, 1) 是不合法的，因为从 (1, 2) 移动到 (1
//, 1) 回到了上一次移动时的格子。 
//
// 如果 grid 中有相同值形成的环，请你返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a",
//"a","a"]]
//输出：true
//解释：如下图所示，有 2 个用不同颜色标出来的环：
//
// 
//
// 示例 2： 
//
// 
//
// 输入：grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c",
//"c","c"]]
//输出：true
//解释：如下图所示，只有高亮所示的一个合法环：
//
// 
//
// 示例 3： 
//
// 
//
// 输入：grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m <= 500 
// 1 <= n <= 500 
// grid 只包含小写英文字母。 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 39 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && grid[i][j] == grid[i - 1][j])
                    if (!uf.findAndUnite(i * n + j, (i - 1) * n + j))
                        return true;
                if (j > 0 && grid[i][j] == grid[i][j - 1])
                    if (!uf.findAndUnite(i * n + j, i * n + j - 1))
                        return true;
            }
        }
        return false;
    }
}

class UnionFind {
    int[] parent;
    int[] size;
    int n;
    int setCount;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        size = new int[n];
        Arrays.fill(size, 1);
        this.n = n;
        setCount = n;
    }

    public int findset(int x) {
        return parent[x] == x ? x : (parent[x] = findset(parent[x]));
    }

    public void unite(int x, int y) {
        if (size[x] < size[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        parent[y] = x;
        size[x] += size[y];
        setCount--;
    }

    public boolean findAndUnite(int x, int y) {
        int parentX = findset(x);
        int parentY = findset(y);
        if (parentX != parentY) {
            unite(parentX, parentY);
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
