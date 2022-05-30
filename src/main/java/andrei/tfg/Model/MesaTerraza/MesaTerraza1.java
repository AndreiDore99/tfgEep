package andrei.tfg.Model.MesaTerraza;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MesaTerraza1 {
    @Column(name = "producto")
    String producto;
    @Column(name = "precio")
    float precio;
}
