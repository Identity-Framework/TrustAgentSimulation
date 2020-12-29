package edu.ncat.webid.trustsimulation;

import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.graph.NetworkTraverser;
import repast.simphony.engine.schedule.ScheduledMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import repast.simphony.context.Context;
import repast.simphony.parameter.Parameters;
import repast.simphony.space.graph.Network;
import repast.simphony.util.ContextUtils;

public class Agent {
//	private Parameters agentParams;
	private String agentName;
	
	private Network net;
	
	private ArrayList neighbors;
	
	private boolean[] props;
	
	private double probTruth;
	
	private int prop;
	
	private HashMap<String, ArrayList<Integer>> expertInfo;
	
	private HashMap<String, AgentTrustInformation> trust;
	
	private NetworkTraverser nt;
	
	private ArrayList<Integer> expertise;
	
	public Agent(String label, boolean[] props) {
		setAgentName(label);
//		agentParams = RunEnvironment.getInstance().getParameters();
		
		neighbors = new ArrayList();
		this.props = props;
		
		probTruth = Math.random();
		
		prop = (int)Math.random()*50;
		
		trust = new HashMap<String, AgentTrustInformation>();
		
		expertInfo = new HashMap<String, ArrayList<Integer>>();
		
		nt = new NetworkTraverser(net);
	}
	
	@ScheduledMethod(start=0)
	public void init() {
		Context context = ContextUtils.getContext(this);
		
		net = (Network)context.getProjection("Network");
		
		Iterable it = net.getAdjacent(this);
		
		for(Object o: it) {
			neighbors.add(o);
		}
		
	}
	
	@ScheduledMethod(start=1, interval=1)
	public void step() {
		Agent neighbor = null;
		Iterator netIter;
		
		int count = 0;
		int prop = 0;
		
		while(neighbor == null) {
			if(((Agent)neighbors.get(count)).askExpert(prop)) {
				neighbor = (Agent)neighbors.get(count);
			}
			
		}
		
	}
	
	public boolean speak(int prop) {
		double truth = Math.random();
		if(truth >= probTruth) {
			return props[prop];
		}
		else {
			return !props[prop];
		}
		
	}
	
	public boolean askExpert(int prop) {
		return expertise.contains(prop);
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	
	public double findTrust(Agent ag) {
		return 0.0;
	}
	
}