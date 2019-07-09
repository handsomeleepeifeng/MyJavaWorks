#正则表达式匹配
##题目
请实现一个函数用来匹配包含'.'和' * '的正则表达式。模式中的字符'.'表示任意一个字符，而' * '表示它前面
的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"
与模式"a.a"和"ab * ac * a"匹配，但与"aa.a"及"ab*a"均不匹配。
##题目解读
'.'可以替换成任意一个字母.'Φ*'Φ可以替换为空，或者任意个Φ比如：ΦΦΦΦΦ。（递归）
于是可以分情况了：

一.第二个字符不是*的情况：

1.第一个字符相同：同时后移一位再判断。

2.如果第一个字符不等，那么直接返回false。

二.第二个字符是*的情况：

1.第一个字符不同，模式后移2位，继续匹配。

2.第一个字符相同，字符串后移一位，模式后移两位（将Φ*等价为了Φ）

3.第一个字符相同，字符串后移一位，模式不后移（将Φ*等价为了多个Φ）

4.第一个字符相同，模式后移2位，继续匹配（将Φ*等价为了空）
##代码
    public class ProNinteen {
        public boolean match(char[] str, char[] pattern){
            return matchcore(str,pattern,0,0);
        }
    
        private boolean matchcore(char[] str, char[] pattern, int sIndex, int pIndex){
            if (sIndex >= str.length && pIndex == pattern.length)
                return true;
            if (sIndex < str.length && pIndex >= pattern.length)
                return false;
            if (pIndex < pattern.length-1 && pattern[pIndex+1] == '*'){
                if (sIndex < str.length && (str[sIndex] == pattern[pIndex] || pattern[pIndex]=='.')){
                    return matchcore(str,pattern,sIndex,pIndex+2) ||
                            matchcore(str,pattern,sIndex+1,pIndex) ||
                            matchcore(str,pattern,sIndex+1,pIndex+2);
                }
                else
                    return matchcore(str,pattern,sIndex,pIndex+2);
            }
            if (sIndex < str.length && (str[sIndex] == pattern[pIndex] || pattern[pIndex]=='.'))
                return matchcore(str,pattern,sIndex+1,pIndex+1);
            return false;
        }
    }