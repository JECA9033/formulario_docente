/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jealv
 */
public class Conexion {
    public Connection conexionBD;
    public final String bd = "db_colegio";
    public final String urlConexion = String.format("jdbc:mysql://localhost:3306/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=America/Guatemala", bd);
    public final String usuario = "root";
    public final String contra = "123456";
    public final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    public void abrir_conexion(){
    try{
        Class.forName(jdbc);
        conexionBD = DriverManager.getConnection(urlConexion,usuario,contra); 
    }catch(HeadlessException | ClassNotFoundException | SQLException ex){
        System.out.println("Error..." + ex.getMessage());
    }
    }
    public void cerrar_conexion(){
    try{
        conexionBD.close();
    }catch(SQLException ex){        
    System.out.println("Error..." + ex.getMessage());
    }
    }
}
