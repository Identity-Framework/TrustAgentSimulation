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
//	private Parameters agentParams;
	private String agentName;
	
	Network net;
	
	private ArrayList neighbors;
	
	private boolean[] props;
	
	private double probTruth;
	
	private Iterator netIT;
	
	private int prop;
	
	public Agent(String label, boolean[] props) {
		agentName = label;
//		agentParams = RunEnvironment.getInstance().getParameters();
		
		neighbors = new ArrayList();
		this.props = props;
		
		probTruth = Math.random();
		
		prop = (int)Math.random()*50;
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
	
	public boolean speak() {
		double truth = Math.random();
		if(truth >= probTruth) {
			return props[prop];
		}
		else {
			return !props[prop];
		}
		
	}
	
}