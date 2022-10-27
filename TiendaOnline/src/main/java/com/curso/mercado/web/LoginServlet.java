package com.curso.mercado.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curso.mercado.entidades.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("Se construye");
        //Se guardan atributos en el ámbito de aplicación
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("Se inicializa");
    	config.getServletContext().setAttribute("nombreTienda", "SI NO, LO TENEMOS NO EXISTE");;
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Se lanza");
		String paramUsuario = request.getParameter("usuario");
		String paramRol = request.getParameter("rol");
		System.out.println("Id: " + paramUsuario + " " + paramRol);
		//********************
		//Evalúa la entrada robusta
		String msgError = "";
		if(paramUsuario==null || paramUsuario.trim().length()==0) {
			msgError = "Nombre inválido.";
		} else if(paramRol==null || paramRol.trim().length()==0) {
			msgError = "Rol inválido.";
		}
		//Si hay error vuelve a login.jsp
		if(msgError.length()>0) {
			request.setAttribute("error", msgError);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		//Si no hay error se va a alta-producto con los datos de usuario
		else {
			HttpSession sesion = request.getSession();
			sesion.setMaxInactiveInterval(60);
			
			//sesion.isNew();
			//sesion.invalidate();
			
			Usuario usuario = new Usuario(paramUsuario, paramRol);
			sesion.setAttribute("usuario", usuario);
			//request.setAttribute("usuario", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
		//doGet(request, response);
	}

}
