package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.constant;

public class ExcelUtility {
	public static XSSFWorkbook w;
	public static XSSFSheet s;
	public static FileInputStream f;
	public static String getStringData(int i,int j,String Sheet) throws IOException {
	f= new FileInputStream(constant.TESTDATAFILE);
w= new XSSFWorkbook(f);
s= w.getSheet(Sheet);
Row r=s.getRow(i);
Cell c=r.getCell(j);
return c.getStringCellValue();
	}
	public static String getIntegerData(int i,int j,String Sheet) throws IOException {
		f= new FileInputStream(constant.TESTDATAFILE);
		w= new XSSFWorkbook(f);
		s= w.getSheet(Sheet);
		Row r=s.getRow(i);
		Cell c=r.getCell(j);
		int value=(int) c.getNumericCellValue();
		return String.valueOf(value);

		}

}

//c.getNumericCellValue()--This reads the numeric value from the Excel cell.It returns a double.
//(int) c.getNumericCellValue()This casts the double to int.It removes the decimal part (not rounded, just truncated).
//String.valueOf(value)This converts the int to a String.