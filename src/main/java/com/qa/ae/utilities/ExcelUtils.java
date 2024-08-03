package com.qa.ae.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	// path of our test data file
	private static final String TEST_DATA_FILE_PATH="./src/main/resources/testdata/autoExercideTestData.xlsx";
	private static Workbook book;
	private static Sheet sheet;
	/**
	 * this method is for getting the test data from excel sheet in which we pass
	 * the parameter as sheet name which were present in the excel sheet
	 * @param sheetName
	 * @return 
	 */
	public static Object[][] getTestData(String sheetName)
	{
		System.out.println("Reading data from sheet "+sheetName);
		
		Object[][] data = null;
		try {
			FileInputStream fis= new FileInputStream(TEST_DATA_FILE_PATH);
			
				book=WorkbookFactory.create(fis);
				sheet=book.getSheet(sheetName);
				//data= new Object [3] [4];  // we have to pass no. of rows ans=d column in array
				// but this is hardcoded values
				data= new Object [sheet.getLastRowNum()] [sheet.getRow(0).getLastCellNum()];
		// in testdata sheet column no. is fixed only rows no. will vary so to get column 
				// no. we have to go to last cell of first row
				// in above we just have created the blank array 
				
				// now we have to go one by one to each row and column means cell 
				// with the help of 2 for loop
				
				for (int i=0; i<sheet.getLastRowNum(); i++)
				{
					for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++)
					{
						// now we have to get data from cell
						data [i] [j]=sheet.getRow(i+1).getCell(j).toString();
						// here for row (i+1) as on 0 row we have column headers
					}
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
		
	}

}
