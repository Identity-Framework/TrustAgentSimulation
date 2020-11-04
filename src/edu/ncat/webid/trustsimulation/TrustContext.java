package edu.ncat.webid.trustsimulation;

import java.io.IOException;

import repast.simphony.context.Context;
import repast.simphony.context.space.graph.NetworkBuilder;
import repast.simphony.context.space.graph.NetworkFileFormat;
import repast.simphony.dataLoader.ContextBuilder;

public class TrustContext implements ContextBuilder<Object> {

	@Override
	public Context<Object> build(Context<Object> context) {
		NetworkBuilder<Object> builder = new NetworkBuilder<Object>("Network", context, true);
		try {
			builder.load("", NetworkFileFormat.EXCEL, new TrustNodeCreator());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return context;
	}

}
