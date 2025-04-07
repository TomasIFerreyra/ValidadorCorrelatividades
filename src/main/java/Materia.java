package main.java;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }

    public Boolean correlativasAprobadas(Alumno alumno) {
        return correlativas.stream().allMatch(alumno::tieneAprobada);
    }
    public void agregarCorrelativa(Materia materia) {
        correlativas.add(materia);
    }
}
