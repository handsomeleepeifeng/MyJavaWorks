import java.lang.String;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class NumAdd {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        char[] num1 = new char[]{};
        char[] num2 = new char[]{};
        while (scan.hasNext()) {
            String Buffer1 = scan.next();
            String Buffer2 = scan.next();
            num1 = Buffer1.toCharArray();
            num2 = Buffer2.toCharArray();
            break;
        }
        Add(num1, num2);
    }

    private static ArrayList Add(char[] Num1, char[] Num2) {
        ArrayList Result = new ArrayList<>();
        int TakeOver = 0;
        int Digit = Num1.length > Num2.length ? Num1.length : Num2.length;
        for (int i = Digit - 1; i >= 0; i--) {
            int number1 = i > Num1.length - 1 ? 0 : Num1[i] - '0';
            int number2 = i > Num2.length - 1 ? 0 : Num2[i] - '0';
            int TempSum = number1 + number2 + TakeOver;
            TakeOver = TempSum >= 10 ? 1 : 0;
            TempSum = TempSum >= 10 ? TempSum - 10 : TempSum;
            Result.add(TempSum);
            if (TakeOver == 1 && i == Digit - 1)
                Result.add(TakeOver);
        }
        for (int i = 0; i < Result.size(); i++) {
            System.out.print(Result.get(i));
        }
        return Result;
    }
}
