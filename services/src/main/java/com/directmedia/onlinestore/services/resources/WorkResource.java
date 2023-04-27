package com.directmedia.onlinestore.services.resources;

import java.util.Optional;
import java.util.Set;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

@Path("/work")
public class WorkResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Work> liste() {
				
		Work film1=null;
		Work film2=null;
		Work film3=null;
		
	
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
		
		return Catalogue.getListOfWorks();
		
	}
	
	@POST
	public Response ajout(@FormParam("name") String name, @FormParam("genre") String genre, @FormParam("title") String title, @FormParam("release") int release, @FormParam("summary") String summary ) {
		
			Work film=null;
			Artist artistFilm  = new Artist(name);
			
			Optional<Work> test = Catalogue.getListOfWorks().stream().filter(w -> w.getTitle().equalsIgnoreCase(title)).findAny();
			if (!(test.isPresent())) {
			film = new Work(title);
			film.setGenre(genre);
			film.setMainArtist(artistFilm);
			film.setRelease(release);
			film.setSummary(summary);
			Catalogue.getListOfWorks().add(film);
			
		}
		
		return Response.status(Response.Status.CREATED).build();
	}
	
}
