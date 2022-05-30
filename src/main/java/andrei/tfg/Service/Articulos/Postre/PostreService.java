package andrei.tfg.Service.Articulos.Postre;

import andrei.tfg.Model.Articulos.Postres.Postre;

import java.util.List;

public interface PostreService {
    abstract List<Postre> listarTodosPostres();
    abstract Postre aniadirPostre(Postre postreNuevo);
    abstract void borrarPostre(Postre postreBorrar);
}
