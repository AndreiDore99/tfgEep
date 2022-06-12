package andrei.tfg.Service.MesaSala;

import andrei.tfg.Model.Articulos.Articulo.Articulo;

import java.util.List;

public interface MesaSala1Service {
    abstract List<Articulo> listarProductosMesa();
    abstract void anidirProductoMesa(Articulo articuloMesa);
    abstract double cobrarMesa();
    abstract void vaciarMesa();

}
