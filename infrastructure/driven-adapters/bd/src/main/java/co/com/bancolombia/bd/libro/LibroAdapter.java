package co.com.bancolombia.bd.libro;


import co.com.bancolombia.model.libros.Libro;
import co.com.bancolombia.model.libros.gateways.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class LibroAdapter implements LibroRepository {

    private final List<Libro> baseDeDatos = new ArrayList<>();

    @Override
    public Mono<Libro> guardarLibro(Libro libro) {
        baseDeDatos.add(libro);
        return Mono.just(libro);
    }

    @Override
    public Flux<Libro> obtenerTodosLibros() {
        return Flux.fromIterable(baseDeDatos);
    }

    @Override
    public Flux<Libro> obtenerPorTitulo(String titulo) {
        List<Libro> filteredBooks = baseDeDatos.stream()
                .filter(libro -> libro.getTitle().toLowerCase().contains(titulo.toLowerCase()) )
                .collect(Collectors.toList());
        return Flux.fromIterable(filteredBooks);
    }

  }
