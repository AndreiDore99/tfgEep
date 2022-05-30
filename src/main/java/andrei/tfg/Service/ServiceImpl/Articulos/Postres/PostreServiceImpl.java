package andrei.tfg.Service.ServiceImpl.Articulos.Postres;

import andrei.tfg.Model.Articulos.Articulo.Articulo;
import andrei.tfg.Model.Articulos.Bocadillos.Bocadillos;
import andrei.tfg.Model.Articulos.Postres.Postre;
import andrei.tfg.Repository.Articulos.Articulo.ArticuloRepository;
import andrei.tfg.Repository.Articulos.Postres.PostresRepository;
import andrei.tfg.Service.Articulos.Postre.PostreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("postreServiceImpl")
public class PostreServiceImpl implements PostreService {
    @Autowired
    @Qualifier("postreJpa")
    public PostresRepository postreJpa;
    @Autowired
    @Qualifier("articuloJpa")
    public ArticuloRepository articuloJpa;
    @Override
    public List<Postre> listarTodosPostres() {
        return postreJpa.findAll();
    }

    @Override
    public Postre aniadirPostre(Postre postreNuevo) {
        Articulo articuloNuevo = new Articulo(postreNuevo);
        articuloJpa.save(articuloNuevo);
        Postre postre = null;
        List<Articulo> lista = articuloJpa.findAll();
        for (Articulo articulo:lista){
            if (articulo.getNombre().equals(postreNuevo.getNombre())){
                postre= new Postre(articulo.getId(),articulo.getNombre(),articulo.getIngredientes(),articulo.getPrecio());
            }
        }
        return postreJpa.save(postre);
    }

    @Override
    public void borrarPostre(Postre postreBorrar) {
        Articulo articuloBorrar = new Articulo(postreBorrar);
        articuloJpa.delete(articuloBorrar);
        postreJpa.delete(postreBorrar);
    }
}
