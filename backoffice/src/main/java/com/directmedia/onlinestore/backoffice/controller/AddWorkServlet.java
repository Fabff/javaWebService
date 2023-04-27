package com.directmedia.onlinestore.backoffice.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

/**
 * Servlet implementation class AddWorkServlet
 */
@WebServlet(urlPatterns = {"/add-work"})
public class AddWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWorkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
			
		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Boolean success = true;
		
		Work filmSuivant= new Work(request.getParameter("titre"));
		filmSuivant.setGenre(request.getParameter("genre"));
		
		filmSuivant.setMainArtist(new Artist(request.getParameter("artiste")));
		
		try
		{
			filmSuivant.setRelease(Integer.parseInt(request.getParameter("annee")));
		}catch(Exception e){
			success = false;
		}
		
		filmSuivant.setSummary(request.getParameter("resume"));
		
		Optional<Work> optWork= Catalogue.getListOfWorks().stream().filter(w -> w.getTitle().equalsIgnoreCase(filmSuivant.getTitle()) && w.getRelease()==filmSuivant.getRelease() 
				&& w.getMainArtist().getName().equalsIgnoreCase(filmSuivant.getMainArtist().getName())).findAny();
		
		if (optWork.isPresent()){
			success = false;
		}
		
		if (success) {
			Catalogue.getListOfWorks().add(filmSuivant);
			
			request.setAttribute("identifiantOeuvre", filmSuivant.getId());
			
			RequestDispatcher disp = request.getRequestDispatcher("workAddedSuccess");
			disp.forward(request, response);
		}else if (success==false) {
			RequestDispatcher disp = request.getRequestDispatcher("/workAddedFailure");
			disp.forward(request, response);
		}
			}

}
