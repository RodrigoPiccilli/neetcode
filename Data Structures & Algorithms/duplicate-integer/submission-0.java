class Solution {
    public boolean hasDuplicate(int[] nums) {
 
        HashMap<Integer, Integer> dupMap = new HashMap<Integer, Integer>();

        for(Integer i : nums) {

            if(dupMap.get(i) == null) {

                dupMap.put(i, i);

            } else {

                return true;

            }




        }

        return false;


    }
}
