package com.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkerToExcel {

	WorkerManager workerManager = new WorkerManager();
	ArrayList<Worker> workers = workerManager.getAllWorkers();

	public static void writeWorkersToExcel(ArrayList<Worker> workers, String filePath) {
		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			XSSFSheet sheet = workbook.createSheet("Workers");

			// заголовки колонок
			XSSFRow header = sheet.createRow(0);
			header.createCell(0).setCellValue("Имя рабочего");
			header.createCell(1).setCellValue("Количество закрытых заданий");
			header.createCell(2).setCellValue("Время отдыха");

			// заполннение данными
			int rowIdx = 1;
			for (Worker worker : workers) {
				XSSFRow row = sheet.createRow(rowIdx++);
				row.createCell(0).setCellValue(worker.getName()); // имя
				row.createCell(1).setCellValue(worker.getClosedTaskList().size()); // закрытые задачи
				row.createCell(2).setCellValue(worker.getChillTime()); // время отдыха
			}

			FileOutputStream output = new FileOutputStream(filePath);
			workbook.write(output);
			output.close();

			System.out.println("Данные записаны в файл " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
