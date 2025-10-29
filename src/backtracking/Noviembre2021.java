package backtracking;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Noviembre2021 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(subcSuma0MaxElem(new int[]{7, 1, -1, 2, -3, 1})));
    }

    private static boolean[] subcSuma0MaxElem(int[] v) {
        boolean[] solucion = new boolean[v.length];
        subcSuma0MaxElemRecursivo(v, 0, 0, new boolean[v.length], 0, solucion, new AtomicInteger(Integer.MIN_VALUE));
        return solucion;
    }

    private static void subcSuma0MaxElemRecursivo(int[] v, int nivel, int suma, boolean[] estadoActual, int bondadActual, boolean[] mejorEstado, AtomicInteger mejorBondad) {
        if (nivel == v.length) {
            if (suma == 0 && bondadActual > mejorBondad.get()) {
                mejorBondad.set(bondadActual);

                for (int i = 0; i < mejorEstado.length; i++) {
                    mejorEstado[i] = estadoActual[i];
                }
            }

            return;
        }

        int c = 0;
        while (c <= 1 && mejorBondad.get() != v.length) {//c=0 no selecciono, c=1 selecciono
            estadoActual[nivel] = c == 1;
            bondadActual += c;
            suma += v[nivel] * c;

            subcSuma0MaxElemRecursivo(v, nivel + 1, suma, estadoActual, bondadActual, mejorEstado, mejorBondad);

            bondadActual -= c;
            suma -= v[nivel] * c;
            c++;
        }
    }
}
