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
	
	Network net;
	
	private ArrayList neighbors;
	
	private boolean[] props;
	
	public Agent(String label, boolean[] props) {
		agentName = label;
		agentParams = RunEnvironment.getInstance().getParameters();
		
		neighbors = new ArrayList();
		this.props = props;
		
	}
	
	public void init() {
		Context context = ContextUtils.getContext(this);
		
		net = (Network)context.getProjection("Network");
		
		Iterable it = net.getAdjacent(this);
		
		for(Object o: it) {
			neighbors.add(o);
		}
	}
	
	@ScheduledMethod()
	public void step() {
		
	}
	
}
