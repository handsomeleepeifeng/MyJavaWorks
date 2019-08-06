#连续子数组最大和
##题目
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,
问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被
他忽悠住？
##思路
用动态规划
##代码
       public class ProFourtytwo {
           public int MaxSum(int[] Array){
               int max = Array[0];
               int res = 0;
               for(int i=0;i<Array.length-1;i++){
                   max = Math.max(max+Array[i],Array[i]);
                   res = Math.max(res,max);
               }
               return res;
           }
       }