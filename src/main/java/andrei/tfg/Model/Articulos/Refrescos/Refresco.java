package andrei.tfg.Model.Articulos.Refrescos;

import andrei.tfg.Model.Articulos.Articulo.Articulo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Refrescos")
public class Refresco {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "ingredientes")
    String Ingredientes;
    @Column(name = "precio")
    double precio;

    public Refresco(String nombre, String ingredientes, double precio) {
        this.nombre = nombre;
        Ingredientes = ingredientes;
        this.precio = precio;
    }
    public Articulo cambiarEntidad(Refresco refresco){
        return new Articulo(refresco.getId(),refresco.getNombre(), refresco.getIngredientes(), refresco.getPrecio());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return Ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        Ingredientes = ingredientes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
