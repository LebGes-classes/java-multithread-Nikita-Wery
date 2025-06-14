package com.example;

import java.util.ArrayList;

public class Day {
	WorkerManager workerManager = new WorkerManager();
	ArrayList<Worker> workerList = workerManager.getAllWorkers();

	public static void main(String[] args) {
		Day day = new Day();
		day.startingDay();

		ArrayList<Thread> threads = new ArrayList<>();
		for (Worker worker : day.workerList) {
			Thread thread = new Thread(worker);
			thread.start();
			threads.add(thread);
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		WorkerToExcel.writeWorkersToExcel(day.workerList, "workersSave.xlsx");

		System.out.println("Все потоки завершились, файл с результатами создан.");

	}

	private void startingDay() {
		XlsxReader excelParser = new XlsxReader();
		excelParser.readXlsx();

		TaskManager taskManager = new TaskManager();

		for (Worker worker : workerList) {
			worker.setTask(taskManager.getTaskByWorkerName(worker.getName()));
		}
	}
}
