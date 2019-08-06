import java.util.Arrays;

public class ProFourtyeight {
    public int LongestStr(String str){
        int curlen = 0;
        int maxlen = 0;
        int[] pos = new int[26];
        Arrays.fill(pos,-1);
        for (int i=0;i<str.length();i++){
            int position = str.charAt(i)-'a';
            int preposititon = pos[position];
            if (preposititon == -1 || i-preposititon > curlen)
                curlen++;
            else {
                maxlen = Math.max(maxlen,curlen);
                curlen = i-preposititon;
            }
        }
        maxlen = Math.max(maxlen,curlen);
        return maxlen;
    }
}
