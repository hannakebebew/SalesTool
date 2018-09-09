package testng.datadriven;

import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader {

	
	
	@DataProvider(name="excelData")
	public static Object[][] dataProvider() throws InvalidFormatException, IOException{
		File file = new File("resources/testData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		Object[][] data = new Object [sheet.getLastRowNum()+1][sheet.getRow(sheet.getLastRowNum()).getLastCellNum()];
	
		for (Row row : sheet) {
			
				
			for (Cell cell : row) {
				
								
				data[cell.getRowIndex()][cell.getColumnIndex()] = cell.getStringCellValue();
				
				
				
			}
			
			
			
		}
		
		
		
		
		return data;
		
		
		
	}

}
