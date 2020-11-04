package edu.ncat.webid.trustsimulation;

import repast.simphony.context.space.graph.NodeCreator;

public class TrustNodeCreator implements NodeCreator<Agent>{

	@Override
	public Agent createNode(String label) {
		return new Agent(label);
	}
}
