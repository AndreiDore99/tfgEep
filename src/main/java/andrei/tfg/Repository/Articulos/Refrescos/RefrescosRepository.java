package andrei.tfg.Repository.Articulos.Refrescos;

import andrei.tfg.Model.Articulos.Refrescos.Refresco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("refrescoJpa")
public interface RefrescosRepository extends JpaRepository<Refresco, Serializable> {
    abstract Refresco findByNombre(String nombre);
}
