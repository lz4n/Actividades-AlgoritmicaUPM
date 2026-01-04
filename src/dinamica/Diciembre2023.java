package dinamica;

/**
 * maxCajas(i, j): numero máximo de cajas (desde la 0 hasta la j) que no superan el volumen i.
 *
 * Entrada
 *  - i {0..volSaco}: capacidad que falta por rellenar del saco, i=0 saco lleno.
 *  - j {0..volumenCajas.length +1}: cajas que se disponen, j=0 ninguna caja seleccionada
 *
 * Salida: numero maximo de cajas
 */

/**
 * maxCajas(0, j) = 0 (no hay espacio para rellenar cajas
 * maxCajas(i, 0) = 0 (no hay ninguna caja sleccionada)
 * maxCajas(i, j) = max(maxCajas(i - volumenCajas[j-1], j), maxCajas(i, j -1))
 */
public class Diciembre2023 {
    int llenarSaco(int[] volumenCajas, int volSaco) {
        int n = volSaco +1, m = 2;
        int[][] maxCajas = new int[n][m];

        for (int i = 0; i < n; i++) {
            maxCajas[i][0] = 0;
        }
        for (int j = 0; j < m; j++) {
            maxCajas[0][j] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < volumenCajas.length +1; j++) {
                maxCajas[i][j % 2] = Math.max(
                        i >= volumenCajas[j-1] ? maxCajas[i - volumenCajas[j-1]][j % 2] : 0,
                        maxCajas[i][(j-1) % 2]
                );
            }
        }

        return maxCajas[volSaco][volumenCajas.length % 2];
    }
}
