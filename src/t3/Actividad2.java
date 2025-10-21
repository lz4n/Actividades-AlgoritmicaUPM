package t3;

public class Actividad2 {
    public static void main(String[] args) {
        System.out.println(hayEnsamblaje(new int[]{1, 7, 3, 4}, new int[]{1, 4, 2, 1}, 8));
    }

    public static boolean hayEnsamblaje(int[] longitud, int[] cantidad, int longitudTotal) {
        return hayEnsamblajeRecursivo(longitud, cantidad, longitudTotal);
    }

    private static boolean hayEnsamblajeRecursivo(int[] logitud, int[] cantidad, int longitudConstruida) {
        if (longitudConstruida == 0) return true;
        if (longitudConstruida < 0) return false;

        int seleccion = 0;
        boolean resultado = false;
        while (!resultado && seleccion < cantidad.length) {
            if (hayTuberia(cantidad, seleccion)) {
                cantidad[seleccion]--;
                resultado = hayEnsamblajeRecursivo(logitud, cantidad, longitudConstruida -logitud[seleccion]);

                if (resultado) cantidad[seleccion]++;
            }

            seleccion++;
        }

        return resultado;
    }

    private static boolean hayTuberia(int[] cantidad, int seleccion) {
        return cantidad[seleccion] >= 1;
    }
}
