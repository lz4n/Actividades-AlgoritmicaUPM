package t2;

public class Examen2018 {
    public static void main(String[] args) {
        System.out.println(minArrayRotado(new int[]{10, 15, 32, 1, 2, 3 ,4 ,7}));
    }

    private static int minArrayRotado(int[] array) {
        return minArrayRotadoRecursivo(array, 0, array.length -1);
    }

    private static int minArrayRotadoRecursivo(int[] array, int i0, int iN) {
        if (array[i0] < array[iN]) {
            return array[i0];
        }

        if (i0 == iN) {
            return array[i0];
        }

        int pivote = (i0 + iN) / 2;
        if (array[pivote] < array[i0]) {
            return minArrayRotadoRecursivo(array, i0, pivote);
        } else {
            return minArrayRotadoRecursivo(array, pivote + 1, iN);
        }
    }
}
