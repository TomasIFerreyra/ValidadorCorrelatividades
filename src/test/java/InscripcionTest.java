package test.java;

import main.java.Alumno;
import main.java.Inscripcion;
import main.java.Materia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class InscripcionTest {

    Materia algoritmos;
    Materia paradigmas;
    Materia diseno;
    Alumno juan;

    @BeforeEach
    public void setUp() {
        algoritmos = new Materia("Algoritmos y Estructuras de Datos");
        paradigmas = new Materia("Paradigmas de Programacion");
        diseno = new Materia("Diseno de Sistemas");

        paradigmas.agregarCorrelativa(algoritmos);
        diseno.agregarCorrelativa(paradigmas);

        juan = new Alumno(123);
    }

    @Test
    public void inscripcionAprobadaConCorrelativasAprobadas() {
        juan.aprobarMateria(algoritmos);
        juan.aprobarMateria(paradigmas);

        Inscripcion inscripcion = new Inscripcion(juan, List.of(diseno));

        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void inscripcionNoAprobadaSiFaltanCorrelativas() {
        juan.aprobarMateria(algoritmos);

        // No puede anotarse a Diseño porque no aprobó Paradigmas
        Inscripcion inscripcion = new Inscripcion(juan, List.of(diseno));

        assertFalse(inscripcion.aprobada());
    }

    @Test
    public void aceptaInscripcionVacia() {
        Inscripcion inscripcion = new Inscripcion(juan, List.of());
        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void inscripcionAprobadaSiMateriaYaFueAprobada() {
        juan.aprobarMateria(algoritmos);
        juan.aprobarMateria(paradigmas);
        juan.aprobarMateria(diseno);

        Inscripcion inscripcion = new Inscripcion(juan, List.of(diseno));
        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void aceptaInscripcionAMateriaSinCorrelativas() {
        Inscripcion inscripcion = new Inscripcion(juan, List.of(algoritmos));
        assertTrue(inscripcion.aprobada());
    }
}
