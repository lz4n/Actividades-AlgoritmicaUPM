package dinamica;

/**
 * maxEnd(i): longuitud máxima del subarray que comienza en una posición 0..i y termina en la posición i.
 * - i {0..vector.length -1}: i=0 indica elemento 0 del array.
 *
 * maxTotal(i): longuitud máxima del subarray que se situa entre 0 e i.
 * - i {0..vector.length -1}: i=0 indica elemento 0 del array.
 */

/**
 * maxEnd(0) = 1 (un subarray de 1 elemento siempre está ordenado)
 * maxEnd(i) =
 *  - maxEnd(i-1) + 1 si vector[i] >= vector[i-1]
 *  - 1 en el resto de casos
 *
 * maxTotal(i) = max(maxTotal[i-1], maxEnd(i))
 */
public class Enero2022 {
    int longMaxSubArrayOrdenado(int[] vector) {
        int maxEnd = 1, maxTotal = 1;
        for (int i = 1; i < vector.length; i++) {
            maxEnd = vector[i] >= vector[i -1] ? maxEnd + 1: 1;
            maxTotal = Math.max(maxTotal, maxEnd);
        }

        return maxTotal;
    }
}
