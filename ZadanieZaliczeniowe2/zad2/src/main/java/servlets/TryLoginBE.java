package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import others.Attributes;
import others.Database;
import others.Links;
import others.User;

/**
 * Servlet implementation class IndexBE
 */
@WebServlet(Links.tryLogin)
public class TryLoginBE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TryLoginBE() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getParameter(Attributes.username);
		String password = (String) request.getParameter(Attributes.password);
		User user = Database.getUser(username, password);

		if (user == null) {
			request.setAttribute(Attributes.loginAnswer, "Failed to login");
			request.getRequestDispatcher(Links.login + ".jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute(Attributes.currentUser, user);
		response.sendRedirect(Links.profile + ".jsp");
	}

}
