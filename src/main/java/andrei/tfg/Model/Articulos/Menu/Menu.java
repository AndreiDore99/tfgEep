package andrei.tfg.Model.Articulos.Menu;

import andrei.tfg.Model.Articulos.Platos.Plato;
import andrei.tfg.Model.Articulos.Postres.Postre;
import andrei.tfg.Model.Articulos.Refrescos.Refresco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Menu {
    Plato primerPlato;
    Plato segundoPlato;
    Refresco bebida;
    Postre postre;
    double precio = 10.00;
}
