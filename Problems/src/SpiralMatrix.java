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
        int items = matrix.length*matrix[0].length;
        int limitRight = matrix[0].length;
        int limitDown = matrix.length;
        int limitUp = 0;
        int limitLeft = -1;
        int currentRow = 0;
        int currentColumn = 0;
        boolean right = true, left = false, up = false, down = false;
        for (int i = 0; i < items; i++) {
            if(right) {                
                result.add(matrix[currentRow][currentColumn]);
                currentColumn++;
                if(currentColumn == limitRight) {
                    right = false;
                    down =true; 
                    currentColumn--;
                    currentRow++;
                    continue;
                }
            } else if(down) {
                result.add(matrix[currentRow][currentColumn]);
                currentRow++;
                if(currentRow == limitDown) {
                    down = false;
                    left =true;
                    currentRow--;
                    currentColumn--;
                    continue;
                }
            } else if(left) {
                result.add(matrix[currentRow][currentColumn]);
                currentColumn--;
                if(currentColumn == limitLeft) {
                    left = false;
                    up =true; 
                    currentRow--;
                    currentColumn++;
                    continue;
                }
            } else if(up) {
                result.add(matrix[currentRow][currentColumn]);
                currentRow--;
                if(currentRow == limitUp) {
                    up = false;
                    right =true; 
                    limitUp++;
                    limitLeft++;
                    limitRight--;
                    limitDown--;
                    currentRow++;
                    currentColumn++;
                    continue;
                }
            }
        }
        return result;
    }
}
