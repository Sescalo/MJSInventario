package BaseDatos;

import Modelo.Objeto;
import Modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Sergio on 8/4/2017.
 */
public class AdminBaseDatos {

    private static final String DB_URL = "jdbc:mysql://localhost/MJSIDataBase";
    
    //  Usuario
    private static final String USER = "Sescalo";
    private static final String PASS = "holaMundo96.";

//    private static final String USER = "oskrg1130";
//    private static final String PASS = "noob3001";

    private Connection conn;
    private Statement stmt;
    private PreparedStatement prepStmt;
    private ResultSet resultado;

    //    Constructor
    public AdminBaseDatos() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("Base Datos Conectada!");
    }

    //    Agregar un producto a la base de datos
    public void agregarUsuario(Usuario usuario){
        try{
            prepStmt = conn.prepareStatement("insert into Usuario (nombreUsuario, nombre, correo, telefono, contrasena, isAdmin) VALUES (?,?,?,?,?,?);");

            prepStmt.setString(1, usuario.getNombreUsuario());
            prepStmt.setString(2, usuario.getNombre());
            prepStmt.setString(3, usuario.getCorreo());
            prepStmt.setInt(4, usuario.getTelefono());
            prepStmt.setString(5, usuario.getContrasena()); //Modificar contrasena con MD5
            prepStmt.setBoolean(6, usuario.isIsAdmin());
            
            int res = prepStmt.executeUpdate();
            if(res>0){
                System.out.println("Usuario guardado");
            }
            else{
                System.out.println("Error al guardar usuario");
            }
//            conn.close();
        }

        catch(Exception e){
            System.out.println("Error al agregar Usuario");
        }
    }

    // Obtener los usuarios que hay en la base de datos
    public ArrayList<Usuario> listaUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try{
            stmt = conn.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM Usuario;");

            while(resultado.next()){
                listaUsuarios.add( new Usuario(resultado.getInt("idUsuario"), resultado.getString("nombreUsuario"),resultado.getString("nombre"),
                        resultado.getString("correo"), resultado.getInt("telefono"), resultado.getString("contrasena"), resultado.getBoolean("isAdmin")
                ));
            }
        }

        catch(Exception e){

        }
        System.out.println("Usuarios extraidos de la BD");
        return listaUsuarios;
    }

    // Metodo que se encarga de eliminar un producto de la base de datos
    public void eliminarUsuario(Usuario usuario) {
        try {
            prepStmt = conn.prepareStatement("DELETE FROM Usuario WHERE idUsuario = ?;");

            prepStmt.setInt(1, usuario.getIdUsuario());

            int res = prepStmt.executeUpdate();
            if (res > 0) {
                System.out.println("Usuario eliminado!");
            } else {
                System.out.println("Error al eliminar el Usuario");
            }
//            conn.close();
        } catch (Exception e) {

        }
    }
    
    // Verifica si el usuario X existe
    public boolean existeUsuario(Usuario usuario){
        boolean existe = false;
        
        try{
            stmt = conn.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM Usuario where nombreUsuario = '"+usuario.getNombreUsuario()+"' and"
                    + " contrasena = '"+usuario.getContrasena()+"';");
            
            existe = resultado.next();   
        }
        
        catch(Exception e){
            System.out.println("Error de consulta");
        }
        
        System.out.println("El usuario existe:"+ existe);
        return existe;
    }
    
    // Actualiza un usuario
    public void actualizarUsuario(Usuario usuario) { 
            try{
                prepStmt = conn.prepareStatement("update Usuario set nombreUsuario = ?, nombre = ?, correo = ?, "
                        + "telefono = ?, isAdmin = ? where idUsuario = ?;");
                
                prepStmt.setString(1, usuario.getNombreUsuario());
                prepStmt.setString(2, usuario.getNombre());
                prepStmt.setString(3, usuario.getCorreo());
                prepStmt.setInt(4, usuario.getTelefono());
                prepStmt.setBoolean(5, usuario.isIsAdmin());
                prepStmt.setInt(6, usuario.getIdUsuario());
                
                int res = prepStmt.executeUpdate();
                    if(res>0){
                        System.out.println("Usuario Actualizado");
                    }
                    else{
                        System.out.println("Error al actualizar el usuario");
                    }
//                  conn.close();
            }
        
            catch(Exception e){
            }
    }
    
    //    Agregar un objeto a la base de datos
    public void agregarObjeto(Objeto objeto){
        try{
            prepStmt = conn.prepareStatement("insert into Objeto (nombreObjeto, formaAdquisicion, fechaIngreso, numRegistro, "
                    + "valorEconomico, nombreFuente, fechaInventario, numInventario, otrosNumeros, direccionFuente, "
                    + "fechaCatalogo, numCatalogo, espesor, alto, ancho, largo, diametro, peso, procedencia, materiaYTecnica, "
                    + "numeroNegativo, autor, epoca, descripcion, documentacion, observaciones, recibio, inventario, catalogo, aprobo) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

            prepStmt.setString(1, objeto.getNombreObjeto());
            prepStmt.setString(2, objeto.getFormaAdquisicion());
            prepStmt.setString(3, objeto.getFechaIngreso());
            prepStmt.setString(4, objeto.getNumRegistro());
            prepStmt.setFloat(5, objeto.getValorEconomico());
            prepStmt.setString(6, objeto.getNombreFuente());
            prepStmt.setString(7, objeto.getFechaInventario());
            prepStmt.setString(8, objeto.getNumInventario());
            prepStmt.setString(9, objeto.getOtrosNumeros());
            prepStmt.setString(10, objeto.getDireccionFuente());
            prepStmt.setString(11, objeto.getFechaCatalogo());
            prepStmt.setString(12, objeto.getNumCatalogo());
            prepStmt.setString(13, objeto.getEspesor());
            prepStmt.setFloat(14, objeto.getAlto());
            prepStmt.setFloat(15, objeto.getAncho());
            prepStmt.setFloat(16, objeto.getLargo());
            prepStmt.setFloat(17, objeto.getDiametro());
            prepStmt.setFloat(18, objeto.getPeso());
            prepStmt.setString(19, objeto.getProcedencia());
            prepStmt.setString(20, objeto.getMateriaYTecnica());
            prepStmt.setString(21, objeto.getNumeroNegativo());
            prepStmt.setString(22, objeto.getAutor());
            prepStmt.setInt(23, objeto.getEpoca());
            prepStmt.setString(24, objeto.getDescripcion());
            prepStmt.setString(25, objeto.getDocumentacion());
            prepStmt.setString(26, objeto.getObservaciones());
            prepStmt.setString(27, objeto.getRecibio());
            prepStmt.setString(28, objeto.getInventario());
            prepStmt.setString(29, objeto.getCatalogo());
            prepStmt.setString(30, objeto.getAprobo());
            
            int res = prepStmt.executeUpdate();
            if(res>0){
                System.out.println("Objeto guardado");
            }
            else{
                System.out.println("Error al guardar el objeto");
            }
//            conn.close();
        }

        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error al agregar el objeto");
        }
    }
    
    // Obtener los objetos que hay en la base de datos
    public ArrayList<Objeto> listaObjetos() {
        ArrayList<Objeto> listaObjetos = new ArrayList<>();

        try{
            stmt = conn.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM Objeto;");

            while(resultado.next()){
                listaObjetos.add( new Objeto(resultado.getInt("idObjeto"), resultado.getString("nombreObjeto")
                , resultado.getString("formaAdquisicion"), resultado.getString("fechaIngreso"), resultado.getString("numRegistro")
                , resultado.getFloat("valorEconomico"), resultado.getString("nombreFuente"), resultado.getString("fechaInventario")
                , resultado.getString("numInventario"), resultado.getString("otrosNumeros"), resultado.getString("direccionFuente")
                , resultado.getString("fechaCatalogo"), resultado.getString("numCatalogo"), resultado.getString("espesor")
                , resultado.getFloat("alto"), resultado.getFloat("ancho"), resultado.getFloat("largo"), resultado.getFloat("diametro")
                , resultado.getFloat("peso"), resultado.getString("procedencia"), resultado.getString("materiaYTecnica")
                , resultado.getString("numeroNegativo"), resultado.getString("autor"), resultado.getInt("epoca")
                , resultado.getString("descripcion"), resultado.getString("documentacion"), resultado.getString("observaciones"), resultado.getString("recibio")
                , resultado.getString("inventario"), resultado.getString("catalgo"), resultado.getString("aprobo")));
            }
        }

        catch(Exception e){

        }
        System.out.println("Objetos extraidos de la BD");
        return listaObjetos;
    }
    
    // Metodo que se encarga de eliminar un objeto de la base de datos
    public void eliminarObjeto(Objeto objeto) {
        try {
            prepStmt = conn.prepareStatement("DELETE FROM Objeto WHERE idObjeto = ?;");

            prepStmt.setInt(1, objeto.getIdObjeto());

            int res = prepStmt.executeUpdate();
            if (res > 0) {
                System.out.println("Objeto eliminado!");
            } else {
                System.out.println("Error al eliminar el objeto");
            }
//            conn.close();
        } catch (Exception e) {

        }
    }
    
}
