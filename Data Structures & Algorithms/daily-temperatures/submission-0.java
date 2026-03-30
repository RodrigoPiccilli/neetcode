class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 1) return new int[1];

        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {

            int count = 0;

            for(int j = i + 1; j < temperatures.length; j++) {

                if(temperatures[i] >= temperatures[j]) {
                    count++;
                } else {
                    result[i] = count + 1;
                    break;
                }     

            }

        }

        return result;
    }
}
