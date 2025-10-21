package t3;

public class Actividad1 {
    public static void main(String[] args) {
        System.out.println(dosSubconjuntos(new int[]{1, 1, 1, 1}, 2));
    }

    private static boolean dosSubconjuntos(int[] vector, int objetivo) {
        return dosSubconjuntosRecursivo(vector, 0, objetivo, objetivo);
    }

    private static boolean dosSubconjuntosRecursivo(int[] vector, int nivel, int faltaSubconjunto1, int faltaSubconjunto2) {
        if (faltaSubconjunto1 == 0 && faltaSubconjunto2 == 0) return true;
        if (faltaSubconjunto1 < 0 || faltaSubconjunto2 < 0) return false;

        if (nivel >= vector.length) return false;

        int elemento = vector[nivel];

        return dosSubconjuntosRecursivo(vector, nivel + 1, faltaSubconjunto1, faltaSubconjunto2)
                || dosSubconjuntosRecursivo(vector, nivel + 1, faltaSubconjunto1 - elemento, faltaSubconjunto2)
                || dosSubconjuntosRecursivo(vector, nivel + 1, faltaSubconjunto1, faltaSubconjunto2 - elemento);
    }
}
