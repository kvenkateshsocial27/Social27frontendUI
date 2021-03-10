package com.kf
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


class WriteExcel {

	@Keyword

	def outputoutput (
			File sourceFile,
			String rowno1,
			String Date,
			String Dashboardlink,
			String User,
			String CubeName,
			String CubeRefresh,
			String Timeallowed,
			String Result) {
		FileInputStream excelFileIS = new FileInputStream(sourceFile);
		XSSFWorkbook excelWB = new XSSFWorkbook(excelFileIS);
		XSSFSheet dataSheet = excelWB.getSheetAt(0);
		int rowno = Integer.parseInt(rowno1)
		int i = dataSheet.getLastRowNum()
		int j = i + 1
		int k = 1
		(new com.stucred.db.Launchapp()).comWait(3)
		XSSFRow resultRow = dataSheet.createRow(j);
		resultRow.createCell(0).setCellValue(j);
		resultRow.createCell(1).setCellValue(Date);
		resultRow.createCell(2).setCellValue(Dashboardlink);
		resultRow.createCell(3).setCellValue(User);
		resultRow.createCell(4).setCellValue(CubeName);
		resultRow.createCell(5).setCellValue(CubeRefresh);
		resultRow.createCell(6).setCellValue(Timeallowed);
		resultRow.createCell(7).setCellValue(Result);
		excelWB.write(new FileOutputStream(sourceFile));
		excelWB.close();
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
	def Nodatacheck(String OutputFile) {
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		File  file1 = new File(OutputFile);
		XSSFWorkbook wb = new XSSFWorkbook(fsIP);
		XSSFSheet sh = wb.getSheetAt(0);
		Row row = wb.getSheetAt(0).getRow(0);
		if (row == null) {
			return false;
		}
		else {
			return true;
		}
	}
}

