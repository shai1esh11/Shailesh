package com.AgileCrmAutomation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtil {		
		private String getFileExtension(String filePath)
		{
			String extension = filePath.substring(filePath.indexOf("."));
			return extension;
		}
		public Workbook getWorkbook(String filePath) throws IOException
		{
			Workbook wb;
			FileInputStream input= new FileInputStream(filePath);
			if(getFileExtension(filePath).equals(".xlsx"))
			{
			 wb = new XSSFWorkbook(input);
			} 
			else
			{
			wb = new HSSFWorkbook(input);
			}
			return wb;
		}
		private Sheet getSheet(String filePath,String sheetName) throws IOException
		{
			Workbook wb=getWorkbook(filePath);
			Sheet sheet =wb.getSheet(sheetName);
			return sheet;
		}
		private Object [][] getExcelData(String filePath,String sheetName) throws IOException 
		{
		   Sheet sheet =getSheet(filePath,sheetName);
		   int totalRows= sheet.getPhysicalNumberOfRows();
		   int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
		   return getCellValue(sheet, totalRows, totalColumns);
		}
		private Object [][] getCellValue(Sheet sheet, int totalRows,int totalColumns)
		{
			Object [][] value = new Object[totalRows][totalColumns];
			for (int i= 1;i<totalRows;i++)
			{
				Row row = sheet.getRow(i);
				for(int j =0;j<totalColumns;j++)
				{
					Cell cell =row.getCell(j);
					CellType type =cell.getCellType();
					switch(type)
					{
					case STRING:
						value[i][j]=cell.getStringCellValue();
						break;
					case NUMERIC:
						value[i][j]=cell.getNumericCellValue();
						break;
					case BOOLEAN:
						value[i][j]=cell.getBooleanCellValue();
						break;
					case _NONE:
						value[i][j]=null;
						break;
					case BLANK:
						value[i][j]=null;
						break;
					default :
						value[i][j]=null;			
					}
				}
			}
			return value;
		}
		
		@Test 
		public static void main() throws IOException 
		{
			
			String filepath = "D:\\Shailesh\\AutomationTestData.xlsx";
			String sheetName = "TestSheet";
			
			ExcelUtil excelValues = new ExcelUtil();
			Object [][] data=excelValues.getExcelData(filepath, sheetName);
			int rowLength=data.length;
			Sheet sheet =excelValues.getSheet(filepath, sheetName);
			int columnLength=sheet.getRow(0).getPhysicalNumberOfCells();
			for(int i = 1;i<rowLength;i++)
			{
				for(int j=0;j<columnLength;j++)
				{
					System.out.print(data[i][j]+" ");
				}
				System.out.println();
			}
			
			      
		}
		
		public void setCellValue(String filePath,String  sheetName,int rowNum,int columnNum) throws IOException
		{
			ExcelUtil excelValues = new ExcelUtil();
			Workbook wb =excelValues.getWorkbook(filePath);
			Sheet sheet;
			if(wb.getSheet(sheetName)!=null)
			{
				sheet=wb.getSheet(sheetName);
			}else
			{
				sheet = wb.createSheet();
			}
			
		Row  row =	sheet.createRow(rowNum);
		row.createCell(columnNum+1);
		Cell cell = sheet.getRow(rowNum).createCell(columnNum);
		cell.setCellValue("Shailesh");
		
		
		FileOutputStream output = new FileOutputStream(filePath);
		wb.write(output);
		}
		@Test
		public void writeIntoSheet() throws IOException {
			
			String filepath = "D:\\Shailesh\\AutomationTestData.xlsx";
			String sheetName = "Test";
			
			setCellValue(filepath,sheetName,0,0);

		}
}




