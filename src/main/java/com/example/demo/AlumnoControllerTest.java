package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AlumnoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AlumnoService alumnoService;

    @InjectMocks
    private AlumnoController alumnoController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(alumnoController).build();
    }

    @Test
    public void testBuscarAlumnoPorClave() throws Exception {
        Alumno alumno = new Alumno();
        alumno.setId(1L);
        alumno.setClave("12345");
        alumno.setNombre("Juan");
        alumno.setApellidos("Perez");

        when(alumnoService.buscarPorClave("12345")).thenReturn(alumno);

        mockMvc.perform(get("/alumnos/buscar/12345")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}