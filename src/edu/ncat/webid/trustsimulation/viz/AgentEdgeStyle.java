package edu.ncat.webid.trustsimulation.viz;

import repast.simphony.visualization.visualization3D.style.DefaultEdgeStyle3D;
import repast.simphony.visualization.visualization3D.style.TaggedAppearance;
import repast.simphony.visualization.visualization3D.style.TaggedBranchGroup;
import repast.simphony.visualization.visualization3D.style.EdgeStyle3D.EdgeType;

public class AgentEdgeStyle extends DefaultEdgeStyle3D<Object>{
	@Override
	public TaggedBranchGroup getBranchGroup(Object o, TaggedBranchGroup taggedGroup) {
		return null;
	}

	@Override
	public EdgeType getEdgeType() {
		return EdgeType.LINE;
	}

	@Override
	public TaggedAppearance getAppearance(Object t, TaggedAppearance taggedAppearance, Object shapeID) {
	}
}
