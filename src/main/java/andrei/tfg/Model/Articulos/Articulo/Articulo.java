package andrei.tfg.Model.Articulos.Articulo;

import andrei.tfg.Model.Articulos.Bocadillos.Bocadillos;
import andrei.tfg.Model.Articulos.Cafes.Cafe;
import andrei.tfg.Model.Articulos.Platos.Plato;
import andrei.tfg.Model.Articulos.Postres.Postre;
import andrei.tfg.Model.Articulos.Refrescos.Refresco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public  class Articulo {
    @Id
    @GeneratedValue
    @Column(name = "id")
    int id;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "ingredientes")
    String Ingredientes;
    @Column(name = "precio")
    double precio;

    public Articulo(String nombre, String ingredientes, double precio) {
        this.nombre = nombre;
        Ingredientes = ingredientes;
        this.precio = precio;
    }

    public Articulo(Bocadillos bocata) {
        this.nombre= bocata.getNombre();
        this.precio= bocata.getPrecio();
        this.Ingredientes= bocata.getIngredientes();
    }

    public Articulo(Cafe cafeNuevo) {
        this.nombre= cafeNuevo.getNombre();
        this.precio= cafeNuevo.getPrecio();
        this.Ingredientes= cafeNuevo.getIngredientes();
    }

    public Articulo(Plato platoNuevo) {
        this.nombre= platoNuevo.getNombre();
        this.precio= platoNuevo.getPrecio();
        this.Ingredientes= platoNuevo.getIngredientes();
    }

    public Articulo(Postre postreNuevo) {
        this.nombre= postreNuevo.getNombre();
        this.precio= postreNuevo.getPrecio();
        this.Ingredientes= postreNuevo.getIngredientes();
    }

    public Articulo(Refresco refrescoNuevo) {
        this.nombre= refrescoNuevo.getNombre();
        this.precio= refrescoNuevo.getPrecio();
        this.Ingredientes= refrescoNuevo.getIngredientes();
    }

}
