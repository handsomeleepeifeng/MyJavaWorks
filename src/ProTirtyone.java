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
