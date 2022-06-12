package andrei.tfg.Model.MesaSala;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MesaSala1 {
    @Id
    @Column(name = "producto")
    String producto;
    @Column(name = "precio")
    float precio;
}
