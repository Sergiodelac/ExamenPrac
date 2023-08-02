package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Test
public void testGuardarAlumno() {
    Alumno alumno = new Alumno();
    alumno.setClave("12345");
    alumno.setNombre("Sergio");
    alumno.setApellidos("De la Cruz");

    alumnoRepository.save(alumno);

    assertNotNull(alumno.getId());
}

@Test
public void testBuscarAlumnoPorClave() {
    Alumno alumno = new Alumno();
    alumno.setClave("12345");
    alumno.setNombre("Sergio");
    alumno.setApellidos("De la Cruz");

    alumnoRepository.save(alumno);

    Alumno alumnoEncontrado = alumnoRepository.findByClave("12345");

    assertNotNull(alumnoEncontrado);
    assertEquals("Sergio", alumnoEncontrado.getNombre());
}
