package t1;

/**
 * Actividad 1.2. Consideremos el problema de comprobar si existe un elemento en un array de enteros ordenados:<br>
 * <ul>
 *     <li>Presentar la cabecera de la función en Java que computa dicha función.</li>
 *     <li>Implementar un algoritmo en Java que compute dicha función.</li>
 * </ul>
 */

public class Actividad2 {
    public static void main(String[] args) {
        System.out.println(contains(new int[]{1, 2, 8}, 3));
    }

    private static boolean contains(int[] array, int value) {
        if (array.length == 0) {
            return false;
        }

        int lowPos = 0, highPos = array.length - 1, midPos;
        while (lowPos <= highPos) { //Búsqueda binaria
            midPos = lowPos + (highPos - lowPos) / 2;

            if (array[midPos] == value) {
                return true;
            }

            if (array[midPos] < value) {
                lowPos = midPos + 1;
            } else {
                highPos = midPos - 1;
            }
        }

        return false;
    }
}
