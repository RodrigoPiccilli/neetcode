class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        int[] count = new int[26]; // Since we are dealing with only lowercase letters, we can
        // use an array to register how many times each letter has been referenced.

        for(char c : s.toCharArray()) { // We can loop through the first word and increment the times each
        // letter has been referrenced.
            int index = (c - 'a');
            count[index]++;
        }


        for(char c : t.toCharArray()) { // We can loop through the second word and decrement the times each
        // letter has been referrenced.
            int index = (c - 'a');
            count[index]--;
        }

        for(int num : count) { // If the words are anagrams, all counts should balance out to zero.
            if(num != 0) return false; // If its not zero, it means that they are not equivalent in char count.
        }

        return true;
    }
}
