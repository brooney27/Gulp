package controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBFunctions;
import model.Grestaurant;
import model.Greview;
import model.Guser;

/**
 * Servlet implementation class UpdateReview
 */
@WebServlet("/UpdateReview")
public class UpdateReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		String rating = request.getParameter("rating");
		String text = request.getParameter("review");
		String rid = request.getParameter("rid");
		String revid = request.getParameter("revid");
		
		Greview r = new Greview();
		
		Grestaurant rt = DBFunctions.getRestaurantByID(rid);
		HttpSession session = request.getSession();
		Guser user = (Guser)session.getAttribute("user");
		
		r.setGrestaurant(rt);
		r.setText(text);
		r.setRating(new BigDecimal(rating));
		r.setGuser((Guser)session.getAttribute("user"));
		r.setReviewdate(new Date());
		r.setGreviewid(Long.parseLong(revid));
		
		DBFunctions.update(r);
		user = DBFunctions.getUserByEmail(user.getEmail());
		
		session.setAttribute("user", user);
		
		request.getRequestDispatcher("/profile.jsp").forward(request,response);
	}

}
