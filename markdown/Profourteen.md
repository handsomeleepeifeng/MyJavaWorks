#剪绳子
##题目
给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1）。每段的绳子的长度记为
k[0]、k[1]、……、k[m]。k[0] * k[1] * … * k[m]可能的最大乘积是多少？例如当绳子的长度是8时
，我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。
##思路
利用动态规划，先剪一刀长度为i，这根绳子上最大的乘积记做f(i),剩下这绳子长度为n-i,那么这根绳子最大乘积
可以记做f(n-i),所以f(n)=f(i)*f(n-i)。
##代码
    public class Profourteen {
        public int maxCut(int len){
            int[] maxlenth = new int[len];
            if (len < 4)
                return len;
            maxlenth[0]=0;
            maxlenth[1]=1;
            maxlenth[2]=2;
            maxlenth[3]=3;
            for (int i = 4;i<len;i++){
                int max = 0;
                for (int j =i;j<i/2 ;j++){
                    int max1 = maxlenth[i] * maxlenth[i - j];
                    if (max < max1){
                        max = max1;
                    }
                }
                maxlenth[i] = max;
            }
            return maxlenth[len-1];
        }
    }