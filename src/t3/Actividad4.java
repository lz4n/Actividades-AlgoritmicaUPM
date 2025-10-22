package t3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Problema 1 (5 puntos). Dada una matriz NxM de números enteros positivos, se quiere encontrar
 * el recorrido de menor valor acumulado desde la celda inicial (0,0) hasta la celda final (N-1,M-1),
 * pudiendo únicamente moverse a celdas hacia abajo, hacia la derecha o hacia la diagonal inferior
 * derecha. Por ejemplo, para la siguiente matriz de 3x3:<br><br>
 * <b>1</b> <b>2</b> 3<br>
 * 4 8 <b>2</b><br>
 * 1 5 <b>3</b><br>
 * El recorrido óptimo sería el indicado en la figura derecha cuyo valor sería 8 (1+2+2+3).<br><br>
 * SE PIDE: Implementar un algoritmo en Java, basado en el esquema de Selección Óptima1, que
 * ofrezca esta funcionalidad2. El algoritmo tendrá la siguiente cabecera:<br>
 * <code>int recorridoOptimo(int[][] matriz)</code><br>
 * donde matriz es la matriz a recorrer. El método devolverá el valor int del recorrido óptimo de menor
 * valor acumulado. Se podrán implementar todos los métodos que se consideren necesarios. No es
 * necesario programar las clases Java Booleano y Entero.
 */
public class Actividad4 {
    public static void main(String[] args) {
        System.out.println(recorridoOptimo(new int[][]{{1, 2, 3}, {4, 8, 2}, {1, 5, 3}}));
    }

    private static int recorridoOptimo(int[][] matriz) {
        AtomicInteger mejorSolucion = new AtomicInteger(Integer.MAX_VALUE);
        recorridoOptimoRecursivo(matriz, 0, 0, 0, mejorSolucion);
        return mejorSolucion.get();
    }

    private static void recorridoOptimoRecursivo(int[][] matriz, int nivelX, int nivelY, int costeActual, AtomicInteger mejorSolucion) {
        costeActual += matriz[nivelY][nivelX];

        if (nivelX == matriz[0].length -1 && nivelY == matriz.length -1) {
            if (mejorSolucion.get() > costeActual) {
                mejorSolucion.set(costeActual);
            }

            return;
        }

        //Poda
        if (mejorSolucion.get() < costeActual) return;

        int[] dx = new int[]{1, 0, 1},
              dy = new int[]{0, 1, 1};

        for (int i = 0; i < 3; i++) {
            int nuevoX = nivelX + dx[i], nuevoY = nivelY + dy[i];
            if (enRango(matriz, nuevoX, nuevoY)) {
                recorridoOptimoRecursivo(matriz, nuevoX, nuevoY, costeActual, mejorSolucion);
            }
        }
    }

    private static boolean enRango(int[][] matriz, int nivelX, int nivelY) {
        return !(nivelX >= matriz[0].length || nivelY >= matriz.length);
    }
}
