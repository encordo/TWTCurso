package com.mybank.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybank.domain.Customer;
import com.mybank.services.ListaClientesService;

/**
 * Servlet implementation class ListaClientesServlet
 */
public class ListaClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaClientesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	
		ListaClientesService lcs = new ListaClientesService();
		List<Customer> lc = lcs.getListaClientes();
		
		request.setAttribute("lista", lc);
		
		//llamar
		RequestDispatcher rd  = request.getRequestDispatcher("lista-clientes.jsp");
		rd.forward(request, response);
	  }
	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
