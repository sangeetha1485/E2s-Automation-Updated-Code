package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.yaml.snakeyaml.scanner.Constant;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtils {

	private static HSSFSheet ExcelWSheet;

	private static HSSFWorkbook ExcelWBook;

	public static HSSFCell Cell;

	private static HSSFRow Row;
	private static MissingCellPolicy xRow;

	// This method is to set the File path and to open the Excel file, Pass Excel
	// Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new HSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {

			throw (e);

		}

	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	public static String getCellData1(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			return "";

		}

	}
	

	   

	    // for creating .xlsx workbook
	    public static String getCellData(int RowNum, int ColNum) throws IOException{

	        //Create an object of File class to open xlsx file

	       // File file =    new File(filePath+"\\"+fileName);

	        //Create an object of FileInputStream class to read excel file

	        //FileInputStream inputStream = new FileInputStream(file);
	    	DataFormatter fmt = new DataFormatter();
	        
	    	try {
	        
	        
	        // prints the substring after index 5

	       // String fileextension= fileName.substring(fileName.indexOf("."));
	        
//	        if(fileextension.contains(".xls"))
//	        {
//	        	wbk= new HSSFWorkbook(inputStream);
//	        }
//	        
//	        else if(fileextension.contains(".xlsx")) {
//	        	wbk= new XSSFWorkbook(inputStream);
//
//	        }
//	        
//	        String data;
//	        Sheet sheet1= wbk.getSheet(sheetName);
	        
	        Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = null ;
			
	        		if(Cell.getCellType()==CellType.STRING)
	        		{
	        			CellData=Cell.getStringCellValue();
	        			
	        			//System.out.print(CellData);
	        			return CellData;
	        		}
	        		
	        		else if(Cell.getCellType()==CellType.NUMERIC)
	        		{
	        			
	        			//The java string valueOf() method converts different types of values into string. 
	        			//By the help of string valueOf() method, you can convert int to string, long to string, boolean to string, 
	        			//character to string, float to string, double to string, object to string and char array to string.
	        			
	        			
	        			CellData=String.valueOf((int) Cell.getNumericCellValue());
	        			System.out.print(CellData);
	        			return CellData;
	        		}
	    	} catch (Exception e) {

				return "";

			}
			return null;
	        	
	    }    

	           

	
	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters

	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {

		try {

			Row = ExcelWSheet.getRow(RowNum);

			// Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			Cell = Row.getCell(ColNum, xRow.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData + Constants.File_TestData);

			ExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		} catch (Exception e) {

			throw (e);

		}

	}

}