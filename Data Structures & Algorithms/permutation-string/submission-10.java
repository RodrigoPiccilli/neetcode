class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()) return false;

        int[] count = new int[26];
        int[] window = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

                    if(Arrays.equals(window, count)) return true;


        int l = 0;

        for(int r = s1.length(); r < s2.length(); r++) {

            char add = s2.charAt(r);
            char remove = s2.charAt(l);

            window[remove - 'a']--;
            window[add - 'a']++;

            l++;

            if(Arrays.equals(window, count)) return true;

        }

        return false;

    
    }
}
