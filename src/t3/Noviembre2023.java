package t3;

import java.util.Arrays;

public class Noviembre2023 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(teleferico(new int[]{1, 2, 3, 1}, 2, 3)));
    }

    public static boolean[] teleferico(int[] pesos, int numP, int pMax) {
        if (pesos.length < numP) return null;

        boolean[] solucion = new boolean[pesos.length];
        boolean encontrado = telefericoRecursivo(pesos, 0, numP, pMax, solucion);

        return encontrado ? solucion : null;
    }

    private static boolean telefericoRecursivo(int[] pesos, int nivel, int faltaPersonas, int faltaPeso, boolean[] estadoActual) {
        if (faltaPersonas == 0 && faltaPeso == 0) return true;
        if (faltaPeso < 0 || nivel == pesos.length) return false;

        //Seleccionamos a la persona con peso = pesos[nivel]
        estadoActual[nivel] = true;
        boolean solucion = telefericoRecursivo(pesos, nivel + 1, faltaPersonas - 1, faltaPeso - pesos[nivel], estadoActual);
        if (solucion) return true;

        //NO seleccionamos a la persona
        estadoActual[nivel] = false;
        solucion = telefericoRecursivo(pesos, nivel + 1, faltaPersonas, faltaPeso, estadoActual);
        return solucion;
    }
}
