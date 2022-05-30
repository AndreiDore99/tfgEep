package andrei.tfg.Model.MesaSala;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MesaSala1 {
    @Column(name = "producto")
    String producto;
    @Column(name = "precio")
    float precio;
}
