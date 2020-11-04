package edu.ncat.webid.trustsimulation;

import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.context.Context;
import repast.simphony.parameter.Parameters;
import repast.simphony.space.graph.Network;
import repast.simphony.util.ContextUtils;

public class Agent {
	private Parameters agentParams;
	private String agentName;
	
	private double posInteractRate;
	
	private int posInteract;
	private int negInteract;
	
	Network net;
	
	
	
	public Agent(String label) {
		agentName = label;
		agentParams = RunEnvironment.getInstance().getParameters();
		
		posInteractRate = agentParams.getDouble("InitialPositiveInteractionRate");
	}
	
	public void init() {
		Context context = ContextUtils.getContext(this);
	}
	
	@ScheduledMethod()
	public void step() {
		
	}
	
}
