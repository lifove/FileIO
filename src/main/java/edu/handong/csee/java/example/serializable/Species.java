package edu.handong.csee.java.example.serializable;

import java.io.Serializable;

public class Species implements Serializable {
	private String name;
	private int population;
	private double growthRate;
	
	public Species(){
		name = null;
		population = 0;
		growthRate = 0;
	}
	
	public Species(String initialName, int initialPopulation, double initialGrowthRate){
		name = initialName;
		if(initialPopulation >= 0){
			population = initialPopulation;
		} else{
			System.out.println("ERROR: NEgative population.");
			System.exit(0);
		}
		
		growthRate = initialGrowthRate;
	}
	
	public String toString() {
		return ("Name = " + name + "\n" + "Population = " + population + "\n" + "Growth rate = " + growthRate + "%");
	}
	
}
