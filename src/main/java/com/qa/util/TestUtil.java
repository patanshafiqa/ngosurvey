package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.base.TestBase;
import com.qa.webpages.LoginPage;

public class TestUtil extends TestBase {
	
	static Workbook book;
	static Sheet sheet;
	public static String excelsheetpath="C:\\Users\\patan\\eclipse-workspace\\biodiversityweb\\src\\main\\java\\com\\qa\\testdata\\FreeCrmTestData.xlsx";
	
	
	public static Object[][] getTestData(String Sheetname)
	{
		FileInputStream fis = null;
		try {
			fis=new FileInputStream(excelsheetpath);
		} catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		sheet=book.getSheet(Sheetname);
		Object[][]data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getLastRowNum(); j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				
			}
			
		}
		return data;
	}
	
}  

