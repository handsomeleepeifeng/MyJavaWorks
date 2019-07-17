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
