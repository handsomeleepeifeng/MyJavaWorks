public class ProEleven {
    public int FindMinNum(int[] Array){
        int head = 0;
        int tail = Array.length-1;
        if (tail == -1)
            return 0;
        while (head < tail){
            int mid = head + (tail-head)/2;
            if (Array[mid] > Array[tail]){
                head = mid+1;
            }
            else if (Array[mid] == Array[tail]){
                tail = tail-1;
            }
            else
                tail = mid;
        }
        return Array[head];
    }
}
