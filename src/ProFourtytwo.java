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
