package sample

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import internal.GlobalVariable

public class Excelwrite {


	public static void write(int row, int col, String value, String Filename) throws IOException {

		//FileInputStream file = new FileInputStream("C://Social27_FrontendAuomation//03_API Run//APIRun.xlsx");
		FileInputStream file = new FileInputStream(Filename);
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet spreadsheet = workbook.getSheetAt(0);
		Cell cell;

		XSSFRow sheetrow = spreadsheet.getRow(row);
		if(sheetrow == null) {
			sheetrow = spreadsheet.createRow(row);
		}

		cell = sheetrow.getCell(col);
		if(cell == null) {
			cell = sheetrow.createCell(col);
		}
		cell.setCellValue(value);
		file.close();

		sheetrow = spreadsheet.getRow(spreadsheet.getFirstRowNum());
		Iterator<Cell> cellIterator = sheetrow.cellIterator();
		while (cellIterator.hasNext()) {
			cell = cellIterator.next();
			int columnIndex = cell.getColumnIndex();
			spreadsheet.autoSizeColumn(columnIndex);
		}
		FileOutputStream out = new FileOutputStream(
				new File(Filename));
		workbook.write(out);
		out.close();
	}
	
	@Keyword
	def createexcel(String File)  {
		Workbook wb1 = new XSSFWorkbook();
		FileOutputStream fileOut1 = new FileOutputStream(File);
		XSSFSheet worksheet= wb1.createSheet("Sheet1");
		wb1.write(fileOut1);
		fileOut1.close();
	}

}
