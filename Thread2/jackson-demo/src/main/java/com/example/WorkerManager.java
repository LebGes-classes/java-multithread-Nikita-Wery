package com.example;

import java.util.ArrayList;

public class WorkerManager {
	public static ArrayList<Worker> workers = new ArrayList<>();

	public static void addWorker(Worker worker) {
		workers.add(worker);
	}

	public static ArrayList<Worker> getAllWorkers() {
		return workers;
	}
}
