#二维数组中的查找
##题目
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
##代码
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