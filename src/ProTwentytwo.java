public class ProTwentytwo {
    public void orderOddEven(int[] input){
        int head = 0;
        int tail = input.length-1;
        int temp;
        while (head < tail){
            if ((input[head]&1)==0 && (input[tail]&1)==1){
                temp = input[head];
                input[head] = input[tail];
                input[tail] = temp;
                head++;
                tail--;
                continue;
            }
            if ((input[head]&1)==1 && (input[tail]&1)==1) {
                head++;
                continue;
            }
            if ((input[head]&1)==0 && (input[tail]&1)==0){
                tail--;
                continue;
            }
            if ((input[head]&1)==1 && (input[tail]&1)==0){
                head++;
                tail--;
            }
        }
    }
}
