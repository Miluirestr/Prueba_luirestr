package co.com.bancolombia.usecase.libros;

import co.com.bancolombia.model.libros.Libro;
import co.com.bancolombia.model.libros.gateways.LibroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FiltrarLibroUseCase {
    private final LibroRepository libroRepository;

    public Flux<Libro> obtenerPorTitulo (String titulo){
        return libroRepository.obtenerPorTitulo(titulo);
    }
}
