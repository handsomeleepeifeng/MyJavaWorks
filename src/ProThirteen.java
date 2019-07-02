public class ProThirteen {
    public int robotRange(int rows, int cols, int limit){
        int[][] flag = new int[rows][cols];
        if (rows<=0 || cols<=0 || limit <0)
            return 0;
        return counting(rows,cols,0,0,limit,flag);
    }

    private int counting(int rows, int cols, int row, int col, int limit, int[][] flag){
        if (row<0 || col<0 || row >rows || col>cols || getSum(row)+getSum(col)>limit || flag[row][col]==1)
            return 0;
        flag[row][col]=1;
        return 1+counting(rows,cols,row,col-1,limit,flag)+
                counting(rows,cols,row,col+1,limit,flag)+
                counting(rows,cols,row-1,col,limit,flag)+
                counting(rows,cols,row+1,col,limit,flag);

    }

    private int getSum(int num){
        int sum = 0;
        while (num>0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}
