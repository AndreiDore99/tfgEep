package andrei.tfg.Service.Articulos.Cafe;

import andrei.tfg.Model.Articulos.Cafes.Cafe;

import java.util.List;

public interface CafeService {
    abstract List<Cafe> listarTodosCafes();
    abstract Cafe aniadirCafe(Cafe cafeNuevo);
    abstract void borrarCafe(Cafe cafeBorrar);
}
