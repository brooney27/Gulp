package controllers;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBFunctions;
import model.Guser;

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String zip = request.getParameter("zip");
		Guser Cuser = (Guser)session.getAttribute("user");
		long id = Cuser.getGuserid();
		
		Guser user = new Guser();
		user.setEmail(email);
		user.setZip(new BigDecimal(zip));
		user.setGname(name);
		user.setPassword(password);
		user.setGuserid(id);
		user.setGreviews(Cuser.getGreviews());
		
		DBFunctions.update(user);
		
		session.setAttribute("user", user);
		
		String gravatar = customTools.Gravatar.getGravatarUrl(user.getEmail());
		session.setAttribute("gravatar", gravatar);
		
		request.getRequestDispatcher("/profile.jsp").forward(request,response);
	}
}
