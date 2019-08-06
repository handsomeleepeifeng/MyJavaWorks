#最长不含重复字符的子字符串
##题目
输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
##思路
动态规划
##代码
    import java.util.Arrays;
    
    public class ProFourtyeight {
        public int LongestStr(String str){
            int curlen = 0;
            int maxlen = 0;
            int[] pos = new int[26];
            Arrays.fill(pos,-1);
            for (int i=0;i<str.length();i++){
                int position = str.charAt(i)-'a';
                int preposititon = pos[position];
                if (preposititon == -1 || i-preposititon > curlen)
                    curlen++;
                else {
                    maxlen = Math.max(maxlen,curlen);
                    curlen = i-preposititon;
                }
            }
            maxlen = Math.max(maxlen,curlen);
            return maxlen;
        }
    }