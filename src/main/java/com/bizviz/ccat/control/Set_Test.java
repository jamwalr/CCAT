package com.bizviz.ccat.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizviz.ccat.modal.Test;
import com.bizviz.ccat.modal.User;

/**
 * Servlet implementation class Set_Test
 */
public class Set_Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Set_Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String userName = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		
		User user = new User(userName, user_email);
		
		String startDate = request.getParameter("start_date");
		String expiryDate = request.getParameter("exam_expiry");
		
		Test test = new Test(user,startDate,expiryDate); 
	}

}
