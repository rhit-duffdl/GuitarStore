import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Inventory {
	private ArrayList<Guitar> guitars; 
	private ArrayList<Mandolin> mandolins;
	
	public Inventory() {
		this.guitars = new ArrayList<Guitar>();
		this.mandolins = new ArrayList<Mandolin>();
	}
	
	public Inventory(ArrayList<Guitar> guitars, ArrayList<Mandolin> mandolins) {
		this.guitars = guitars;
		this.mandolins = mandolins;
	}
	
	public void addGuitar(Guitar g) {
		this.guitars.add(g);
	}
	
	public void addMandolin(Mandolin m) {
		this.mandolins.add(m);
	}
	
	public Guitar getGuitar(String modelName) {
		return null;
	}
	
	public Mandolin getMandolin(String modelName) {
		return null;
	}
	
	public void saveInventory() throws Exception {	
		FileInputStream inv = new FileInputStream(new File("src/Inventory.xlsx"));
		Workbook workbook = new XSSFWorkbook(inv);
		Sheet sheet = workbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();
		
		for (Guitar guitar : this.guitars) {
			Row row = sheet.createRow(sheet.getLastRowNum() + 1);
			
			Cell cell0 = row.createCell(0);
			cell0.setCellValue("Guitar");
			
			Cell cell1 = row.createCell(1);
			cell1.setCellValue((String) guitar.getSerialNumber());
			
			Cell cell2 = row.createCell(row.getLastCellNum());
			cell2.setCellValue(guitar.getPrice());
			
			Cell cell3 = row.createCell(row.getLastCellNum());
			cell3.setCellValue(guitar.getSpec().getBuilder().toString());
			
			Cell cell4 = row.createCell(row.getLastCellNum());
			cell4.setCellValue(guitar.getSpec().getType().toString());
			
			Cell cell5 = row.createCell(row.getLastCellNum());
			cell5.setCellValue(guitar.getSpec().getBackWood().toString());
			
			Cell cell6 = row.createCell(row.getLastCellNum());
			cell6.setCellValue(guitar.getSpec().getTopWood().toString());
			
		}
		
		for (Mandolin m : this.mandolins) {
			Row row = sheet.createRow(sheet.getLastRowNum() + 1);
			
			Cell cell0 = row.createCell(0);
			cell0.setCellValue("Mandolin");
			
			Cell cell1 = row.createCell(1);
			cell1.setCellValue((String) m.getSerialNumber());
			
			Cell cell2 = row.createCell(row.getLastCellNum());
			cell2.setCellValue(m.getPrice());
			
			Cell cell3 = row.createCell(row.getLastCellNum());
			cell3.setCellValue(m.getSpec().getBuilder().toString());
			
			Cell cell4 = row.createCell(row.getLastCellNum());
			cell4.setCellValue(m.getSpec().getType().toString());
			
			Cell cell5 = row.createCell(row.getLastCellNum());
			cell5.setCellValue(m.getSpec().getBackWood().toString());
			
			Cell cell6 = row.createCell(row.getLastCellNum());
			cell6.setCellValue(m.getSpec().getTopWood().toString());
			
			Cell cell7 = row.createCell(row.getLastCellNum());
			cell7.setCellValue(m.getSpec().hasPickGuard());
		}
				
		
		FileOutputStream out = new FileOutputStream(
	            new File("src/Inventory.xlsx"));
		workbook.write(out);
		out.close();
		workbook.close();
		inv.close();
		
	}

	
}
