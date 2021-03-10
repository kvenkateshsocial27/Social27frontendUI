package com.stucred.db
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import internal.GlobalVariable
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import java.lang.Object
import java.util.Arrays
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat as DateFormat
import java.util.Date as Date
import java.util.Calendar as Calendar
import java.util.TimeZone as TimeZone
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.logging.KeywordLogger
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import org.apache.commons.io.FileUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File;
import org.apache.commons.io.IOUtils;
import org.apache.poi.sl.draw.geom.PathCommand
import org.openqa.selenium.io.FileHandler;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import java.lang.String
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;


class DBNewCases {




	@Keyword
	def globalwritetoexcel(String OutputFile, String Outputfile)  {
		System.out.println(OutputFile)
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		File  file1 = new File(OutputFile);	
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
		Cell cell = null;
		Row row = wb.getSheetAt(0).getRow(1);
		sh.createRow(1).createCell(0).setCellValue(Outputfile);
		fsIP.close()
		FileOutputStream fos = new FileOutputStream(file1);
		wb.write(fos);
		fos.close()
	}

	@Keyword
	def acessswritetoexcel(String OutputFile, String Outputfile)  {
		System.out.println(OutputFile)
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		File  file1 = new File(OutputFile);
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
		Cell cell = null;
		Row row = wb.getSheetAt(1).getRow(1);
		sh.createRow(1).createCell(0).setCellValue(Outputfile);
		fsIP.close()
		FileOutputStream fos = new FileOutputStream(file1);
		wb.write(fos);
		fos.close()
	}



	@Keyword
	def splitValues_StudentLoan (File sourceFile, File resultFile) {
		FileInputStream excelFileIS = new FileInputStream(sourceFile);
		XSSFWorkbook excelWB = new XSSFWorkbook(excelFileIS);
		XSSFSheet dataSheet = excelWB.getSheetAt(0);
		XSSFWorkbook resultWb = new XSSFWorkbook();
		XSSFSheet resultDataSheet = resultWb.createSheet("Result");
		XSSFRow headerRow = resultDataSheet.createRow(0);
		headerRow.createCell(0).setCellValue("Student Id");
		headerRow.createCell(1).setCellValue("Loan Amount");
		headerRow.createCell(2).setCellValue("Loan Id");
		headerRow.createCell(3).setCellValue("Extension");
		headerRow.createCell(4).setCellValue("Service Charge");
		headerRow.createCell(5).setCellValue("Start Date");
		headerRow.createCell(6).setCellValue("Due Date");
		headerRow.createCell(7).setCellValue("Status");
		headerRow.createCell(8).setCellValue("Days");
		CreationHelper  createHelper = resultWb.getCreationHelper();
		CellStyle dateCellStyle = resultWb.createCellStyle();
		dateCellStyle.setDataFormat(
				createHelper.createDataFormat().getFormat("d/m/yy h:mm:ss"));

		for (int i = 0; i <= dataSheet.getLastRowNum(); i++) {
			XSSFRow row = dataSheet.getRow(i);
			XSSFCell cell = row.getCell(0);
			XSSFRow resultRow = resultDataSheet.createRow(i+1);
			Gson gson = new Gson();
			JsonObject dataObj = gson.fromJson(cell.getStringCellValue(), JsonObject.class);
			resultRow.createCell(0).setCellValue(dataObj.get("student_cog_id").getAsString());
			resultRow.createCell(1).setCellValue(dataObj.get("loan_amt").getAsDouble());
			resultRow.createCell(2).setCellValue(dataObj.get("loan_id").getAsString());
			resultRow.createCell(3).setCellValue(dataObj.get("extension").getAsDouble());
			resultRow.createCell(4).setCellValue(dataObj.get("service_charge").getAsDouble());
			Cell startDateCell = resultRow.createCell(5);
			startDateCell.setCellStyle(dateCellStyle);
			startDateCell.setCellValue(new Date(dataObj.get("start").getAsJsonObject().get('$date').getAsLong()));

			Cell dueDateCell = resultRow.createCell(6);
			dueDateCell.setCellStyle(dateCellStyle);
			dueDateCell.setCellValue(new Date(dataObj.get("due").getAsJsonObject().get('$date').getAsLong()));

			resultRow.createCell(7).setCellValue(dataObj.get("status").getAsString());
			if (dataObj.get("close_date") != null){
				Cell closedDateCell = resultRow.createCell(8);
				closedDateCell.setCellStyle(dateCellStyle);
				closedDateCell.setCellValue(new Date(dataObj.get("close_date").getAsJsonObject().get('$date').getAsLong()));
			}

			double noOfDays = dataObj.get("days").getAsJsonObject().get('$numberDecimal').getAsDouble();
			resultRow.createCell(8).setCellValue(noOfDays);
		}
		resultWb.write(new FileOutputStream(resultFile));
		resultWb.close();
	}

	@Keyword
	def splitValues_doublerepay (File sourceFile, File resultFile) {
		FileInputStream excelFileIS = new FileInputStream(sourceFile);
		XSSFWorkbook excelWB = new XSSFWorkbook(excelFileIS);
		XSSFSheet dataSheet = excelWB.getSheetAt(0);
		XSSFWorkbook resultWb = new XSSFWorkbook();
		XSSFSheet resultDataSheet = resultWb.createSheet("Result");
		XSSFRow headerRow = resultDataSheet.createRow(0);
		headerRow.createCell(0).setCellValue("Loan ID");
		headerRow.createCell(1).setCellValue("Transaction Type");
		headerRow.createCell(2).setCellValue("Transaction Amount");
		headerRow.createCell(3).setCellValue("Student Cog ID");
		headerRow.createCell(4).setCellValue("Student Name");
		headerRow.createCell(5).setCellValue("Student Email");
		headerRow.createCell(6).setCellValue("Student Mobile Number");
		int j = 1
		for (int i = 0; i <= dataSheet.getLastRowNum(); i++) {
			XSSFRow row = dataSheet.getRow(i);
			XSSFCell cell = row.getCell(0);
			XSSFRow resultRow = resultDataSheet.createRow(j);
			j++
			Gson gson = new Gson();
			JsonObject dataObj = gson.fromJson(cell.getStringCellValue(), JsonObject.class);
			JsonObject transObj = dataObj.get("a").getAsJsonObject();
			resultRow.createCell(0).setCellValue(transObj.get("student_loan_local_id").getAsString());
			resultRow.createCell(1).setCellValue(transObj.get("transaction_type").getAsString());
			resultRow.createCell(2).setCellValue(transObj.get("amount").getAsString());
			resultRow.createCell(3).setCellValue(transObj.get("student_cog_id").getAsString());
			resultRow.createCell(4).setCellValue(dataObj.get("b").getAsJsonObject().get("student_name").getAsString());
			resultRow.createCell(5).setCellValue(dataObj.get("b").getAsJsonObject().get("student_email").getAsString());
			resultRow.createCell(6).setCellValue(dataObj.get("b").getAsJsonObject().get("student_mobilenumber").getAsString());
		}
		resultWb.write(new FileOutputStream(resultFile));
		resultWb.close();
	}

	def outputoutput (File sourceFile, String rowno1, String TCNO, String TSNO, String Filter, String ES, String EB, String ED, String Env, int BEvalue, int FEvalue, String Result) {
		FileInputStream excelFileIS = new FileInputStream(sourceFile);
		XSSFWorkbook excelWB = new XSSFWorkbook(excelFileIS);
		XSSFSheet dataSheet = excelWB.getSheetAt(0);
		int rowno = Integer.parseInt(rowno1)
		int i = dataSheet.getLastRowNum()
		System.out.println(i)
		int j = i + 1
		int k = 1
		if ( rowno == k ) {
			XSSFRow headerRow = dataSheet.createRow(0);
			headerRow.createCell(0).setCellValue("S.No");
			headerRow.createCell(1).setCellValue("Test Case ID ");
			headerRow.createCell(2).setCellValue("Test Suite ID");
			headerRow.createCell(3).setCellValue("Filter By");
			headerRow.createCell(4).setCellValue("Record Number");
			headerRow.createCell(5).setCellValue("Executed By");
			headerRow.createCell(6).setCellValue("Executed Date");
			headerRow.createCell(7).setCellValue("Environment");
			headerRow.createCell(8).setCellValue("RecordCount in DB / Expected Data");
			headerRow.createCell(9).setCellValue("RecordCount in App / Actual Data");
			headerRow.createCell(10).setCellValue("Result");
		}

		(new com.stucred.db.Launchapp()).comWait(5)

		XSSFRow resultRow = dataSheet.createRow(j);
		resultRow.createCell(0).setCellValue(rowno);
		resultRow.createCell(1).setCellValue(TCNO);
		resultRow.createCell(2).setCellValue(TSNO);
		resultRow.createCell(3).setCellValue(Filter);
		resultRow.createCell(4).setCellValue(ES);
		resultRow.createCell(5).setCellValue(EB);
		resultRow.createCell(6).setCellValue(ED);
		resultRow.createCell(7).setCellValue(Env);
		resultRow.createCell(8).setCellValue(BEvalue);
		resultRow.createCell(9).setCellValue(FEvalue);
		resultRow.createCell(10).setCellValue(Result);
		excelWB.write(new FileOutputStream(sourceFile));
		excelWB.close();
	}


	def outputoutput_datanew (File sourceFile, String rowno1, String TCNO, String TSNO, String Description,  String EB, String ED, String Env, String BEvalue, String FEvalue, String Result) {
		FileInputStream excelFileIS = new FileInputStream(sourceFile);
		XSSFWorkbook excelWB = new XSSFWorkbook(excelFileIS);
		XSSFSheet dataSheet = excelWB.getSheetAt(0);

		int rowno = Integer.parseInt(rowno1)
		int i = dataSheet.getLastRowNum()
		int j = i + 1
		String sno1 = String.valueOf(j)

		int k = 0
		if ( rowno == k ) {
			XSSFRow headerRow = dataSheet.createRow(0);
			headerRow.createCell(0).setCellValue("S.No");
			headerRow.createCell(1).setCellValue("Test Case ID ");
			headerRow.createCell(2).setCellValue("Test Suite ID");
			headerRow.createCell(3).setCellValue("Test Description");
			headerRow.createCell(4).setCellValue("Executed By");
			headerRow.createCell(5).setCellValue("Executed Date");
			headerRow.createCell(6).setCellValue("Test Environment");
			headerRow.createCell(7).setCellValue("Expected Data");
			headerRow.createCell(8).setCellValue("Actual Data");
			headerRow.createCell(9).setCellValue("Result");
		}

		(new com.stucred.db.Launchapp()).comWait(5)

		XSSFRow resultRow = dataSheet.createRow(j);
		resultRow.createCell(0).setCellValue(sno1);
		resultRow.createCell(1).setCellValue(TCNO);
		resultRow.createCell(2).setCellValue(TSNO);
		resultRow.createCell(3).setCellValue(Description);
		resultRow.createCell(4).setCellValue(EB);
		resultRow.createCell(5).setCellValue(ED);
		resultRow.createCell(6).setCellValue(Env);
		resultRow.createCell(7).setCellValue(BEvalue);
		resultRow.createCell(8).setCellValue(FEvalue);
		resultRow.createCell(9).setCellValue(Result);
		excelWB.write(new FileOutputStream(sourceFile));
		excelWB.close();
	}

	def outputoutput_data (File sourceFile, String rowno1, String TCNO, String TSNO, String Description, String Additional,  String EB, String ED, String Env, String BEvalue, String FEvalue, String Result) {
		FileInputStream excelFileIS = new FileInputStream(sourceFile);
		XSSFWorkbook excelWB = new XSSFWorkbook(excelFileIS);
		XSSFSheet dataSheet = excelWB.getSheetAt(0);

		int rowno = Integer.parseInt(rowno1)
		int i = dataSheet.getLastRowNum()

		System.out.println(i)
		int j = i + 1
		String sno1 = String.valueOf(j)

		int k = 0
		if ( rowno == k ) {
			XSSFRow headerRow = dataSheet.createRow(0);
			headerRow.createCell(0).setCellValue("S.No");
			headerRow.createCell(1).setCellValue("Test Case ID ");
			headerRow.createCell(2).setCellValue("Test Suite ID");
			headerRow.createCell(3).setCellValue("Test Description");
			headerRow.createCell(4).setCellValue("Additional Test Information");
			headerRow.createCell(5).setCellValue("Executed By");
			headerRow.createCell(6).setCellValue("Executed Date");
			headerRow.createCell(7).setCellValue("Test Environment");
			headerRow.createCell(8).setCellValue("Expected Data");
			headerRow.createCell(9).setCellValue("Actual Data");
			headerRow.createCell(10).setCellValue("Result");
		}

		(new com.stucred.db.Launchapp()).comWait(5)

		XSSFRow resultRow = dataSheet.createRow(j);
		resultRow.createCell(0).setCellValue(sno1);
		resultRow.createCell(1).setCellValue(TCNO);
		resultRow.createCell(2).setCellValue(TSNO);
		resultRow.createCell(3).setCellValue(Description);
		resultRow.createCell(4).setCellValue(Additional);
		resultRow.createCell(5).setCellValue(EB);
		resultRow.createCell(6).setCellValue(ED);
		resultRow.createCell(7).setCellValue(Env);
		resultRow.createCell(8).setCellValue(BEvalue);
		resultRow.createCell(9).setCellValue(FEvalue);
		resultRow.createCell(10).setCellValue(Result);
		excelWB.write(new FileOutputStream(sourceFile));
		excelWB.close();
	}

	def outputoutput_data_new (File sourceFile, String rowno1, String TCNO, String TSNO,  String Filter, String ES, String EB, String ED, String Env, String BEvalue, String FEvalue, String Result) {
		System.out.println(rowno1)
		FileInputStream excelFileIS = new FileInputStream(sourceFile);
		XSSFWorkbook excelWB = new XSSFWorkbook(excelFileIS);
		XSSFSheet dataSheet = excelWB.getSheetAt(0);
		int rowno = Integer.parseInt(rowno1)
		int i

		if ( rowno1 != "0") {
			i = dataSheet.getLastRowNum()
			XSSFRow row = dataSheet.getRow(i)
			XSSFCell cell = row.getCell(1)
			String value = cell.getStringCellValue();

			System.out.println(value)
			System.out.println(TSNO)

			if (value == TSNO ) {
				TSNO = ""
				TCNO = ""
			}
		}
		else {
			i = 0
		}

		int j = i + 1
		String sno1 = String.valueOf(j)
		int k = 0

		if ( rowno == k ) {
			XSSFRow headerRow = dataSheet.createRow(0);
			headerRow.createCell(0).setCellValue("S.No");
			headerRow.createCell(1).setCellValue("Test Suite ID");
			headerRow.createCell(2).setCellValue("Test Steps");
			headerRow.createCell(3).setCellValue("Test Description");
			headerRow.createCell(4).setCellValue("Additional Test Details");
			headerRow.createCell(5).setCellValue("Executed By");
			headerRow.createCell(6).setCellValue("Executed Date");
			headerRow.createCell(7).setCellValue("Environment");
			headerRow.createCell(8).setCellValue("Expected Data");
			headerRow.createCell(9).setCellValue("Actual Data");
			headerRow.createCell(10).setCellValue("Result");
		}

		(new com.stucred.db.Launchapp()).comWait(5)

		XSSFRow resultRow = dataSheet.createRow(j);
		resultRow.createCell(0).setCellValue(sno1);
		resultRow.createCell(1).setCellValue(TSNO);
		resultRow.createCell(2).setCellValue(TCNO);
		resultRow.createCell(3).setCellValue(Filter);
		resultRow.createCell(4).setCellValue(ES);
		resultRow.createCell(5).setCellValue(EB);
		resultRow.createCell(6).setCellValue(ED);
		resultRow.createCell(7).setCellValue(Env);
		resultRow.createCell(8).setCellValue(BEvalue);
		resultRow.createCell(9).setCellValue(FEvalue);
		resultRow.createCell(10).setCellValue(Result);
		excelWB.write(new FileOutputStream(sourceFile));
		excelWB.close();
	}


	def outputoutput_Page (File sourceFile, String rowno1, String TCNO, String TSNO, String Filter, String ES, String EB, String ED, String Env, String BEvalue, String FEvalue, String Result) {
		FileInputStream excelFileIS = new FileInputStream(sourceFile);
		XSSFWorkbook excelWB = new XSSFWorkbook(excelFileIS);
		XSSFSheet dataSheet = excelWB.getSheetAt(0);
		int rowno = Integer.parseInt(rowno1)
		int i = dataSheet.getLastRowNum()
		int j = i + 1
		int k = 1
		if ( rowno == k ) {
			XSSFRow headerRow = dataSheet.createRow(0);
			headerRow.createCell(0).setCellValue("S.No");
			headerRow.createCell(1).setCellValue("Test Case ID ");
			headerRow.createCell(2).setCellValue("Test Suite ID");
			headerRow.createCell(3).setCellValue("Credit Approval Date");
			headerRow.createCell(4).setCellValue("Execution Status");
			headerRow.createCell(5).setCellValue("Executed By");
			headerRow.createCell(6).setCellValue("Executed Date");
			headerRow.createCell(7).setCellValue("Environment");
			headerRow.createCell(8).setCellValue("Expected State Code");
			headerRow.createCell(9).setCellValue("Actual State code");
			headerRow.createCell(10).setCellValue("Result");
		}

		(new com.stucred.db.Launchapp()).comWait(2)

		XSSFRow resultRow = dataSheet.createRow(j);
		resultRow.createCell(0).setCellValue(rowno);
		resultRow.createCell(1).setCellValue(TCNO);
		resultRow.createCell(2).setCellValue(TSNO);
		resultRow.createCell(3).setCellValue(Filter);
		resultRow.createCell(4).setCellValue(ES);
		resultRow.createCell(5).setCellValue(EB);
		resultRow.createCell(6).setCellValue(ED);
		resultRow.createCell(7).setCellValue(Env);
		resultRow.createCell(8).setCellValue(BEvalue);
		resultRow.createCell(9).setCellValue(FEvalue);
		resultRow.createCell(10).setCellValue(Result);
		excelWB.write(new FileOutputStream(sourceFile));
		excelWB.close();
	}

	def outputoutputblock (File sourceFile, String rowno1, String TCNO, String TSNO, String EB, String ED, String Filter, String Env, String Username, String Mobilenumber, String userstatus, String Expectedstatus, String Actualstatus, String Result) {
		FileInputStream excelFileIS = new FileInputStream(sourceFile);
		XSSFWorkbook excelWB = new XSSFWorkbook(excelFileIS);
		XSSFSheet dataSheet = excelWB.getSheetAt(0);
		int rowno = Integer.parseInt(rowno1)
		int i = dataSheet.getLastRowNum()
		int j = i + 1
		int k = 1
		if ( rowno == k ) {
			XSSFRow headerRow = dataSheet.createRow(0);
			headerRow.createCell(0).setCellValue("S.No");
			headerRow.createCell(1).setCellValue("Test Case ID ");
			headerRow.createCell(2).setCellValue("Test Suite ID");
			headerRow.createCell(3).setCellValue("Execution By");
			headerRow.createCell(4).setCellValue("Executed Date");
			headerRow.createCell(5).setCellValue("Filter By");
			headerRow.createCell(6).setCellValue("Environment");
			headerRow.createCell(7).setCellValue("User Name");
			headerRow.createCell(8).setCellValue("Mobile Number");
			headerRow.createCell(9).setCellValue("User Status");
			headerRow.createCell(10).setCellValue("Expected Credit Status");
			headerRow.createCell(11).setCellValue("Actual Credit Status");
			headerRow.createCell(12).setCellValue("Result");
		}
		(new com.stucred.db.Launchapp()).comWait(1)
		XSSFRow resultRow = dataSheet.createRow(j);
		resultRow.createCell(0).setCellValue(rowno);
		resultRow.createCell(1).setCellValue(TCNO);
		resultRow.createCell(2).setCellValue(TSNO);
		resultRow.createCell(3).setCellValue(EB);
		resultRow.createCell(4).setCellValue(ED);
		resultRow.createCell(5).setCellValue(Filter);
		resultRow.createCell(6).setCellValue(Env);
		resultRow.createCell(7).setCellValue(Username);
		resultRow.createCell(8).setCellValue(Mobilenumber);
		resultRow.createCell(9).setCellValue(userstatus);
		resultRow.createCell(10).setCellValue(Expectedstatus);
		resultRow.createCell(11).setCellValue(Actualstatus);
		resultRow.createCell(12).setCellValue(Result);
		excelWB.write(new FileOutputStream(sourceFile));
		excelWB.close();
	}

	def outputoutput1 (File sourceFile, String rowno1, String TCNO, String TSNO, String Filter, String ES, String EB, String ED, String Env, String Pageno, String BEvalue,  String Result) {
		FileInputStream excelFileIS = new FileInputStream(sourceFile);
		XSSFWorkbook excelWB = new XSSFWorkbook(excelFileIS);
		XSSFSheet dataSheet = excelWB.getSheetAt(0);
		int rowno = Integer.parseInt(rowno1)
		int i = dataSheet.getLastRowNum()
		int j = i + 1
		int k = 1
		if ( rowno == k ) {
			XSSFRow headerRow = dataSheet.createRow(0);
			headerRow.createCell(0).setCellValue("S.No");
			headerRow.createCell(1).setCellValue("Test Case ID ");
			headerRow.createCell(2).setCellValue("Test Suite ID");
			headerRow.createCell(3).setCellValue("Test Function");
			headerRow.createCell(4).setCellValue("Execution Status");
			headerRow.createCell(5).setCellValue("Executed By");
			headerRow.createCell(6).setCellValue("Executed Date");
			headerRow.createCell(7).setCellValue("Environment");
			headerRow.createCell(8).setCellValue("Expected Data ");
			headerRow.createCell(9).setCellValue("Actual Data");
			headerRow.createCell(10).setCellValue("Result");
		}


		XSSFRow resultRow = dataSheet.createRow(j);
		resultRow.createCell(0).setCellValue(rowno);
		resultRow.createCell(1).setCellValue(TCNO);
		resultRow.createCell(2).setCellValue(TSNO);
		resultRow.createCell(3).setCellValue(Filter);
		resultRow.createCell(4).setCellValue(ES);
		resultRow.createCell(5).setCellValue(EB);
		resultRow.createCell(6).setCellValue(ED);
		resultRow.createCell(7).setCellValue(Env);
		resultRow.createCell(8).setCellValue(Pageno);
		resultRow.createCell(9).setCellValue(BEvalue);
		resultRow.createCell(10).setCellValue(Result);
		excelWB.write(new FileOutputStream(sourceFile));
		excelWB.close();
	}

	def outputoutput2 (File sourceFile, String TCNO, String TSNO, String Filter, String Env, String Pageno, String BEvalue,  String Result) {

		//File Output = new File(sourceFile)
		FileInputStream excelFileIS = new FileInputStream(sourceFile);
		XSSFWorkbook excelWB = new XSSFWorkbook(excelFileIS);
		XSSFSheet dataSheet = excelWB.getSheetAt(0);
		//int rowno = dataSheet.getLastRowNum()-dataSheet.getFirstRowNum();
		//int rowno = Integer.parseInt(rowno1)
		int i = dataSheet.getLastRowNum()
		int j = i + 1
		int k = 0
		if ( i == k )
		{
			XSSFRow headerRow = dataSheet.createRow(0);
			headerRow.createCell(0).setCellValue("S.No");
			headerRow.createCell(1).setCellValue("Test Case ID ");
			headerRow.createCell(2).setCellValue("Test Suite ID");
			headerRow.createCell(3).setCellValue("Test Function");
			headerRow.createCell(4).setCellValue("Environment");
			headerRow.createCell(5).setCellValue("Table data");
			headerRow.createCell(6).setCellValue("Excel data");
			headerRow.createCell(7).setCellValue("Result");
		}


		XSSFRow resultRow = dataSheet.createRow(j);
		resultRow.createCell(0).setCellValue(j);
		resultRow.createCell(1).setCellValue(TCNO);
		resultRow.createCell(2).setCellValue(TSNO);
		resultRow.createCell(3).setCellValue(Filter);
		resultRow.createCell(4).setCellValue(Env);
		resultRow.createCell(5).setCellValue(Pageno);
		resultRow.createCell(6).setCellValue(BEvalue);
		resultRow.createCell(7).setCellValue(Result);
		excelWB.write(new FileOutputStream(sourceFile));
		excelWB.close();
	}


	def splitValues_incorrectstatus (File sourceFile, File resultFile)
	{
		FileInputStream excelFileIS = new FileInputStream(sourceFile);
		XSSFWorkbook excelWB = new XSSFWorkbook(excelFileIS);
		XSSFSheet dataSheet = excelWB.getSheetAt(0);
		XSSFWorkbook resultWb = new XSSFWorkbook();
		XSSFSheet resultDataSheet = resultWb.createSheet("Result");
		XSSFRow headerRow = resultDataSheet.createRow(0);
		headerRow.createCell(0).setCellValue("Loan ID");
		headerRow.createCell(1).setCellValue("Loan Amoutn");
		headerRow.createCell(2).setCellValue("Customer Reference ID");
		headerRow.createCell(3).setCellValue("Transaction Type");
		headerRow.createCell(4).setCellValue("Student Cog ID");
		headerRow.createCell(5).setCellValue("Order ID");
		headerRow.createCell(6).setCellValue("Student Name");
		headerRow.createCell(7).setCellValue("Student Mobile Number");
		int j = 1
		for (int i = 0; i <= dataSheet.getLastRowNum(); i++) {
			XSSFRow row = dataSheet.getRow(i);
			XSSFCell cell = row.getCell(0);
			XSSFRow resultRow = resultDataSheet.createRow(j);
			j++
			Gson gson = new Gson();
			JsonObject dataObj = gson.fromJson(cell.getStringCellValue(), JsonObject.class);
			JsonObject transObj = dataObj.get("a").getAsJsonObject();
			resultRow.createCell(0).setCellValue(transObj.get("loan_id").getAsString());
			resultRow.createCell(1).setCellValue(transObj.get("loan_amt").getAsString());
			resultRow.createCell(2).setCellValue(dataObj.get("b").getAsJsonObject().get("customer_ref_id").getAsString());
			resultRow.createCell(3).setCellValue(dataObj.get("b").getAsJsonObject().get("transaction_type").getAsString());
			resultRow.createCell(4).setCellValue(dataObj.get("b").getAsJsonObject().get("student_cog_id").getAsString());
			resultRow.createCell(5).setCellValue(dataObj.get("b").getAsJsonObject().get("order_id").getAsString());
			resultRow.createCell(6).setCellValue(dataObj.get("c").getAsJsonObject().get("student_name").getAsString());
			resultRow.createCell(7).setCellValue(dataObj.get("c").getAsJsonObject().get("student_mobilenumber").getAsString());

		}
		resultWb.write(new FileOutputStream(resultFile));
		resultWb.close();
	}

	@Keyword
	def createexcel(String File)  {
		Workbook wb1 = new XSSFWorkbook();
		FileOutputStream fileOut1 = new FileOutputStream(File);
		XSSFSheet worksheet= wb1.createSheet("Sheet1");
		wb1.write(fileOut1);
		fileOut1.close();
	}

	@Keyword
	def writetoexcel(String OutputFile, int Sheetno, int getRowno, int getCellNo, String inresult)  {
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		File  file1 = new File(OutputFile);
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno); //Access the worksheet, so that we can update / modify it.
		Cell cell = null;
		Row row = wb.getSheetAt(Sheetno).getRow(getRowno);
		sh.createRow(getRowno).createCell(getCellNo).setCellValue(inresult);
		fsIP.close()
		FileOutputStream fos = new FileOutputStream(file1);
		wb.write(fos);
		fos.close()
	}


	@Keyword
	def Nodatacheck(String OutputFile)
	{
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		File  file1 = new File(OutputFile);
		XSSFWorkbook wb = new XSSFWorkbook(fsIP);
		XSSFSheet sh = wb.getSheetAt(0);
		Row row = wb.getSheetAt(0).getRow(0);
		if (row == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}

