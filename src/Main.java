import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
	private Inventory inventory;	
	
	public Main() {
		this.inventory = new Inventory();
	}
	
	public static void main(String[] args) throws Exception {	
		Main app = new Main();
		app.addGuitarsFromFile("src/Guitars.xlsx");
		app.addMandolinsFromFile("src/Mandolins.xlsx");
	}
	
	
	public void addGuitarsFromFile(String filename) throws Exception {
		FileInputStream file = new FileInputStream(new File(filename));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		int i = 0;
		for (Row row : sheet) {
			if (i != 0) {
				ArrayList<Object> vals = new ArrayList<Object>();
				for (Cell cell : row) {					
					vals.add(cell);
				}
				Builder b = null;
				Type t = null;
				Wood bw = null;
				Wood tw = null;
				switch(((Cell) vals.get(2)).getRichStringCellValue().getString().toLowerCase()) {
				case "fender": b = Builder.FENDER;	break;			
				case "martin": b = Builder.MARTIN; break;	
				case "gibson": b = Builder.GIBSON; break;	
				case "collings": b = Builder.COLLINGS; break;	
				case "olson": b = Builder.OLSON; break;	
				case "ryan": b = Builder.RYAN; break;	
				case "any": b = Builder.ANY;		
				}
				
				switch(((Cell) vals.get(3)).getRichStringCellValue().getString().toLowerCase()) {
				case "acoustic": t = Type.ACOUSTIC; break;	
				case "electric": t = Type.ELECTRIC;	break;				
				}
				
				switch(((Cell) vals.get(4)).getRichStringCellValue().getString().toLowerCase()) {
				case "indian_rosewood": bw = Wood.INDIAN_ROSEWOOD; break;	
				case "brazilian_rosewood": bw = Wood.BRAZILIAN_ROSEWOOD; break;	
				case "mahogany": bw = Wood.MAHOGANY; break;	
				case "maple": bw = Wood.MAPLE; break;	
				case "cedar": bw = Wood.CEDAR;	 break;				
				}
				
				switch(((Cell) vals.get(5)).getRichStringCellValue().getString().toLowerCase()) {
				case "indian_rosewood": tw = Wood.INDIAN_ROSEWOOD; break;	
				case "brazilian_rosewood": tw = Wood.BRAZILIAN_ROSEWOOD; break;	
				case "mahogany": tw = Wood.MAHOGANY; break;	
				case "maple": tw = Wood.MAPLE; break;	
				case "cedar": tw = Wood.CEDAR;	 break;				
				}
				
				
				
				GuitarSpec gs = new GuitarSpec(b, t, bw, tw);				
				Guitar g = new Guitar(((Cell) vals.get(0)).getRichStringCellValue().getString(), Double.valueOf(((Cell) vals.get(1)).getNumericCellValue()), gs);
				this.inventory.addGuitar(g);
			}			
			i++;
		}
		
		this.inventory.saveInventory();
	}
	
	
	public void addMandolinsFromFile(String filename) throws Exception {
		FileInputStream file = new FileInputStream(new File(filename));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		int i = 0;
		for (Row row : sheet) {
			if (i != 0) {
				ArrayList<Object> vals = new ArrayList<Object>();
				for (Cell cell : row) {					
					vals.add(cell);					
				}
				
				Builder b = null;
				Type t = null;
				Wood bw = null;
				Wood tw = null;
				switch(((Cell) vals.get(2)).getRichStringCellValue().getString().toLowerCase()) {
				case "fender": b = Builder.FENDER;	break;			
				case "martin": b = Builder.MARTIN; break;	
				case "gibson": b = Builder.GIBSON; break;	
				case "collings": b = Builder.COLLINGS; break;	
				case "olson": b = Builder.OLSON; break;	
				case "ryan": b = Builder.RYAN; break;	
				case "any": b = Builder.ANY;		
				}
				
				switch(((Cell) vals.get(3)).getRichStringCellValue().getString().toLowerCase()) {
				case "acoustic": t = Type.ACOUSTIC; break;	
				case "electric": t = Type.ELECTRIC;	break;				
				}
				
				switch(((Cell) vals.get(4)).getRichStringCellValue().getString().toLowerCase()) {
				case "indian_rosewood": bw = Wood.INDIAN_ROSEWOOD; break;	
				case "brazilian_rosewood": bw = Wood.BRAZILIAN_ROSEWOOD; break;	
				case "mahogany": bw = Wood.MAHOGANY; break;	
				case "maple": bw = Wood.MAPLE; break;	
				case "cedar": bw = Wood.CEDAR;	 break;				
				}
				
				switch(((Cell) vals.get(5)).getRichStringCellValue().getString().toLowerCase()) {
				case "indian_rosewood": tw = Wood.INDIAN_ROSEWOOD; break;	
				case "brazilian_rosewood": tw = Wood.BRAZILIAN_ROSEWOOD; break;	
				case "mahogany": tw = Wood.MAHOGANY; break;	
				case "maple": tw = Wood.MAPLE; break;	
				case "cedar": tw = Wood.CEDAR;	 break;				
				}
				
				boolean pg = false;
				
				if (((Cell) vals.get(5)).getRichStringCellValue().getString().toLowerCase().equals("true")) {
					pg = true;
				}
				
				
				
				MandolinSpec ms = new MandolinSpec(b, t, bw, tw, pg);				
				Mandolin m = new Mandolin(((Cell) vals.get(0)).getRichStringCellValue().getString(), Double.valueOf(((Cell) vals.get(1)).getNumericCellValue()), ms);
				this.inventory.addMandolin(m);
			}			
			i++;
		}		
		this.inventory.saveInventory();
	}
	

	
	public List<Spec> search(Spec spec) {
		return null;		
	}
}
