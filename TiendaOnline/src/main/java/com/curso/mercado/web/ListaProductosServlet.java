package com.curso.mercado.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.entidades.Producto;
import com.curso.mercado.servicios.ProductosService;

/**
 * Servlet implementation class ListaProductosServlet
 */
public class ListaProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaProductosServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperar
		ProductosService ps = new ProductosService();
		List<Producto> lp = ps.dameTodosLosProductos();
		//asignar atributo
		request.setAttribute("lista", lp);
		//llamar
		RequestDispatcher rd  = request.getRequestDispatcher("producto-lista.jsp");
		rd.forward(request, response);
	}


}
