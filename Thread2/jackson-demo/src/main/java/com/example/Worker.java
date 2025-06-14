package com.example;

import java.util.ArrayList;
import java.util.List;

public class Worker implements Runnable {
	private String workerName;
	private int chillTime;
	private List<String> closedTaskList = new ArrayList<>();
	private Task actualTask;

	public Worker(String name) {
		this.workerName = name;
	}

	public void getClosedTaskList(int index) {
		System.out.println(workerName + " завершил: ");
		for (String closedTask : closedTaskList) {
			System.out.println(closedTask);
		}
	}

	public int getChillTime() {
		return chillTime;
	}

	public List<String> getClosedTaskList() {
		return closedTaskList;
	}

	public String getName() {
		return workerName;
	}

	public void setTask(Task task) {
		actualTask = task;
	}

	@Override
	public void run() {
		TaskManager taskManager = new TaskManager();
		try {
			while (actualTask != null) {

				while (actualTask.getHours() > 0) {
					if (actualTask.decrementHours()) {
						closedTaskList.add(actualTask.getId());
						System.out.println("Рабочий " + workerName + " завершил задание " + actualTask.getId());
					}
				}
				taskManager.removeTask(actualTask);
				int pause = (int) (Math.random() * 4);
				for (int j = 0; j < pause; j++) {
					chillTime();
					chillTime++;
					Thread.sleep(1000);
				}
				System.out.println("Рабочий " + workerName + " снова в деле");
				actualTask = taskManager.getTaskByWorkerName(workerName);
			}
			System.out.println(workerName + "Выходит из гонки");
			System.out.println(workerName + " отдыхал " + chillTime);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void chillTime() {
		System.out.println("Рабочий " + workerName + "отдыхает");
	}
}
