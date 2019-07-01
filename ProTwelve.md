#矩阵中的路径
##题目
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意
一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一
个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符
串”bcced”的路径，但是矩阵中不包含”abcb”路径，因为字符串的第一个字符b占据了矩阵中的第一行第二
个格子之后，路径不能再次进入该格子。
##思路
利用回溯法
##代码
    public class ProTwelve {
        public boolean hasPath(char[] maxtrix, int rows, int cols, char[] str){
            if (str.length == 0 || maxtrix.length ==0)
                return false;
            else{
                int[][] flag = new int[rows][cols];
                for (int i=0;i<rows;i++){
                    for (int j=0;j<cols;j++){
                        if(seach(maxtrix,rows,cols,i,j,0,str,flag))
                            return true;
                    }
                }
                return false;
            }
        }
        private boolean seach(char[] maxtrix, int rows, int cols, int row, int col, int deep, char[] str,int[][] flag){
            if (row<0 || col<0 || row>rows || col>cols || maxtrix[row*cols+col]!=str[deep] || flag[row][col]==1)
                return false; //超过矩阵范围，已经路过的路径，矩阵这一格不等于字符串中的字符返回false
            if (deep >= str.length-1)
                return true;//如果找到字符串最后的深度，且矩阵中的字符等于字符串中的，就已经找到了
            flag[row][col] = 1;
            if (seach(maxtrix,rows,cols,row,col-1,deep+1,str,flag) ||
                seach(maxtrix,rows,cols,row,col+1,deep+1,str,flag) ||
                seach(maxtrix,rows,cols,row-1,col,deep+1,str,flag) ||
                seach(maxtrix,rows,cols,row+1,col,deep+1,str,flag))
                return true;//没有到最后的深度，但是前面的字符都符合，那么继续深入找，找到了返回true
            flag[row][col] = 0;//如果下面的路径都找不到，那么清除路径，以便其他点出发的路径可以经过。
            return false;//都咩找到返回false
    }
    }