package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_WriteData {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
public static void setData(String path,String sheet,int r,int c,String[] data) throws IOException {
		
		FileInputStream fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheet);
		row=ws.createRow(r);
		for(int i=0;i<c;i++) {
			
			cell=row.createCell(i);
			cell.setCellValue(data[i]);
		}
		FileOutputStream fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fo.close();
		fi.close();
		
	}
}
