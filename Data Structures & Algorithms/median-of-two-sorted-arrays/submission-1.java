class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int halfTotal = (nums1.length + nums2.length + 1) / 2;

        int l = 0;
        int r = nums1.length;

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        while (l <= r) {
            int i = l + (r - l) / 2;
            int j = halfTotal - i;

            int leftA = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int rightA = (i < nums1.length) ? nums1[i] : Integer.MAX_VALUE;
            int leftB = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int rightB = (j < nums2.length) ? nums2[j] : Integer.MAX_VALUE;

            if (leftA <= rightB && leftB <= rightA) {
                if ((nums1.length + nums2.length) % 2 != 0) {
                    return Math.max(leftA, leftB);
                } else {
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                }
            } else if (leftA > rightB) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return -1;
    }
}
