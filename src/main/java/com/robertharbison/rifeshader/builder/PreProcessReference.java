package com.robertharbison.rifeshader.builder;

public class PreProcessReference {

	public static final String PRE_PROCESSOR_SYMBOL = "#";
	public static final String TYPE_COMMAND = getPreProcessorString("type");
	public static final String INCLUDE_COMMAND = getPreProcessorString("include");
	
	private static String getPreProcessorString(String variable) {
		return PRE_PROCESSOR_SYMBOL + variable;
	}
}
