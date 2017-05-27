/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.Connection;
import entidades.LoginEntidad;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author awelo
 */
public class Conexion {
    private final String user = "root";
    private final String password = "awelo";
    private final String url = "jdbc:mysql://localhost:3306/nomina?autoReconnect=true&useSSL=false";
    
    private Connection con = null;
    
    /*
        Metodo para crear la conexión
    */
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
    
    /*
        Método para hacer una consulta de los empleados
    */
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
    
    /*
        Método para consultar semanas
    */
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
    
    /*
        Método para consultar la tabla del login donde estan los usuarios de los empleados
    */
    public ResultSet consultaLogin(LoginEntidad login){
        boolean hecho = false;
        ResultSet obtener= null;
        try{
            String sql1 = "SELECT password, activo, fk_idEmpleado, permiso, activo FROM login WHERE idLogin="+login.getUsuario();
            Statement statment = conectar().createStatement();
            obtener = (ResultSet) statment.executeQuery(sql1);
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return obtener;
    }
    
    /*
        Método para devolver los datos en caso de que el login haya sido aprobatorio
    */
    public ResultSet loginAprobado(int user){
        ResultSet obtener=null;
        try{
            String sql2 = "UPDATE login SET logeado=1 WHERE fk_idEmpleado="+user;
            PreparedStatement stat = conectar().prepareStatement(sql2);
                
            stat.executeUpdate();
            
            Statement statement =conectar().createStatement();
            obtener=(ResultSet) statement.executeQuery("SELECT empleado.nombreEmpleado, apepat, apemat FROM login INNER JOIN empleado ON login.fk_idEmpleado=empleado.idEmpleado WHERE idLogin="+user);
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        
        return obtener;
    }
    
    /*
        Método para consultar los usuarios activos en el sistema
    */
    public ResultSet darLogon(){
        ResultSet obtener=null;
        
        try{
            String sql="Select idLogin, empleado.nombreEmpleado, apepat FROM login INNER JOIN empleado ON fk_idEmpleado=idEmpleado WHERE logeado=1";
            Statement statement=conectar().createStatement();
            obtener=(ResultSet) statement.executeQuery(sql);
        } catch(SQLException e){
            System.out.println("Error al cargar "+e);
        }
        
        return obtener;
    }
    public ResultSet darLogonFilt(int user){
        ResultSet obtener=null;
        
        try{
            String sql="Select idLogin, empleado.nombreEmpleado, apepat, password FROM login INNER JOIN empleado ON fk_idEmpleado=idEmpleado WHERE logeado=1 AND idLogin="+user;
            Statement statement=conectar().createStatement();
            obtener=(ResultSet) statement.executeQuery(sql);
        } catch(SQLException e){
            System.out.println("Error al cargar "+e);
        }
        
        return obtener;
    }
    
    public ResultSet consulEmpleados(){
        ResultSet obtener= null;
        try{
            String sql1 = "SELECT idEmpleado, nombreEmpleado, apepat, apemat, cargo.puesto FROM empleado INNER JOIN cargo ON cargo_idCargo=idCargo";
            Statement statment = conectar().createStatement();
            obtener = (ResultSet) statment.executeQuery(sql1);
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return obtener;
    }
    
    public ResultSet consulEmpleadosFil(String dato, int index){
        ResultSet obtener= null;
        try{
            String sql1;
            if(index==0){
                sql1 = "SELECT idEmpleado, nombreEmpleado, apepat, apemat, cargo.puesto FROM empleado INNER JOIN cargo ON cargo_idCargo=idCargo WHERE idEmpleado="+dato;
            } else{
                sql1 = "SELECT idEmpleado, nombreEmpleado, apepat, apemat, cargo.puesto FROM empleado INNER JOIN cargo ON cargo_idCargo=idCargo WHERE nombreEmpleado LIKE '"+dato+"%' OR apepat LIKE '"+dato+"%' OR apemat LIKE '"+dato+"%'";
            }
            Statement statment = conectar().createStatement();
            obtener = (ResultSet) statment.executeQuery(sql1);
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return obtener;
    }
    
    public ResultSet darCargos(){
        ResultSet obtener=null;
        try{
            String sql="Select puesto FROM cargo";
            Statement stm=conectar().createStatement();
            obtener=stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obtener;
    }
}
