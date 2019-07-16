#栈的压入、弹出元素
##题目
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压
栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
（注意：这两个序列的长度是相等的）
##思路
用栈来模拟，将元素逐一push，直到和出栈序列的数字相等，然后开始出栈，直到和出栈序列数字不等，又
开始入栈，到最后看栈是否是空，如果空则代表是序列对应出栈顺序，反之，则不代表。
##代码
    import java.util.Stack;
    
    public class ProTirtyone {
        public boolean isStackOrder(int[] in, int[] out){
            if (in.length != out.length || in.length == 0)
                return false;
            Stack<Integer> stack = new Stack<>();
            int index = 0;
            for (int i=0; i<in.length; i++){
                stack.push(in[i]);
                while(!stack.isEmpty() && stack.peek() == out[index]){
                    stack.pop();
                    index++;
                }
            }
            return stack.isEmpty();
        }
    }
