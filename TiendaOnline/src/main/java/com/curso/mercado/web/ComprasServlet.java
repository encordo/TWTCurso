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
import com.curso.mercado.servicios.VentasService;
import com.curso.mercado.servicios.excepciones.VentasException;

/**
 * Servlet implementation class ComprasServlet
 */
public class ComprasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("idProducto");
		String paramcantidad = request.getParameter("cantidad");
		int idProductoComprar = 0;
		int cantidad = 1;
		if(paramId!=null && !paramId.equals("")) {
			idProductoComprar = Integer.parseInt(paramId);
		}
		if(paramcantidad!=null && !paramcantidad.equals("")) {
			cantidad = Integer.parseInt(paramcantidad);
		}
		VentasService vs = new VentasService();
		String mensaje = "";
		try {
			vs.comprarProducto(idProductoComprar, cantidad);
			mensaje = (cantidad==1?"Se ha comprado una unidad.":"Se han comprado "+ cantidad +" unidades");
		} catch (Exception e) {
			// xxx
			mensaje = "No se ha comprado. \n" + e.getMessage();
		}
		request.setAttribute("mensaje", mensaje);
		//Despachar lista
		//recuperar
		/*
		 * ProductosService ps = new ProductosService();
			List<Producto> lp = ps.dameTodosLosProductos();
		
		 * request.setAttribute("lista", lp); RequestDispatcher rd =
		 * request.getRequestDispatcher("producto-lista.jsp");
		 */
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaProductos");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
