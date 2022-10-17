//有效数字（按顺序）可以分成以下几个部分： 
//
// 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 
//
// 小数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 下述格式之一： 
// 
// 至少一位数字，后面跟着一个点 '.' 
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
// 一个点 '.' ，后面跟着至少一位数字 
// 
// 
//
// 整数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 至少一位数字 
// 
//
// 部分有效数字列举如下：["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7
//", "+6e-1", "53.5e93", "-123.456e789"] 
//
// 部分无效数字列举如下：["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"] 
//
// 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "e"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s = "."
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。 
// 
//
// Related Topics 字符串 👍 332 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    enum CharType {
        CHAR_NUMBER,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_SIGN,
        CHAR_ILLEGAL,
    }

    enum State {
        STATE_INITIAL,
        STATE_INT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WO_INT,
        STATE_FRAC,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUMBER,
        STATE_END,
    }

    public CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9')
            return CharType.CHAR_NUMBER;
        if (ch == 'e' || ch == 'E')
            return CharType.CHAR_EXP;
        if (ch == '.')
            return CharType.CHAR_POINT;
        if (ch == '+' || ch == '-')
            return CharType.CHAR_SIGN;
        return CharType.CHAR_ILLEGAL;
    }

    public boolean isNumber(String s) {
        Map<CharType, State> initialMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WO_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }};
        Map<CharType, State> intSignMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WO_INT);
        }};
        Map<CharType, State> integerMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
        }};
        Map<CharType, State> pointMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRAC);
            put(CharType.CHAR_EXP, State.STATE_EXP);
        }};
        Map<CharType, State> pointWOIntMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRAC);
        }};
        Map<CharType, State> fracMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRAC);
            put(CharType.CHAR_EXP, State.STATE_EXP);
        }};
        Map<CharType, State> expMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        Map<CharType, State> expSignMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        Map<CharType, State> expNumMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        Map<State, Map<CharType, State>> transfer = new HashMap<>() {{
            put(State.STATE_INITIAL, initialMap);
            put(State.STATE_INT_SIGN, intSignMap);
            put(State.STATE_INTEGER, integerMap);
            put(State.STATE_POINT, pointMap);
            put(State.STATE_POINT_WO_INT, pointWOIntMap);
            put(State.STATE_FRAC, fracMap);
            put(State.STATE_EXP, expMap);
            put(State.STATE_EXP_SIGN, expSignMap);
            put(State.STATE_EXP_NUMBER, expNumMap);
        }};

        int n = s.length();
        State state = State.STATE_INITIAL;
        for (int i = 0; i < n; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type))
                return false;
            else
                state = transfer.get(state).get(type);
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRAC || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
