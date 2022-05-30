package andrei.tfg.Model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {
    @Id
    @GeneratedValue
    @Column(name = "id")
    int id;
    @Column(name = "clave")
    String clave ="YW5kcmVpZG9yZQ==";


    public Usuario(String clave) {
        this.clave= clave;
    }


    public String encriptar(){
        return Base64.getEncoder().encodeToString(clave.getBytes(StandardCharsets.UTF_8));
    }

}
