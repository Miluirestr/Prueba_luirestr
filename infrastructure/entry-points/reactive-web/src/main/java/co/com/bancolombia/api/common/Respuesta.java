package co.com.bancolombia.api.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data()
@NoArgsConstructor
public class Respuesta<T> {
    private HttpStatus status;
    private T data;

    public Respuesta(T data, HttpStatus status){
        this.data = data;
        this.status = status;
    }
}
