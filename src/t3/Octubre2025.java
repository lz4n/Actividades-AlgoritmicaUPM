package t3;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Octubre2025 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minEsfuerzoEnT(new int[]{1, 2, 3, 2}, new int[]{1, 2, 3 ,4}, 2)));
    }

    public static boolean[] minEsfuerzoEnT(int[] tiempo, int[] esfuerzo, int T) {
        boolean[] solucion = new boolean[tiempo.length];
        minEsfuerzoEnTRecursivo(tiempo, esfuerzo, T, 0,
                new boolean[tiempo.length], 0,
                solucion, new AtomicInteger(Integer.MAX_VALUE)
        );
        return solucion;
    }

    private static void minEsfuerzoEnTRecursivo(int[] tiempo, int[] esfuerzo, int faltaT, int nivel,
                                                boolean[] estadoActual, int bondadActual,
                                                boolean[] mejorEstado, AtomicInteger mejorBondad) {
        if (nivel == tiempo.length) {
            if (faltaT == 0 && bondadActual < mejorBondad.get()) {
                mejorBondad.set(bondadActual);
                for (int i = 0; i < mejorEstado.length; i++) {
                    mejorEstado[i] = estadoActual[i];
                }
            }

            return;
        }

        if (faltaT < 0 || bondadActual > mejorBondad.get()) return;

        for (int c = 0; c < 2; c++) {
            estadoActual[nivel] = c == 1;
            minEsfuerzoEnTRecursivo(tiempo, esfuerzo, faltaT - (tiempo[nivel] * c), nivel + 1,
                    estadoActual, bondadActual + (esfuerzo[nivel] * c),
                    mejorEstado, mejorBondad
            );
        }
    }

    //Sin objeto para mejorBondad
    private static int minEsfuerzoEnTRecursivo(int[] tiempo, int[] esfuerzo, int faltaT, int nivel,
                                               boolean[] estadoActual, int bondadActual,
                                               boolean[] mejorEstado, int mejorBondad) {
        if (nivel == tiempo.length) {
            if (faltaT == 0 && bondadActual < mejorBondad) {
                for (int i = 0; i < mejorEstado.length; i++) {
                    mejorEstado[i] = estadoActual[i];
                }
                return bondadActual;
            }

            return mejorBondad;
        }

        if (faltaT < 0 || bondadActual >= mejorBondad) return mejorBondad;

        for (int c = 0; c < 2; c++) {
            estadoActual[nivel] = c == 1;
            mejorBondad = minEsfuerzoEnTRecursivo(tiempo, esfuerzo, faltaT - (tiempo[nivel] * c), nivel + 1,
                    estadoActual, bondadActual + (esfuerzo[nivel] * c),
                    mejorEstado, mejorBondad
            );
        }

        return mejorBondad;
    }
}
