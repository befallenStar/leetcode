//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列
// beginWord -> s1 -> s2 -> ... -> sk： 
//
// 
// 每一对相邻的单词只差一个字母。 
// 
// 对于 1 <= i <= k 时，每个
// si 都在
// wordList 中。注意， beginWord 不需要在
// wordList 中。
// 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
//
// Related Topics 广度优先搜索 哈希表 字符串 👍 1111 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);
        while (!que.isEmpty()) {
            int s = que.size();
            for (int i = 0; i < s; i++) {
                String tmp = que.poll();
                for (String word : wordList) {
                    if (map.containsKey(word))
                        continue;
                    if (convert(tmp, word)) {
                        map.put(word, map.get(tmp) + 1);
                        que.offer(word);
                    }
                }
            }
        }
        return map.getOrDefault(endWord, 0);
    }

    public boolean convert(String w1, String w2) {
        int cnt = 0;
        for (int i = 0; i < w1.length(); i++)
            if (w1.charAt(i) != w2.charAt(i))
                cnt++;
        return cnt == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
