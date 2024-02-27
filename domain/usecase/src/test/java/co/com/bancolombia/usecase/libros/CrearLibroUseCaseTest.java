package co.com.bancolombia.usecase.libros;

import co.com.bancolombia.model.libros.Libro;
import co.com.bancolombia.model.libros.gateways.LibroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class CrearLibroUseCaseTest {
    @Mock
    LibroRepository libroRepository;
    @InjectMocks
    CrearLibroUseCase crearLibroUseCase;
    Libro libro;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        libro= Libro.builder()
                .title("Libro1")
                .build();
    }

    @Test
    void crearLibro() {
        when(libroRepository.guardarLibro(any())).thenReturn(Mono.just(libro));//Evita que se ejecute la logica que tiene la función guardar libro
        crearLibroUseCase.crearLibro(libro)
                .as(StepVerifier::create)
                .expectNext(libro)//esperando que devuelva libro
                .verifyComplete();
    }
}