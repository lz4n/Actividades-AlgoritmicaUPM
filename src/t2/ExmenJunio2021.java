package t2;

/**
 * Sean A y B dos vectores de N elementos enteros, ordenados circularmente
 * y que pueden contener números repetidos. Ambos vectores comparten exactamente
 * los mismos elementos hasta una posición determinada ‘k’, a partir de la cual todos
 * sus elementos serán diferentes. Se pide implementar un algoritmo, que dado los
 * vectores A y B determine esa posición ‘k’. En el caso de que los dos vectores sean
 * idénticos el procedimiento devolverá -1 (indicando de esa forma que tal posición no
 * existe).<br>
 * Diseñar el procedimiento basado en Divide y Vencerás con complejidad O(logN)
 * en el caso peor1 (donde N es el tamaño del vector) que devuelva un número
 * entero que corresponde a la posición del primer elemento diferente entre
 * ambos vectores.
 * <br><br>
 * Ejemplo:<br>
 * [-4, -2, 0, 1, 1, 2, 3, 4, -9]<br>
 * [-4, -2, 0, 1, 1, 5, 7, 10, -6]<br>
 * Devolvería la posición=5
 */
public class ExmenJunio2021 {
    public static void main(String[] args) {
                      //0  1  2  3  4  5  6  7
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8},
              array2 = {1, 2, 3, 4, 5, 6, 8, 9};

        System.out.println(posDiferente(array1, array2));
    }

    private static int posDiferente(int[] array1,int[] array2) {
        return posDiferenteRecursivo(array1, array2, 0, array1.length - 1);
    }

    private static int posDiferenteRecursivo(int[] array1,int[] array2, int i0, int iN) {
        if (i0 == iN) return array1[i0] == array2[i0] ? -1 : i0;

        int pivote = (i0 + iN) / 2;
        if (array1[pivote] == array2[pivote]) {
            return posDiferenteRecursivo(array1, array2, pivote + 1, iN);
        } else {
            return posDiferenteRecursivo(array1, array2, i0, pivote);
        }
    }
}
