public class ProFourTwoDimensionalArray {
    /*先缩小查找范围，再在缩小范围下的数组空间内查找*/
    public boolean TwoDimensionalArraySolution(int num, int row,int col,int[] input){
        int EndRow = row-1;
        int EndCol = col-1;
        int StartRow = 0;
        int StartCol = 0;
        boolean flag = false;
        while (input[EndCol]>num){
            EndCol--;
        }
        while (input[col*EndRow]>num){
            EndRow--;
        }
        while(input[StartRow*col+EndCol] < num){
            StartRow++;
        }
        while(input[EndRow*col+StartCol] < num){
            StartCol++;
        }
        for (int i=StartRow;i<=EndRow;i++){
            for (int j=StartCol;j<=EndCol;j++){
                if (input[i*col+j]==num)
                    flag = true;
            }
        }
        return flag;
    }
}
