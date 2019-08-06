#把数字翻译成字符串
##题目
给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成
“z”。一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh
，abyh，lyh。实现一个函数，用来计算一个数字有多少种不同的翻译方法。
##思路
用动态规划
##代码
    public class ProFourtysix {
        public int numDecoding(int num){
            if (num==0)
                return 0;
            String str = String.valueOf(num);
            int[] dp = new int[str.length()+1];
            dp[0]=1;
            dp[1]=0;
            for (int i=2;i<str.length();i++){
                int onedigit = Integer.valueOf(str.substring(i-1,i));
                if (onedigit != 0)
                    dp[i] += dp[i-1];
                if (str.charAt(i-2)==0)
                    continue;
                int twodigit = Integer.valueOf(str.substring(i-2,i));
                if (twodigit<26)
                    dp[i] += dp[i-2];
            }
            return dp[str.length()];
        }
    }