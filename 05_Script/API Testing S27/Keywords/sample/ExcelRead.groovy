package sample


import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.testng.Assert as Assert
import java.lang.Object as Object
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.webui.keyword.builtin.ClickKeyword as ClickKeyword
import com.kms.katalon.core.webui.helper.screenshot.WebUIScreenCaptor as WebUIScreenCaptor
import java.util.ArrayList as ArrayList
import java.util.List as List
import java.util.Set as Set
import java.util.Arrays as Arrays
import java.time.LocalDate as LocalDate
import java.awt.AWTException as AWTException
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import org.apache.commons.io.FileUtils as FileUtils
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import java.text.ParseException as ParseException
import java.text.SimpleDateFormat as SimpleDateFormat
import java.text.DateFormat as DateFormat
import java.util.Date as Date
import java.util.Calendar as Calendar
import java.util.TimeZone as TimeZone
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import java.io.IOException as IOException
import java.io.Reader as Reader
import java.nio.file.Files as Files
import java.nio.file.Paths as Paths
import java.io.File as File
import org.apache.commons.io.IOUtils as IOUtils
import org.apache.poi.sl.draw.geom.PathCommand as PathCommand
import org.openqa.selenium.io.FileHandler as FileHandler
import org.apache.poi.poifs.filesystem.POIFSFileSystem as POIFSFileSystem
import org.apache.poi.ss.usermodel.Row as Row
import java.util.concurrent.TimeUnit as TimeUnit
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import javax.imageio.ImageIO as ImageIO
import java.awt.image.BufferedImage as BufferedImage
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import java.lang.String


public class ExcelRead {




	@Keyword
	def expectedRowNo(String OutputFile, int Sheetno, String columnvalue) {

		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno); //Access the worksheet, so that we can update / modify it.
		int colCount = sh.getLastRowNum();

		for (int i = 0; i < colCount; i++)
		{
			XSSFRow row = sh.getRow(i)
			XSSFCell cell = row.getCell(2)
			String value = cell.getStringCellValue()
			System.out.println(value)
			if( value.equalsIgnoreCase(columnvalue))
			{
				System.out.println(i)
				fsIP.close();
				return i
				break
			}
		}
	}

	@Keyword
	def expectedRowNo1(String OutputFile, int Sheetno, String columnvalue) {

		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno); //Access the worksheet, so that we can update / modify it.
		int colCount = sh.getLastRowNum();

		for (int i = 0; i <= colCount; i++)
		{
			XSSFRow row = sh.getRow(i)
			XSSFCell cell = row.getCell(2)
			String value = cell.getStringCellValue()
			if( value.equalsIgnoreCase(columnvalue))
			{
				System.out.println(i)
				fsIP.close();
				return i
				break
			}
		}
	}


	@Keyword
	def expectedColumnnNo(String OutputFile, int Sheetno, String columnvalue) {

		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno); //Access the worksheet, so that we can update / modify it.
		XSSFRow row = sh.getRow(0)
		int colCount = row.getLastCellNum()
		for (int i = 0; i < colCount; i++)
		{
			XSSFCell cell = row.getCell(i)
			String value = cell.getStringCellValue()
			//System.out.println(value)
			if( value == columnvalue)
			{
				//System.out.println(value)
				//System.out.println(i)
				fsIP.close();
				return i
				break
			}
		}
	}

	def readexcel_getlastnonblankrowno(String OutputFile, int Sheetno) {
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno); //Access the worksheet, so that we can update / modify it.
		int value = sh.getLastRowNum();
		System.out.println(value)

		if (value > 0)
		{
			Loop: for (int i = 0; i < value; i++)
			{
				XSSFRow row = sh.getRow(i)
				XSSFCell cell = row.getCell(1)
				String value1 = cell.getStringCellValue();
				//System.out.println("Value of the Excel Cell is - "+ value1);
				if (value1 == "")
				{
					//System.out.println("Row number is - " +i);
					return i-1
					break
				}
			}
		}
		else
		{
			value = 0
		}
		return value
	}

	@Keyword
	def globalwritetoexcel(String OutputFile, String inresult)  {
		System.out.println(OutputFile)
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		File  file1 = new File(OutputFile);
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
		Cell cell = null;
		Row row = wb.getSheetAt(0).getRow(1);
		sh.createRow(1).createCell(1).setCellValue(inresult);
		fsIP.close()
		FileOutputStream fos = new FileOutputStream(file1);
		wb.write(fos);
		fos.close()
	}


	@Keyword
	def readexcel_cellvalue(String OutputFile, int Sheetno, int Rownum, int Cellnum) {
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno)
		XSSFRow row = sh.getRow(Rownum)
		int row1 = wb.getSheetAt(Sheetno).getLastRowNum();
		if (row1 > 0)
		{
			XSSFCell cell = row.getCell(Cellnum)
			String value = cell.getStringCellValue();
			return value
		}
		else
		{
			return ""
		}
		//System.out.println("Value of the Excel Cell is - "+ value);
		fsIP.close();
	}


	@Keyword
	def readExcel(String filePath,String fileName,int sheetName,String data,int count , String Outputfile, String TC_ID, String TS_ID, String DB_Env) {
		File file =  new File(filePath+"\\"+fileName);
		//Create an object of FileInputStream class to read excel file
		File Output = new File(Outputfile)
		FileInputStream fsIP = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fsIP);
		//Read sheet inside the workbook by its name
		XSSFSheet sh = wb.getSheetAt(sheetName)
		//Find number of rows in excel file
		int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();

		String customcolumnmdata = data
		String[] arrSplitcolumns = customcolumnmdata.split(';')
		int columnlength = arrSplitcolumns.length
		for (int i = 0; i < columnlength; i++)
		{
			String Datavalue1 = arrSplitcolumns[i]

		}
		for (int i = 0; i < 1; i++) {
			Row row = sh.getRow(i);
			for (int j = 1; j < row.getLastCellNum(); j++)
			{
				String Check2 = arrSplitcolumns[j]
				String Check1 = row.getCell(j).getStringCellValue()

			}
		}
	}
}

