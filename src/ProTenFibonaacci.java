public class ProTenFibonaacci {
    /***直接递归***/
    public long solution1(int n){
        if (n<=0)
            return 0;
        if (n==1)
            return 1;
        else
            return solution1(n-1)+solution1(n-2);
    }
    /*****改进n过大递归过深可能出现溢出的情况****/
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
