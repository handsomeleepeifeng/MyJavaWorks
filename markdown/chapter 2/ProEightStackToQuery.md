#用两个栈实现队列
##题目
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
##代码
    import java.util.Stack;
    /***用两个栈来模拟列队，栈1用来入队，栈2用来出队，将栈一元素依次出栈并压入栈二刚好反序***/
    public class ProEightStackToQuery {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
    
        public void push(int num){
            stack1.push(num);
        }
        public int pop(){
            if (stack1.isEmpty() && stack2.isEmpty())
                throw new RuntimeException("Query is empty");
                if (stack2.isEmpty()){
                    while (!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }
                return stack2.pop();
        }
    }