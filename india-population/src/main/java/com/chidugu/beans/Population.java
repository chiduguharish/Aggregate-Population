package com.chidugu.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


public class Population {
	
	String population;
	String male;
	String female;
	
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getMale() {
		return male;
	}
	public void setMale(String male) {
		this.male = male;
	}
	public String getFemale() {
		return female;
	}
	public void setFemale(String female) {
		this.female = female;
	}
	
	

}
