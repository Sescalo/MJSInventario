package Controlador;

import BaseDatos.AdminBaseDatos;
import Modelo.AtributosObjeto;
import Modelo.Busqueda;
import Modelo.EscribirExcel;
import Modelo.EscribirWord;
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

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


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
    private EscribirWord ew;
    private ArrayList<String> historial;
    private Busqueda busqueda;
    private Usuario usuario;
    private boolean sesionAbierta;
    
    
//  =========Atributos del modelo
    @ModelAttribute("usuario")     //Usuario que esta utilizando el sistema
    public Usuario usuario() {
        return this.usuario;
    }
    
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
    public void actualizarObjetos(ArrayList <Objeto> arr){
        
        this.objetos.removeAll(objetos);
        
        for(int i=0; i< arr.size(); i++){
            this.objetos.add(arr.get(i));
        }
    }
    
    //Actualizar usuarios con la base de datos
    public void actualizarUsuarios(ArrayList <Usuario> arr){
        
        this.usuarios.removeAll(usuarios);
        
        for(int i=0; i< arr.size(); i++){
            this.usuarios.add(arr.get(i));
        }
    }
    
    //Actualizar historial con la base de datos
    public void actualizarHistorial(){
        
        this.historial.removeAll(historial);
        ArrayList <String> arr = adminBD.listaHistorial();
        
        for(int i=0; i< arr.size(); i++){
            this.historial.add(arr.get(i));
        }
    }
    
    //Reiniciar el objeto de busqueda
    public void reiniciarBusqueda(){
        this.busqueda.setInput("");
        this.busqueda.setAb(AtributosObjeto.nombreObjeto);
    }
    
    //Verificar si existe alguna sesion abierta
    public String verificarSesion(){
        if (sesionAbierta == false){
            System.out.println("Error de Sesion");
            return errorSesion();
            
        }

        return "";
    }
    
//    *****************************Constructor
    public MJSInventarioControlador() throws ClassNotFoundException, SQLException, FileNotFoundException, /*InvalidFormatException,*/ Exception{
        this.adminBD = new AdminBaseDatos();
        this.usuario = new Usuario();
        this.usuarios = adminBD.listaUsuarios();
        this.objetos = adminBD.listaObjetos();
        this.historial = adminBD.listaHistorial();
        this.busqueda = new Busqueda();
        this.ew = new EscribirWord();
        this.sesionAbierta = false;
        ew.cambiarLogo();
        
        
    }
    
//    Inicio Sesion
    @GetMapping("/InicioSesion")
    public String getInicioSesion(Model model) {
        return "InicioSesion";
    }

    @PostMapping("/InicioSesion")
    public String postInicioSesion(Model model, @ModelAttribute Usuario usuario){
        
        if(adminBD.existeUsuario(usuario)) { //Existe el usuario
            this.sesionAbierta = true;
            
            if(adminBD.isAdmin(usuario.getNombreUsuario())){ //Buscar si el usuario es admin
                usuario().setIsAdmin(true);
            }
            else{
                usuario().setIsAdmin(false);
            }

        }
        else{ //No existe Usuario
            //mostar mensaje error
            model.addAttribute("error", "Combinación de usuario y contraseña incorrecta");
            return "InicioSesion";
        }

        
        adminBD.agregarMovimiento("Inicio de Sesión para "+usuario.getNombreUsuario());
        return "pagPrincipal";
    }
    
    
//    Pag Principal
    @GetMapping("/pagPrincipal")
    public String getPagPrincipal(Model model) {
        if(sesionAbierta){

            reiniciarBusqueda();
            actualizarObjetos(adminBD.listaObjetos());

            System.out.println("Get paginaPrincipal");

            return "pagPrincipal";
        }
        return "ErrorSesion";
    }
    
    //Buscar objetos
    @PostMapping("/pagPrincipal")
    public String postPagPrincipal(Model model, @ModelAttribute Busqueda busqueda) {

        actualizarObjetos(adminBD.busquedaObjetos(busqueda));
        
        System.out.println("Post Pag Principal");
        return "pagPrincipal";
        
    }
    
//    Agregar Usuario
    @GetMapping("/AgregarUsuario")
    public String getAgregarUsuario(Model model) {
        if(sesionAbierta){
            model.addAttribute("usuario", new Usuario());

            return "AgregarUsuario";
        }
        
        return "ErrorSesion";
    }
    
    @PostMapping("/AgregarUsuario")
    public String postAgregarUsuario(Model model, @ModelAttribute Usuario usuario) {
                
        System.out.println(usuario.toString());
        this.usuarios.add(usuario);
        adminBD.agregarUsuario(usuario);  //agrego a Base Datos
        adminBD.agregarMovimiento("Se agregó el usuario "+usuario.getNombreUsuario());
        
        return "Usuarios";
    }
    
//    Lista Usuarios
    @GetMapping("/Usuarios")
    public String getUsuarios(Model model) {
        if(sesionAbierta){
            System.out.println("GET Usuarios");

            actualizarUsuarios(adminBD.listaUsuarios());
            return "Usuarios";
            
        }
        return "ErrorSesion";
    }  
    
    //    Lista Historial
    @GetMapping("/Historial")
    public String getHistorial(Model model) {
        if(sesionAbierta){
            actualizarHistorial();

            System.out.println("GET Historial");
            return "Historial";
        }
        return "ErrorSesion";
    }  
    
    
//    Editar un Usuario
    @GetMapping("/EditarUsuario")
    public String getEditarUsuario(Model model, @RequestParam(value = "ind") int indiceUsuario) {
        if(sesionAbierta){
            model.addAttribute("indi", indiceUsuario);
            model.addAttribute("user", adminBD.listaUsuarios().get(indiceUsuario));
//            System.out.println(adminBD.listaUsuarios().get(indiceUsuario).toString());

            return "EditarUsuario";
        }
        
        return "ErrorSesion";
    }
    
    @PostMapping("/EditarUsuario")
    public String postEditarUsuario(Model model, @ModelAttribute Usuario user/*, @RequestParam(value = "action", required = true) String action*/) {

        System.out.println("actualizar usuario");
        System.out.println(user.toString());
        adminBD.actualizarUsuario(user);
        actualizarUsuarios(adminBD.listaUsuarios());
        
        model.addAttribute("ea", user);
        return "Usuarios";
    }
    
    //    Agregar un Objeto
    @GetMapping("/AgregarObjeto")
    public String getAgregarObjeto(Model model) {
        if(sesionAbierta){
            System.out.println("Get AgregarObjeto");
            model. addAttribute("objeto", new Objeto());

            return "AgregarObjeto";
        }
        return "ErrorSesion";
    }
    
    @PostMapping("/AgregarObjeto")
    public String postAgregarObjeto(Model model, Objeto objeto) {
      System.out.println("Post Agregar Objeto");
      
        System.out.println(objeto.toString());
//        this.objetos.add(objeto);    
        adminBD.agregarObjeto(objeto); //agrego a base datos
        actualizarObjetos(adminBD.listaObjetos());
        adminBD.agregarMovimiento("Se agregó el objeto "+objeto.getNombreObjeto());
        
        return "pagPrincipal";
    }
    
    //    Editar un objeto
    @GetMapping("/VerObjeto")
    public String getVerObjeto(Model model, @RequestParam(value = "ind") int indiceObjeto) {
        if(sesionAbierta){
            model.addAttribute("objeto", adminBD.listaObjetos().get(indiceObjeto));
            model.addAttribute("indice", indiceObjeto); // Para efectos de descarga y editar

    //        System.out.println(adminBD.listaObjetos().get(indiceObjeto).toString());

            return "VerObjeto";
        }
        return "ErrorSesion";
    }
    
    @PostMapping("/VerObjeto")
    public String postVerObjeto(Model model, @ModelAttribute Objeto objeto, @RequestParam(value = "action", required = true) String action) {
        
        System.out.println(objeto.toString());
        //Preguntar contrasena administrador

        if (action.equals("eliminar")){
            adminBD.eliminarObjeto(objeto);
            adminBD.agregarMovimiento("Se eliminó el objeto "+objeto.getNombreObjeto());
            actualizarObjetos(adminBD.listaObjetos());
        }
        
        
//        else if(action.equals("editar")){
//            model.addAttribute("objeto", objeto);
//            return "EditarObjeto";
//        }
        
//        actualizar usuarios      
//        this.usuarios = adminBD.listaUsuarios();
        return "pagPrincipal";
    }
    
    //    Editar un objeto
    @GetMapping("/EditarObjeto")
    public String getEditarObjeto(Model model, @RequestParam(value = "ind") int indiceObjeto) {
        if(sesionAbierta){
            model.addAttribute("objeto", adminBD.listaObjetos().get(indiceObjeto));
            
            return "EditarObjeto";
        }
        return "ErrorSesion";
    }
    
    @PostMapping("/EditarObjeto")
    public String postEditarObjeto(Model model, @ModelAttribute Objeto objeto) {
        
        //Preguntar contrasena administrador
        adminBD.actualizarObjeto(objeto);
        adminBD.agregarMovimiento("Edición del objeto "+objeto.getNombreObjeto());
        
//        actualizar objetos
        actualizarObjetos(adminBD.listaObjetos());

        return "pagPrincipal";
    }
     
    
    @RequestMapping("/descarga")
    public void downloadPDFResource( HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "ind") int indiceObjeto) throws FileNotFoundException, IOException/*, InvalidFormatException*/ {
        //Preparar el archivo
        //Sobreescribir
        ew.crearWord(objetos.get(indiceObjeto));
//        ew.convert();
        
        //If user is not authorized - he should be thrown out from here itself
        //Authorized user will download the file
        String fileName = "HojaInventarioObjeto.doc";            
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
    
    @RequestMapping("/salir")
    public String salir( Model model ){
        this.sesionAbierta = false;
        return "InicioSesion";
    }
    
    @RequestMapping("/errorSesion")
    public String errorSesion(){
        return "ErrorSesion";
    }
    
    @RequestMapping("/eliminarUsuario")
    public String actualizarUsuario(Model model, @ModelAttribute Usuario ea, @RequestParam(value = "ind") int indice, HttpServletRequest request, HttpServletResponse response){
        System.out.println("eliminar usuario");
        adminBD.eliminarUsuario(usuarios.get(indice));
        actualizarUsuarios(adminBD.listaUsuarios());
        return "Usuarios";
    }
}