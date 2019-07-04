#打印从1到最大的n位数
##题目
输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数999。
##思考
打印的数字并未说明是什么类型，有可能特别大，利用数组来模拟数字,然后利用递归，打印出所有数字,另外
打印数字的时候，数组最前面的0不应该打印出来
##代码
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