#第一个只出现一次的字符位置
##题目
Input: abacc
Output: b
##思路
利用2个BitSet来存储字符出现的信息，字符第一次出现存在第一个，第二次出现存在第二个，查找
只出现在第一个BitSet中的字符就可以。
##代码
    import java.util.BitSet;
    
    public class Profivty {
        public char FirstNorep(String str){
            BitSet bs1 = new BitSet(256);
            BitSet bs2 = new BitSet(256);
            for (char c:str.toCharArray()) {
                if (!bs1.get(c) && !bs2.get(c))
                    bs1.set(c);
                if (bs1.get(c) && !bs2.get(c))
                    bs2.set(c);
            }
            for (char c:str.toCharArray()) {
                if (bs1.get(c) && !bs2.get(c))
                    return c;
            }
            return '\0';
        }
    }