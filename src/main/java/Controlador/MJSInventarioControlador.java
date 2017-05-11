package Controlador;

import BaseDatos.AdminBaseDatos;
import Modelo.DatosUsuario;
import Modelo.EscribirExcel;
import Modelo.Objeto;
import Modelo.Usuario;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MJSInventarioControlador {
    
    AdminBaseDatos adminBD;
    ArrayList <Usuario> usuarios;
    ArrayList <Objeto> objetos;
    
//  =========Atributos del modelo
    @ModelAttribute("usuarios")
    public ArrayList<Usuario> usuarios() {
//        this.usuarios = adminBD.listaUsuarios();
        
        return this.usuarios;
    }
    
    @ModelAttribute("objetos")
    public ArrayList<Objeto> objetos() {
//        this.usuarios = adminBD.listaUsuarios();
        
        return this.objetos;
    }
    
//    Consructor
    public MJSInventarioControlador() throws ClassNotFoundException, SQLException, FileNotFoundException, InvalidFormatException{
        this.adminBD = new AdminBaseDatos();
        this.usuarios = adminBD.listaUsuarios();
        this.objetos = adminBD.listaObjetos();
        
//        EscribirExcel es = new EscribirExcel();
//        es.actualizarCelda();
        
    }
    
//    Inicio Sesion
    @GetMapping("/InicioSesion")
    public String getInicioSesion(Model model) {
        
        model.addAttribute("usuario", new Usuario());
        return "InicioSesion";
    }

    @PostMapping("/InicioSesion")
    public String postInicioSesion(Model model, @ModelAttribute Usuario usuario){
        
        if(!adminBD.existeUsuario(usuario)) { //No existe el usuario
//            model.addAttribute("error", true);
//            mostar mensaje error
            usuario = new Usuario();
            return "InicioSesion";
        }
        
        return "pagPrincipal";
    }
    
    
//    Pag Principal
    @GetMapping("/pagPrincipal")
    public String getPagPrincipal(Model model) {
        this.objetos = adminBD.listaObjetos();
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
//        usuario.encriptarContra();
                
        System.out.println(usuario.toString());
        
        adminBD.agregarUsuario(usuario);
        
        return "Usuarios";
    }
    
//    Lista Usuarios
    @GetMapping("/Usuarios")
    public String getUsuarios(Model model) {
        System.out.println("GET Usuarios");
//        model.addAttribute("usuarios", adminBD.listaUsuarios());

        this.usuarios = adminBD.listaUsuarios();
        
        return "Usuarios";
    }       
    
    
//    Editar un Usuario
    @GetMapping("/EditarUsuario")
    public String getEditarUsuario(Model model, @RequestParam(value = "ind") int indiceUsuario) {
        
        model.addAttribute("usuario", adminBD.listaUsuarios().get(indiceUsuario));
        System.out.println(adminBD.listaUsuarios().get(indiceUsuario).toString());
        
        return "EditarUsuario";
    }
    
    @PostMapping("/EditarUsuario")
    public String postEditarUsuario(Model model, @ModelAttribute Usuario usuario, @RequestParam(value = "action", required = true) String action) {
        
        System.out.println(usuario.toString());
        //Preguntar contrasena administrador
        adminBD.actualizarUsuario(usuario);
        

        if (action.equals("eliminar")){
            adminBD.eliminarUsuario(usuario);
        }
        
        
        else if(action.equals("actualizar")){
        
        }
        
//        actualizar usuarios      
//        this.usuarios = adminBD.listaUsuarios();
        return "Usuarios";
    }
    
    //    Agregar un Objeto
    @GetMapping("/AgregarObjeto")
    public String getAgregarObjeto(Model model) {
        System.out.println("Get AgregarObjeto");
        model. addAttribute("objeto",new Objeto());
        
        return "AgregarObjeto";
    }
    
    @PostMapping("/AgregarObjeto")
    public String postAgregarObjeto(Model model, Objeto objeto) {
      System.out.println("Post Agregar Objeto");
      
        System.out.println(objeto.toString());
        
        adminBD.agregarObjeto(objeto);
        
        return "pagPrincipal";
    }
    
    //    Editar un objeto
    @GetMapping("/VerObjeto")
    public String getVerObjeto(Model model, @RequestParam(value = "ind") int indiceObjeto) {
        
        model.addAttribute("objeto", adminBD.listaObjetos().get(indiceObjeto));
        System.out.println(adminBD.listaObjetos().get(indiceObjeto).toString());
        
        return "VerObjeto";
    }
    
    @PostMapping("/VerObjeto")
    public String postVerObjeto(Model model, @ModelAttribute Objeto objeto, @RequestParam(value = "action", required = true) String action) {
        
        System.out.println(objeto.toString());
        //Preguntar contrasena administrador
        
        

        if (action.equals("eliminar")){
            adminBD.eliminarObjeto(objeto);
        }
        
        
        else if(action.equals("editar")){
            return getEditarObjeto(model, objeto);
        }
        
//        actualizar usuarios      
//        this.usuarios = adminBD.listaUsuarios();
        return "pagPrincipal";
    }
    
    //    Editar un objeto
    @GetMapping("/EditarObjeto")
    public String getEditarObjeto(Model model, Objeto objeto) {
        
        model.addAttribute("objeto", objeto);
        
        return "EditarObjeto";
    }
    
    @PostMapping("/EditarObjeto")
    public String postEditarObjeto(Model model, @ModelAttribute Objeto objeto) {
        
        System.out.println(objeto.toString());
        //Preguntar contrasena administrador
      
        adminBD.actualizarObjeto(objeto);
        
//        actualizar usuarios      
//        this.usuarios = adminBD.listaUsuarios();
        return "pagPrincipal";
    }
}