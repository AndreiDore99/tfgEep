package andrei.tfg.Component;

import andrei.tfg.Model.Articulos.Articulo.Articulo;
import andrei.tfg.Model.Articulos.Bocadillos.Bocadillos;
import andrei.tfg.Model.Articulos.Cafes.Cafe;
import andrei.tfg.Model.Articulos.Platos.Plato;
import andrei.tfg.Model.Articulos.Postres.Postre;
import andrei.tfg.Model.Articulos.Refrescos.Refresco;
import andrei.tfg.Service.ServiceImpl.Articulos.Articulo.ArticuloServiceImpl;
import andrei.tfg.Service.ServiceImpl.Articulos.Bocadillo.BocadilloServiceImpl;
import andrei.tfg.Service.ServiceImpl.Articulos.Cafes.CafeServiceImpl;
import andrei.tfg.Service.ServiceImpl.Articulos.Platos.PlatosServiceImpl;
import andrei.tfg.Service.ServiceImpl.Articulos.Postres.PostreServiceImpl;
import andrei.tfg.Service.ServiceImpl.Articulos.Refrescos.RefrescoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Aplicacion implements CommandLineRunner {
    //Mesas que tenemos
    ArrayList<Articulo> mesa1 = new ArrayList<>();
    ArrayList<Articulo> mesa2 = new ArrayList<>();
    ArrayList<Articulo> mesa3 = new ArrayList<>();
    ArrayList<Articulo> mesa4 = new ArrayList<>();
    ArrayList<Articulo> mesa5 = new ArrayList<>();

    ArrayList<Double> ingresos = new ArrayList<>();

    Scanner scannerNumeros = new Scanner(System.in);
    Scanner scannerLetras = new Scanner(System.in);

    //Inyecciones necesarias
    @Autowired
    @Qualifier("articuloServiceImpl")
    public ArticuloServiceImpl articuloJpa;
    @Autowired
    @Qualifier("bocadilloServiceImpl")
    public BocadilloServiceImpl bocataJpa;
    @Autowired
    @Qualifier("cafeServiceImpl")
    public CafeServiceImpl cafeJpa;
    @Autowired
    @Qualifier("platosServiceImpl")
    public PlatosServiceImpl platoJpa;
    @Autowired
    @Qualifier("postreServiceImpl")
    public PostreServiceImpl postreJpa;
    @Autowired
    @Qualifier("refrescoServiceImpl")
    public RefrescoServiceImpl refescoJpa;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("------------------------>Bienvenido al TFG de Andrei<--------------------------");
        do {
            System.out.println("Elige una de las opciones:");

            int opcion =  opciones();
            switch (opcion){
                case 1:
                    verArticulos();
                    ;break;
                case 2:
                     darDeAlta();
                    ;break;
                case 3:
                    borrarProducto();
                    ;break;
                case 4:
                    verMesa();
                    ;break;
                case 5:
                    anadirProductoMesa();
                    ;break;
                case 6:
                    cobrarMesa();
                    ;break;
                case 7:
                    System.out.println("El ingreso esperado de hoy es de "+verIngresosDiarios());
                    ;break;

            }
        }while (true);


    }
    public int opciones(){
        int op = -1;
       do {
           System.out.println();
           System.out.println("1. Ver Carta");
           System.out.println("2. Añadir un producto");
           System.out.println("3. Borrar un producto");
           System.out.println("4. Ver Mesa");
           System.out.println("5. Añadir Producto Mesa");
           System.out.println("6. Cobrar Mesa");
           System.out.println("7. Ver Ingresos Esperados");
           System.out.println("MARQUE CON EL NUMERO LA OPCION QUE DESEE \n");

          op = scannerNumeros.nextInt();
          if (op>7&&op<0){
              System.out.println("Tiene que ser un numero entre 1 y 6 \n");
          }
       }while (op>6&&op<0);
        return op;
    }
    public void verArticulos(){
         List<Articulo> lista =articuloJpa.listarTodosArticulos();
        for (Articulo art:lista) {
            System.out.println(art.getId()+". "+art.getNombre()+"INGREDIENTES:  "+art.getIngredientes()+" PRECIO ---> "+ art.getPrecio());
        }
    }
    public void darDeAlta(){
        System.out.println("Que quieres dar de alta?");
        System.out.println("    1. Bocata");
        System.out.println("    2. Cafe");
        System.out.println("    3. Plato");
        System.out.println("    4. Postre");
        System.out.println("    5. Refresco");
        int opcionPrimera = scannerNumeros.nextInt();

        System.out.println("Nombre del Articulo: ");
        String nombre = scannerLetras.nextLine();
        System.out.println("Ingredientes: ");
        String ingredinetes = scannerLetras.nextLine();
        System.out.println("Precio: ");
        double precio= scannerNumeros.nextDouble();
        switch (opcionPrimera){
            case 1:
                Bocadillos bocadillos = new Bocadillos(nombre,ingredinetes,precio);
                bocataJpa.aniadirBocadillo(bocadillos);
                ;break;
            case 2:
                Cafe cafe = new Cafe(nombre,ingredinetes,precio);
                cafeJpa.aniadirCafe(cafe);
                ;break;
            case 3:
                Plato plato = new Plato(nombre,ingredinetes,precio);
                platoJpa.aniadirPlato(plato);
                ;break;
            case 4:
                Postre postre = new Postre(nombre,ingredinetes,precio);
                postreJpa.aniadirPostre(postre);
                ;break;
            case 5:
                Refresco refresco = new Refresco(nombre,ingredinetes,precio);
                refescoJpa.aniadirRefresco(refresco);
                ;break;
        }
        System.out.println("Articulo añadido con exito!!!!");
        System.out.println();
    }
    public void borrarProducto(){
        verArticulos();
        System.out.println("¿Que Producto quieres Borrar? (Indique con el indentificador)");
        int numero = scannerNumeros.nextInt();
        List<Articulo> lista = articuloJpa.listarTodosArticulos();
        Articulo articuloBorrar = new Articulo();
        for (Articulo art:lista) {
            if (art.getId()==numero){
                articuloBorrar=art;
            }
        }
        articuloJpa.borrarArticulo(articuloBorrar);
    }
    public void verMesa(){
        int opcion = Integer.MAX_VALUE;
      do {
          System.out.println("¿Que mesa es la que deseas ver?");
          System.out.println("    1. Mesa 1 ");
          System.out.println("    2. Mesa 2");
          System.out.println("    3. Mesa 3");
          System.out.println("    4. Mesa 4");
          System.out.println("    5. Mesa 5");
          System.out.println();
          opcion= scannerNumeros.nextInt();
      }while (opcion<0&&opcion>6);
      switch (opcion){
          case 1:
              double cuenta= 0;
              for (Articulo a:mesa1) {
                  System.out.println("Procuto: "+a.getNombre()+"-- Precio: "+a.getPrecio());
                  cuenta=cuenta+a.getPrecio();
              }
              System.out.println("      Total: "+cuenta+" Euros");
          case 2:
              double cuenta2= 0;
              for (Articulo a:mesa1) {
                  System.out.println("Procuto: "+a.getNombre()+"-- Precio: "+a.getPrecio());
                  cuenta2=cuenta2+a.getPrecio();
              }
              System.out.println("      Total: "+cuenta2+" Euros");
      }
    }
    public void anadirProductoMesa(){
        int opcion = Integer.MAX_VALUE;
        do {
            System.out.println("¿En que mesa quieres añadir un producto?");
            System.out.println("    1. Mesa 1 ");
            System.out.println("    2. Mesa 2");
            System.out.println("    3. Mesa 3");
            System.out.println("    4. Mesa 4");
            System.out.println("    5. Mesa 5");
            System.out.println();
            opcion= scannerNumeros.nextInt();
        }while (opcion<0&&opcion>6);
        switch (opcion){
            case 1:
                int opcion2= Integer.MAX_VALUE;
                do {
                    System.out.println("Que es lo que quieres agregar a la mesa?");
                    System.out.println("    1. Bocata");
                    System.out.println("    2. Cafe");
                    System.out.println("    3. Plato");
                    System.out.println("    4. Postre");
                    System.out.println("    5. Refresco");
                    opcion2= scannerNumeros.nextInt();
                }while(opcion2<0&&opcion2>6);

                switch (opcion2) {
                    case 1:
                        int pedido =0;
                        List<Bocadillos> listaBocadillos = bocataJpa.listarTodosBocadillos();
                        for (Bocadillos bocata : listaBocadillos) {
                            System.out.println("Codigo : " + bocata.getId() + "-- " + bocata.getNombre() + " PRECIO: " + bocata.getPrecio() + " euros");
                        }
                        System.out.println("Ponga el codigo del producto: ");
                        pedido = scannerNumeros.nextInt();
                        for (Bocadillos bocata : listaBocadillos) {
                            if (bocata.getId() == pedido) {
                                Articulo articulo = new Articulo(bocata);
                                mesa1.add(articulo);
                            }
                        }
                        ;
                        break;
                    case 2:
                        List<Cafe> listaCafe = cafeJpa.listarTodosCafes();
                        for (Cafe cafe : listaCafe) {
                            System.out.println("Codigo : " + cafe.getId() + "-- " + cafe.getNombre() + " PRECIO: " + cafe.getPrecio() + " euros");
                        }
                        System.out.println("Ponga el codigo del producto: ");
                        pedido = scannerNumeros.nextInt();
                        for (Cafe cafe : listaCafe) {
                            if (cafe.getId() == pedido) {
                                Articulo articulo = new Articulo(cafe);
                                mesa1.add(articulo);
                            }
                        }
                        ;
                        break;
                    case 3:
                        List<Plato> listaPlatos = platoJpa.listarTodosPlatos();
                        for (Plato plato : listaPlatos) {
                            System.out.println("Codigo : " + plato.getId() + "-- " + plato.getNombre() + " PRECIO: " + plato.getPrecio() + " euros");
                        }
                        System.out.println("Ponga el codigo del producto: ");
                        pedido = scannerNumeros.nextInt();
                        for (Plato plato : listaPlatos) {
                            if (plato.getId() == pedido) {
                                Articulo articulo = new Articulo(plato);
                                mesa1.add(articulo);
                            }
                        }
                        ;
                        break;
                    case 4:
                        List<Postre> listaPostres = postreJpa.listarTodosPostres();
                        for (Postre postre : listaPostres) {
                            System.out.println("Codigo : " + postre.getId() + "-- " + postre.getNombre() + " PRECIO: " + postre.getPrecio() + " euros");
                        }
                        System.out.println("Ponga el codigo del producto: ");
                        pedido = scannerNumeros.nextInt();
                        for (Postre postre : listaPostres) {
                            if (postre.getId() == pedido) {
                                Articulo articulo = new Articulo(postre);
                                mesa1.add(articulo);
                            }
                        }
                        ;
                        break;
                    case 5:
                        List<Refresco> listaRefrescos = refescoJpa.listarRefrescos();
                        for (Refresco refresco : listaRefrescos) {
                            System.out.println("Codigo : " + refresco.getId() + "-- " + refresco.getNombre() + " PRECIO: " + refresco.getPrecio() + " euros");
                        }
                        System.out.println("Ponga el codigo del producto: ");
                        pedido = scannerNumeros.nextInt();
                        for (Refresco refresco : listaRefrescos) {
                            if (refresco.getId() == pedido) {
                                Articulo articulo = new Articulo(refresco);
                                mesa1.add(articulo);
                            }
                        }
                        ;
                        break;
                }
        }
    }
    public void cobrarMesa(){
        int opcionMesa =0;
        double cuenta =0;
        System.out.println("¿Que mesa quieres cobrar?");
        System.out.println("    1. Mesa 1 ");
        System.out.println("    2. Mesa 2");
        System.out.println("    3. Mesa 3");
        System.out.println("    4. Mesa 4");
        System.out.println("    5. Mesa 5");
        System.out.println();
        opcionMesa= scannerNumeros.nextInt();
        switch (opcionMesa){
            case 1:
                for (Articulo articulo:mesa1) {
                    cuenta = cuenta+articulo.getPrecio();
                }
                ingresos.add(cuenta);
                ;break;
            case 2:
                for (Articulo articulo:mesa2) {
                    cuenta = cuenta+articulo.getPrecio();
                }
                ingresos.add(cuenta);
                ;break;
            case 3:
                for (Articulo articulo:mesa3) {
                    cuenta = cuenta+articulo.getPrecio();
                }
                ingresos.add(cuenta);
                ;break;
            case 4:
                for (Articulo articulo:mesa4) {
                    cuenta = cuenta+articulo.getPrecio();
                }
                ingresos.add(cuenta);
                ;break;
            case 5:
                for (Articulo articulo:mesa5) {
                    cuenta = cuenta+articulo.getPrecio();
                }
                ingresos.add(cuenta);
                ;break;
        }

    }
    public double verIngresosDiarios(){
        double diario = 0;
        for (Double n:ingresos) {
            diario=+n;
        }
        return diario;
    }


}
