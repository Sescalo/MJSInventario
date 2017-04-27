package Controlador;

import BaseDatos.AdminBaseDatos;
import Modelo.DatosUsuario;
import Modelo.Usuario;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MJSInventarioControlador {
    
    AdminBaseDatos adminBD;
    
//  =========Atributos del modelo     
    public int indiceUsuario;
    
    @ModelAttribute("indiceUsuario")
    public int indiceUsuario(){
        return this.indiceUsuario;
    }
    
    public MJSInventarioControlador() throws ClassNotFoundException, SQLException{
        this.adminBD = new AdminBaseDatos();
    }
    
//    Inicio Sesion
    @GetMapping("/InicioSesion")
    public String getInicioSesion(Model model) {
        
        model.addAttribute("usuario", new Usuario());
        return "InicioSesion";
    }

    @PostMapping("/InicioSesion")
    public String postInicioSesion(Model model, @ModelAttribute Usuario usuario) {
        usuario.encriptarContra();
        
        if(!adminBD.existeUsuario(usuario)) { //No existe el usuario
//            model.addAttribute("error", true);
            return "InicioSesion";
        }
        
        return "pagPrincipal";
    }
    
//    Pag Principal
    @GetMapping("/pagPrincipal")
    public String getPagPrincipal(Model model) {
        
        return "pagPrincipal";
    }
    
//    Agregar Usuario
    @GetMapping("/AgregarUsuario")
    public String getAgregarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());

        return "AgregarUsuario";
    }
    
    @PostMapping("/AgregarUsuario")
    public String postAgregarUsuario(Model model, @ModelAttribute Usuario usuario) {
        //Encriptar contrasena del usuario
        usuario.encriptarContra();
                
        System.out.println("asad"+usuario.toString());
        
        adminBD.agregarUsuario(usuario);
        
        return "AgregarUsuario";
    }
    
    DatosUsuario d = new DatosUsuario(1);
    
    @ModelAttribute("datos")
    public DatosUsuario datos(){
        return this.d;
    }
    
//    Lista Usuarios
    @GetMapping("/Usuarios")
    public String getUsuarios(Model model) {
        model.addAttribute("usuarios", adminBD.listaUsuarios());

//        model.addAttribute("datos", d);
      
        return "Usuarios";
    }       
    
    
    
//    Editar un Usuario
    @GetMapping("/EditarUsuario")
    public String getEditarUsuario(Model model) {
        
        model.addAttribute("usuario", adminBD.listaUsuarios().get(indiceUsuario()));
        
//        System.out.println("Indice: "+ indiceUsuario);
//        System.out.println("Indice: "+ indiceUsuario());
        System.out.println("Indice:" +d.getIndice());
        
        return "EditarUsuario";
    }
}