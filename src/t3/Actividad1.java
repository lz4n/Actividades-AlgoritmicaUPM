package t3;

/**
 * Problema (2.5 puntos). Disponemos de una cantidad concreta de varios tipos de
 * tuberías, cada tipo de una longitud exacta. Queremos comprobar si existe una
 * combinación de estas tuberías que ensambladas consigan una longitud total Ltotal.<br>
 * Se pide: implementar un algoritmo en Java con la siguiente cabecera, basado en el
 * esquema de backtracking1,2, que permita determinar si existe una combinación de
 * tuberías cuyo ensamblado consiga una longitud Ltotal:<br>
 * <code>boolean hayEnsamblaje (int[] longitud, int[] cantidad, int Ltotal)</code><br>
 * donde longitud es un vector con las longitudes de tuberías disponibles, cantidad es un
 * vector con la cantidad disponible de cada tipo y Ltotal es la longitud total que se desea
 * conseguir una vez ensambladas las tuberías (dos tuberías de longitudes l1 y l2
 * ensambladas consiguen una longitud total de l1+l2).<br><br>
 * El método devolverá si se ha podido encontrar la combinación de tuberías que ensambladas consigan la longitud Ltotal.<br><br>
 * Ejemplo: Dados los siguientes vectores de longitudes y cantidades de tuberías:<br>
 * longitud: 1 7 3 4 cantidad: 3 1 4 2 1<br>
 * Para una longitud total de 21 la solución sería true (se ensamblarían 2 de
 * longitud 7, 1 de longitud 3 y 1 de longitud 4); para una longitud total de 9 la
 * solución sería false.<br><br>
 * Aclaraciones: No es necesario que la solución conste de todos los tipos de tuberías
 * ni de todas las instancias de todos los tipos. No es necesario programar las clases
 * Java Boolea
 */
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
