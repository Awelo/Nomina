/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.Connection;
import entidades.LoginEntidad;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author awelo
 */
public class Conexion {
    private final String user = "root";
    private final String password = "awelo";
    private final String url = "jdbc:mysql://localhost:3306/nomina?autoReconnect=true&useSSL=false";
    
    private Connection con = null;
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection)DriverManager.getConnection(url,user,password);
            System.out.println("Se conecto correctamente");
        } catch(SQLException | java.lang.ClassNotFoundException e){
            System.out.println("Error en la conexion"+e);
        }
        return con;
    }
    
    public ResultSet consultarEmpleados(){
        ResultSet obtener= null;
        
        try{
            String sql="SELECT empleado.idEmpleado, nombreEmpleado, apepat, apemat, foto, cargo.puesto FROM empleado INNER JOIN cargo ON empleado.cargo_idCargo=cargo.idCargo";
            Statement statement = conectar().createStatement();
            obtener=(ResultSet) statement.executeQuery(sql);
            System.out.println("Hecho");
        } catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        
        return obtener;
    }
    
    public ResultSet consultaSemanas(){
        ResultSet obtener= null;
        
        try{
            String sql="SELECT empleado.Nombre, semana.fechaInicio, fechaFin, diasTrabajados, horasSemana, sueldo FROM semana INNER JOIN empleado ON semana.empleado_idEmpleado=empleado.idEmpleado";
            Statement statement = conectar().createStatement();
            obtener=(ResultSet) statement.executeQuery(sql);
            System.out.println("Hecho");
        } catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return obtener;
    }
    
    public ResultSet consultaLogin(LoginEntidad login){
        boolean hecho = false;
        ResultSet obtener= null;
        try{
            String sql1 = "SELECT * FROM login WHERE fk_idEmpleado="+login.getUsuario();
            Statement statment = conectar().createStatement();
            ResultSet obtenido = (ResultSet) statment.executeQuery(sql1);
            if(obtenido.next()){
               if(obtenido.getString(1).equals(login.getPassword())){
                   hecho=true;
               } 
            }
            
            if(hecho){
                String sql2 = "UPDATE login SET logeado=1 WHERE fk_idEmpleado="+login.getUsuario();
                Statement stat = conectar().prepareStatement(sql2);
                stat.executeUpdate(sql2);
            }
            obtener=(ResultSet) statment.executeQuery("SELECT nombreEmpleado, apepat, apemat FROM empleado WHERE idEmpleado="+login.getUsuario());
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return obtener;
    }
}
