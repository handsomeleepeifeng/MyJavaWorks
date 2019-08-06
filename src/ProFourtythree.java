public class ProFourtythree {
    public int Numof1(int n){
        String input = String.valueOf(n);
        int num = 0;
        for (int i=0;i<input.length();i++){
            if (input.charAt(i) == '1')
                num++;
        }
        return num;
    }
}
