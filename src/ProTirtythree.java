public class ProTirtythree {
    public boolean isOrder(int[] seq){
        if (seq.length == 0)
            return false;
        return isOrderCore(0,seq.length-1,seq);
    }

    private boolean isOrderCore(int start, int end, int[] seq){
        if (start >= end)
            return true;
        int i = start;
        while (seq[i] < seq[end]) {
            i++;
        }
        int mid = i;
        while (seq[i] > seq[end])
            i++;
        if (i != end)
            return false;
        return isOrderCore(start,mid-1,seq)&&isOrderCore(mid,end-1,seq);
    }
}
