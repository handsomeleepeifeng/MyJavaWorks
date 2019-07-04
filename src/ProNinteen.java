public class ProNinteen {
    public boolean match(char[] str, char[] pattern){
        return matchcore(str,pattern,0,0);
    }

    private boolean matchcore(char[] str, char[] pattern, int sIndex, int pIndex){
        if (sIndex >= str.length && pIndex == pattern.length)
            return true;
        if (sIndex < str.length && pIndex >= pattern.length)
            return false;
        if (pIndex < pattern.length-1 && pattern[pIndex+1] == '*'){
            if (sIndex < str.length && (str[sIndex] == pattern[pIndex] || pattern[pIndex]=='.')){
                return matchcore(str,pattern,sIndex,pIndex+2) ||
                        matchcore(str,pattern,sIndex+1,pIndex) ||
                        matchcore(str,pattern,sIndex+1,pIndex+2);
            }
            else
                return matchcore(str,pattern,sIndex,pIndex+2);
        }
        if (sIndex < str.length && (str[sIndex] == pattern[pIndex] || pattern[pIndex]=='.'))
            return matchcore(str,pattern,sIndex+1,pIndex+1);
        return false;
    }
}
