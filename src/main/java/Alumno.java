package main.java;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private Integer legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(Integer legajo) {
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
    }

    public Boolean tieneAprobada(Materia materia) {
        return materiasAprobadas.contains(materia);
    }

    public void aprobarMateria(Materia materia) {
        materiasAprobadas.add(materia);
    }
}
