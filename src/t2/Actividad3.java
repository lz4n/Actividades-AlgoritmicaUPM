package t2;

/**
 * Problema. Diseñar un algoritmo que, dado v un array de enteros ordenados, y
 * num, un entero, nos devuelva el índice más pequeño donde se encuentra num. En
 * caso de que no exista num en el array, el algoritmo devolverá -1.<br><br>
 * [2, 4, 4, 4, 6, 6, 7, 7, 8]<br>
 * Para num=1, el algoritmo tiene que devolver -1 (no aparece el número 1)<br>
 * Para num=6, el algoritmo tiene que devolver 4 (el número 6 aparece en el índice
 * 4 por primera vez)
 */

public class Actividad3 {
    public static void main(String[] args) {
        System.out.println(primerIndex(new int[]{2, 4, 4, 4, 6, 6, 7, 7, 8}, 6));
    }

    private static int primerIndex(int[] v, int num) {
        if (v.length == 0) {
            return -1;
        }

        return primerIndexRecursivo(v, num, 0, v.length - 1);
    }

    private static int primerIndexRecursivo(int[] v, int num, int inicioSubarray, int finSubarray) {
        if (inicioSubarray == finSubarray) {
            return v[inicioSubarray] == num ? inicioSubarray : -1;
        }

        int mitadSubarray = (inicioSubarray + finSubarray) / 2, index;
        if (v[mitadSubarray] >= num) { //Mitad izquierda
            index = primerIndexRecursivo(v, num, inicioSubarray, mitadSubarray);
        } else { //Mitad derecha
            index = primerIndexRecursivo(v, num, mitadSubarray + 1, finSubarray);
        }

        return index;
    }
}
