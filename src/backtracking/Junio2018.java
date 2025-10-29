package backtracking;

public class Junio2018 {
    public static void main(String[] args) {
        System.out.println(hayRepartoEquitativo(new int[]{5, 5, 7, 2, 2}));
    }

    private static boolean hayRepartoEquitativo(int[] bienes) {
        return hayRepartoEquitativo(bienes, 0, new int[3]);
    }

    private static boolean hayRepartoEquitativo(int[] bienes, int nivel, int[] repartoHerederos) {
        if (nivel == bienes.length) {
            return herederosConLaMismaCantidad(repartoHerederos);
        }

        boolean solucion = false;
        int c = 0;
        while (c < repartoHerederos.length && !solucion) { //El heredero "c" se lleva el "bien[nivel]"
            repartoHerederos[c] += bienes[nivel];
            solucion = hayRepartoEquitativo(bienes, nivel + 1, repartoHerederos);
            repartoHerederos[c] -= bienes[nivel]; //Aunque se haya encontrado solución podemos eliminar el bien del heredero, puesto que el valor ya no es necesario.

            c++;
        }

        return solucion;
    }

    private static boolean herederosConLaMismaCantidad(int[] repartoHerederos) {
        int i = 1;
        boolean herederoConMismaCantidad = true;
        while (i < repartoHerederos.length && herederoConMismaCantidad) {
            herederoConMismaCantidad = repartoHerederos[0] == repartoHerederos[i++];
        }

        return herederoConMismaCantidad;
    }
}
