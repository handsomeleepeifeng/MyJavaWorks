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
