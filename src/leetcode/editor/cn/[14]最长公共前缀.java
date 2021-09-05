//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1766 👎 0

package leetcode.editor.cn;

import java.util.Objects;

class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        boolean breakFlag = false;
        for (int i = 0; i < 200; i++) {
            if (breakFlag) {
                break;
            }
            if (i > 0) {
                prefix = prefix.concat(Objects.toString(strs[0].charAt(i-1)));
            }
            char currentChar = strs[0].length() > i ? strs[0].charAt(i) : '1';
            for (String s : strs) {
                if (s.length() <= i || s.charAt(i) != currentChar) {
                    breakFlag = true;
                    break;
                }
            }
        }
        return prefix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
