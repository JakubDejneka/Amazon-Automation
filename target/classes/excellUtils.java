package resources;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excellUtils {
	
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;
	String excelPath = "";
	
	
	public excellUtils(String excelPath, String sheetName) {		
		
		try {
			
		 workBook = new XSSFWorkbook(excelPath);
		 sheet = workBook.getSheet(sheetName);
		}
		
	 catch (Exception exp)
		
	{
		System.out.println(exp.getMessage());
		System.out.println(exp.getCause());
		exp.printStackTrace();
	}
		
		
}
		
	
public void getRownCount() {
			
			int rowCount = sheet.getPhysicalNumberOfRows();			
			System.out.println("Number of rows: "+rowCount);
			
		
	}
	
	public static void getCellData(int rowNumber, int cellNumber) {		
			DataFormatter formatter = new DataFormatter();
			Object value  = formatter.formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
					
}

}
