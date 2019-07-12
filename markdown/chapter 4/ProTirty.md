#最小的k个数
##题目
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字
是1,2,3,4。
##思路
用快排先将数组排序，再取排序后的数组的前K个数。
##代码
    public class ProTirty {
        public int[] findKthNum(int[] Array,int k){
            int[] output = new int[k];
    
        }
        private void QuickSort(int[] Array, int left, int  right){
            if (left >= right)
                return;
            int baseNum = Array[left];
            int i = left,j = right;
            first: while (i != j){
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