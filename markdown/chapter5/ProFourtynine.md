#丑数
##题目
把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。例如 6、8 都是丑数，但 14 不是，
因为它包含因子 7。习惯上我们把 1 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。
##思路
一个丑数乘以2,3,5就变成了另外的丑数，按这个规律不断生成丑数，再按顺序排，最终可以得到。
##代码
    public class ProFourtynine {
        public int Uglynum(int Index){
            if (Index<=6)
                return Index;
            int i2=0,i3=0,i5=0;
            int[] dp = new int[Index];
            dp[0] = 1;
            for (int i=1;i<Index;i++){
                int next2 = dp[i2]<<1,next3 = dp[i3]*3,next5 = dp[i5]*5;
                dp[i] = Math.min(next2,Math.min(next3,next5));
                if (dp[i] == next2)
                    i2++;
                if (dp[i] == next3)
                    i3++;
                if (dp[i] == next5)
                    i5++;
            }
            return dp[Index-1];
        }
    }