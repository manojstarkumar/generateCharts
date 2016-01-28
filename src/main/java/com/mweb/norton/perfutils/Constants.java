package com.mweb.norton.perfutils;


public class Constants {
	
	public static final String repoLocation = "C:\\JMXSources";
	public static final String jenkinsHome = "http://10.223.19.73/jenkins/";
	public static final String jmeterBuildJob = "JMeterExec";
	public static final String jmeterHome = "C:\\apache-jmeter-2.13";
	public static final String jenkinsPhysical = "C:\\Program Files (x86)\\Jenkins";
	public static final String reportLocation = "/jmeterResults";
	public static final String cmdRunnerJar = Constants.jmeterHome+"\\lib\\ext\\CMDRunner.jar";
	public static final String jtlFile = Constants.jenkinsPhysical+"\\workspace\\"+jmeterBuildJob+"\\results.jtl";
	public static final String saveLocation = Constants.jenkinsPhysical+"\\workspace\\"+jmeterBuildJob+"\\";
	public static final String mongoHost ="localhost";
	public static final String mongoDatabase ="test";
	public static final String mongoCollection ="jMeterStats";

}
