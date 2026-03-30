class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // Fixed Size Window, where size k = length of s1.

        // Only lowercase Letters

        Map<Character, Integer> map = new HashMap<>();

        for(char c : s1.toCharArray()) {
            if(map.get(c) == null) map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }


        // Perhaps keep a hashmap of our window? Check if maps are the same?

        int start = 0;
        int end = s1.length() - 1;

        while(end < s2.length()) {

            String cur = s2.substring(start, end + 1);

            if(checkMap(cur).equals(map)) return true;

            start++;
            end++;

        }

        return false;
        
    }

    private HashMap<Character, Integer> checkMap(String s) {

        HashMap<Character, Integer> check = new HashMap<>();

        for(char c : s.toCharArray()) {
             if(check.get(c) == null) check.put(c, 0);
            check.put(c, check.get(c) + 1);
        }

        return check;
    }

   
}
