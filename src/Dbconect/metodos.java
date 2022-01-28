/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dbconect;

import java.sql.*;
/**
 *
 * @author andree
 */
public class metodos {
    
    public static basedatos conexion = new basedatos();

    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static int resultado_numero;
    
    public static String buscarUsuarioRegistrado(String usuario, String contraseña) {
        String busqueda_usuario = null;
        Connection coneccion2 = null;

        try {
            coneccion2 = basedatos.conectar();
            String sentencia_buscar_usuario = ("SELECT admin_username,admin_password FROM admin WHERE admin_username = '" + usuario + "' and admin_password ='" + contraseña + "'");
            sentencia_preparada = coneccion2.prepareStatement(sentencia_buscar_usuario);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                busqueda_usuario = "usuario encontrado";
            } else {
                busqueda_usuario = "usuario no encontrado";
            }
            coneccion2.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return busqueda_usuario;

    }
    
    public static float buscarPrecioProducto(String nombre){
        float busqueda_precio = 0.0f;
        Connection coneccion3 = null;
        
        try{
            coneccion3 = basedatos.conectar();
            String sentencia_buscarPrecio = ("SELECT product_price FROM ajvznjo29l0fdb0a.products WHERE product_name = '"+nombre+"'");
            sentencia_preparada = coneccion3.prepareStatement(sentencia_buscarPrecio);
            resultado = sentencia_preparada.executeQuery();
            if(resultado.next()){
                busqueda_precio = resultado.getFloat("product_price");
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return busqueda_precio;
        
    }
  
    public static void ingresarRegistro(int dni,int telef,String nombre,String mesa,String direc, float precio){
        Connection coneccion4 = null;
        
        try{
            coneccion4 = basedatos.conectar();
            String sentencia_ingresar_registro = ("INSERT INTO registro "
                    + "(clientes_id, clientes_telf, clientes_name, nro_mesa, direccion, precio) "
                    + "VALUES ('"+dni+"', '"+telef+"', '"+nombre+"', '"+mesa+"', '"+direc+"', '"+precio+"')");
            st = coneccion4.createStatement();
            st.executeUpdate(sentencia_ingresar_registro);
            coneccion4.close();
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
}
