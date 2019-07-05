public class ProTwenty {
    public boolean isNumber(char[] str){
        boolean hasPlusorRe = false;
        boolean hasE = false;
        boolean hasPoint = false;
        int pointPosition = 0;
        int EPosotion = 0;
        for (int i=0; i<str.length;i++){
            if (str[i]=='+' || str[i]=='-') {
                if (i==0){
                    hasPlusorRe = true;
                    continue;
                }
                if (!hasPlusorRe && str[i - 1] != 'E' && str[i - 1] != 'e')
                    return false;
                if (hasPlusorRe && str[i - 1] != 'E' && str[i - 1] != 'e')
                    return false;
            }
            else if (str[i] == 'e' || str[i] =='E'){
                if (hasE)
                    return false;
                if (i==0 || i==str.length-1)
                    return false;
                hasE =true;
                EPosotion = i;
            }
            else if (str[i] == '.'){
                if (hasPoint || hasE)
                    return false;
                hasPoint = true;
                pointPosition = i;
            }
            else if (str[i] < '0' || str[i] >'9')
                return false;
        }
        if (hasE && hasPoint && pointPosition>1)
            return false;
        else return !hasE || hasPoint || EPosotion <= 1;
    }
}


