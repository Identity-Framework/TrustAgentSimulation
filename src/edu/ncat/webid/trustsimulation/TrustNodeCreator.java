package edu.ncat.webid.trustsimulation;

import repast.simphony.context.space.graph.NodeCreator;

public class TrustNodeCreator implements NodeCreator<Agent>{
	
	boolean[] props;
	
	public TrustNodeCreator(boolean[] props) {
		this.props=props;
	}

	@Override
	public Agent createNode(String label) {
		return new Agent(label, props);
	}
}
