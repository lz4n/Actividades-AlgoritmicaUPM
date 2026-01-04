package dinamica;

/**
 * haySuma(i, j): calcula si es posible consguir sumar i usando los elementos 0..j del vector.
 *
 * Entrada:
 *  - i {0..inf} Indica lo que falta para sumar, i=0 se ha llegado al objtivo.
 *  - j {0..valores.length} Indica que valores del vector se disponen, j=0 indica que se dispone del elemento 0.
 */

/**
 * haySuma(i, j):
 *  - i=0 => true
 *  - j=0 => valores[0]==i
 *  - en el resto de casos => haySuma(i -valores[j], j-1) || haySuma(i, j-1)
 */
public class Diciembre2016 {
    public boolean haySuma(int[] valores, int v) {
        int n = v +1, m = valores.length;
        boolean[][] matrizSuma = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            matrizSuma[i][0] = valores[0] == i;
        }
        for (int j = 0; j < m; j++) {
            matrizSuma[0][j] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                matrizSuma[i][j] = (i -valores[j] >= 0 ? matrizSuma[i -valores[j]][j -1] : false) || matrizSuma[i][j -1];
            }
        }

        return matrizSuma[n -1][m -1];
    }
}
