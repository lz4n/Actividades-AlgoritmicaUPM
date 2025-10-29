package backtracking;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Enero2024 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(equipos(new int[]{12, 5, 8, 9, 3, 10, 15, 4, 20, 7}, 4)));
    }

    private static int[] equipos(int[] habilidad, int k) {
        if (habilidad.length < k) return null;

        int[] mejorEstado = new int[habilidad.length];
        boolean encontrado = equiposRecursivo(habilidad, k, 0, new int[habilidad.length], new int[k], mejorEstado, new AtomicInteger(Integer.MAX_VALUE));

        return encontrado ? mejorEstado : null;
    }

    private static boolean equiposRecursivo(int[] habilidad, int k, int nivel, int[] estadoAcutal, int[] equipos, int[] mejorEstado, AtomicInteger mejorBondad) {
        if (nivel == habilidad.length) {
            int bondadActual = getBondadActual(equipos);
            if (bondadActual < mejorBondad.get()) {
                mejorBondad.set(bondadActual);

                for (int i = 0; i < estadoAcutal.length; i++) {
                    mejorEstado[i] = estadoAcutal[i];
                }

                return true;
            }

            return false;
        }

        boolean encontrado = false;
        for (int c = 0; c < k; c++) {

            estadoAcutal[nivel] = c;
            equipos[c] += habilidad[nivel];

            encontrado = equiposRecursivo(habilidad, k, nivel + 1, estadoAcutal, equipos, mejorEstado, mejorBondad) || encontrado;

            equipos[c] -= habilidad[nivel];
        }

        return encontrado;
    }

    private static int getBondadActual(int[] equipos) {
        boolean equipoVacio = false;
        int i = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        while (i < equipos.length && !equipoVacio) {
            equipoVacio = equipos[i] == 0;

            if (equipos[i] < min) min = equipos[i];
            if (equipos[i] > max) max = equipos[i];

            i++;
        }

        return equipoVacio ? Integer.MAX_VALUE : max - min;
    }
}
