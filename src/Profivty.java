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
