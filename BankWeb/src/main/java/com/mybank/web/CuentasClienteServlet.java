package com.mybank.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybank.domain.Account;
import com.mybank.domain.Customer;
import com.mybank.services.CuentasClienteService;

/**
 * Servlet implementation class CuentasClienteServlet
 */
public class CuentasClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuentasClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramIdCliente = request.getParameter("idCliente");
		int idCliente = Integer.parseInt(paramIdCliente);
		CuentasClienteService ccs = new CuentasClienteService();
		List<Account> la = ccs.getCuentasCliente(idCliente);
		
		request.setAttribute("lista", la);
		
		//llamar
		RequestDispatcher rd  = request.getRequestDispatcher("cuentas-cliente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
