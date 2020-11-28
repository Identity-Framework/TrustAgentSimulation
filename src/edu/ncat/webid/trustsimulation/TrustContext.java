package edu.ncat.webid.trustsimulation;

import java.io.IOException;
import java.util.Random;

import repast.simphony.context.Context;
import repast.simphony.context.space.graph.NetworkBuilder;
import repast.simphony.context.space.graph.NetworkFileFormat;
import repast.simphony.dataLoader.ContextBuilder;

public class TrustContext implements ContextBuilder<Object> {

	@Override
	public Context<Object> build(Context<Object> context) {
		
		context.setId("TrustSim");
		
		boolean[] props = new boolean[50];
		Random rBoolean = new Random();
		
		for(int i=0; i<props.length; i++) {
			props[i] = rBoolean.nextBoolean();
		}
		NetworkBuilder<Object> builder = new NetworkBuilder<Object>("Network", context, true);
		try {
			builder.load("dolphins.xls", NetworkFileFormat.EXCEL, new TrustNodeCreator(props));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return context;
	}

}
