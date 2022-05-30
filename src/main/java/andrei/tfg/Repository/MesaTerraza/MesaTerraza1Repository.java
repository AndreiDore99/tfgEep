package andrei.tfg.Repository.MesaTerraza;

import andrei.tfg.Model.MesaSala.MesaSala1;
import andrei.tfg.Model.MesaTerraza.MesaTerraza1;
import org.springframework.stereotype.Repository;

@Repository("mesaTerraza1Repository")
public interface MesaTerraza1Repository {
    abstract MesaTerraza1 buscarPorNombre(String nombre);
}
