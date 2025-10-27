package t3;

import java.util.concurrent.atomic.AtomicInteger;

public class ExtraSeleccionOptima {
    public static void main(String[] args) {
        System.out.println(maxPeticiones(3, new int[]{0, 2, 2, 1, 2}, new int[]{1, 1, 0, 2, 0}));
    }

    private static int maxPeticiones(int N, int[] origen, int[] destino) {
        AtomicInteger maxPeticiones = new AtomicInteger(0);
        maxPeticionesRecursivo(N, origen, destino, 0, new boolean[origen.length], 0, maxPeticiones);
        return maxPeticiones.get();
    }

    private static void maxPeticionesRecursivo(int N, int[] origen, int[] destino, int nivel, boolean[] peticionesSeleccionadas, int cantidadPeticiones, AtomicInteger mejorBondad) {
        if (nivel == origen.length) {
            if (peticionesValidas(N, origen, destino, peticionesSeleccionadas) && cantidadPeticiones > mejorBondad.get()) {
                mejorBondad.set(cantidadPeticiones);
            }

            return;
        }

        for (int c = 0; c < 2; c++) { //c=0 NO selecciono, c=1 SI selecciono
            peticionesSeleccionadas[nivel] = c == 1;
            cantidadPeticiones += c;

            maxPeticionesRecursivo(N, origen, destino, nivel + 1, peticionesSeleccionadas, cantidadPeticiones, mejorBondad);

            cantidadPeticiones -= c;
        }
    }

    private static boolean peticionesValidas(int N, int[] origen, int[] destino, boolean[] peticionesSeleccionadas) {
        int[] peticiones = new int[N];

        for (int i = 0; i < origen.length; i++) if (peticionesSeleccionadas[i]) {
            peticiones[origen[i]]++;
            peticiones[destino[i]]--;
        }

        boolean peticionValida = true;
        int i = 0;
        while (i < peticiones.length && peticionValida) {
            peticionValida = peticiones[i++] == 0;
        }

        return peticionValida;
    }
}
