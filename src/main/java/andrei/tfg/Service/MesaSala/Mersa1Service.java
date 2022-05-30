package andrei.tfg.Service.MesaSala;

import andrei.tfg.Model.Articulos.Articulo.Articulo;

import java.util.List;

public interface Mersa1Service {
    abstract List<Articulo> listarProductosMesa();
    abstract double cobrarMesa(List<Articulo> cuenta);
    abstract void vaciarMesa();
}
