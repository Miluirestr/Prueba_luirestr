package co.com.bancolombia.model.libros.gateways;

import co.com.bancolombia.model.libros.Libro;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LibroRepository {
    Mono<Libro> guardarLibro(Libro libro);
    Flux<Libro> obtenerTodosLibros();
    Flux<Libro> obtenerPorTitulo(String titulo);
}
