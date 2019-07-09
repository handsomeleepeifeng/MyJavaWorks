#数值的整数次方
##题目
实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，
同时不需要考虑大数问题。
##思路
考虑几种情况：1.底数为0；2.指数小于等于0。
##代码
    public class ProSixteen {
        public double Power(double base, int exponent){
            if (base==0)
                return 0;
            if (exponent == 0)
                return 1;
            int n = exponent;
            if (exponent < 0) {
                n = -exponent;
                base = 1/base;
            }
            return PowerAbs(base,n);
        }
        private double PowerAbs(double base,int n){
            if (n == 0)
                return 1;
            if (n == 1)
                return base;
            double result = PowerAbs(base,n>>1);
            result *= result;
            if ((n&0x01) == 1)
                result *= base;
            return result;
        }
    }