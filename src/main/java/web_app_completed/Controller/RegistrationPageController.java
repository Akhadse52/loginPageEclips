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
@WebServlet("/reg")
public class RegistrationPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegistrationPageController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/registrationPage.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("emailid")!=null) {
		
		String name = request.getParameter("name");
		String emailId = request.getParameter("emailid");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		
		DAOService service = new DAOServiceImpl();
		service.connectionDB();
		service.saveData(name,emailId,mobile,password);
		request.setAttribute("save", "Data Save Succefully");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/registrationPage.jsp");
		rd.forward(request, response);
	}else {
		RequestDispatcher rd = request.getRequestDispatcher("indexLoginPage.jsp");
		rd.forward(request, response);
	}
	}

}
