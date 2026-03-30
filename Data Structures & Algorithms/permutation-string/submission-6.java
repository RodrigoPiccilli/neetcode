class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for(char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        for(int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            s2Freq[c - 'a']++;
        }

        int l = 0;

        if(Arrays.equals(s1Freq, s2Freq)) return true;

        for(int r = s1.length(); r < s2.length(); r++) {

            s2Freq[s2.charAt(l) - 'a']--;
            s2Freq[s2.charAt(r) - 'a']++;

            if(Arrays.equals(s1Freq, s2Freq)) return true;
            l++;
        }


        return false;

    }
}
