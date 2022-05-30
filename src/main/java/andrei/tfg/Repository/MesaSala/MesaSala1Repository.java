package andrei.tfg.Repository.MesaSala;

import andrei.tfg.Model.MesaSala.MesaSala1;
import org.springframework.stereotype.Repository;

@Repository("mesaSala1Repository")
public interface MesaSala1Repository {
    abstract MesaSala1 buscarPorNombre(String nombre);
}
