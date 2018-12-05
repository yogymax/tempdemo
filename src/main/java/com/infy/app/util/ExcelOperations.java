package com.infy.app.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelOperations {
	
	public static Logger log = Logger.getLogger(ExcelOperations.class);
	
	public static void main(String[] args) throws IOException {
		try {
			writeDataIntoExcelSheet();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeDataIntoExcelSheet() throws IOException{
		log.info("Writing data into excelsheet");
		List<Emp> listOfEmps = DatabaseUtil.getListOfEmps();
		
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet = workBook.createSheet("empinfo");
		log.info("sheet created");



		for(int i=0;i<listOfEmps.size();i++){
					

			Row row = sheet.createRow(i);
			Cell id = row.createCell(0);
			Cell name = row.createCell(1);
			Cell dept = row.createCell(2);
			Cell sal = row.createCell(3);
			
			id.setCellType(CellType.NUMERIC);
			id.setCellValue(listOfEmps.get(i).getEmpId());
			name.setCellType(CellType.STRING);
			name.setCellValue(listOfEmps.get(i).getEmpName());
			dept.setCellType(CellType.STRING);
			dept.setCellValue(listOfEmps.get(i).getDeptName());
			sal.setCellType(CellType.NUMERIC);
			sal.setCellValue(listOfEmps.get(i).getEmpSal());
			
		}

		 FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Yogesh\\Desktop\\J#7\\dbdata.xlsx");
         workBook.write(outputStream);
         workBook.close();

         log.info("write operation completed Successfully...!");
	}
	
	
	@DataProvider
	public static Object[][] readFromExcel() throws InvalidFormatException, IOException {
		/**
		 * Apache-POI -- <=2007 -- HSSF
		 * Apache-POI-Ooxml >=2007 XSSF + HSSF
		 * 
		 */
		Object[][] testData = new Object[6][3];
		log.info("read operation started");
		File file = new File("C:\\Users\\Yogesh\\Desktop\\J#7\\userdatanew.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("UserData");
		Iterator<Row> rows = sheet.rowIterator();
		rows.next();
		int rowCount =0;
		int colnCount =0;
		while(rows.hasNext()){
					Row row = rows.next();
					log.info("\n");
					Iterator<Cell> cells = row.cellIterator();
						while(cells.hasNext()){
								Cell cell = cells.next();
								//System.out.print(cell.getStringCellValue()+" | ");
								if(cell.getStringCellValue().equals("NULL"))
									testData[rowCount][colnCount]="";
								else
									testData[rowCount][colnCount] = cell.getStringCellValue();
								
								colnCount++;
						}
						
						rowCount++;
						colnCount=0;
					
		}
		
		log.info("Read operation completed Successfully...!");
		return testData;
	}

}
