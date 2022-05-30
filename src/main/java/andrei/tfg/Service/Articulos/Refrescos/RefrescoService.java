package andrei.tfg.Service.Articulos.Refrescos;

import andrei.tfg.Model.Articulos.Refrescos.Refresco;

import java.util.List;

public interface RefrescoService {
    abstract List<Refresco> listarRefrescos();
    abstract Refresco aniadirRefresco(Refresco refrescoNuevo);
    abstract void borrarRefresco(Refresco refrescoBorrar);
}
