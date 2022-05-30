package andrei.tfg.Repository.Articulos.Postres;

import andrei.tfg.Model.Articulos.Postres.Postre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("postreJpa")
public interface PostresRepository extends JpaRepository<Postre, Serializable> {
    abstract Postre findByNombre(String nombre);
}
