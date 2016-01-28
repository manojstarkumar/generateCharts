package com.mweb.norton.perfutils.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.mweb.norton.perfutils.Constants;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WriteCSV {
	
	public void tableCSV() throws IOException {
		BufferedReader br = null;
		br = new BufferedReader(new FileReader(Constants.saveLocation+"JSynthesis.csv"));
		br.readLine().split(",");
		String line;
		String[] lineArray = null;
		
		JSONArray metric = new JSONArray();
		while((line=br.readLine())!=null){
			lineArray=line.split(",");
			JSONArray single = new JSONArray();
			for(String s : lineArray) single.add(s);
			metric.add(single);
		}
		JSONObject json = new JSONObject();
		json.put("data", metric);
		br.close();
		FileWriter fw = new FileWriter(new File(Constants.saveLocation+"csv.data"));
		fw.write(json.toString());
		fw.close();
	}
	
}
