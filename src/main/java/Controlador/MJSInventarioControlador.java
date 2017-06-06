package Controlador;

import BaseDatos.AdminBaseDatos;
import Modelo.Busqueda;
import Modelo.EscribirExcel;
import Modelo.Objeto;
import Modelo.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MJSInventarioControlador {
    
    private AdminBaseDatos adminBD;
    private ArrayList <Usuario> usuarios;
    private ArrayList <Objeto> objetos;
    private EscribirExcel es;
    private ArrayList<String> historial;
    private Busqueda busqueda;
    
//  =========Atributos del modelo
    @ModelAttribute("usuarios")
    public ArrayList<Usuario> usuarios() {
        return this.usuarios;
    }
    
    @ModelAttribute("objetos")
    public ArrayList<Objeto> objetos() {
        return this.objetos;
    }
    
    @ModelAttribute("historial")
    public ArrayList<String> historial() {
        return this.historial;
    }
    
    @ModelAttribute("busqueda")
    public Busqueda busqueda() {
        return this.busqueda;
    }
    
    //Actualizar objetos con la base de datos
    public void actualizarObjetos(){
        this.objetos = adminBD.listaObjetos();
    }
    
    //Actualizar historial con la base de datos
    public void actualizarHistorial(){
        this.historial = adminBD.listaHistorial();
    }
    
//    Consructor
    public MJSInventarioControlador() throws ClassNotFoundException, SQLException, FileNotFoundException, InvalidFormatException, Exception{
        this.adminBD = new AdminBaseDatos();
        this.usuarios = adminBD.listaUsuarios();
        this.objetos = adminBD.listaObjetos();
        this.historial = adminBD.listaHistorial();
        
        es = new EscribirExcel();
//        es.crearPDF();
        
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
        adminBD.agregarMovimiento("Inicio de Sesión para "+usuario.getNombreUsuario());
        return getPagPrincipal(model);
    }
    
//    Pag Principal
    @GetMapping("/pagPrincipal")
    public String getPagPrincipal(Model model) {

        actualizarHistorial();
        System.out.println("Get paginaPrincipal");
        
        return "pagPrincipal";
    }
    
    @PostMapping("/pagPrincipal")
    public void postPagPrincipal(Model model, @ModelAttribute Busqueda busq) {
        System.out.println("Post PAg Principal");
        
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
        this.usuarios.add(usuario);
        adminBD.agregarUsuario(usuario);  //agrego a Base Datos
        adminBD.agregarMovimiento("Se agregó el usuario "+usuario.getNombreUsuario());
        
        return "Usuarios";
    }
    
//    Lista Usuarios
    @GetMapping("/Usuarios")
    public String getUsuarios(Model model) {
        System.out.println("GET Usuarios");

        this.usuarios = adminBD.listaUsuarios();
        
        return "Usuarios";
    }  
    
    //    Lista Historial
    @GetMapping("/Historial")
    public String getHistorial(Model model) {
        System.out.println("GET Historial");
        this.historial = adminBD.listaHistorial();
        return "Historial";
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
        adminBD.agregarMovimiento("Edición del usuario "+usuario.getNombreUsuario());

        if (action.equals("eliminar")){
            adminBD.eliminarUsuario(usuario);
            adminBD.agregarMovimiento("Se eliminó el usuario "+usuario.getNombreUsuario());
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
        model. addAttribute("objeto", new Objeto());
        
        return "AgregarObjeto";
    }
    
    @PostMapping("/AgregarObjeto")
    public String postAgregarObjeto(Model model, Objeto objeto) {
      System.out.println("Post Agregar Objeto");
      
        System.out.println(objeto.toString());
        this.objetos.add(objeto);    
        adminBD.agregarObjeto(objeto); //agrego a base datos
        actualizarObjetos();
        adminBD.agregarMovimiento("Se agregó el objeto "+objeto.getNombreObjeto());
        
        return "pagPrincipal";
    }
    
    //    Editar un objeto
    @GetMapping("/VerObjeto")
    public String getVerObjeto(Model model, @RequestParam(value = "ind") int indiceObjeto) {
        
        model.addAttribute("objeto", adminBD.listaObjetos().get(indiceObjeto));
        model.addAttribute("indice", indiceObjeto);
        
//        System.out.println(adminBD.listaObjetos().get(indiceObjeto).toString());
        
        return "VerObjeto";
    }
    
    @PostMapping("/VerObjeto")
    public String postVerObjeto(Model model, @ModelAttribute Objeto objeto, @RequestParam(value = "action", required = true) String action) {
        
        System.out.println(objeto.toString());
        //Preguntar contrasena administrador

        if (action.equals("eliminar")){
            adminBD.eliminarObjeto(objeto);
            adminBD.agregarMovimiento("Se eliminó el objeto "+objeto.getNombreObjeto());
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
        adminBD.agregarMovimiento("Edición del objeto "+objeto.getNombreObjeto());
        
//        actualizar usuarios      
//        this.usuarios = adminBD.listaUsuarios();
        return "pagPrincipal";
    }
     
    
    @RequestMapping("/descarga")
    public void downloadPDFResource( HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "ind") int indiceObjeto) throws FileNotFoundException, InvalidFormatException {
        //Preparar el archivo
        //Sobreescribir
        es.crearHojaCalculo(objetos.get(indiceObjeto));
        
        //If user is not authorized - he should be thrown out from here itself
        //Authorized user will download the file
        String fileName = "Objeto.xls";            
        Path file = Paths.get(fileName);
        
        if (Files.exists(file)) 
        {
//            response.setContentType("application/pdf");  //Para indicar el tipo de archivo
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
                adminBD.agregarMovimiento("Se descargó el objeto "+objetos.get(indiceObjeto).getNombreObjeto());
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}