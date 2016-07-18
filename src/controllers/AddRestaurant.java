package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.DBFunctions;
import model.Grestaurant;

@WebServlet("/AddRestaurant")
public class AddRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddRestaurant() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String description = request.getParameter("description");
		
		Grestaurant r = new Grestaurant();
		
		r.setGname(name);
		r.setAddress(address);
		r.setDescription(description);
		
		DBFunctions.insert(r);
		
		request.getRequestDispatcher("/Home").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
