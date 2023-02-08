package web_app_completed.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_app_completed.Model.DAOService;
import web_app_completed.Model.DAOServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emailId = request.getParameter("emailid");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		session.setAttribute("emailid", emailId);
		DAOService service = new DAOServiceImpl();
		service.connectionDB();
		boolean status = service.verifyCreditial(emailId, password);
		if (status == true) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/registrationPage.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("invaild", "EmailId/Password Invaild");
			RequestDispatcher rd = request.getRequestDispatcher("indexLoginPage.jsp");
			rd.forward(request, response);
		}

	}

}
