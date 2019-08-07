public class ProFivetythree {
    public int Frequece(int[] array,int num){
        int start = binaryFind(array,num);
        int end = binaryFind(array,num+1);
        return (array[start] != num)?0:end-start;
    }

    private int binaryFind(int[] array,int num){
        int low = 0,high = array.length-1;
        while(low < high){
            int middle = low + (high-low)>>2;
            if (array[middle] >= num)
                high = middle;
            else
                low = middle+1;
        }
        return low;
    }
}
