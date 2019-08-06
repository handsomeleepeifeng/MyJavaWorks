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
