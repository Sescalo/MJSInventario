package BaseDatos;

import Modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Sergio on 8/4/2017.
 */
public class AdminBaseDatos {

    private static final String DB_URL = "jdbc:mysql://localhost/mjsidatabase";
    //  Usuario
    private static final String USER = "Sescalo";
    private static final String PASS = "holamundo";

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
            prepStmt = conn.prepareStatement("insert into Usuario (nombreUsuario, nombre, correo, telefono, contrasena) VALUES (?,?,?,?,?);");

            prepStmt.setString(1, usuario.getNombreUsuario());
            prepStmt.setString(2, usuario.getNombre());
            prepStmt.setString(3, usuario.getCorreo());
            prepStmt.setInt(4, usuario.getTelefono());
            prepStmt.setString(5, usuario.getContrasena()); //Modificar oontrasena con MD5

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

        }
    }

    // Obtener los usuarios que hay en la base de datos
    public ArrayList<Usuario> listaUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try{
            stmt = conn.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM Usuario;");

            while(resultado.next()){
                listaUsuarios.add(new Usuario(resultado.getInt("idUsuario"), resultado.getString("nombreUsuario"),resultado.getString("nombre"),
                        resultado.getString("correo"), resultado.getInt("telefono"), resultado.getString("contrasena")  ));
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
                System.out.println("Usuario eliminado correctamente");
            } else {
                System.out.println("Error al eliminar el usuario");
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
            System.out.println("existe:"+ existe);
        }
        
        catch(Exception e){
            System.out.println("Error de consulta");
        }
        
        return existe;
    }
}
