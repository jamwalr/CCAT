package com.bizviz.ccat.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bizviz.ccat.db.DataLayer;
import com.bizviz.ccat.modal.User;

/**
 * Servlet implementation class BeginTest
 */
public class BeginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeginTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String uid = request.getParameter("uid");
		String tid = request.getParameter("tid");
		
		ValidateTest valid = new ValidateTest();
		String isValid = valid.checkValidity(uid, tid);
		
		if(isValid.equals("BeginTest")){
			User user = DataLayer.getUser(uid);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.setAttribute(null, null);
			request.getRequestDispatcher("exam_form.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}
}
