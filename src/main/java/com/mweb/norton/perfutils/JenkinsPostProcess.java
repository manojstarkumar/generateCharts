package com.mweb.norton.perfutils;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

public class JenkinsPostProcess {
	
public int generateReports(String buildNumber) {
	
	GenerateCharts charts = new GenerateCharts();
	
	try {

		File sourceIndex = new File(Constants.jenkinsPhysical+"\\index.html");
		File destinatinIndex = new File(Constants.saveLocation+"index.html");
		
		charts.cmdRunner(Constants.cmdRunnerJar,Constants.jtlFile,"csv",Constants.saveLocation+"JAgg", "AggregateReport",null);
		charts.cmdRunner(Constants.cmdRunnerJar,Constants.jtlFile,"png",Constants.saveLocation+"JThreads", "ThreadsStateOverTime",null);
		charts.cmdRunner(Constants.cmdRunnerJar,Constants.jtlFile,"png",Constants.saveLocation+"JBytes", "BytesThroughputOverTime",null);
		charts.cmdRunner(Constants.cmdRunnerJar,Constants.jtlFile,"png",Constants.saveLocation+"JHits", "HitsPerSecond",null);
		charts.cmdRunner(Constants.cmdRunnerJar,Constants.jtlFile,"png",Constants.saveLocation+"JResponse", "ResponseTimesOverTime",null);
		charts.cmdRunner(Constants.cmdRunnerJar,Constants.jtlFile,"png",Constants.saveLocation+"JThroughput", "ThroughputVsThreads",null);
		charts.cmdRunner(Constants.cmdRunnerJar,Constants.jtlFile,"png",Constants.saveLocation+"JTimes", "TimesVsThreads",null);
		charts.cmdRunner(Constants.cmdRunnerJar,Constants.jtlFile,"png",Constants.saveLocation+"JTransactions", "TransactionsPerSecond",null);
		charts.cmdRunner(Constants.cmdRunnerJar,Constants.jtlFile,"csv",Constants.saveLocation+"JSynthesis", "SynthesisReport",null);

		System.out.println("File copy initiated...");
		System.out.println("SRC : "+sourceIndex.toString());
		System.out.println("Dest : "+destinatinIndex.toString());
		Files.copy(sourceIndex, destinatinIndex);
		
		return 0;/*Constants.reportLocation+"/"+buildNumber+"/archive";*/
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("OH... NO. AN Exception");
		return -1;/*"-1";*/
	}
}

public static void main(String args[]) {
	String saveLocation = Constants.jenkinsPhysical+"\\jobs\\JMeterExec\\builds\\22\\archive\\";
	File sourceIndex = new File(Constants.jenkinsPhysical+"\\index.html");
	File destinatinIndex = new File(saveLocation+"index.html");
	
	try {
		Files.copy(sourceIndex, destinatinIndex);
		System.out.println("copied");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
