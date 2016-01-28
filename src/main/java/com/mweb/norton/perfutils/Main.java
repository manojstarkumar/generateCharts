package com.mweb.norton.perfutils;

import java.io.IOException;
import java.util.HashMap;

import com.mweb.norton.perfutils.actions.InsertToMongo;
import com.mweb.norton.perfutils.actions.WriteCSV;
import com.mweb.norton.perfutils.modal.RunData;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		JenkinsPostProcess postProcess = new JenkinsPostProcess();
		if(args.length!=12) {
			System.out.println("Usage --b <build> --c <comment> --u <users> --d <duration> --t <test> --p <param>");
			System.exit(-1);
		}
		HashMap<String,Integer> acceptedParams = new HashMap<String,Integer>();
		acceptedParams.put("b",0);acceptedParams.put("c",1);acceptedParams.put("u",2);
		acceptedParams.put("d",3);acceptedParams.put("t",4);acceptedParams.put("p",5);
		String[] argsArray = new String[6];
		for(int i=0;i<12;i++){
			if(i%2==0){
				if(!args[i].startsWith("--")) {
					System.out.println("Illegal argument " + args[i]);
					System.exit(-1);
				}
				else {
					//position = acceptedParams.get(args[i].substring(2));
					if(acceptedParams.get(args[i].substring(2))==null) {
						System.out.println("Illegal argument " + args[i]);
						System.exit(-1);
					}
					else {
						argsArray[acceptedParams.get(args[i].substring(2))] = args[i+1];
						i++;
						//System.out.println(acceptedParams.get(args[i].substring(2)));
					}
					
				}
			}
		}
		postProcess.generateReports(argsArray[0]);
		RunData run = new RunData(argsArray[0],argsArray[1],argsArray[2],argsArray[3],argsArray[4],argsArray[5]);
		new InsertToMongo().putJson(run);
		new WriteCSV().tableCSV();
	}

}
