package andrei.tfg.Model.Articulos.Bocadillos;

import andrei.tfg.Model.Articulos.Articulo.Articulo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Bocadillos")
public class Bocadillos {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "ingredientes")
    String Ingredientes;
    @Column(name = "precio")
    double precio;

    public Bocadillos(String nombre, String ingredientes, double precio) {
        this.nombre = nombre;
        Ingredientes = ingredientes;
        this.precio = precio;
    }
    public Articulo cambiarEntidad(Bocadillos bocadillos){
        return new Articulo(bocadillos.getId(),bocadillos.getNombre(), bocadillos.getIngredientes(), bocadillos.getPrecio());
    }
}
