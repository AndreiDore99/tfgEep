package andrei.tfg.Service.ServiceImpl.Articulos.Cafes;

import andrei.tfg.Model.Articulos.Articulo.Articulo;
import andrei.tfg.Model.Articulos.Cafes.Cafe;
import andrei.tfg.Repository.Articulos.Articulo.ArticuloRepository;
import andrei.tfg.Repository.Articulos.Cafes.CafeRepository;
import andrei.tfg.Service.Articulos.Cafe.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cafeServiceImpl")
public class CafeServiceImpl implements CafeService {
    @Autowired
    @Qualifier("cafeJpa")
    public CafeRepository cafeJpa;
    @Autowired
    @Qualifier("articuloJpa")
    public ArticuloRepository articuloJpa;

    @Override
    public List<Cafe> listarTodosCafes() {
        return cafeJpa.findAll();
    }

    @Override
    public Cafe aniadirCafe(Cafe cafeNuevo) {
        Articulo articuloNuevo= new Articulo(cafeNuevo);
        articuloJpa.save(articuloNuevo);
        List<Articulo> lista=articuloJpa.findAll();
        Cafe cafe = null;
        for (Articulo articulo:lista) {
            if (cafeNuevo.getNombre().equals(articulo.getNombre())){
                cafe= new Cafe(articulo.getId(),articulo.getNombre(),articulo.getIngredientes(),articulo.getPrecio());
            }
        }
        return cafeJpa.save(cafe);
    }

    @Override
    public void borrarCafe(Cafe cafeBorrar) {
        Articulo articuloBorrar = new Articulo(cafeBorrar);
        articuloJpa.delete(articuloBorrar);
        cafeJpa.delete(cafeBorrar);
    }
}
