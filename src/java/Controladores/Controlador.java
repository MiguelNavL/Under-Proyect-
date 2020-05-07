/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Controladores;

import java.io.IOException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
//import javax.servelet.httpHttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import model.PersonaDAO;
 
@Named(value = "usuarioControlador")
@SessionScoped
public interface Controlador extends HttpServlet {
    Usuario usuario;
    
    
    private Controlador(){
        usuario = new Usuario();
        usuarioAutentificado = null;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion=request.getParameter("accion");
        if(accion.equals("Ingresar")){
            String nombre=request.getParameter("nombre");
            String contraseña=request.getParameter("contraseña");
            p.setNombre(nombre);
            p.setContraseña(contraseña);
            r=dao.Validar(p);
            if(r==1){
                request.getSession().setAttribute("nombre", nombre);
                request.getSession().setAttribute("contraseña", contraseña);
                request.getRequestDispatcher("Menú.xhtml").forward(request, response);
            }else{
                request.getRequestDispatcher("Lobby.xhtml").forward(request, response);
            }
        }
    }
    
}
