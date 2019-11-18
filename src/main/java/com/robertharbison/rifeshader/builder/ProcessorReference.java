package com.robertharbison.rifeshader.builder;

public class ProcessorReference {

	public static final String PRE_PROCESSOR_SYMBOL = "#";
	public static final String TYPE_COMMAND = getProcessorString("type");
	public static final String INCLUDE_COMMAND = getProcessorString("include");
	
	private static String getProcessorString(String variable) {
		return PRE_PROCESSOR_SYMBOL + variable;
	}
}
