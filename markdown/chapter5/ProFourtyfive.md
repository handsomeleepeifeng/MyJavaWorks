#把数组排成最小的数
##题目
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的
一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
##思路
实现一个排序，将他们排序后顺序输出。
##代码
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.Comparator;
    
    public class ProFourtyfive {
        public String printMinNum(int[] input){
            ArrayList<String> array = new ArrayList<>();
            StringBuilder res = new StringBuilder();
            if (input==null || input.length==0)
                return "";
            for (int value : input) {
                array.add(String.valueOf(value));
            }
            array.sort((o1, o2) -> {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo(c2);
            });
            for (String e:array){
                res.append(e);
            }
            return res.toString();
        }
    }

