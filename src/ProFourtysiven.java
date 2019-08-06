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
