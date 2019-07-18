public class ProFourty {
    public int[] miniK(int[] num,int k){
        int[] result = new int[k];
        int start = 0;
        int end = num.length-1;
        int index = HalfQuickSort(num,start,end);
        while (index != k-1){
            if (index < k-1) {
                start = index+1;
                index = HalfQuickSort(num,start,end);
            }
            else {
                end = index-1;
                index = HalfQuickSort(num,start,end);
            }
        }
        System.arraycopy(num,0,result,0,k);
        return result;
    }

    private int HalfQuickSort(int[] Array, int left, int  right){
        int basenum = Array[left];
        int i=left,j=right;
        while (i!=j){
            while(Array[j] > basenum && i!=j)
                j--;
            while (Array[i] < basenum && i!=j)
                i++;
            if (i!=j){
                int temp = Array[j];
                Array[j] = Array[i];
                Array[i] = temp;
            }
            Array[left] = Array[i];
            Array[i] = basenum;
        }
        return i;
    }
}
