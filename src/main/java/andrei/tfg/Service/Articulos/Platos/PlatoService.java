package andrei.tfg.Service.Articulos.Platos;

import andrei.tfg.Model.Articulos.Platos.Plato;

import java.util.List;

public interface PlatoService {
    abstract List<Plato> listarTodosPlatos();
    abstract Plato aniadirPlato(Plato platoNuevo);
    abstract void borrarPlato(Plato platoBorrar);
}
