package andrei.tfg.Repository.MesaSala;

import andrei.tfg.Model.Articulos.Articulo.Articulo;
import andrei.tfg.Model.MesaSala.MesaSala1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("mesaSala1Jpa")
public interface MesaSala1Repository extends JpaRepository<Articulo, Serializable> {
     Articulo findByNombre(String nombre);
}
