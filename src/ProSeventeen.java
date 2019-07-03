public class ProSeventeen {
    public void Print1ToN(int n){
        if (n<=0)
            return;
        char[] num = new char[n];
        for (int i=0;i<10;i++){
            num[0] = (char)i;
            Print1ToNCore(num,n,0);
        }
    }

    private void PrintNumber(char[] num){
        boolean flag = false;
        for (int i=0;i<num.length;i++){
            if (!flag && num[i] != '0')
                flag = true;
            if (flag)
                System.out.print(num[i]);
        }
        System.out.println();
    }

    private void Print1ToNCore(char[] num, int n, int index){
        if (index == n-1){
            PrintNumber(num);
            return;
        }
        for (int i=0;i<10;i++){
            num[index+1] = (char)i;
            Print1ToNCore(num,n,index+1);
        }
    }
}
