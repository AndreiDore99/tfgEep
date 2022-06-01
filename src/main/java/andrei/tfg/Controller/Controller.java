package andrei.tfg.Controller;


import andrei.tfg.Service.ServiceImpl.Plantilla;
import andrei.tfg.Model.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class Controller {

    private static Usuario us = new Usuario();
    private static EnlacesHtml enlace = new EnlacesHtml();
    @Autowired
    @Qualifier("plantilla")
    private  Plantilla plantilla;

    @GetMapping
    public ModelAndView inicio(){
        ModelAndView mav = new ModelAndView(enlace.ENTRAR);
        mav.addObject("usuario", new Usuario());
        return mav;
    }
    @GetMapping("loggin")
    public ModelAndView loggin(@ModelAttribute("usuario") Usuario usuario){
        if (usuario.encriptar().equals(us.getClave())){
            return new ModelAndView(enlace.INICIO);
        }else return new ModelAndView(enlace.ENTRAR);
    }
    @GetMapping("plantillaCarta")
    public void plantillaCarta(){
        plantilla.darDeAltaCarta();
    }

}
