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
