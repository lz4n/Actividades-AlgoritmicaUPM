package t2;

/**
 * Problema 1. Dado un array de números enteros ordenado, se desea obtener el
 * número positivo (distinto de 0) menor. Si el vector sólo contuviera números negativos
 * devolvería -1. Ejemplos:<br><br>
 * [-4,-2, 0, 1, 5, 7, 11, 13] positivoMenor = 1<br>
 * [-1, 4, 8, 10] positivoMenor = 4<br>
 * [-5, -5, -1, 3, 7] positivoMenor = 3<br>
 * [-8, -7, -4, 2, 10, 11, 12, 17] positivoMenor = 2<br>
 * [-20, -4, 0, 0, 1, 1, 3] positivoMenor = 1
 */
public class Actividad2 {
    public static void main(String[] args) {
        System.out.println(positivoMenor(new int[]{-8, -7, -4, 2, 10, 11, 12, 17}));
    }

    private static int positivoMenor(int[] vector) {
        if (vector.length == 0) {
            return -1;
        }

        int menorPositivo = positivoMenorRecursivo(vector, 0, vector.length -1);
        return menorPositivo == Integer.MAX_VALUE ? -1 : menorPositivo;
    }

    private static int positivoMenorRecursivo(int[] vector, int inicioSubarray, int finSubarray) {
        if (inicioSubarray == finSubarray) {
            int valor = vector[inicioSubarray];
            return valor > 0 ? valor : Integer.MAX_VALUE;
        }

        int mitadSubarray = (inicioSubarray + finSubarray) / 2, menorPositivo = Integer.MAX_VALUE;

        if (vector[mitadSubarray] > 0) { //Parte izquierda
            menorPositivo = Math.min(menorPositivo, positivoMenorRecursivo(vector, inicioSubarray, mitadSubarray));
        } else { //Parte derecha
            menorPositivo = Math.min(menorPositivo, positivoMenorRecursivo(vector, mitadSubarray + 1, finSubarray));
        }

        return menorPositivo;
    }
}
