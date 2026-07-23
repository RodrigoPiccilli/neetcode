class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int totalLength = matrix.length * matrix[0].length;

        int l = 0;
        int r = totalLength - 1;

        while(l <= r) {

            int mid = l + (r - l) / 2;

            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;

            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;

            }

        }

        return false;



    }
}
