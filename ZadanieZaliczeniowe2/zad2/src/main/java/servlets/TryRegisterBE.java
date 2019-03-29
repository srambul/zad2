package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import others.Attributes;
import others.Database;
import others.Links;
import others.User;

/**
 * Servlet implementation class IndexBE
 */
@WebServlet(Links.tryRegister)
public class TryRegisterBE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TryRegisterBE() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(Links.register + ".jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = assembleUser(request);
		boolean success = Database.addUser(user);
		
		if(success) {
			request.setAttribute(Attributes.regAnswer, "Register successful");
		}else{
			 request.setAttribute(Attributes.regAnswer, "Register unsuccessful");
		}
		request.getRequestDispatcher(Links.register+".jsp").forward(request, response);
	}

	private User assembleUser(HttpServletRequest request) {
		User user = new User();
		user.setAdmin(false);
		user.setPremium(false);
		user.setEmail(request.getParameter(Attributes.email));
		user.setPassword(request.getParameter(Attributes.password));
		user.setUserName(request.getParameter(Attributes.username));
		return user;
	}

}
