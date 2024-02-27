package co.com.bancolombia.api.libros;

import co.com.bancolombia.api.Handler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class LibrosRouterRest {
    @Bean
    public RouterFunction<ServerResponse> librosRouterFunction(LibrosHandler handler) {

        return route(POST("/api/libros"), handler::crearLibros)
                .andRoute(GET("/api/libros/filtrarTitulos"), handler::filtrarLibrosTitulo);

    }

}
