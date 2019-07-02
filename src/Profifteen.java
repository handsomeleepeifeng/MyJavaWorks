public class Profifteen {

    public int getNumberOf1(int n){
        int count = 0;
        int flag = 1;
        for (int i=0;i<32;i++){
            if ((flag&n)!=0)
                count++;
            flag <<= 1;
        }
        return count;
    }
    public int othergetNumberOf1(int n){
        int count = 0;
        while ((n&(n-1)) != 0) {
            count++;
            n &= (n-1);
        }
        return count;
    }

}
