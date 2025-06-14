package com.example;

import java.util.ArrayList;

public class TaskManager {
	public static ArrayList<Task> allTasks = new ArrayList<>();

	public static void addTask(Task task) {
		allTasks.add(task);
	}

	public Task getTaskByWorkerName(String nameOfWorker) {
		Task returnedTask = null;
		for (Task task : allTasks) {
			if (task.getNameOfWorker(nameOfWorker)) {
				returnedTask = task;
			}
		}
		return returnedTask;
	}

	public static synchronized void removeTask(Task task) {
		allTasks.remove(task);
	}
}
