package cucumberframework.poiclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String filepath="C:\\Users\\Dhanush S\\Desktop\\HIlliti.xlsx";
		File file=new File("C:\\Users\\Dhanush S\\Desktop\\HIlliti.xlsx");
		FileInputStream fis=new FileInputStream(filepath);
		Workbook work=WorkbookFactory.create(fis);
		int sheetnumber = work.getNumberOfSheets();
		System.out.println(sheetnumber);
		//work.createName();
		for (int i = 0; i < sheetnumber; i++) {
			String nameofsheet = work.getSheetName(i);
			System.out.println(nameofsheet);
	
			
		}
		int index=-1;
		Sheet sheet =work.getSheet("Sheet1");
	for(int j=0; j<sheet.getLastRowNum(); j++) {
		System.out.println(sheet.getRow(j).getCell(0));
		String valur=sheet.getRow(j).getCell(0).getStringCellValue();
		if(valur.contains("Dhanush")) {
			index=j;
			System.out.println(j);
			String vasdf=sheet.getRow(j).getCell(1).getStringCellValue();
			System.out.println(vasdf);
		}
		
	}
	FileOutputStream fos=new FileOutputStream(file);
	sheet.getRow(index).getCell(0).setCellValue("shigg");
	work.write(fos);
	work.close();
	fos.close();
	fis.close();
	}
}
