package edu.ncat.webid.trustsimulation;

import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.graph.NetworkTraverser;
import repast.simphony.engine.schedule.ScheduledMethod;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	private double propTruth;
	
	private Iterator netIT;
	
	public Agent(String label, boolean[] props) {
		agentName = label;
		agentParams = RunEnvironment.getInstance().getParameters();
		
		neighbors = new ArrayList();
		this.props = props;
		
		propTruth = Math.random();
	}
	
	@ScheduledMethod(start=0)
	public void init() {
		Context context = ContextUtils.getContext(this);
		
		net = (Network)context.getProjection("Network");
		
		Iterable it = net.getAdjacent(this);
		
		for(Object o: it) {
			neighbors.add(o);
		}
		
		NetworkTraverser nt = new NetworkTraverser(net);
	}
	
	@ScheduledMethod(start=1, interval=1)
	public void step() {
		
	}
	
}