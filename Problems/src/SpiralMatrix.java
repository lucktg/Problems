import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        List<Integer> order = spiralOrder(new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}});
        System.out.println("Result " + order);

    }

    //Spiral matrix
    //https://leetcode.com/problems/spiral-matrix/
    public static  List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int limitRight = matrix[0].length;
        int limitLeft = 0;
        int limitDown = matrix.length;
        int limitUp = limitDown - 1;
        int initialRow = 0;
        int initialColumn = 0;
        for(int count = 0; count < matrix.length*matrix[0].length; ){
            count = right(matrix, initialColumn,initialRow, limitRight, result, count);
            count = down(matrix, initialRow+1, limitRight-1, limitDown, result, count);
            count = left(matrix, limitDown, limitRight-1, limitLeft, result, count);
            count = up(matrix, limitUp, limitLeft, initialRow+1, result, count);
            limitRight--;
            limitLeft++;
            limitDown--;
            limitUp--;
            initialRow++;
            initialColumn++;
        }

        return result;
        
    }

    private static int right(int[][] matrix,int initialColumn, int row, int limitRight, List<Integer> result, int count) {
        for (int i = initialColumn; i < limitRight; i++ ) {
            if (count == matrix.length*matrix[0].length) break;
            result.add(matrix[row][i]);
            count++;
        }
        return count;
    }
    
    private static  int down(int[][] matrix, int row,int column,int limitDown,  List<Integer> result, int count) {
        for (int i = row; i < limitDown;  i++) {
            if (count == matrix.length*matrix[0].length) break;
            result.add(matrix[i][column]);
            count++;
        }
        return count;
    }
    
    private static  int left(int[][] matrix, int row,int column, int limitLeft, List<Integer> result, int count) {
        for (int i = column-1; i >= limitLeft;  i--) {
            if (count == matrix.length*matrix[0].length) break;
            result.add(matrix[row-1][i]);
            count++;
        }
        return count;
    }
    
    private static  int up(int[][] matrix, int row,int column,int limitUp,  List<Integer> result, int count) {
        for (int i = row-1; i >= limitUp;  i--) {
            if (count == matrix.length*matrix[0].length) break;
            result.add(matrix[i][column]);
            count++;
        }
        return count;
    }
}
