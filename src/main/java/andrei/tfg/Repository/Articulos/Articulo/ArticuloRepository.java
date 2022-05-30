package andrei.tfg.Repository.Articulos.Articulo;

import andrei.tfg.Model.Articulos.Articulo.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.util.concurrent.ListenableFuture;

import java.io.Serializable;
import java.util.Optional;

@Repository("articuloJpa")
public interface ArticuloRepository extends JpaRepository<Articulo, Serializable> {
    Articulo findByNombre(String nombre);

}
