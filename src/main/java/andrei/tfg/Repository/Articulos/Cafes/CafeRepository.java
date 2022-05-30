package andrei.tfg.Repository.Articulos.Cafes;

import andrei.tfg.Model.Articulos.Cafes.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("cafeJpa")
public interface CafeRepository extends JpaRepository<Cafe, Serializable> {
    abstract Cafe findByNombre(String nombre);
}
