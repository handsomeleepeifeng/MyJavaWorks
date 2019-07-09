#Fibonacci数列
##题目
写一个函数，输入n，求Fibonacci数列的第n项，数列定义如下：

f(n) = n, n <= 1

f(n) = f(n-1) + f(n-2), n > 1
##代码
    public class ProTenFibonaacci {
        public long solution1(int n){
            if (n<=0)
                return 0;
            if (n==1)
                return 1;
            else
                return solution1(n-1)+solution1(n-2);
        }
        public long solution2(int n){
            if (n<=0)
                return 0;
            if (n==1)
                return 1;
            else{
                long f0=0;
                long f1=1;
                for (int i=2;i<=n;i++){
                    f1 += f0;
                    f0 = f1 - f0;
                }
                return f1;
            }
    
        }
    }