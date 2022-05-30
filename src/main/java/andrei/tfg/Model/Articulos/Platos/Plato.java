package andrei.tfg.Model.Articulos.Platos;

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
@Table(name = "Platos")
public class Plato{
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "ingredientes")
    String Ingredientes;
    @Column(name = "precio")
    double precio;

    public Plato(String nombre, String ingredientes, double precio) {
        this.nombre = nombre;
        Ingredientes = ingredientes;
        this.precio = precio;
    }
    public Articulo cambiarEntidad(Plato plato){
        return new Articulo(plato.getId(),plato.getNombre(), plato.getIngredientes(), plato.getPrecio());
    }
}
