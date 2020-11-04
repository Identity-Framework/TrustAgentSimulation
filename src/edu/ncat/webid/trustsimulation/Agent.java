package edu.ncat.webid.trustsimulation;

import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.parameter.Parameters;

public class Agent {
	private Parameters agentParams;
	private String agentName;
	
	private double posInteractRate;
	
	private int posInteract;
	
	
	public Agent(String label) {
		agentName = label;
		agentParams = RunEnvironment.getInstance().getParameters();
		
		posInteractRate = agentParams.getDouble("InitialPositiveInteractionRate");
	}
	
	@ScheduledMethod()
	public void step() {
		
	}
	
}
