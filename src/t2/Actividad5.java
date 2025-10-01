package t2;

/**
 * Problema. Dada una cadena de ceros y unos, encontrar la secuencia más larga de unos
 * basado en la estrategia de Divide y Vencerás con complejidad en el caso peor de
 * O(N·logN) (donde N es el tamaño del vector). Se pide implementar un algoritmo que
 * deberá tener la siguiente cabecera:<br><br>
 * int oneSubArray (int[] v)<br><br>
 * donde v es el array que contiene la secuencia de ceros y unos.
 */
public class Actividad5 {
    public static void main(String[] args) {
        System.out.println(oneSubArray(new int[]{1, 1, 1, 1, 1, 0, 1}));
    }

    private static int oneSubArray(int[] v) {
        return oneSubArrayRecursivo(v, 0, v.length-1);
    }

    private static int oneSubArrayRecursivo(int[] v, int i0, int iN) {
        if (i0 == iN) return v[i0] == 1 ? 1 : 0;

        int pivote = (i0 + iN) / 2;
        return Math.max(Math.max(oneSubArrayRecursivo(v, 0, pivote), oneSubArrayRecursivo(v, pivote + 1, iN)), oneSubArrayPivote(v, i0, iN, pivote));
    }

    private static int oneSubArrayPivote(int[] v, int i0, int iN, int pivote) {
        int i = pivote, longitud = 0;

        //1s a la izquierda del pivote (incluido)
        while (i >= i0 && v[i] == 1) {
            longitud++;
            i--;
        }

        //1s a la derecha del pivote (excluido)
        i = pivote + 1;
        while (i <= iN && v[i] == 1) {
            longitud++;
            i++;
        }

        return longitud;
    }
}
