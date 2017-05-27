/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import entidades.Domicilio;
import entidades.Empleado;
import entidades.Sesion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author awelo
 */
public class Control extends Conexion{
    
    public byte logOut(String user){
        byte exito=0;
        try{
            String sql= "UPDATE login SET logeado=0 WHERE fk_idEmpleado="+user;
            PreparedStatement statement= conectar().prepareStatement(sql);
            
            if(statement.executeUpdate()!=0){
                exito=1;
            }
            
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        
        return exito;
    }
    
    public byte sesion(Sesion sesion){
        byte exito=0;
        String sql="INSERT INTO horasDiarias VALUES (0,?,?,?,?,?,?)";
        try{
            PreparedStatement stm = conectar().prepareStatement(sql);
            stm.setDate(1, sesion.getFecha());
            stm.setTime(2, sesion.getHoraInicio());
            stm.setTime(3, sesion.getHoraInicio());
            stm.setInt(4, 0);
            stm.setInt(5, sesion.getUser());
            stm.setInt(6, sesion.getSemana());
            
            if(stm.executeUpdate()>0){
                exito=1;
            }
        }catch(SQLException e){
            System.out.println("Error en la conexion 34 "+e);
        }
        
        return exito;
    }
    public java.util.Date darInicio(int user){
        java.util.Date hora = null;
        try{
            String sql="SELECT horaInicio FROM horasDiarias WHERE idHorasDiarias=(SELECT MAX(idHorasDiarias) FROM horasDiarias WHERE empleado_idEmpleado="+user+")";
            Statement stm= conectar().createStatement();
            ResultSet obtener = (ResultSet) stm.executeQuery(sql);
            
            while(obtener.next()){
                hora=obtener.getDate(1);
            }
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        
        return hora;
    }
    
    public byte cerrarSesion(java.sql.Time hora, float horasTra, int user){
        byte exito=0;
        try{
            String sql="UPDATE horasDiarias SET horaFin='"+hora+"', totalHoras="+horasTra+" WHERE idHorasDiarias=(SELECT MAX(idHorasDiarias) FROM horasDiarias WHERE empleado_idEmpleado="+user+")";
            PreparedStatement stm= conectar().prepareStatement(sql);
            
            if(stm.executeUpdate()>0){
                exito=1;
            }
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return exito;
    }
    
    public byte addEmpleado(Empleado empleado, Domicilio domicilio){
        byte exito=0;
        
        try{
            String sql1= "INSERT INTO domicilio VALUES(0,?,?,?,?,?,?)";
            PreparedStatement stm =conectar().prepareStatement(sql1);
            stm.setString(1, domicilio.getCalle());
            stm.setString(2, domicilio.getNumExt());
            stm.setString(3, domicilio.getNumInt());
            stm.setString(4, domicilio.getColonia());
            stm.setString(5, domicilio.getCp());
            stm.setString(6, domicilio.getCiudad());
            
            if(stm.executeUpdate()>0){
                String sql2="INSERT INTO empleado VALUES(0,?,?,?,?,?,?,(SELECT MAX(idDomiclio) FROM domicilio),?)";
                PreparedStatement estate = conectar().prepareStatement(sql2);
                estate.setString(1, empleado.getNombre());
                estate.setString(2, empleado.getApepat());
                estate.setString(3, empleado.getApemat());
                estate.setString(4, empleado.getTelefono());
                estate.setString(5, empleado.getEmail());
                estate.setInt(6, empleado.getCargo());
                estate.setString(7, empleado.getImagen());
                
                if(estate.executeUpdate()>0){
                    exito=1;
                }
                
            }
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        
        return exito;
    }
    
    public int setPassword(String pass){
        int user=0;
        try{
            PreparedStatement prepar = conectar().prepareStatement("INSERT INTO login VALUES(0,'"+pass+"',(SELECT MAX(idEmpleado) FROM empleado),0,0,1");
            if(prepar.executeUpdate()>0){
                Statement stado= conectar().createStatement();
                ResultSet consulta=(ResultSet)stado.executeQuery("SELECT MAX(idLogin) FROM login");
                
                while(consulta.next()){
                    user=consulta.getInt(1);
                }
            }
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        
        return user;
    }
}
