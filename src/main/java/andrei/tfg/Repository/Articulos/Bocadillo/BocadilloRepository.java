package andrei.tfg.Repository.Articulos.Bocadillo;

import andrei.tfg.Model.Articulos.Bocadillos.Bocadillos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("bocadilloJpa")
public interface BocadilloRepository extends JpaRepository<Bocadillos, Serializable> {
    Bocadillos findByNombre(String nombre);

}
