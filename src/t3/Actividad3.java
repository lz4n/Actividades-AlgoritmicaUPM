package t3;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Problema. Se dispone de dos contenedores, cada uno capaz de soportar un peso máximo,
 * y un conjunto de productos, cada uno con un peso característico. Se pretende distribuir
 * todos los productos entre los dos contenedores de forma que el reparto del peso sea lo
 * más equilibrado posible.<br><br>
 * Ejemplo: dado un peso máximo de 10 para cada contenedor y
 * el siguiente array de pesos de los productos:<br>
 * <i>0 1 2 3 4 5 6 7</i><br>
 * 1 3 2 5 1 4 2 1<br>
 * el reparto más equilibrado distribuye los objetos {0,1,2,4,6,7} en el contenedor 1 (con un
 * peso total de 10) y {3,5} en el contenedor 2 (con un peso total de 9).<br><br>
 * SE PIDE: Implementar un algoritmo en Java, basado en el esquema de Selección
 * óptima1, que ofrezca esta funcionalidad2. El algoritmo deberá tener la siguiente cabecera:<br>
 * <code>int[] distribucionCarga2 (int[] pesos, int pMax)</code><br>
 * donde pesos es un array que contiene los pesos de los productos y pMax es el peso
 * máximo soportado por cada contenedor. El método deberá devolver un vector de valores
 * int3, con tantos elementos como tenga el vector pesos, con valor 1 o 2 según el objeto
 * haya sido asignado al contenedor 1 o al 2 (ningún producto puede quedar sin asignar).
 */
public class Actividad3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distribucionCarga2(new int[]{1, 3, 2, 5, 1, 4, 2, 1}, 10)));
    }

    public static int[]  distribucionCarga2(int[] elementos, int pMax) {
        int[] mejorSolucion = new int[elementos.length];
        distribucionCarga2Recursivo(elementos, 0, new int[]{pMax, pMax}, new int[elementos.length], mejorSolucion, new AtomicInteger(Integer.MAX_VALUE));

        return mejorSolucion;
    }

    private static void distribucionCarga2Recursivo(int[] elementos, int nivel, int[] falta, int[] estadoActual, int[] mejorSolucion, AtomicInteger mejorSolucionDiferencia) {
        if (mejorSolucionDiferencia.get() == 0) return;

        if (nivel >= elementos.length) {
            int bondadSolucion = diferencia(falta);
            if (mejorSolucionDiferencia.get() > bondadSolucion) {
                mejorSolucionDiferencia.set(bondadSolucion);

                for (int i = 0; i < elementos.length; i++) {
                    mejorSolucion[i] = estadoActual[i];
                }
            }

            return;
        }

        int elemento = elementos[nivel];
        for (int i = 0; i < 2; i++) {
            if (falta[i] >= elemento) {
                falta[i] -= elemento;
                estadoActual[nivel] = i + 1;

                distribucionCarga2Recursivo(elementos, nivel + 1, falta, estadoActual, mejorSolucion, mejorSolucionDiferencia);

                falta[i] += elemento;
                estadoActual[nivel] = 0;
            }
        }
    }

    private static int diferencia(int[] suma) {
        return Math.abs(suma[0] - suma[1]);
    }
}
