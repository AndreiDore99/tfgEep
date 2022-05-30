package andrei.tfg.Service.Articulos.Bocadillo;

import andrei.tfg.Model.Articulos.Bocadillos.Bocadillos;

import java.util.List;

public interface BocadilloService {
    abstract List<Bocadillos> listarTodosBocadillos();
    abstract Bocadillos aniadirBocadillo(Bocadillos bocata);
    abstract void borrarBocadillo(Bocadillos bocata);
}
