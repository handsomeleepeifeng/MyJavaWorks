import java.lang.String;
import java.util.ArrayList;
import java.util.Scanner;


public class NumAdd {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        char[] num1;
        char[] num2;
        num1 = scan.next().toCharArray();
        num2 = scan.next().toCharArray();

        Add(num1, num2);
    }

    private static void Add(char[] Num1, char[] Num2) {
        ArrayList<Integer> Result = new ArrayList<>();
        int TakeOver = 0;
        int Digit = Num1.length > Num2.length ? Num1.length : Num2.length;
        for (int i = 0; i <= Digit - 1; i++) {
            int number1 = i > Num1.length - 1 ? 0 : Num1[Num1.length-i-1]-'0';
            int number2 = i > Num2.length - 1 ? 0 : Num2[Num2.length-i-1]-'0';
            int TempSum = number1 + number2 + TakeOver;
            TakeOver = TempSum >= 10 ? 1 : 0;
            TempSum = TempSum >= 10 ? TempSum - 10 : TempSum;
            Result.add(TempSum);
            if ((TakeOver == 1) && (i == Digit - 1))
                Result.add(TakeOver);
        }
        for (int i = Result.size()-1; i >= 0; i--) {
            System.out.print(Result.get(i));
        }
    }
}
