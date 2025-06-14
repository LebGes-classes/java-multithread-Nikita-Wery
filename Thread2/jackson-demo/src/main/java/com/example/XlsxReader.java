package com.example;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsxReader {
	public void readXlsx() {

		// List<Worker> workerList = new ArrayList<>();
		TaskManager allTasks = new TaskManager();
		WorkerManager workerManager = new WorkerManager();

		try (Workbook workbook = new XSSFWorkbook(new FileInputStream("workers.xlsx"))) {
			Sheet sheet = workbook.getSheetAt(0);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row == null)
					continue;

				String nameOfFirstWorker = row.getCell(0).getStringCellValue();
				String nameOfSecondWorker = row.getCell(1).getStringCellValue();
				allTasks.addTask(
						new Task(nameOfFirstWorker, nameOfSecondWorker, (int) row.getCell(2).getNumericCellValue()));
				allTasks.addTask(
						new Task(nameOfFirstWorker, nameOfSecondWorker, (int) row.getCell(3).getNumericCellValue()));
				allTasks.addTask(
						new Task(nameOfFirstWorker, nameOfSecondWorker, (int) row.getCell(4).getNumericCellValue()));
				allTasks.addTask(
						new Task(nameOfFirstWorker, nameOfSecondWorker, (int) row.getCell(5).getNumericCellValue()));
				allTasks.addTask(
						new Task(nameOfFirstWorker, nameOfSecondWorker, (int) row.getCell(6).getNumericCellValue()));

				workerManager.addWorker(new Worker(nameOfFirstWorker));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
