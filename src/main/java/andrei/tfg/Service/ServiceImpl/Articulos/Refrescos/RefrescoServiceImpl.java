package andrei.tfg.Service.ServiceImpl.Articulos.Refrescos;

import andrei.tfg.Model.Articulos.Articulo.Articulo;
import andrei.tfg.Model.Articulos.Cafes.Cafe;
import andrei.tfg.Model.Articulos.Refrescos.Refresco;
import andrei.tfg.Repository.Articulos.Articulo.ArticuloRepository;
import andrei.tfg.Repository.Articulos.Refrescos.RefrescosRepository;
import andrei.tfg.Service.Articulos.Refrescos.RefrescoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("refrescoServiceImpl")
public class RefrescoServiceImpl implements RefrescoService {
    @Autowired
    @Qualifier("refrescoJpa")
    public RefrescosRepository refrescoJpa;
    @Autowired
    @Qualifier("articuloJpa")
    public ArticuloRepository articuloJpa;
    @Override
    public List<Refresco> listarRefrescos() {
        return refrescoJpa.findAll();
    }

    @Override
    public Refresco aniadirRefresco(Refresco refrescoNuevo) {
        Articulo articuloNuevo= new Articulo(refrescoNuevo);
        articuloJpa.save(articuloNuevo);
        List<Articulo> lista=articuloJpa.findAll();
        Refresco refresco = null;
        for (Articulo articulo:lista) {
            if (refrescoNuevo.getNombre().equals(articulo.getNombre())){
                refresco= new Refresco(articulo.getId(),articulo.getNombre(),articulo.getIngredientes(),articulo.getPrecio());
            }
        }
        return refrescoJpa.save(refresco);
    }

    @Override
    public void borrarRefresco(Refresco refrescoBorrar) {
        Articulo articuloBorrar = new Articulo(refrescoBorrar);
        articuloJpa.delete(articuloBorrar);
        refrescoJpa.delete(refrescoBorrar);
    }
}
