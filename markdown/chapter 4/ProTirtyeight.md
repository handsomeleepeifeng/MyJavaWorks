#字符串的排列
##题目
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由
字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
##思路
和从1打印到n尾数有点类似，但是字符不能重复使用，我们分两部分第一部分是第一个字母，第二部分
是其他字母，每次我们将第一个字母和后面的字母交换顺序，这样就能使用递归来解决。
##代码
    import java.util.ArrayList;
    
    public class ProTirtyeight {
        ArrayList<String> result = new ArrayList<>();
        public ArrayList<String> Permutation(String str){
            if (str == null)
                return null;
            PermutationCore(str.toCharArray(),0);
            return result;
        }
    
        private void PermutationCore(char[] str,int pos){
            if (pos == str.length-1) {
                result.add(String.valueOf(str));
                return;
            }
            else{
                for (int j=pos+1;j<str.length;j++){
                    if (str[j] == str[pos])
                        continue;
                    exchange(str,j,pos);
                    PermutationCore(str,pos+1);
                    exchange(str,j,pos);
                }
            }
        }
    
        private void exchange(char[] str,int i, int j){
            char temp = str[j];
            str[j] = str[i];
            str[i] = temp;
        }
    }