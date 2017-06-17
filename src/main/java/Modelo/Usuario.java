package Modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Sergio on 8/4/2017.
 */
public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String nombre;
    private String correo;
    private int telefono;
    private String contrasena;
    private boolean isAdmin;

    public Usuario(int idUsuario, String nombreUsuario, String nombre, String correo, int telefono, String contrasena, boolean pisAdmin) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.isAdmin = pisAdmin;
    }
    
    public Usuario(){
//        this.isAdmin = true;
    }
    
    public String encriptarContra(String pw){
        StringBuilder sb = new StringBuilder();
        
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(pw.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            for(int i=0; i< bytes.length ;i++)            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
        } 
        catch (NoSuchAlgorithmException e)        {
            e.printStackTrace();
        }
        
        return sb.toString();
    }
    

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
//        System.out.println("Seteando contrasena");
        
        this.contrasena = encriptarContra(contrasena);
//        this.contrasena = contrasena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean b) {
        this.isAdmin = b;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + 
                ", nombreUsuario=" + nombreUsuario + 
                ", nombre=" + nombre + ", correo=" + 
                correo + ", telefono=" + telefono + 
                ", contrasena=" + contrasena + 
                ", isAdmin=" + isAdmin + '}';
    }

    
}
