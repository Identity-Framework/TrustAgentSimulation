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
	
	private NetworkTraverser nt;
	
	private ArrayList neighbors;
	
	private boolean[] props;
	
	private double probTruth;
	
	private Iterator netIT;
	
	private int prop;
	
	private HashMap<String, AgentTrustInformation> trust;
	
	public Agent(String label, boolean[] props) {
		setAgentName(label);
//		agentParams = RunEnvironment.getInstance().getParameters();
		
		neighbors = new ArrayList();
		this.props = props;
		
		probTruth = Math.random();
		
		prop = (int)Math.random()*50;
		
		trust = new HashMap<String, AgentTrustInformation>();
	}
	
	@ScheduledMethod(start=0)
	public void init() {
		Context context = ContextUtils.getContext(this);
		
		net = (Network)context.getProjection("Network");
		
		Iterable it = net.getAdjacent(this);
		
		for(Object o: it) {
			neighbors.add(o);
		}
		
		nt = new NetworkTraverser(net);
		
	}
	
	@ScheduledMethod(start=1, interval=1)
	public void step() {
		Agent neighbor;
		
		if(netIT != null || netIT.hasNext()) {
			neighbor = (Agent) netIT.next();
			
			if(!trust.containsKey(neighbor.getAgentName())) {
				trust.put(neighbor.getAgentName(), new AgentTrustInformation());
				trust.get(neighbor.getAgentName()).setTransTrust(findTrust(neighbor));
			}
			
		}
		
		else {
			int rdmIdx = (int)Math.random()*neighbors.size();
			neighbor = (Agent) neighbors.get(rdmIdx);
			
			if(!trust.containsKey(neighbor.getAgentName())) {
				trust.put(neighbor.getAgentName(), new AgentTrustInformation());
				trust.get(neighbor.getAgentName()).setTransTrust(0.0);
			}
			
			netIT = nt.getSuccessors(this, neighbor);
		}
		
		
		
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