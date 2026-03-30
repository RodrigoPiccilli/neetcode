class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // [ 1, 2, 4, 8]
        // [10,11,12,13]
        // [14,20,30,40]

        // 3 x 4

        int l = 0;

        int r = (matrix.length * matrix[0].length) - 1;

        while(l <= r) {

            int mid = l + ((r - l) / 2);

            int row = mid / (matrix[0].length);

            int col = mid % matrix[0].length;

            if(matrix[row][col] == target) return true;

            if(matrix[row][col] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return false;

    }
}
