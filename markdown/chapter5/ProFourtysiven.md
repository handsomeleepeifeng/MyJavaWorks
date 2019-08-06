#礼物的最大价值
##题目
在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。从左上角
开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值
。例如，对于如下棋盘礼物的最大价值为 1+12+5+7+7+16+5=53。

    1    10   3    8
    12   2    9    6
    5    7    4    11
    3    7    16   5
##思路
动态规划
##代码
    public class ProFourtysiven {
        public int getMax(int[][] giftdisplay){
            int rows = giftdisplay.length;
            int cols = giftdisplay[0].length;
            int[][] maxValue = new int[rows][cols];
            for (int i=0;i<rows;i++){
                for (int j=0;j<cols;j++) {
                    int up = 0;
                    int left = 0;
                    if (i > 0)
                        up = maxValue[i - 1][j];
                    if (j>0)
                        left = maxValue[i][j-1];
                    maxValue[i][j] = Math.max(up,left)+giftdisplay[i][j];
                }
            }
            return maxValue[rows-1][cols-1];
        }
    }