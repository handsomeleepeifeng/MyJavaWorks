import java.util.Stack;

public class ProEightStackToQuery {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

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
