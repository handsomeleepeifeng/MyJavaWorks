import java.util.Comparator;
import java.util.PriorityQueue;

public class ProFourtyone {
    //右边的是最小堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //左边的是最大堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, (o1, o2) -> o2-o1);

    public void Insert(int num){
        if (maxHeap.size() == 0 || num <= maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);
        if (maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.peek());
            minHeap.poll();
        }
        if (maxHeap.size() > minHeap.size()+1){
            minHeap.offer(maxHeap.peek());
            maxHeap.poll();
        }
    }
     public double findMiddle(){
        if (maxHeap.size() == minHeap.size())
            return (double) ((maxHeap.peek() + minHeap.peek()) >> 1);
        else
            return new Double(maxHeap.peek());
     }

}
