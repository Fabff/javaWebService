package com.directmedia.onlinestore.core.entity;

import java.util.HashSet;
import java.util.Set;

public class Catalogue {
	static Set<Work> listOfWorks = new HashSet<Work>();

	public static void setListOfWorks(Set<Work> listOfWorks) {
		Catalogue.listOfWorks = listOfWorks;
	}
	public static Set<Work> getListOfWorks() {
		return listOfWorks;
	}
}
