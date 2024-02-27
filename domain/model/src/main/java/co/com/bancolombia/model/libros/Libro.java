package co.com.bancolombia.model.libros;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder(toBuilder = true)
@Data
public class Libro {
    private Long idLibro;
    private String title;
    private String subtitle;
    private BigDecimal price;
    private String imageUrl;
    private String libroUrl;
    private Autor autorLibro;
    private String editorial;
    private Integer pages;
    private Integer year;
    private String descrip;
    private Double rating;
}
