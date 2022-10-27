package com.curso.mercado.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.entidades.Producto;
import com.curso.mercado.servicios.ProductosService;

/**
 * Servlet implementation class AltaProductoServlet
 */
public class AltaProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductosService productoService = new ProductosService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaProductoServlet() {
        super();
        System.out.println("Se Construye");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("En doPost()");
		//Leer parámetros
		String paramDescripcion = request.getParameter("descripcion") ;
		String paramPrecio = request.getParameter("precio");
		String msgError = "";
		double precio=0;
		//Validar parámetros
		if(paramDescripcion==null || paramDescripcion.trim().length()==0) {
			msgError = "Descripción inválida.";
		} else if(paramPrecio==null || paramPrecio.trim().length()==0) {
			msgError = "Precio inválido.";
		} else  {
			precio = Double.parseDouble(paramPrecio);
		}
		if(msgError.length()==0) {
			//Se crea el producto
			Producto p = new Producto(null, paramDescripcion, precio,5);
			productoService.darAltaUnProducto(p);
			response.setContentType("text/html");

			System.out.println("Se da de alta " + paramDescripcion + " con un precio de " + precio);
						
			List<Producto> lp = productoService.dameTodosLosProductos();
			request.setAttribute("lista", lp); RequestDispatcher rd = request.getRequestDispatcher("producto-lista.jsp");
			 
			//RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaProductos");
			rd.forward(request, response);
		} else {
			System.out.println(msgError);
			request.setAttribute("error", msgError);
			RequestDispatcher rd = request.getRequestDispatcher("alta-producto.jsp");
			rd.forward(request, response);
		}
		
	}

}
