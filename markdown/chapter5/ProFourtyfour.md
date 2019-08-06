#数字序列中某一位的数字
##题目
数字以01234567891011121314...的格式排列。在这个序列中，第5位（从0开始计）是5，
第13位是1，第19位是4。求任意第n为对应的数字。
##思路
先确认这个数字对应的是哪个自然数，再确定这个数在自然数中的位置。
##代码
    public class ProFourtyfour {
        public int digitAtIndex(int index){
            if (index < 0)
                return -1;
            int digit = 1;
            while (true){
                int number = numberCount(digit);
                if (index < number*digit)
                    return digitAt(index,digit);
                index -= number*digit;
                digit++;
            }
        }
    
        private int numberCount(int digit){
            if (digit==1)
                return 10;
            return 9*(int)Math.pow(10,digit-1);
        }
    
        private int digitAt(int index,int digit){
            int Indexofnum = index%digit;
            int num = (int)Math.pow(10,digit)+index/digit;
            char number = String.valueOf(num).charAt(Indexofnum);
            return (int)number;
        }
    }