//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 4049 👎 0

package leetcode.editor.cn;
class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i=0;i<s.length();i++) {
            for (int j=0; j<s.length();j++) {
                if (i >= j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        int start = 0;
        int end = 0;
        int maxLen = 1;
        int i,j,k;
        for (k = 1; k < s.length(); k++) {
            for (i=0; i+k < s.length(); i++) {
                j = i+k;
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i+1][j-1];
                    if (dp[i][j]) {
                        if (k+1 > maxLen) {
                            maxLen = k+1;
                            start = i;
                            end = j;
                        }
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
