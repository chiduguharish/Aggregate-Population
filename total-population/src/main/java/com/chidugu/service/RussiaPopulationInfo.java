package com.chidugu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chidugu.beans.Population;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class RussiaPopulationInfo {
	
	@Autowired
    private RestTemplate restTemplate;
	
	
	@HystrixCommand(fallbackMethod = "getFallBackRussiaPopulation",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000")
	})
	public Population getRussiaPopulation() {
		Population population = restTemplate.getForObject("http://russia-population/russia/population", Population.class);
		return population;
	}
	
	public Population getFallBackRussiaPopulation() {
		Population population = new Population();
		population.setPopulation("0");
		population.setMale("0");
		population.setFemale("0");
		return population;
	}

}
