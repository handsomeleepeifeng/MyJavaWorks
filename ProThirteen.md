#机器人的运动范围
##题目
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向
移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格
（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够
达到多少个格子？
##思路
利用回溯法
##代码
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