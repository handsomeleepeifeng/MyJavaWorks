#数组中出现次数超过一半的数字
##题目
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为
9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，
因此输出2。如果不存在则输出0。
##思路
(1.用一半快排的方法找到中位数（数字超过数组长度一半，那么中位数肯定在数组的中间）

(2.超过数组长度一半也就是说这个数字长度加起来比其他数字的和还多，可以维护两个变量，一个
是数字，另一个是数字出现的次数，首先保存数字，下个数字相等，次数加一，不等次数减一，次数
等于零了，换下个数字。

（3.用一个哈希map去存储数字出现的次数，看是否超过了长度的一半。
##代码
    import java.util.HashMap;
    
    public class ProTirtynine {
        public int HalfMore3(int[] num){
            if (num == null || num.length==0)
                return 0;
            HashMap<Integer,Integer> map = new HashMap<>();
            for (Integer e : num){
                if (!map.containsKey(e))
                    map.put(e,1);
                else
                    map.put(e,map.get(e)+1);
            }
            for (Integer e: map.keySet()){
                if (map.get(e) > num.length>>1)
                    return e;
            }
            return 0;
        }
    
        public int HalfMore2(int[] num){
            if (num == null || num.length==0)
                return 0;
            int Half = 0;
            int Fre = 0;
            for (Integer e : num){
                if (Half == 0){
                    Half = e;
                    Fre = 1;
                    continue;
                }
                Fre = Half==e ? Fre+1 : Fre-1;
                if (Fre == 0)
                    Half = 0;
            }
            if (Fre >= 1) {
                if (CheckHalf(num, Half))
                    return Half;
                else
                    return 0;
            }
            else
                return 0;
        }
    
        public int HalfMore1(int[] num){
            if (num == null || num.length==0)
                return 0;
            int middle = num.length>>1;
            int start = 0;
            int end = num.length-1;
            int index = HalfQuickSort(num,start,end);
            while(index != middle){
                if (index < middle) {
                    start = index+1;
                    index = HalfQuickSort(num,start,end);
                }
                else {
                    end = index-1;
                    index = HalfQuickSort(num,start,end);
                }
            }
            int result = num[middle];
            if (CheckHalf(num,result))
                return result;
            else 
                return 0;
        }
    
        private boolean CheckHalf(int[] num, int result){
            int fre = 0;
            for (Integer e: num){
                if (e == result)
                    fre++;
            }
            return fre > num.length >> 1;
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