package projects.covidSimulator;

import projects.covidSimulator.simulator.Simulator;

public class DriverCovid {

	public static void main(String[] args) {
		Simulator sim = new Simulator();
		sim.start();
	}

}
