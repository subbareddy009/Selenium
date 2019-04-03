package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader{
	public static Object[][] readExcel()
	{
		File file=new File("src\\test\\resources\\TestData.xlsx");
		InputStream is=null;
		Object[][] obj=null;
		try {
			is=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(is);
			XSSFSheet sheet1=workbook.getSheet("Sheet1");
			obj=new Object[sheet1.getLastRowNum()][];		
			for(int i=1;i<=sheet1.getLastRowNum();i++) {
				obj[i-1]=new Object[sheet1.getRow(i-1).getPhysicalNumberOfCells()];
				for(int j=0;j<sheet1.getRow(i-1).getPhysicalNumberOfCells();j++)
				{
					obj[i-1][j]=sheet1.getRow(i).getCell(j).getStringCellValue();
					System.out.print(obj[i-1][j]);
				}
				System.out.println("");
				//sheet1.getRow(i).getCell(0).getStringCellValue());
				//System.out.println("\t"+sheet1.getRow(i).getCell(1).getStringCellValue());
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return obj;
	}

}
