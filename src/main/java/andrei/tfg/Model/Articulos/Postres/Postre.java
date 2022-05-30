package andrei.tfg.Model.Articulos.Postres;

import andrei.tfg.Model.Articulos.Articulo.Articulo;
import andrei.tfg.Model.Articulos.Bocadillos.Bocadillos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Postres")
@NoArgsConstructor
public class Postre {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "ingredientes")
    String Ingredientes;
    @Column(name = "precio")
    double precio;

    public Postre(String nombre, String ingredientes, double precio) {
        this.nombre = nombre;
        Ingredientes = ingredientes;
        this.precio = precio;
    }
    public Articulo cambiarEntidad(Postre postre){
        return new Articulo(postre.getId(),postre.getNombre(), postre.getIngredientes(), postre.getPrecio());
    }
}

