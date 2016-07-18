package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBFunctions;
import model.Guser;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Guser user = DBFunctions.getUserByEmail(request.getParameter("email"));
		HttpSession session = request.getSession();
		
		String nextUrl;
		
		if(user.getPassword().equals(request.getParameter("password"))){
			session.setAttribute("user", user);
			nextUrl = "/Home";
			String gravatar = customTools.Gravatar.getGravatarUrl(user.getEmail());
			//String gravatar = customTools.Gravatar.getGravatarUrl("briguy278@yahoo.com");
			session.setAttribute("gravatar", gravatar);
		}
		else{
			nextUrl = "/login.jsp";
		}
		request.getRequestDispatcher(nextUrl).forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
