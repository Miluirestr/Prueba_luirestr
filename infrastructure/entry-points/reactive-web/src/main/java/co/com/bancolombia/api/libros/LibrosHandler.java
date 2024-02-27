package co.com.bancolombia.api.libros;

import co.com.bancolombia.api.common.Respuesta;
import co.com.bancolombia.api.libros.solicitud.SolicitudLibros;
import co.com.bancolombia.model.libros.Libro;
import co.com.bancolombia.usecase.libros.CrearLibroUseCase;
import co.com.bancolombia.usecase.libros.FiltrarLibroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LibrosHandler {
    private final CrearLibroUseCase crearLibroUseCase;
    private final FiltrarLibroUseCase filtrarLibroUseCase;

    public Mono<ServerResponse> crearLibros(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(SolicitudLibros.class)
                .map(solicitudLibros -> Libro.builder()
                        .title(solicitudLibros.getTitle())
                        .subtitle(solicitudLibros.getSubtitle())
                        .descrip(solicitudLibros.getDescrip())
                        .build())
                .flatMap(crearLibroUseCase::crearLibro)
                .flatMap(libro -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(new Respuesta<>(libro, HttpStatus.OK)));
    }

    public Mono<ServerResponse> filtrarLibrosTitulo (ServerRequest serverRequest) {
        final String titulo = serverRequest.queryParam("title").orElse("");
        return filtrarLibroUseCase.obtenerPorTitulo(titulo)
                .collectList()
                .flatMap(libros -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(new Respuesta<>(libros, HttpStatus.OK)));
    }

}
