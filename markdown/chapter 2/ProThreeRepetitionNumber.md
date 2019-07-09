#数组重复数字
##找出数组中重复的数字
在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重
复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组
{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2或者3。
##代码
    import java.util.HashMap;
    
    class ProThreeRepetitionNumber {
        /*利用哈希表来完成*/
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
    }