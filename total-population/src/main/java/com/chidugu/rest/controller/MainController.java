package com.chidugu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chidugu.beans.Population;
import com.chidugu.beans.TotalPopulation;
import com.chidugu.service.IndiaPopulationInfo;
import com.chidugu.service.RussiaPopulationInfo;
import com.chidugu.service.UsPopulationInfo;

@RestController
@RequestMapping("/total")
public class MainController {
	
	@Autowired
	IndiaPopulationInfo indiaPopulation;
	
	@Autowired
	RussiaPopulationInfo russiaPopulation;
	
	@Autowired
	UsPopulationInfo usPopulation;
	
	
	@RequestMapping("/population")
	TotalPopulation getTotalPopulation() {
		TotalPopulation totalPopulation = new TotalPopulation();
		
		Population population = indiaPopulation.getIndiaPopulation();
		
		if(!population.getPopulation().equals("0")) {
			totalPopulation.setTotalPopulation(Integer.parseInt(population.getPopulation()));
			totalPopulation.setMalePopulation(Integer.parseInt(population.getMale()));
			totalPopulation.setFemalePopulation(Integer.parseInt(population.getFemale()));
			totalPopulation.setInfo("India");
		}
		
		population = russiaPopulation.getRussiaPopulation();
		
		if(!population.getPopulation().equals("0")) {
			totalPopulation.setTotalPopulation(Integer.parseInt(population.getPopulation()) + totalPopulation.getTotalPopulation());
			totalPopulation.setMalePopulation(Integer.parseInt(population.getMale())+ totalPopulation.getMalePopulation());
			totalPopulation.setFemalePopulation(Integer.parseInt(population.getFemale())+ totalPopulation.getFemalePopulation());
			totalPopulation.setInfo("Russia".concat(totalPopulation.getInfo() == null? "" : ","+totalPopulation.getInfo()));
		}
		
		population = usPopulation.getUsPopulation();
		
		if(!population.getPopulation().equals("0")) {
			totalPopulation.setTotalPopulation(Integer.parseInt(population.getPopulation()) + totalPopulation.getTotalPopulation());
			totalPopulation.setMalePopulation(Integer.parseInt(population.getMale())+ totalPopulation.getMalePopulation());
			totalPopulation.setFemalePopulation(Integer.parseInt(population.getFemale())+ totalPopulation.getFemalePopulation());
			totalPopulation.setInfo("US".concat(totalPopulation.getInfo() == null? "" : ","+totalPopulation.getInfo()));
		}
		
		if(totalPopulation.getInfo() == null || totalPopulation.getInfo().equals(""))
			totalPopulation.setInfo("No Data");
		else
			totalPopulation.setInfo("Information contains data of "+totalPopulation.getInfo()+" contry/contries.");
		
		return totalPopulation;
	}
	

}
