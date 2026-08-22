class Solution {
    public List<Integer> partitionLabels(String s) {
        // 1. Map to lookup last instance of character.

        Map<Character, Integer> last = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            last.put(
                s.charAt(i), i); // We can do this because even if i is not the last instance, the
                                 // last instance will be assigned to s.charAt(i) eventually.
        }

        // 2. Iterate through input, extending our group window until we reach the last index we
        // need to reach

        int size = 0; // Size of group
        List<Integer> res = new ArrayList<>(); // Result list

        int lastIdx = 0; // Last index we must reach to close out group
        for (int i = 0; i < s.length(); i++) {
            
            size++;
            lastIdx = Math.max(last.get(s.charAt(i)), lastIdx);

            if(lastIdx == i) { // If we reach our last idx, we can add the size of the group to our result list, and reset the qty counter for the group.
                res.add(size);
                size = 0;
            }
        }

        return res;
    }
}
