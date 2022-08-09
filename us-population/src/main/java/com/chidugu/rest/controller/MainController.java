package com.chidugu.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chidugu.bean.Population;

@RestController
@RequestMapping("/us")
@RefreshScope
public class MainController {
	

	@Value(value = "${population}")
	String totalPopulation;
	
	@Value(value = "${male}")
	String male;
	
	@Value(value = "${female}")
	String female;
	
	
	@RequestMapping("/population")
	Population getPopulation() {
		
		Population population = new Population();
		population.setPopulation(totalPopulation);
		population.setMale(male);
		population.setFemale(female);
	
		return population;
	}

}
