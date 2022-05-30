package andrei.tfg.Service.Articulos.Articulos;

import andrei.tfg.Model.Articulos.Articulo.Articulo;

import java.util.List;

public interface ArticuloService {
    List<Articulo> listarTodosArticulos();
    Articulo aniadirArticulo(Articulo articuloNuevo);
    void borrarArticulo(Articulo articuloBorrar);
}
