package andrei.tfg.Service.ServiceImpl.MesaSala;

import andrei.tfg.Model.Articulos.Articulo.Articulo;
import andrei.tfg.Repository.MesaSala.MesaSala1Repository;
import andrei.tfg.Service.MesaSala.MesaSala1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("mesaSala1ServiceImpl")
public class MesaSala1Impl implements MesaSala1Service {
    @Autowired
    @Qualifier("mesaSala1Jpa")
    public MesaSala1Repository mesaJpa;

    @Override
    public List<Articulo> listarProductosMesa() {
        return mesaJpa.findAll();
    }

    @Override
    public void anidirProductoMesa(Articulo articuloMesa) {
        mesaJpa.save(articuloMesa);
    }

    @Override
    public double cobrarMesa() {
        List <Articulo> lista = mesaJpa.findAll();
        int precioCuenta = 0;
        for (Articulo articulo:lista){
            precioCuenta+=articulo.getPrecio();
        }
        return precioCuenta;
    }

    @Override
    public void vaciarMesa() {
        mesaJpa.deleteAll();
    }
}
