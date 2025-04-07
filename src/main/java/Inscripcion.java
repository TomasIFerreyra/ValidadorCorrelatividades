package main.java;

import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materiasSolicitadas;

    public Inscripcion(Alumno alumno, List<Materia> materiasSolicitadas) {
        this.alumno = alumno;
        this.materiasSolicitadas = materiasSolicitadas;
    }

    public Boolean aprobada() {
        return materiasSolicitadas.stream().allMatch(materia -> materia.correlativasAprobadas(alumno));
    }
}
