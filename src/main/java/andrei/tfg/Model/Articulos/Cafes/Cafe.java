package andrei.tfg.Model.Articulos.Cafes;

import andrei.tfg.Model.Articulos.Articulo.Articulo;
import andrei.tfg.Model.Articulos.Bocadillos.Bocadillos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cafes")
public class Cafe {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "ingredientes")
    String Ingredientes;
    @Column(name = "precio")
    double precio;

    public Cafe(String nombre, String ingredientes, double precio) {
        this.nombre = nombre;
        Ingredientes = ingredientes;
        this.precio = precio;
    }
    public Articulo cambiarEntidad(Cafe cafe){
        return new Articulo(cafe.getId(),cafe.getNombre(), cafe.getIngredientes(), cafe.getPrecio());
    }
}
