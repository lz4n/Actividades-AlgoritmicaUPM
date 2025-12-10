package dinamica;

/**
 * maxPerdidas(i): Suma de los subarrays negativos comprendidos entre las posiciones 0…i.
 * maxTotal(i): Suma de los subarrays negativos que empiezan en algún entre 0…i y terminan en i.
 *
 * Entrada: i {0…n-1}. El valor i=0 hace referencia a la posición 0 del array.
 * Salida: valor entero que indica la suma del menor subarray.
 */

/**
 * maxPerdidas(i):
 *  si i=0 => {0 si registro[i] >= 0, registro[i] si registro[i] < 0}
 *  si i>0 => min(registro[i], maxPerdidas(i-1) + registro[i]}
 *
 * maxTotal(i):
 *  si i=0 => {0 si registro[i] >= 0, registro[i] si registro[i] < 0}
 *  si i>0 => min(maxTotal(i), maxTotal(i-1)}
 */
public class Diciembre2024 {
    public static void main(String[] args) {
        System.out.println(minPeriodoNegativo(new int[]{1, -1, 2, -2, -3}));
    }

    public static int minPeriodoNegativo(int[] vector){
        int maxPerdidas = Math.min(vector[0], 0);
        int maxTotal = Math.min(vector[0], 0);

        for (int i = 1; i < vector.length; i++) {
            if (vector[i] >= 0) {
                maxPerdidas = 0;
            } else {
                maxPerdidas += vector[i];
            }
            maxTotal = Math.min(maxTotal, maxPerdidas);
        }

        return maxTotal;
    }
}
