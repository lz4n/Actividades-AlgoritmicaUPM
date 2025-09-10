package t1;

import java.util.Arrays;

/**
 * Actividad 1.3. Consideremos el problema de encontrar la matriz transpuesta a una dada:<br>
 * <ul>
 *     <li>Presentar la cabecera de la función en Java que computa dicha función.</li>
 *     <li>Implementar un algoritmo en Java que compute dicha función.</li>
 * </ul>
 */

public class Actividad3 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(transpose(new int[][]{{1, 2}, {3, 4}})));
    }

    private static int[][] transpose(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                newMatrix[y][x] = matrix[x][y];
            }
        }

        return newMatrix;
    }
}
