
package com.example;

import java.util.ArrayList;

public class Task {
	private String idOfTask;
	private static int counter;
	private ArrayList<String> performers = new ArrayList<String>();
	private int hours;

	public Task(String nameOfWorker1, String nameOfWorker2, int hours) {
		performers.add(nameOfWorker1);
		performers.add(nameOfWorker2);
		this.idOfTask = "id-" + counter++;
		this.hours = hours;
	}

	public boolean getNameOfWorker(String nameOfWorker) {
		return performers.contains(nameOfWorker);
	}

	public synchronized int getHours() {
		return hours;
	}

	public String getId() {
		return idOfTask;
	}

	public synchronized boolean decrementHours() {
		boolean status = false;
		hours--;
		if (hours == 0) {
			status = true;
		}
		return status;
	}
}
