package t2;

import java.util.Arrays;

public class ExamenJunio2025 {
    public static void main(String[] args) {
        System.out.println(elementoMayoritario(new int[]{0, 1, 2, 3, 1, 1, 1}));
    }

    private static int elementoMayoritario(int[] array) {
        int mitad = (array.length -1) / 2;
        mergeSort(array);

        System.out.println(Arrays.toString(array));

        return array[mitad];
    }

    private static void mergeSort(int[] vector) {
        mergeSortRecursivo(vector,0, vector.length-1);
    }

    private static void mergeSortRecursivo(int[] vector, int i0, int iN){
        if (i0 >= iN) return;

        int pivote = (i0 + iN) /2;
        mergeSortRecursivo(vector, i0, pivote);
        mergeSortRecursivo(vector, pivote +1, iN);
        merge(vector, i0, pivote, iN);
    }

    private static void merge(int[] vector, int i0, int pivote, int iN) {
        int i = i0, j = pivote + 1, k = 0;
        int[] aux = new int[iN - i0 + 1];
        while (i <= pivote && j <= iN) {
            if (vector[i] <= vector[j]) {
                aux[k] = vector[i++];
            } else {
                aux[k] = vector[j++];
            }

            k++;
        }

        for (int a = i; a <= pivote; a++) {
            aux[k++] = vector[a];
        }
        for (int a = j; a <= iN; a++) {
            aux[k++] = vector[a];
        }
        for (int a = 0; a < aux.length; a++) {
            vector[i0 + a] = aux[a];
        }
    }
}
