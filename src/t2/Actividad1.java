package t2;

/**
 * Dado un vector de enteros ordenados mayores que cero, se quiere obtener
 * cuántos múltiplos de una cifra x hay en el vector (para cualquier x>0). Por ejemplo, dado
 * el siguiente vector con x=3, la salida sería 2 porque encuentra 2 múltiplos de 3.<br><br>
 * [1, 1, 2, 4, 6, 17, 18]
 */

public class Actividad1 {
    public static void main(String[] args) {
        System.out.println(numMultiplosRecursivo(new int[]{1, 1, 2, 4, 6, 17, 18}, 3));
    }

    private static int numMultiplosRecursivo(int[] v, int x) {
        if (v.length == 0) {
            return 0;
        }

        return numMultiplosRecursivo(v, x, 0, v.length -1);
    }

    private static int numMultiplosRecursivo(int[] v, int x, int inicioSubarray, int finSubarray) {
        if (inicioSubarray == finSubarray) {
            return v[inicioSubarray] % x == 0 ? 1 : 0;
        }

        return numMultiplosRecursivo(v, x, inicioSubarray, (inicioSubarray + finSubarray) / 2) //Mitad izquierda
                + numMultiplosRecursivo(v, x, (inicioSubarray + finSubarray) / 2 + 1, finSubarray); //Mitad derecha
    }

}
