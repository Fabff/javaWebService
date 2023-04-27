package com.directmedia.onlinestore.core;

import java.util.Set;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

public class Startup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Artist artistFilm1  = new Artist("John Travolta");
		Work film1 = new Work("Pulp Fiction");
		film1.setGenre("Gangster");
		film1.setMainArtist(artistFilm1);
		film1.setRelease(1994);
		film1.setSummary("L'odyssée sanglante, burlesque et cocasse de petits malfrats dans "
				+ "la jungle de Hollywood à travers trois histoires qui s'entremêlent.");
		
		Artist artistFilm2  = new Artist("Edward Norton");
		Work film2 = new Work("Fight Club");
		film2.setGenre("Drame");
		film2.setMainArtist(artistFilm2);
		film2.setRelease(1999);
		film2.setSummary("insomniaque, désillusionné par sa vie personnelle et professionnelle, "
				+ "un jeune cadre expert en assurances, mène une vie monotone et sans saveur...");
		
		Artist artistFilm3  = new Artist("Clint Eastwood");
		Work film3 = new Work("Le Bon, la Brute et le Truand");
		film3.setGenre("Western");
		film3.setMainArtist(artistFilm3);
		film3.setRelease(1966);
		film3.setSummary("Un chasseur de primes rejoint deux hommes dans une alliance précaire...");
		
		Catalogue.getListOfWorks().add(film1);
		Catalogue.getListOfWorks().add(film2);
		Catalogue.getListOfWorks().add(film3);
		
		Set<Work> listFilms = Catalogue.getListOfWorks();
		
		for (Work w : listFilms) {
			System.out.println(w.getTitle()+"("+w.getRelease()+")");
		}
	}

}
