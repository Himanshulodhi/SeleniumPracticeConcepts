package JavaCodePractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadMethod {
	
	public void readExcel(String filePath, String fileName, String sheetName) {
		
		FileInputStream fis=null;
		// //Create an object of File class to open xlsx file
		File file=new File(filePath+"\\"+fileName);
		try {
			//Create an object of FileInputStream class to read excel file

			fis=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Workbook book=null;
		//Find the file extension by splitting file name in substring  and getting only extension name
	    String fileextension=fileName.substring(fileName.indexOf("."));
	    
	    if (fileextension.equalsIgnoreCase(".xlsx")) {
	    	
	    	try {
				book=new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    		
				
			}
	    else if (fileextension.equalsIgnoreCase(".xls")) {
    		
	    	try {
				book=new HSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	    //Read sheet inside the workbook by its name
	    Sheet sheet=book.getSheet(sheetName);
	    //Find number of rows in excel file
		//int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		for (int i = 0; i < sheet.getLastRowNum()+1; i++) {
			Row row=sheet.getRow(i);
			
			for (int j = 0; j < row.getLastCellNum(); j++) {
				
				
				System.out.print(row.getCell(j).getStringCellValue()+"|| ");
				
			}
			System.out.println();
		}
		
		
	}
	

}
