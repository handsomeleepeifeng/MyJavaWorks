public class Profourteen {
    public int maxCut(int len){
        int[] maxlenth = new int[len];
        if (len < 4)
            return len;
        maxlenth[0]=0;
        maxlenth[1]=1;
        maxlenth[2]=2;
        maxlenth[3]=3;
        for (int i = 4;i<len;i++){
            int max = 0;
            for (int j =i;j<i/2 ;j++){
                int max1 = maxlenth[i] * maxlenth[i - j];
                if (max < max1){
                    max = max1;
                }
            }
            maxlenth[i] = max;
        }
        return maxlenth[len-1];
    }
}
