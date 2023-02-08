package web_app_completed.Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_app_completed.Model.DAOService;
import web_app_completed.Model.DAOServiceImpl;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("emailid")!=null) {
		
		String emailId = request.getParameter("email");
	String mobile = request.getParameter("mobile");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	
	request.setAttribute("emailid", emailId);
	request.setAttribute("mobile", mobile);
	request.setAttribute("name", name);
	request.setAttribute("password", password);
	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/UpdatePage.jsp");
	rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("indexLoginPage.jsp");
			rd.forward(request, response);
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		if(session.getAttribute("emailid")!=null) {
		String emailId = request.getParameter("emailid");
		String mobile = request.getParameter("mobile");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		DAOService service = new DAOServiceImpl();
		service.connectionDB();
		service.updateData(emailId,mobile,name,password);
		ResultSet result = service.allData();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/allData.jsp");
		rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("indexLoginPage.jsp");
			rd.forward(request, response);
		}

	
	}

}
