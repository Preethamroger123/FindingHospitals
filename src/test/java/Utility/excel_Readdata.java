package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_Readdata {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet1;
	public static XSSFRow row;
	public static XSSFCell cell;
 
	public static List<String> read_Data(String path,String sheet,int r,int c) throws IOException{
		List<String> getData=new ArrayList<>();
		String s;
		
		FileInputStream file=new FileInputStream(path);
		wb=new XSSFWorkbook(file);
		sheet1=wb.getSheet(sheet);
		for(int i=0;i<r;i++) {
			row=sheet1.getRow(i);
			cell=row.getCell(c);
			try {
				DataFormatter df=new DataFormatter();
				s=df.formatCellValue(cell);
				
			}
			catch(Exception e) {
				s=" ";
			}
			getData.add(s);
		}
		return getData;
	} 
}
