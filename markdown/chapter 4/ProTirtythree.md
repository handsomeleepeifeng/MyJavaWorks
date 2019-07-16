#二叉搜索树的后序遍历序列
##题目
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,
否则输出No。假设输入的数组的任意两个数字都互不相同。
##思路
二叉搜索树性质：所有左子节点值比根小，所有右子节点值比根大，可以利用递归判断。
##代码
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