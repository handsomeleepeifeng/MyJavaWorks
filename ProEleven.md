#旋转数组的最小数字
##题目
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，
输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
##代码
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