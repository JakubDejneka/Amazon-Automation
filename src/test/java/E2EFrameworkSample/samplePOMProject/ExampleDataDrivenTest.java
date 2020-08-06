package E2EFrameworkSample.samplePOMProject;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import resources.Base;
import resources.ExcellUtilsClass;




public class ExampleDataDrivenTest  {
		
	String excellPath = "./src/main/java/resources/testData.xlsx";
	String sheetName = "testSheet1";
	
	
	
	
	@Test
	public void displayExcelDataFromFirstColumn() {
		ExcellUtilsClass ex = new ExcellUtilsClass(excellPath, sheetName);
		
		for(int i=0; i < ex.getRownCount(); i++) {
			ex.getCellData(i, 0);
			
		}
		
		
	}

}
