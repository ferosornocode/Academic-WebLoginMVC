package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Authenticator;
import model.User;

public class LoginController extends HttpServlet {
private static final long serialVersionUID = 1L;
	public LoginController() {
		super();
	}
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
                RequestDispatcher rd = null;
                
                
		String username = request.getParameter("username");
		String password = request.getParameter("password");
                
		
		Authenticator authenticator = new Authenticator();
                User user = authenticator.authenticate(username, password);
                
		if (user!=null)
                {
			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("user", user);
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
}
