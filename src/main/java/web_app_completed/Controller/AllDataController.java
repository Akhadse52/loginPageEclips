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

@WebServlet("/list")
public class AllDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AllDataController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("emailid")!=null) {
		DAOService service = new DAOServiceImpl();
		service.connectionDB();
		ResultSet result = service.allData();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/allData.jsp");
		rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("indexLoginPage.jsp");
			rd.forward(request, response);
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
