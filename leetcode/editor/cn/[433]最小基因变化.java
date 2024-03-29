//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。 
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意： 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 如果一个起始基因序列需要多次变化，那么它每一次变化之后的基因序列都必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 
//
// 示例 1： 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2： 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
// 
//
// 示例 3： 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
// Related Topics 广度优先搜索 哈希表 字符串 👍 91 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> que = new LinkedList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        int distance = 0;
        que.offer(start);
        map.put(start, distance);
        while (!que.isEmpty()) {
            String tmp = que.poll();
            if(null == tmp)
                break;
            distance = map.get(tmp);
            distance++;
            for(String b : bank) {
                if (!map.containsKey(b) && 1 == difference(tmp, b)) {
                    map.put(b, distance);
                    que.offer(b);
                }
            }
        }
        if(map.containsKey(end))
            return map.get(end);
        else
            return -1;
    }

    public int difference(String a, String b) {
        int diff = 0;
        for (int i = 0; i < 8; i++) {
            if (a.charAt(i) != b.charAt(i))
                diff++;
        }
        return diff;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
