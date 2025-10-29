package backtracking;

import java.util.Arrays;

public class Noviembre2023 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(teleferico(new int[]{1, 2, 3, 1}, 2, 3)));
    }

    private static boolean[] teleferico(int[] pesos, int numP, int pMax) {
        boolean[] solucion = new boolean[pesos.length];
        boolean haySolucion = telefericoRecursivo(pesos, 0, numP, pMax, solucion);
        return haySolucion ? solucion : null;
    }

    private static boolean telefericoRecursivo(int[] pesos, int nivel, int faltaPersonas, int faltaPeso, boolean[] estado) {
        if (faltaPersonas == 0 && faltaPeso == 0) return true;

        boolean solucion = false;
        int c = 0;
        while (c < 2 && !solucion) {//c=0 no selecciono, c=1 selecciono
            if (c == 0 || (c == 1 && faltaPersonas >= 1 && faltaPeso >= pesos[nivel])) {
                estado[nivel] = c == 1;

                faltaPersonas -= c;
                faltaPeso -= pesos[nivel] * c;

                solucion = telefericoRecursivo(pesos, nivel + 1, faltaPersonas, faltaPeso, estado);

                if (!solucion) {
                    estado[nivel] = false;
                    faltaPersonas += c;
                    faltaPeso += pesos[nivel] * c;
                }
            }

            c++;
        }

        return solucion;
    }
}
