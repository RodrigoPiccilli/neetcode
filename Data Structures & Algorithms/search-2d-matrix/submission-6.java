class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int colSize = matrix[0].length;
        
        int totalLength = colSize * matrix.length;

        int l = 0;
        int r = totalLength - 1;

        while(l <= r) {

            int mid = l + (r - l) / 2;

            int row = mid / colSize;
            int col = mid % colSize;

            int value = matrix[row][col];

            if(value == target) {
                return true;
            } else if(value < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return false;

    }
}
