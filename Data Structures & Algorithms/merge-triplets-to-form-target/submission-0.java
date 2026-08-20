class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        int[] cur = new int[] {0, 0, 0};

        // Ignore triplets with sizes greater than target

        for(int[] triplet : triplets) {

            if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }

            merge(cur, triplet);
        }

        return Arrays.equals(cur, target);

    }

    private void merge(int[] t1, int[] t2) {
        t1[0] = Math.max(t1[0], t2[0]);
        t1[1] = Math.max(t1[1], t2[1]);
        t1[2] = Math.max(t1[2], t2[2]);
    }
}
