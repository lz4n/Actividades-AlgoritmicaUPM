package t3;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Enero2024 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(equipos(new int[]{12, 5, 8, 9, 3, 10, 15, 4, 20, 7}, 4)));
    }

    private static int[] equipos(int[] habilidad, int k) {
        if (habilidad.length < k) return null;

        int[] mejorSolucion = new int[habilidad.length];
        equipos(habilidad, k, 0, new int[habilidad.length], new int[k], mejorSolucion, new AtomicInteger(Integer.MAX_VALUE));
        return mejorSolucion;
    }

    private static void equipos(int[] habilidad, int k, int nivel, int[] estadoActual, int[] habilidadEquipo, int[] mejorSolucion, AtomicInteger mejorBondad) {
        if (nivel == habilidad.length) {
            int bondadSolucion = calcularBondadSolucion(habilidadEquipo);
            if (bondadSolucion < mejorBondad.get()) {
                mejorBondad.set(bondadSolucion);
                for (int i = 0; i < estadoActual.length; i++) {
                    mejorSolucion[i] = estadoActual[i];
                }
            }
            return;
        }

        if (mejorBondad.get() == 0) return;

        for (int c = 0; c < k; c++) {
            estadoActual[nivel] = c;
            habilidadEquipo[c] += habilidad[nivel];

            equipos(habilidad, k, nivel + 1, estadoActual, habilidadEquipo, mejorSolucion, mejorBondad);

            estadoActual[nivel] = 0;
            habilidadEquipo[c] -= habilidad[nivel];
        }
    }

    private static int calcularBondadSolucion(int[] habilidadEquipo) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean hayEquipoSinHabilidad = false;

        int i = 0;
        while (!hayEquipoSinHabilidad && i < habilidadEquipo.length) {
            min = Math.min(min, habilidadEquipo[i]);
            max = Math.max(max, habilidadEquipo[i]);

            hayEquipoSinHabilidad = habilidadEquipo[i] == 0;

            i++;
        }

        return hayEquipoSinHabilidad ? Integer.MAX_VALUE : max - min;
    }
}
