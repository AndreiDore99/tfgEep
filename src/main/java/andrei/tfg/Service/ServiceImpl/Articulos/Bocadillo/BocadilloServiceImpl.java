package andrei.tfg.Service.ServiceImpl.Articulos.Bocadillo;

import andrei.tfg.Model.Articulos.Articulo.Articulo;
import andrei.tfg.Model.Articulos.Bocadillos.Bocadillos;
import andrei.tfg.Repository.Articulos.Articulo.ArticuloRepository;
import andrei.tfg.Repository.Articulos.Bocadillo.BocadilloRepository;
import andrei.tfg.Service.Articulos.Bocadillo.BocadilloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bocadilloServiceImpl")
public class BocadilloServiceImpl implements BocadilloService {
    @Autowired
    @Qualifier("bocadilloJpa")
    public BocadilloRepository bocadilloJpa;
    @Autowired
    @Qualifier("articuloJpa")
    public ArticuloRepository articuloJpa;


    @Override
    public List<Bocadillos> listarTodosBocadillos() {
        return bocadilloJpa.findAll();
    }

    @Override
    public Bocadillos aniadirBocadillo(Bocadillos bocata) {
        Articulo articuloNuevo= new Articulo(bocata);
        articuloJpa.save(articuloNuevo);
        List<Articulo> lista=articuloJpa.findAll();
        Bocadillos bocataNuevo = null;
        for (Articulo articulo:lista) {
            if (bocata.getNombre().equals(articulo.getNombre())){
                bocataNuevo= new Bocadillos(articulo.getId(),articulo.getNombre(),articulo.getIngredientes(),articulo.getPrecio());
            }
        }
        return bocadilloJpa.save(bocataNuevo);
    }

    @Override
    public void borrarBocadillo(Bocadillos bocata) {
        Articulo articuloBorrar = new Articulo(bocata);
        articuloJpa.delete(articuloBorrar);
        bocadilloJpa.delete(bocata);
    }
}
