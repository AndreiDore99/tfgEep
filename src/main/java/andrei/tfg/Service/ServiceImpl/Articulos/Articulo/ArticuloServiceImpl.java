package andrei.tfg.Service.ServiceImpl.Articulos.Articulo;

import andrei.tfg.Model.Articulos.Articulo.Articulo;
import andrei.tfg.Repository.Articulos.Articulo.ArticuloRepository;
import andrei.tfg.Service.Articulos.Articulos.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articuloServiceImpl")
public class ArticuloServiceImpl implements ArticuloService {
    @Autowired
    @Qualifier("articuloJpa")
    public ArticuloRepository articuloJpa;


    @Override
    public List<Articulo> listarTodosArticulos() {
        return articuloJpa.findAll();
    }

    @Override
    public Articulo aniadirArticulo(Articulo articuloNuevo) {
        return articuloJpa.save(articuloNuevo);
    }

    @Override
    public void borrarArticulo(Articulo articuloBorrar) {
        articuloJpa.delete(articuloBorrar);
    }
}
