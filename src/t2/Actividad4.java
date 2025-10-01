package t2;

/**
 * Problema. Dado un array de números ordenados en los que todos ellos aparecen dos
 * veces salvo uno, se desea buscar el único elemento que aparece sólo una vez.<br><br>
 * Ejemplo:<br>
 * [1, 1, <b>4</b>, 5, 5, 7, 7, 8, 8, 9, 9]<br>
 * Para este vector, se devolvería el valor 4.<br><br>
 * Implementar un algoritmo en Java, basado en Divide y Vencerás, que solucione
 * el problema expuesto, con complejidad O(log N) en el caso peor1 (donde N es el
 * tamaño del vector).
 */
public class Actividad4 {
    public static void main(String[] args) {
        System.out.println(encontrarUnico(new int[]{1, 1, 4, 5, 5, 7, 7, 8, 8, 9, 9}));
    }

    private static int encontrarUnico(int[] array) {
        return encontrarUnicoRecursivo(array, 0, array.length -1);
    }

    private static int encontrarUnicoRecursivo(int[] array, int i0, int iN) {
        if (i0 == iN) {
            return array[i0];
        }

        int pivote = (i0 + iN) / 2;
        if (pivote % 2 == 0) {
            if (array[pivote] == array[pivote +1]) { //Si el pivote es PAR y en su posición EMPIEZA la pareja de números => número único está a la derecha
                return encontrarUnicoRecursivo(array, pivote + 1, iN);
            } else { //Si el pivote es PAR y en su posición TERMINA la pareja de números => número único está a la izquierda
                return encontrarUnicoRecursivo(array, i0, pivote);
            }
        } else {
            if (array[pivote] == array[pivote +1]) { //Si el pivote es IMPAR y en su posición EMPIEZA la pareja de números => número único está a la izquierda
                return encontrarUnicoRecursivo(array, i0, pivote);
            } else { //Si el pivote es IMPAR y en su posición TERMINA la pareja de números => número único está a la derecha
                return encontrarUnicoRecursivo(array, pivote + 1, iN);
            }
        }
    }
}
