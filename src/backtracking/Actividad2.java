package backtracking;

/**
 * Problema. Dado un vector, v, que contiene los valores de un conjunto de elementos, se
 * desea comprobar si existen dos subconjuntos de elementos tal que la suma de valores de
 * cada subconjunto sea exactamente igual a un valor predeterminado vObjetivo.<br><br>
 * Por ejemplo, dado el siguiente vector v:<br>
 * 4 2 5 5 1 8<br>
 * Para vObjetivo=10, los dos subconjuntos de elementos {0,2,4} y {1,5} cumplen que
 * (v[0]+v[2]+v[4])=10 y (v[1]+v[5])=10. Sin embargo, para vObjetivo=11 no existen dos
 * subconjuntos en v tal que la suma de valores de cada subconjunto sea 11.<br><br>
 * Implementar un algoritmo en Java, basado en el esquema de Backtracking, que valide si
 * existen dos subconjuntos de elementos en el vector de valores cuya suma sea exactamente
 * el valor objetivo:<br>
 * boolean dosSubconjuntos(int[] v, int vObjetivo)<br>
 * donde v es el vector de valores y vObjetivo es el valor objetivo a conseguir. El método deberá
 * devolver un valor booleano que indique si existen los dos subconjuntos que cumplan los
 * requisitos o no. Se podrán implementar todos los métodos/clases adicionales que se
 * consideren necesarios.<br>
 * Aclaraciones: NO es necesario que todos los elementos del vector v formen parte de la
 * solución
 */

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
