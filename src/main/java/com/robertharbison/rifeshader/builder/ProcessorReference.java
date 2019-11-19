package com.robertharbison.rifeshader.builder;

/*
 * Variables used during the building of shaders.
 */
public class ProcessorReference {

	public static final String PRE_PROCESSOR_SYMBOL = "#";
	public static final String TYPE_COMMAND = getProcessorString("type");
	public static final String REQUIRE_COMMAND = getProcessorString("require");
	
	private static String getProcessorString(String variable) {
		return PRE_PROCESSOR_SYMBOL + variable;
	}
}
