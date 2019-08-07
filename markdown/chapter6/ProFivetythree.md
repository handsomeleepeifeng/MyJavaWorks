#数字在排序数组中出现的次数
##题目
输入一个顺序排列数组和数字，统计这个数字在数组中出现的次数。
##思路
因为是排序好的，所以用二分法查找
##代码
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