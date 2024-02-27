package co.com.bancolombia.api.libros.solicitud;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SolicitudLibros {
    Long idLibro;
    String title;
    String subtitle;
    BigDecimal price;
    String imageUrl;
    String libroUrl;
    SolicitudAutorLibro autorLibro;
    String editorial;
    Integer pages;
    Integer year;
    String descrip;
    Double rating;
}



