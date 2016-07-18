package controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBFunctions;
import customTools.DBUtil;
import model.Grestaurant;
import model.Greview;
import model.Guser;

@WebServlet("/AddReview")
public class AddReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String rating = request.getParameter("rating");
		String text = request.getParameter("review");
		String rid = request.getParameter("rid");
		
		Greview r = new Greview();
		
		Grestaurant rt = DBFunctions.getRestaurantByID(rid);
		HttpSession session = request.getSession();
		
		r.setGrestaurant(rt);
		r.setText(text);
		r.setRating(new BigDecimal(rating));
		r.setGuser((Guser)session.getAttribute("user"));
		r.setReviewdate(new Date());
		
		DBFunctions.insert(r);
		rt.addGreview(r);
		
		List<Greview> revs = rt.getGreviews();
		double avg = 0;
		
		for(Greview rev:revs){
			avg+=rev.getRating().doubleValue();
		}
		avg=avg/revs.size();
		rt.getAvgrating().setAvgrating(new BigDecimal(avg));
		
		request.getRequestDispatcher("/Home").forward(request,response);
	}

}
