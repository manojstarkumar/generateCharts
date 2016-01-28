package com.mweb.norton.perfutils.modal;

public class RunData {
	
	public String buildNumber;
	public String comment;
	public String users;
	public String duration;
	public String testScript;
	public String parameters;
	
	public RunData() {
		
	}
	
	public RunData(String buildNumber, String comment, String users,
			String duration, String testScript, String parameters) {
		this.buildNumber = buildNumber;
		this.comment = comment;
		this.users = users;
		this.duration = duration;
		this.testScript = testScript;
		this.parameters = parameters;
	}
	public String getBuildNumber() {
		return buildNumber;
	}
	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTestScript() {
		return testScript;
	}
	public void setTestScript(String testScript) {
		this.testScript = testScript;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

}
