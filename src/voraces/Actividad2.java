package voraces;

import java.util.ArrayList;
import java.util.List;

/**
 * SE PIDE: Implementar un algoritmo basado en el esquema Voraz que maximice el número resultado de concatenar todos los números del array. Usa la siguiente cabecera:
 * <br><br>int numeroGrande(ArrayList<Numero> nums)
 */
public class Actividad2 {
    int numeroGrande(ArrayList<Numero> nums) {
        Numero solucion = new Numero(0);

        while (!nums.isEmpty()) {
            Numero numero = seleccionarNumero(nums);
            solucion.concatRight(numero);
            nums.remove(numero);
        }

        return solucion.getNumInt();
    }

    Numero seleccionarNumero(List<Numero> numeros) {
        Numero seleccion = null;

        for (Numero numero : numeros) {
            if (seleccion == null || esNumeroMayor(seleccion, numero)) {
                seleccion = numero;
            }
        }

        return seleccion;
    }

    boolean esNumeroMayor(Numero num1, Numero num2) {
        if (num1.getLength() == num2.getLength()) return num1.getNumInt()> num2.getNumInt();

        Numero numeroConcatenado1 = new Numero(num1);
        numeroConcatenado1.concatRight(num2);

        Numero numeroConcatenado2 = new Numero(num2);
        numeroConcatenado2.concatRight(num1);

        return numeroConcatenado1.getNumInt() > numeroConcatenado2.getNumInt();
    }

    public static class Numero {
        public Numero(int num) {
        }

        public Numero(Numero num) {
        }

        public Numero(String num) {
        }

        public int getNumInt() {
            return 0;
        }

        public String getNumStr() {
            return "";
        }

        public int getLength() {
            return 0;
        }

        public int getDigit(int pos_i) {
            return 0;
        }

        public void concatRight(Numero right) {
        }

        public void concatLeft(Numero left) {
        }
    }
}
