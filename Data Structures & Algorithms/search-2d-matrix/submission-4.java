class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int colSize = matrix[0].length;
        int n = colSize * matrix.length;


        int left = 0;
        int right = n - 1;

        while(left <= right) {

            int mid = left + (right-left)/2;

            System.out.println("Left: " + left + "  " + "Right: " + right);

            int row = mid / colSize;
            int col = mid % colSize;

            System.out.println("Row: " + row + " " + "Column: " + col);
            System.out.println("Mid: " + mid + " " + "Value: " + matrix[row][col]);

            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                right = mid - 1;
            } else if(target > matrix[row][col]) {
                left = mid + 1;
            }

        }

        return false;


        
    }
}
