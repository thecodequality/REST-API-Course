import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String excelPath = "C:\\Users\\Administrator\\Downloads\\REST Assured API\\ExcelData.xlsx";
		ArrayList<Object> excelValue = new ArrayList<Object>();
		FileInputStream inputStream = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		
		int count = workbook.getNumberOfSheets();
		
		for(int index = 0;index < count;index++) {
			if(workbook.getSheetName(index).equalsIgnoreCase("Excel")) {
				XSSFSheet workSheet = workbook.getSheetAt(index);
				
				//Identify required column name by scanning entire first row
				Iterator<Row> rows = workSheet.iterator(); //Sheet is a collection of rows
				Row firstRow = rows.next();
				
				Iterator<Cell> cell = firstRow.cellIterator(); //Row is a collection of cells
				int column = 0;
				while(cell.hasNext()) {
					Cell value = cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						column = value.getColumnIndex();
					}
				}
				System.out.println("TestCases is in column : "+column);
				
				//Iterate through the required column and fetch all values in that and print it
				 while(rows.hasNext()) {
					 Row nextRow = rows.next();
					 if(nextRow.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase")) {
						 Iterator<Cell> cellValue = nextRow.cellIterator();
						 while(cellValue.hasNext()) {
							 Cell type = cellValue.next();
							 if(type.getCellType() == CellType.STRING) {
								 excelValue.add(type.getStringCellValue());
							 }else {
								 excelValue.add(NumberToTextConverter.toText(type.getNumericCellValue()));
							 }
						 }
					 }
				 }
			}
		}
		System.out.println(excelValue.get(0));
		System.out.println(excelValue.get(1));
		System.out.println(excelValue.get(2));
		System.out.println(excelValue.get(3));

	}

}
