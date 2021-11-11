//给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。 
//
// 一个点的坐标（x，y）由一个有两个整数的整数数组表示。 
//
// 示例: 
//
// 
//输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//输出: True
// 
//
// 
//
// 注意: 
//
// 
// 所有输入整数都在 [-10000，10000] 范围内。 
// 一个有效的正方形有四个等长的正长和四个等角（90度角）。 
// 输入点没有顺序。 
// 
// Related Topics 几何 数学 👍 78 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double[] ds = new double[]{distance(p1, p2), distance(p1, p3), distance(p1, p4), distance(p2, p3), distance(p2, p4), distance(p3, p4)};
        Map<Double, Integer> map = new HashMap<>();
        for (double d : ds) {
            if (map.containsKey(d))
                map.put(d, map.get(d) + 1);
            else
                map.put(d, 1);
        }
        Double[] ks = new Double[map.keySet().size()];
        map.keySet().toArray(ks);
        return (ks.length == 2 && ((ks[0] < ks[1] && map.get(ks[0]) == 4 && map.get(ks[1]) == 2) || (ks[1] < ks[0] && map.get(ks[1]) == 4 && map.get(ks[0]) == 2)));
    }

    public double distance(int[] p1, int[] p2) {
        int x = p1[0] - p2[0], y = p1[1] - p2[1];
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
