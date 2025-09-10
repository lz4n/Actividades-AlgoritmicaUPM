package t1;

/**
 * Actividad 1.1. Consideremos el problema de encontrar el valor máximo de un
 * array de enteros:<br>
 * <ul>
 *     <li>Presentar la cabecera de la función (en Java) que computa dicha función.</li>
 *     <li>Implementar un algoritmo en Java que compute dicha función.</li>
 * </ul>
 */

public class Actividad1 {
    public static void main(String[] args) {
        System.out.println(getMaxValue(new int[]{10, 1, 2, 8}));
    }

    private static int getMaxValue(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int value : array) {
            maxValue = Math.max(maxValue, value);
        }

        return maxValue;
    }
}
