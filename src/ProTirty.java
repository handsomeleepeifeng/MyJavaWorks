public class ProTirty {
    public int[] findKthNum(int[] Array,int k){
        int[] output = new int[k];
        QuickSort(Array,0,Array.length-1);
        System.arraycopy(Array, 0, output, 0, k);
        return output;

    }
    private void QuickSort(int[] Array, int left, int  right){
        if (left >= right)
            return;
        int baseNum = Array[left];
        int i = left,j = right;
        while (i != j){
            while (Array[j] > baseNum && i!=j){
                j--;
            }
            while (Array[i] < baseNum && i!=j){
                i++;
            }
            if ( i != j){
                int temp = Array[j];
                Array[j] = Array[i];
                Array[i] = temp;
            }
        }
        Array[left] = Array[i];
        Array[i] = baseNum;
        QuickSort(Array,left,i-1);
        QuickSort(Array,i+1,right);
    }
}
