package com.directmedia.onlinestore.backoffice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * Servlet implementation class CatalogueServlet
 */
@WebServlet(urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		
		
		Work film1=null;
		Work film2=null;
		Work film3=null;
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Artist artistFilm1  = new Artist("John Travolta");
		Artist artistFilm2  = new Artist("Edward Norton");
		Artist artistFilm3  = new Artist("Clint Eastwood");
		
		Optional<Work> test = Catalogue.getListOfWorks().stream().filter(w -> w.getTitle().equalsIgnoreCase("Pulp Fiction")).findAny();
		if (!(test.isPresent())) {
		film1 = new Work("Pulp Fiction");
		film1.setGenre("Gangster");
		film1.setMainArtist(artistFilm1);
		film1.setRelease(1994);
		film1.setSummary("L'odyssée sanglante, burlesque et cocasse de petits malfrats dans "
				+ "la jungle de Hollywood à travers trois histoires qui s'entremêlent.");
		}
		
		Optional<Work> test2 = Catalogue.getListOfWorks().stream().filter(w -> w.getTitle().equalsIgnoreCase("Fight Club")).findAny();
		if (!(test2.isPresent())) {
		film2 = new Work("Fight Club");
		film2.setGenre("Drame");
		film2.setMainArtist(artistFilm2);
		film2.setRelease(1999);
		film2.setSummary("insomniaque, désillusionné par sa vie personnelle et professionnelle, "
				+ "un jeune cadre expert en assurances, mène une vie monotone et sans saveur...");
		}
		
		Optional<Work> test3 = Catalogue.getListOfWorks().stream().filter(w -> w.getTitle().equalsIgnoreCase("Le Bon, la Brute et le Truand")).findAny();
		if (!(test3.isPresent())) {
		film3 = new Work("Le Bon, la Brute et le Truand");
		film3.setGenre("Western");
		film3.setMainArtist(artistFilm3);
		film3.setRelease(1966);
		film3.setSummary("Un chasseur de primes rejoint deux hommes dans une alliance précaire...");
		}
		
		if (Catalogue.getListOfWorks().isEmpty())
		{
			Catalogue.getListOfWorks().add(film1);
			Catalogue.getListOfWorks().add(film2);
			Catalogue.getListOfWorks().add(film3);
		}
		
		objectMapper.writeValue(out, Catalogue.getListOfWorks());

	}


}
