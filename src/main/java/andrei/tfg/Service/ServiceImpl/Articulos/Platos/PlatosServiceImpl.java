package andrei.tfg.Service.ServiceImpl.Articulos.Platos;

import andrei.tfg.Model.Articulos.Articulo.Articulo;
import andrei.tfg.Model.Articulos.Bocadillos.Bocadillos;
import andrei.tfg.Model.Articulos.Platos.Plato;
import andrei.tfg.Repository.Articulos.Articulo.ArticuloRepository;
import andrei.tfg.Repository.Articulos.Platos.PlatosRepository;
import andrei.tfg.Service.Articulos.Platos.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("platosServiceImpl")
public class PlatosServiceImpl implements PlatoService {
    @Autowired
    @Qualifier("platoJpa")
    public PlatosRepository platoJpa;
    @Autowired
    @Qualifier("articuloJpa")
    public ArticuloRepository articuloJpa;

    @Override
    public List<Plato> listarTodosPlatos() {
        return platoJpa.findAll();
    }

    @Override
    public Plato aniadirPlato(Plato platoNuevo) {
        Articulo articuloNuevo = new Articulo(platoNuevo);
        articuloJpa.save(articuloNuevo);
        Plato plato = null;
        List<Articulo> lista = articuloJpa.findAll();
        for (Articulo articulo:lista) {
            if (platoNuevo.getNombre().equals(articulo.getNombre())) {
                plato = new Plato(articulo.getId(), articulo.getNombre(), articulo.getIngredientes(), articulo.getPrecio());
            }
        }
        return platoJpa.save(plato);
    }

    @Override
    public void borrarPlato(Plato platoBorrar) {
        Articulo articuloBorrar = new Articulo(platoBorrar);
        articuloJpa.delete(articuloBorrar);
        platoJpa.delete(platoBorrar);
    }
}
