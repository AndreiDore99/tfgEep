package andrei.tfg.Service.ServiceImpl;

import andrei.tfg.Model.Articulos.Articulo.Articulo;
import andrei.tfg.Model.Articulos.Bocadillos.Bocadillos;
import andrei.tfg.Model.Articulos.Cafes.Cafe;
import andrei.tfg.Model.Articulos.Platos.Plato;
import andrei.tfg.Model.Articulos.Postres.Postre;
import andrei.tfg.Model.Articulos.Refrescos.Refresco;
import andrei.tfg.Service.Articulos.Articulos.ArticuloService;
import andrei.tfg.Service.ServiceImpl.Articulos.Articulo.ArticuloServiceImpl;
import andrei.tfg.Service.ServiceImpl.Articulos.Bocadillo.BocadilloServiceImpl;
import andrei.tfg.Service.ServiceImpl.Articulos.Cafes.CafeServiceImpl;
import andrei.tfg.Service.ServiceImpl.Articulos.Platos.PlatosServiceImpl;
import andrei.tfg.Service.ServiceImpl.Articulos.Postres.PostreServiceImpl;
import andrei.tfg.Service.ServiceImpl.Articulos.Refrescos.RefrescoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("plantilla")
public class Plantilla implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Articulo> lista = artService.listarTodosArticulos();
        if (lista.size()==0){
            this.darDeAltaCarta();
        }

    }
    @Autowired
    @Qualifier("articuloServiceImpl")
    ArticuloServiceImpl artService;
    @Autowired
    @Qualifier("postreServiceImpl")
    public PostreServiceImpl postreService;
    @Autowired
    @Qualifier("refrescoServiceImpl")
    public RefrescoServiceImpl refrescoService;
    @Autowired
    @Qualifier("platosServiceImpl")
    public PlatosServiceImpl platoService;
    @Autowired
    @Qualifier("cafeServiceImpl")
    public CafeServiceImpl cafeService;
    @Autowired
    @Qualifier("bocadilloServiceImpl")
    public BocadilloServiceImpl bocadilloService;


    public void darDeAltaCarta() {
        ArrayList<Bocadillos> listaBocatas = new ArrayList<>();
        ArrayList<Cafe> listaCafes = new ArrayList<>();
        ArrayList<Plato> listaPlatos = new ArrayList<>();
        ArrayList<Postre> listaPostres = new ArrayList<>();
        ArrayList<Refresco> listaRefrescos = new ArrayList<>();
        listaBocatas.add(new Bocadillos("Bocadillo de Sepia","Pan,Sepia",6)) ;
        listaBocatas.add(new Bocadillos("Bocadillo de Calamares","Pan,Calamares,Limon",8));
        listaBocatas.add(new Bocadillos("Bocadillo de Lomo","Pan,Lomo,Queso",7)) ;
        listaBocatas.add(new Bocadillos("Bocadillo de Queso","Pan,Queso Chedar",6)) ;
        listaBocatas.add(new Bocadillos("Bocadillo de Brascada","Pan,Ternera,Cebolla Frita y Jamon Serrno",12)) ;
        listaCafes.add(new Cafe("Café solo","",1.50));
        listaCafes.add(new Cafe("Café Americano","",1.50));
        listaCafes.add(new Cafe("Carajillo","",2));
        listaCafes.add(new Cafe("Bombón Tocado de Whisky","",2.25));
        listaCafes.add(new Cafe("Capuchino","",2));
        listaPlatos.add(new Plato("Emperador a la plancha","Filete de pez espada uqe se acompaña con una guarnicion de ensalada valenciana y huevo frito",14));
        listaPlatos.add(new Plato("Oreja","Oreja de cerdo a la plancha",13));
        listaPlatos.add(new Plato("Chuleton a la Parrilla","Chuleton de PEZ!!!!",89));
        listaPlatos.add(new Plato("Paella 4 pers.","Arroz, gambas, lechuga",45));
        listaPlatos.add(new Plato("Sopa du Macaco.","",11));
        listaPlatos.add(new Plato("Arroz con gobante","",20.5));
        listaPostres.add(new Postre("Tarta de Chocolate","",2));
        listaPostres.add(new Postre("Brownie","",2.3));
        listaPostres.add(new Postre("Flan","",1.95));
        listaPostres.add(new Postre("Cupcake","",1.75));
        listaPostres.add(new Postre("Sandia","",2.99));
        listaRefrescos.add(new Refresco("Coca Cola","",2.55));
        listaRefrescos.add(new Refresco("Coca Cola Zero","",2.55));
        listaRefrescos.add(new Refresco("Fanta Naranja","",2.55));
        listaRefrescos.add(new Refresco("Fanta Limon","",2.55));
        listaRefrescos.add(new Refresco("Aquarius Naranja","",2.55));
        listaRefrescos.add(new Refresco("Aquarius Limon","",2.55));
        listaRefrescos.add(new Refresco("Nestea","",2.55));
        listaRefrescos.add(new Refresco("Agua","",1.50));
        for (Bocadillos bocata:listaBocatas) {
            bocadilloService.aniadirBocadillo(bocata);
        }
        for(Cafe cafe:listaCafes){
            cafeService.aniadirCafe(cafe);
        }
        for (Plato plato: listaPlatos){
            platoService.aniadirPlato(plato);
        }
        for (Postre postre:listaPostres){
            postreService.aniadirPostre(postre);
        }
        for (Refresco refresco : listaRefrescos){
            refrescoService.aniadirRefresco(refresco);
        }
    }




}
