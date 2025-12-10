package dinamica;

/**
 * coste(i, j):
 * Coste minimo para transformar los i primeros numeros de adn1 en los j primeros de adn2.
 *
 * Entrada
 * - i: num entero {0..adn1.length}, donde i=0 indica que adn1 está vacío.
 * - j: num entero {0..adn2.length}, donde j=0 indica que adn2 está vacío.
 *
 * Salida:
 * Num entero que indica el coste mínimo.
 */

/**
 * coste(i, j):
 *  - si i=0, j>0 => j*a
 *  - si i>0, j=0 => i*b
 *  - si i>0, j>0 => min(coste(i -1, j -1) +m[adn1[i]][adn2[j]], coste(i -1, j) +b, coste(i, j -1) +a)
 */
public class Diciembre2020 {
    public static int coste(int[] adn1, int[] adn2, int a, int b, int[][] m) {
        if (adn1.length > adn2.length) {
            return costeJMenorI(adn1, adn2, a, b, m);
        }

        return costeIMenorJ(adn1, adn2, a, b, m);
    }

    public static int costeIMenorJ(int[] adn1, int[] adn2, int a, int b, int[][] m) {
        int[][] costeMin = new int[adn1.length +1][2];
        for (int i = 0; i < adn1.length +1; i++) {
            costeMin[i][0] = i*b;
        }

        for (int j = 1; j < adn2.length +1; j++) {
            costeMin[0][j % 2] = j*a;
            for (int i = 1; i < adn1.length +1; i++) {
                costeMin[i][j % 2] = Math.min(
                        Math.min(
                            costeMin[i -1][(j -1) % 2] +m[adn1[i -1]][adn2[j -1]],
                            costeMin[i -1][j % 2] +b),
                        costeMin[i][(j -1) % 2] +a
                );
            }
        }

        return costeMin[adn1.length][adn2.length % 2];
    }

    public static int costeJMenorI(int[] adn1, int[] adn2, int a, int b, int[][] m) {
        int[][] costeMin = new int[2][adn2.length +1];
        for (int j = 0; j < adn2.length +1; j++) {
            costeMin[0][j] = j*a;
        }

        for (int i = 1; i < adn1.length +1; i++) {
            costeMin[i % 2][0] = i*b;
            for (int j = 1; j < adn2.length +1; j++) {
                costeMin[(i -1) % 2][j] = Math.min(
                        Math.min(
                                costeMin[(i -1) % 2][j -1] +m[adn1[i -1]][adn2[j -1]],
                                costeMin[(i -1) % 2][j] +b),
                        costeMin[i % 2][j -1] +a
                );
            }
        }

        return costeMin[adn1.length % 2][adn2.length];
    }
}
