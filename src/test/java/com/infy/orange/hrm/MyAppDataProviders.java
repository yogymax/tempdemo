package com.infy.orange.hrm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

//https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml/3.15
public class MyAppDataProviders {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		//readExcel();
		writeIntoExcel();
	}
	
	@DataProvider(name="data") 
	static public Object[][] readExcel() throws InvalidFormatException, IOException{
		Object[][] data = new Object[7][3];
		
		File file = new File("C:\\Users\\Yogesh\\Desktop\\J#7\\userdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("users");
		Iterator<Row> rows = sheet.rowIterator();
		Row row = rows.next(); //skip what header row
		int rowCount =0;
		int cellCount=0;
		
		while(rows.hasNext()){
				 row = rows.next();
				System.out.println("---------------------------------------------------------------------------");		
				Iterator<Cell> cells=row.cellIterator();
						while(cells.hasNext()){
							Cell cell = cells.next();
							System.out.print(cell.getStringCellValue()+" | ");
							if(cell.getStringCellValue().equals("NA"))
								data[rowCount][cellCount] ="";
							else
								data[rowCount][cellCount] = cell.getStringCellValue();
							cellCount++;
						}
						System.out.println();
						rowCount++;
						cellCount=0;
		}
		return data;//
	}

	
	public static void writeIntoExcel() throws InvalidFormatException, IOException{
		Object[][] data = readExcel();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet empsheet =workbook.createSheet("employee");

		for(int i=1;i<=7;i++){
		Row row = empsheet.createRow(i);
		Cell username = row.createCell(0); //username
		Cell password = row.createCell(1); //password
		Cell message=  row.createCell(2); //msg
		
		username.setCellValue("A");
		password.setCellValue("B");
		message.setCellValue("C");
		}
		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Yogesh\\Desktop\\J#7\\userdatanew.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        // Closing the workbook
        workbook.close();
	}
	
	
	public Object[][] userCredentails(){
		Object[][] data = new Object[5][3];
		
		data[0][0] = ""; // username
		data[0][1]=""; //password
		data[0][2]="Username cannot be empty";//expected msg
		
		data[1][0] = ""; // username
		data[1][1]="min123"; //password
		data[1][2]="Username cannot be empty";//expected msg
		
		data[2][0] = "admin"; // username
		data[2][1]=""; //password
		data[2][2]="Password cannot be empty";//expected msg
		
		data[3][0] = "admin123"; // username
		data[3][1]="Admin"; //password
		data[3][2]="Invalid credentials";//expected msg
		
		data[4][0] = "admin"; // username
		data[4][1]="admin123"; //password
		data[4][2]="Success";//expected msg
		return data;
	}
	
}
