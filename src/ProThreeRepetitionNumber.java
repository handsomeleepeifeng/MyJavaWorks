import java.util.HashMap;

class ProThreeRepetitionNumber {
    /*利用哈希表来完成,空间复杂度O(n),时间复杂度O(n)*/
    public int RepetitionNumberSolution1(int[] input){
        int result = -1;
        HashMap<Integer,Boolean> Dictionary = new HashMap<>();
        for (int value : input) {
            if (Dictionary.containsKey(value)) {
                result = value;
            } else
                Dictionary.put(value, true);
        }
        return result;
    }
    /*空间复杂度为O(1)的方法,时间复杂度为O(n)*/
    public int RepetitionNumberSolution2(int[] input){
        int temp;
        int result = -1;
        sort_data:
        for (int i = 0; i<input.length; i++){
            while (input[i] != i){
                if (input[i] != input[input[i]]){
                    temp = input[i];
                    input[i] = input[input[i]];
                    input[input[i]] = temp;
                }
                else {
                    result = input[i];
                    break sort_data;
                }
            }
        }
        return result;
    }
}
