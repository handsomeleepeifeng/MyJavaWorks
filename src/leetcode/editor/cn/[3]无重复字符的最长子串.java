//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 6052 👎 0

package leetcode.editor.cn;

import java.util.*;

class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstringV2(String s) {
            if (s.length() <= 1) {
                return s.length();
            }
            Map<Character, Integer> map = new HashMap<>();
            int head = 0;
            int tail = 1;
            int maxL = 1;
            map.put(s.charAt(head), head);
            while (tail < s.length()) {
                if (!map.containsKey(s.charAt(tail))) {
                    maxL = Math.max(tail - head + 1, maxL);
                } else {
                    head = map.get(s.charAt(tail)) + 1;
                    Set<Character> removeKeys = new HashSet<>();
                    int finalHead = head;
                    map.forEach((k, v) -> {
                        if (v < finalHead) {
                            removeKeys.add(k);
                        }
                    });
                    removeKeys.forEach(map::remove);
                }
                map.put(s.charAt(tail), tail);
                tail++;
            }
            return maxL;
        }

        public int lengthOfLongestSubstring(String s) {
            if (s.length() <= 1) {
                return s.length();
            }
            int head = 0;
            int tail = 1;
            int maxL = 1;
            String subString = s.substring(head, tail);
            while (tail < s.length()) {
                if (subString.contains(Objects.toString(s.charAt(tail)))) {
                    int index = subString.indexOf(Objects.toString(s.charAt(tail)));
                    head = head + index + 1;
                }
                tail++;
                subString = s.substring(head, tail);
                maxL = Math.max(subString.length(), maxL);
            }
            return maxL;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
