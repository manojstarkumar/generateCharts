package com.mweb.norton.perfutils.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;
import com.mweb.norton.perfutils.Constants;
import com.mweb.norton.perfutils.modal.RunData;

public class InsertToMongo {

	public void putJson(RunData run) throws IOException {
		File csv = new File(Constants.saveLocation+"JAgg.csv");
		String testCase = run.getTestScript();
		String users = run.getUsers();
		String duration = run.getDuration();
		String comment = run.getComment();
		
		BufferedReader br = null;
		Mongo mongo = null;
		try {
		br = new BufferedReader(new FileReader(csv));
		String headers[] = br.readLine().split(",");
		
		String line;
		String[] lineArray = null;
		
		JSONObject obj = new JSONObject();
		obj.put("test", testCase);
		obj.put("users", users);
		obj.put("duration", duration);
		obj.put("comment", comment);
		
		JSONArray metric = new JSONArray();
		while((line=br.readLine())!=null){
			int i = 0;
			lineArray=line.split(",");
			JSONObject sample = new JSONObject();
			for(String head : headers){
			sample.put(head, lineArray[i]);
			i++;
			}
			metric.add(sample);
		}
		obj.put("metric", metric);

		mongo = new Mongo(Constants.mongoHost, 27017);
		DB db = mongo.getDB(Constants.mongoDatabase);
		System.out.println("Connected...");
		DBObject dbObject = (DBObject)JSON.parse(obj.toString());
		
		DBCollection collection = db.getCollection(Constants.mongoCollection);
		collection.insert(dbObject);
		
		System.out.println("Completed");
		br.close();
		mongo.close();
		}
		catch (Exception e) {
			System.out.println(e);
			br.close();
			mongo.close();
		}
		finally {
			br.close();
			br.close();
			mongo.close();
		}
		
	}

}
