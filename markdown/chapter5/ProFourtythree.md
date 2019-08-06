#1~n整数中1出现的次数
##题目
给定一个整数n，求1~n这n个整数中十进制表示中1出现的次数。
##思路
类型转换
##代码
    public class ProFourtythree {
        public int Numof1(int n){
            String input = String.valueOf(n);
            int num = 0;
            for (int i=0;i<input.length();i++){
                if (input.charAt(i) == '1')
                    num++;
            }
            return num;
        }
    }