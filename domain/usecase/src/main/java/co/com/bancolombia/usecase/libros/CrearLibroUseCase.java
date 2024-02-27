package co.com.bancolombia.usecase.libros;

import co.com.bancolombia.model.libros.Libro;
import co.com.bancolombia.model.libros.gateways.LibroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearLibroUseCase {
    private final LibroRepository libroRepository;

    public Mono<Libro> crearLibro(Libro libro){
        return libroRepository.guardarLibro(libro);
    }
}
