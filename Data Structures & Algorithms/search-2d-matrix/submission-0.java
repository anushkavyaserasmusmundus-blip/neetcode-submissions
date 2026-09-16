class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int left =0;
        int right = matrix.length * matrix[0].length - 1;
        //           3 rows * element in 1 row
        //            3*4=12 elements
        

        while(left <= right){

            int mid = (left+right)/2;
            int row = mid / matrix[0].length; 
            // mid/4 afer 4 row changes so tells which row    you are in
            int col = mid % matrix[0].length;
            //mid % 4 = 2
            //row = 2 col = 2

            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }

            

        }
        return false;
    }
}
