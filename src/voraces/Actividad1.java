package voraces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problema. El I.E.S. Almudena Grandes necesita crear los nuevos grupos de alumnos de
 * 1º de la ESO. Para ello debe distribuir un grupo desordenado de N nuevos estudiantes,
 * que provienen de diferentes centros escolares de la zona, en grupos de un tamaño
 * máximo de L alumnos/grupo (numMaxAlumnos). De cada estudiante se dispone del
 * nombre y apellidos, el género (femenino/masculino) y su nota media (expresada como un
 * número entero entre el 5 y el 10). Se desea implementar un algoritmo, basado en una
 * estrategia voraz, que permita crear los nuevos grupos de alumnos, de forma que tengan
 * una nota media de grupo lo más parecida posible.
 * <br><br>
 * Implementar el método MezclaEstudiantes así como los métodos auxiliares que se
 * consideren necesarios.
 */

public class Actividad1 {
    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        Estudiante estudiante = new Estudiante();
        estudiante.nota = 5;
        estudiantes.add(estudiante);

        estudiante = new Estudiante();
        estudiante.nota = 3;
        estudiantes.add(estudiante);

        estudiante = new Estudiante();
        estudiante.nota = 10;
        estudiantes.add(estudiante);

        estudiante = new Estudiante();
        estudiante.nota = 1;
        estudiantes.add(estudiante);

        System.out.println(estudiantes);
        System.out.println(mezclaEstudiantes(estudiantes, 0));
    }

    public static ArrayList<Grupo> mezclaEstudiantes(ArrayList<Estudiante> listaEst, int numMaxAlumnos) {
        Map<Grupo, Double> grupos = generarGrupos(listaEst.size(), numMaxAlumnos);

        boolean bandera = true;
        while (!listaEst.isEmpty() && bandera) {
            Estudiante estudiante = seleccionarEstudianteMayorNota(listaEst);
            Grupo grupo = seleccionarGrupoMenorNota(grupos); //Seleccionar ya se encarga de q el grupo sea valido. Si no hay ninguno valido devuelve nulo y no hay forma de hacer el reparto.

            if (grupo == null) {
                bandera = false;
            } else {
                grupo.aniadeAlumno(estudiante);
                grupos.put(grupo, grupos.get(grupo) + estudiante.nota);

                listaEst.remove(estudiante);
            }
        }

        return bandera ? new ArrayList<>(grupos.keySet()) : null;
    }

    private static Map<Grupo, Double> generarGrupos(int numAlumnos, int maxAlumnosPorGrupo) {
        Map<Grupo, Double> grupos = new HashMap<>(); //Grupo, sumatorioNotas

        if (maxAlumnosPorGrupo == 0) return grupos;
        int numGrupos = numAlumnos / maxAlumnosPorGrupo;
        if (numAlumnos % maxAlumnosPorGrupo != 0) numGrupos++;

        for (int i = 0; i < numGrupos; i++) {
            grupos.put(new Grupo(maxAlumnosPorGrupo), 0d);
        }

        return grupos;
    }

    private static Estudiante seleccionarEstudianteMayorNota(List<Estudiante> estudiantes) {
        double mayorNota = Double.MIN_VALUE;
        Estudiante seleccion = null;

        for (Estudiante estudiante : estudiantes) {
            if (seleccion == null || estudiante.nota > mayorNota) {
                seleccion = estudiante;
                mayorNota = estudiante.nota;
            }
        }

        return seleccion;
    }

    private static Grupo seleccionarGrupoMenorNota(Map<Grupo, Double> grupos) {
        Double minNota = Double.MAX_VALUE;
        Grupo seleccion = null;

        for (Map.Entry<Grupo, Double> grupo : grupos.entrySet()) if (grupo.getKey().getAlumnosRestantes() > 0) {
            if (seleccion == null || grupo.getValue() < minNota) {
                seleccion = grupo.getKey();
                minNota = grupo.getValue();
            }
        }

        return seleccion;
    }

    public static class Estudiante {
        private String nombre, apellidos;
        private double nota;

        @Override
        public String toString() {
            return "Estudiante{" +
                    "nota=" + nota +
                    '}';
        }
    }

    public static class Grupo {

        private ArrayList<Estudiante> alumnos;
        private int maxAlumnos;

        public Grupo(int maxAlumnos){
            alumnos = new ArrayList<Estudiante>();
            this.maxAlumnos = maxAlumnos;
        }
        public Grupo(ArrayList<Estudiante> lista, int maxAlumnos){
            alumnos = new ArrayList<Estudiante>(lista);
            this.maxAlumnos = maxAlumnos;
        }

        public int getAlumnosRestantes(){ return maxAlumnos-alumnos.size();}
        public void aniadeAlumno(Estudiante e){ alumnos.add(e);}

        @Override
        public String toString() {
            return "Grupo{" +
                    "alumnos=" + alumnos +
                    ", maxAlumnos=" + maxAlumnos +
                    '}';
        }
    }
}
