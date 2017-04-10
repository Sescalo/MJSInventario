package Controlador;

import BaseDatos.AdminBaseDatos;
import Modelo.Greeting;
import Modelo.Usuario;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MJSInventarioControlador {
    
    AdminBaseDatos adminBD;
    
    public MJSInventarioControlador() throws ClassNotFoundException, SQLException{
        this.adminBD = new AdminBaseDatos();
    }
    
    @GetMapping("/InicioSesion")
    public String getInicioSesion(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "InicioSesion";
    }

    @PostMapping("/InicioSesion")
    public String postInicioSesion(Model model, @ModelAttribute Usuario usuario) {
        if(!adminBD.existeUsuario(usuario)) {
            model.addAttribute("error", true);
            return "InicioSesion";
        }
        return "pagPrincipal";
    }
    
    @GetMapping("/AgregarUsuario")
    public String getAgregarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "AgregarUsuario";
    }
    
    @PostMapping("/AgregarUsuario")
    public String postAgregarUsuario(Model model, @ModelAttribute Usuario usuario) {
        System.out.println(usuario.toString());
        adminBD.agregarUsuario(usuario);
        return "AgregarUsuario";
    }
    
    @GetMapping("/Usuarios")
    public String getUsuarios(Model model) {
        model.addAttribute("usuarios", adminBD.listaUsuarios());
        
        return "Usuarios";
    }
    
    @GetMapping("/pagPrincipal")
    public String getPagPrincipal(Model model) {
        
        return "pagPrincipal";
    }
}