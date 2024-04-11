
package mintic.misiontic.ciclo3.EjemploSpring;


import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import mintic.misiontic.ciclo3.EjemploSpring.modelo.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 *
 * @author Alejandro
 */
@Controller
@Slf4j
public class ControladorInicio {
    @Value("$(index.mensaje)")
    String dato;
    @GetMapping("/")
    public String inicio(Model modelo){
        String mensaje ="saludo desde Spring MVC con paso de informacion";
        modelo.addAttribute("mesaje", mensaje);
        modelo.addAttribute("dato", dato);
        Usuario u1 = new Usuario();
        u1.setCedula("1234");
        u1.setClave("Abecd");
        u1.setNombre("JOHN CARLOS ARRIETA ARRIETA");
        u1.setEmail("jarrieta@gmail.com");
        modelo.addAttribute("alguien", u1);
        
        Usuario u2 = new  Usuario();
        u2.setCedula("777");
        u2.setClave("EL MEJOR");
        u2.setNombre("JESUS DE NAZARET");
        u2.setEmail("jesucristo@iglesia.com");
        Usuario u3 = new  Usuario();
        u3.setCedula("4321");
        u3.setClave("xyz");
        u3.setNombre("FULANITO DE TAL");
        u3.setEmail("fulanito@gmail.com");
        List<Usuario>listaUsuarios = Arrays.asList(u2,u3);
        modelo.addAttribute("usuarios",listaUsuarios);

        log.info("ejecutando el controlador inicio MVP");
    return "index";
    }
}
