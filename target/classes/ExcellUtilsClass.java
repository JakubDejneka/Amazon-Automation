package resources;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellUtilsClass {
	
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;
	
	
	
	public ExcellUtilsClass(String excelPath, String sheetName) {		
		
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
		
	
public int getRownCount() {
			
			int rowCount = sheet.getPhysicalNumberOfRows();	
			return rowCount;
			
		
	}
	
	public static void getCellData(int rowNumber, int cellNumber) {		
			DataFormatter formatter = new DataFormatter();
			Object value  = formatter.formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
			System.out.println(value);
					
}

}
