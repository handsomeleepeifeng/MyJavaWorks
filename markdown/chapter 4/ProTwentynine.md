#顺时针打印矩阵
##题目
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
##代码
    public class ProTwentynine {
        public void printMaxtrix(int[][] matrix){
            int row = matrix.length;
            int col = matrix[0].length;
            int left = 0, right = col-1, top = 0, buttom = row-1;
            while (left <= right && top <= buttom){
                //从左往右打印
                for (int i=left;i <= right;i++){
                    System.out.print(matrix[top][i]);
                }
                //从上往下打印
                for (int i=top+1;i<=buttom;i++)
                    System.out.print(matrix[i][right]);
                //如果不止一行，再从右往左打印
                if (top != buttom){
                    for (int i=right-1;i>=left;i--)
                        System.out.print(matrix[buttom][i]);
                }
                //如果不止一列，再从下往上打印
                if (left != right){
                    for (int i=buttom-1;i>=top;i--)
                        System.out.print(matrix[i][left]);
                }
                left++;
                right--;
                top--;
                buttom++;
            }
        }
    }