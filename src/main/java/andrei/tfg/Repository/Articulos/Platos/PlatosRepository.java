package andrei.tfg.Repository.Articulos.Platos;

import andrei.tfg.Model.Articulos.Platos.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("platoJpa")
public interface PlatosRepository extends JpaRepository<Plato, Serializable> {
    abstract Plato findByNombre(String nombre);
}
