#表示数值的字符串
##题目
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串“+100”、“5e2”、
“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、“1a3.14”、“1.2.3”、“+-5”及
“12e+5.4”都不是。
##思路
首先，‘E’和‘.’不能出现两次，其次‘+’‘-’只能出现在第一位或者E的后面一位，并且E后面不能出
现‘.’,而且‘E’前面的数不能大于10。
##代码
    public class ProTwenty {
        public boolean isNumber(char[] str){
            boolean hasPlusorRe = false;
            boolean hasE = false;
            boolean hasPoint = false;
            int pointPosition = 0;
            int EPosotion = 0;
            for (int i=0; i<str.length;i++){
                if (str[i]=='+' || str[i]=='-') {
                    if (i==0){
                        hasPlusorRe = true;
                        continue;
                    }
                    if (!hasPlusorRe && i > 0 && str[i - 1] != 'E' && str[i - 1] != 'e')
                        return false;
                    if (hasPlusorRe && str[i - 1] != 'E' && str[i - 1] != 'e')
                        return false;
                }
                else if (str[i] == 'e' || str[i] =='E'){
                    if (hasE)
                        return false;
                    if (i==0 || i==str.length-1)
                        return false;
                    hasE =true;
                    EPosotion = i;
                }
                else if (str[i] == '.'){
                    if (hasPoint || hasE)
                        return false;
                    hasPoint = true;
                    pointPosition = i;
                }
                else if (str[i] < '0' || str[i] >'9')
                    return false;
            }
            if (hasE && hasPoint && pointPosition>1)
                return false;
            else return !hasE || hasPoint || EPosotion <= 1;
        }
    }