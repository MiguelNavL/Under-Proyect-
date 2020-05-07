/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ejb.Stateless;

/**
 *
 * @author David Parra
 * 
 */
@Stateless
public class PersonaDAO implements Validar {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    @Override
    public int validar(Usuario per) {
        String sql="Select * from persona where Nombre=? and Contraseña=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, per.getIdUsuario());
            ps.setString(2, per.getPasswordUsuario());
            rs=ps.executeQuery();
            while(rs.next()){
                r=r+1;
                per.setIdUsuario(r);
                per.setPasswordUsuario(sql);
            }
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e){
            return 0;
        }
    }
    
}
