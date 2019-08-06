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
