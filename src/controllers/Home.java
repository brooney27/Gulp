package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.DBFunctions;
import model.Grestaurant;
import model.Greview;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Home() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Grestaurant> restaurants = DBFunctions.getRestaurants();
		
		int size = restaurants.size();
		
		//for(Grestaurant r : restaurants){
		//System.out.println(r.getGname()+" "+r.getAvgrating().getAvgrating());
	//}

		for(int i = 0; i < size; i++){
			for(int j = 0; j < size-1; j++){
				if(restaurants.get(j+1).getAvgrating()!=null){//if second is null do nothing
					if(restaurants.get(j).getAvgrating()!=null){//if both have values compare
						double r1 = restaurants.get(j).getAvgrating().getAvgrating().doubleValue();
						double r2 = restaurants.get(j+1).getAvgrating().getAvgrating().doubleValue();
						if(r1<r2){
							Grestaurant temp = restaurants.get(j);
							restaurants.set(j, restaurants.get(j+1));
							restaurants.set(j+1, temp);
						}
					}
					else {//if just the second has value swap
						Grestaurant temp = restaurants.get(j);
						restaurants.set(j, restaurants.get(j+1));
						restaurants.set(j+1, temp);
					}
				}
			}
		}
		
		request.setAttribute("restaurants", restaurants);

		request.getRequestDispatcher("/home.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
