//如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ： 
//
// 
// 操作 1：交换任意两个 现有 字符。
//
// 
// 例如，abcde -> aecdb 
// 
// 
// 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
// 
// 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ） 
// 
// 
// 
//
// 你可以根据需要对任意一个字符串多次使用这两种操作。 
//
// 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "abc", word2 = "bca"
//输出：true
//解释：2 次操作从 word1 获得 word2 。
//执行操作 1："abc" -> "acb"
//执行操作 1："acb" -> "bca"
// 
//
// 示例 2： 
//
// 
//输入：word1 = "a", word2 = "aa"
//输出：false
//解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。 
//
// 示例 3： 
//
// 
//输入：word1 = "cabbba", word2 = "abbccc"
//输出：true
//解释：3 次操作从 word1 获得 word2 。
//执行操作 1："cabbba" -> "caabbb"
//执行操作 2："caabbb" -> "baaccc"
//执行操作 2："baaccc" -> "abbccc"
// 
//
// 示例 4： 
//
// 
//输入：word1 = "cabbba", word2 = "aabbss"
//输出：false
//解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 10⁵ 
// word1 和 word2 仅包含小写英文字母 
// 
// Related Topics 哈希表 字符串 排序 👍 30 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> map1 = analyze(word1);
        Map<Character, Integer> map2 = analyze(word2);
        Set<Character> set1 = map1.keySet();
        Set<Character> set2 = map2.keySet();
        if (set1.size() != set2.size())
            return false;
        if (!(set1.containsAll(set2) && set2.containsAll(set1)))
            return false;
        Integer[] i1 = map1.values().toArray(new Integer[0]);
        Integer[] i2 = map2.values().toArray(new Integer[0]);
        Arrays.sort(i1);
        Arrays.sort(i2);
        for (int i = 0; i < set1.size(); i++) {
            if (!i1[i].equals(i2[i]))
                return false;
        }
        return true;
    }

    public Map<Character, Integer> analyze(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        return map;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
