package E2EFrameworkSample.samplePOMProject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import resources.Base;
import resources.ExcellUtilsClass;




public class ExampleDataDrivenTest  {
		
	
	String excellPath = "./src/main/java/resources/testData.xlsx";
	String sheetName = "testSheet1";
	DataFormatter formatter = new DataFormatter();
	
	
		
	//@Test
	public void displayExcelDataFromFirstColumn() {
		
		ExcellUtilsClass ex = new ExcellUtilsClass(excellPath, sheetName);
		
		for(int i=0; i < ex.getRownCount(); i++) {
			 ex.getCellData(i, 0);
		}
		 
	}

	
	@Test
	public void displayAllDataFromExcell() {
		
		ExcellUtilsClass ex2 = new ExcellUtilsClass(excellPath, sheetName);
		
		
		for	(int i =0;i<ex2.getRownCount(); i++) {
			XSSFRow currentRow = ex2.getSheet().getRow(i);			
			
			for(int j =0; j<ex2.getColCount();j++) {
				Object value1  = formatter.formatCellValue((ex2.getSheet().getRow(i).getCell(j)));
				System.out.print(value1 + " ");
			}System.out.println();
		}
		
	}
}
