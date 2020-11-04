package edu.ncat.webid.trustsimulation;

import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.schedule.ScheduledMethod;

import java.util.ArrayList;

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
	
	private ArrayList neighbors;
	
	
	
	public Agent(String label) {
		agentName = label;
		agentParams = RunEnvironment.getInstance().getParameters();
		
		posInteractRate = agentParams.getDouble("InitialPositiveInteractionRate");
		neighbors = new ArrayList();
	}
	
	public void init() {
		Context context = ContextUtils.getContext(this);
		
		net = (Network)context.getProjection("Network");
		
		Iterable it = net.getAdjacent(this);
		
		for
	}
	
	@ScheduledMethod()
	public void step() {
		
	}
	
}
