#数据流中的中位数
##题目
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序
之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间
两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据
的中位数。
##思路
从数据流中拿到一个数后，先按顺序插入堆中：如果左边的最大堆是否为空或者该数小于等于
最大堆顶的数，则把它插入最大堆，否则插入最小堆。然后，我们要保证左边的最大堆的size
等于右边的最小堆的size或者最大堆的size比最小堆的size大1。要获取中位数的话，直接判
断最大堆和最小堆的size，如果相等，则分别取出两个堆的堆顶除以2得到中位数，不然，就
是最大堆的size要比最小堆的size大，这时直接取出最大堆的堆顶就是我们要的中位数。
##代码
    import java.util.Comparator;
    import java.util.PriorityQueue;
    
    public class ProFourtyone {
        //右边的是最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //左边的是最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    
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
                return new Double((maxHeap.peek() + minHeap.peek()) >> 1);
            else
                return new Double(maxHeap.peek());
         }
    
    }