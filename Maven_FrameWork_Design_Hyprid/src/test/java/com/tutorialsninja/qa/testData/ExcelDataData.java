package com.tutorialsninja.qa.testData;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataData {
	public static FileInputStream ip;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	
	@DataProvider(name = "TN")
	public static Object[][] getTNData() throws Exception {
		Object[][] data = ExcelDataData.readDataFromExcelForTN("LoginTN");
		return data;
	}
	
	
	
public static Object[][] readDataFromExcelForTN(String sheetName) throws Exception {
		
	ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tutorialsninja\\qa\\testData\\RadingExcelSelenium.xlsx");

		workbook = new XSSFWorkbook(ip);
		
	    sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for(int i=0 ; i<rows ; i++) {
			XSSFRow row = sheet.getRow(i+1);
			
			 for(int j=0 ; j<cols ; j++) {
				 XSSFCell cell = row.getCell(j);
				 
				 CellType cellType = cell.getCellType();
				 
				 switch(cellType) {
				 
				 case STRING:
					 data[i][j] = cell.getStringCellValue();
					 break;
					 
				 case NUMERIC:
					 data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					 break;
					 
				 case BOOLEAN:
					 data[i][j] = cell.getBooleanCellValue();
					 break;
				 }
			 }
		}
		
		return data;
	
	}


}
