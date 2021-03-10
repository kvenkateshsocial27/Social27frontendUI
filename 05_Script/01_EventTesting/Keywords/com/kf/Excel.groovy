package com.kf

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.apache.commons.io.FileUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import java.awt.AWTException as AWTException
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import java.util.concurrent.TimeUnit as TimeUnit


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.poi.sl.draw.geom.PathCommand
//import org.apache.xpath.axes.PathComponent
import java.util.Arrays;
import org.openqa.selenium.io.FileHandler;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import internal.GlobalVariable
import java.lang.Object
import java.lang.String

public class Excel {

	KeywordUtil keyword = new KeywordUtil()

	@Keyword
	def createexcel(String File)  {
		Workbook wb1 = new XSSFWorkbook();
		FileOutputStream fileOut1 = new FileOutputStream(File);
		XSSFSheet worksheet= wb1.createSheet("Sheet1");
		wb1.write(fileOut1);
		fileOut1.close();
	}

	@Keyword
	def mergecells(String OutputFile, int Sheetno, int fromRownum, int  toRownum, int fromcolumn, int tocolumn) {
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno)
		sh.addMergedRegion(fromRownum,toRownum,fromcolumn,tocolumn)
		//System.out.println("Value of the Excel Cell is - "+ value);
		fsIP.close();
	}

	@Keyword
	def readexcel_cellvalue(String OutputFile, int Sheetno, int Rownum, int Cellnum) {
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno)
		XSSFRow row = sh.getRow(Rownum)
		XSSFCell cell = row.getCell(Cellnum)
		String value = cell.getStringCellValue();
		//System.out.println("Value of the Excel Cell is - "+ value);
		fsIP.close();
		return value
	}

	@Keyword
	def readexcel_cellvalue_int(String OutputFile, int Sheetno, int Rownum, int Cellnum) {
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno)
		XSSFRow row = sh.getRow(Rownum)
		XSSFCell cell = row.getCell(Cellnum)
		int value = cell.getStringCellValue();
		//System.out.println("Value of the Excel Cell is - "+ value);
		fsIP.close();
		return value
	}

	@Keyword
	def waitUntilFileToDownload (String folderLocation) {
		File directory = new File(folderLocation);
		boolean downloadinFilePresence = false;
		File[] filesList =null;
		LOOP:
		while(true) {
			filesList =  directory.listFiles();
			for (File file : filesList) {
				downloadinFilePresence = file.getName().contains(".csv");
			}
			if(downloadinFilePresence) {
				for(;downloadinFilePresence;) {
					(new com.stucred.db.Launchapp()).comWait(10)
					continue LOOP;
				}
			}else {
				break;
			}
		}
	}


	@Keyword
	def isFileDownloaded_Ext(String dirPath){
		boolean flag=false;
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if(  files[0].length == "" || files == ""|| files == "null") {
			flag = false;
			return flag
		}
		else {
			flag=true;
			return flag
		}
	}
	@Keyword
	def getNumberOfSheets(String OutputFile) {
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		int sheetno = wb.getNumberOfSheets()
		return sheetno
	}


	@Keyword
	def getsheetname (String OutputFile, int Sheetno) {
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno)
		String sheetname = sh.getSheetName()
		return sheetname
	}

	@Keyword
	def getsheetnofromname(String OutputFile, String expectedsheet) {
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		int sheetno = wb.getNumberOfSheets()
		//System.out.println(sheetno)
		Loop: for (int i = 0; i <= sheetno; i++)
		{
			XSSFSheet sh = wb.getSheetAt(i)
			String sheetname = sh.getSheetName()
			System.out.println(sheetname)
			if (sheetname == expectedsheet)
			{
				System.out.println("Value of the Excel Cell is - " + i);
				return i
				break
			}
		}
		fsIP.close();
	}


	def readexcel_getlastnonblankrowno(String OutputFile, int Sheetno) {
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno); //Access the worksheet, so that we can update / modify it.
		int value = sh.getLastRowNum();
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
		return value
	}

	def writetoexcel(String OutputFile, int Sheetno, int getRowno, int getCellNo, String inresult)  {

		Runtime.getRuntime().exec("cmd /c taskkill /f /im excel.exe");
		/*
		 File workbookFile = new File(OutputFile);
		 FileInputStream fileout = new FileInputStream(workbookFile);
		 fileout.close();
		 */

		new com.stucred.db.Launchapp().comWait(5)
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		File  file1 = new File(OutputFile);
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno); //Access the worksheet, so that we can update / modify it.
		Cell cell = null;
		Row row = wb.getSheetAt(Sheetno).getRow(getRowno);
		cell = sh.getRow(getRowno).getCell(getCellNo);
		if (cell == null)
		{
			//cell = row.createCell(15);
			cell = row.createCell(getCellNo);
			cell.setCellValue(inresult)
		}
		else
		{
			cell.setCellValue(inresult)
		}
		fsIP.close()
		FileOutputStream fos = new FileOutputStream(file1);
		wb.write(fos);
		fos.close()
		new com.stucred.db.Launchapp().comWait(10)

	}

	def writetoexcel1(String OutputFile, int Sheetno, int getRowno, int getCellNo, double inresult)  {

		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		File  file1 = new File(OutputFile);
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno); //Access the worksheet, so that we can update / modify it.
		Cell cell = null;
		Row row = wb.getSheetAt(Sheetno).getRow(getRowno);
		cell = sh.getRow(getRowno).getCell(getCellNo);

		if (cell == null)
		{
			System.out.println("null lopp")
			cell = row.createCell(getCellNo);
			cell.setCellValue(inresult)
		}
		else
		{
			System.out.println("value lopp")

			cell.setCellValue(inresult)
		}
		fsIP.close()
		FileOutputStream fos = new FileOutputStream(file1);
		wb.write(fos);
		fos.close()
	}


	def writetoexcel_status(String OutputFile, int Sheetno, int getRowno, int getCellNo, String inresult)
	{


		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		File  file1 = new File(OutputFile);
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno); //Access the worksheet, so that we can update / modify it.
		Cell cell = null;
		Row row = wb.getSheetAt(Sheetno).getRow(getRowno);
		cell = sh.getRow(getRowno).getCell(getCellNo);
		Font font = wb.createFont();
		CellStyle cellStyle = wb.createCellStyle();

		if (inresult.contains("PASS"))
		{
			font.setColor(IndexedColors.WHITE.getIndex());
			font.setBold(true);
			font.setFontHeightInPoints((short)9);
			font.setFontName("Calibri");
			cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cellStyle.setFont(font);
			cell.setCellStyle(cellStyle);
		}
		else if (inresult.contains("FAIL"))
		{
			font.setColor(IndexedColors.WHITE.getIndex());
			font.setBold(true);
			font.setFontHeightInPoints((short)9);
			font.setFontName("Calibri");
			cellStyle.setFont(font);
			cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());
			cellStyle.setFillPattern(FillPatternType.ALT_BARS);
			cell.setCellStyle(cellStyle);
		}

		else if (inresult == "WARNING")
		{
			font.setColor(IndexedColors.WHITE.getIndex());
			font.setBold(true);
			font.setFontHeightInPoints((short)9);
			font.setFontName("Calibri");

			cellStyle.setFont(font);
			cellStyle.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(cellStyle);
		}

		else if (inresult == "CHECK")
		{
			font.setColor(IndexedColors.WHITE.getIndex());
			font.setBold(true);
			cellStyle.setFont(font);
			cellStyle.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(cellStyle);
		}

		if (cell == null)
		{

			cell = row.createCell(15);
			cell.setCellValue(inresult)

		}
		else
		{
			cell.setCellValue(inresult)
		}
		fsIP.close()
		FileOutputStream fos = new FileOutputStream(file1);
		wb.write(fos);
		fos.close()
	}

	def writetoexcel_status_merge(String OutputFile, int Sheetno, int getRowno, int getCellNo, String inresult)  {
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		File  file1 = new File(OutputFile);
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno); //Access the worksheet, so that we can update / modify it.
		Cell cell = null;
		Row row = wb.getSheetAt(Sheetno).getRow(getRowno);
		cell = sh.getRow(getRowno).getCell(getCellNo);
		Font font = wb.createFont();
		CellStyle cellStyle = wb.createCellStyle();

		if (cell == null)
		{
			cell = row.createCell(getCellNo);
			cell.setCellValue(inresult)

		}
		else
		{
			cell.setCellValue(inresult)
		}

		if (inresult == "PASS")
		{
			font.setColor(IndexedColors.WHITE.getIndex());
			font.setBold(true);
			font.setFontHeightInPoints((short)9);
			font.setFontName("Calibri");
			cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cellStyle.setFont(font);
			cell.setCellStyle(cellStyle);
		}
		else if (inresult == "FAIL")
		{
			font.setColor(IndexedColors.WHITE.getIndex());
			font.setBold(true);
			font.setFontHeightInPoints((short)9);
			font.setFontName("Calibri");
			cellStyle.setFont(font);
			cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());
			cellStyle.setFillPattern(FillPatternType.ALT_BARS);
			cell.setCellStyle(cellStyle);
		}

		else if (inresult == "WARNING")
		{
			font.setColor(IndexedColors.WHITE.getIndex());
			font.setBold(true);
			font.setFontHeightInPoints((short)9);
			font.setFontName("Calibri");

			cellStyle.setFont(font);
			cellStyle.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(cellStyle);
		}

		else if (inresult == "CHECK")
		{
			font.setColor(IndexedColors.WHITE.getIndex());
			font.setBold(true);
			cellStyle.setFont(font);
			cellStyle.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(cellStyle);
		}

		fsIP.close()
		FileOutputStream fos = new FileOutputStream(file1);
		wb.write(fos);
		fos.close()
	}


	@Keyword
	def getColumnsCount(String OutputFile,  int Sheetno) {
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno); //Access the worksheet, so that we can update / modify it.
		XSSFRow row = sh.getRow(0)
		int colCount = row.getLastCellNum()
		fsIP.close();
		return colCount
	}

	@Keyword
	def copysheet (String OutputFile, int Sheetno, String newsheetname) {
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook workbook = new XSSFWorkbook(fsIP);
		XSSFSheet XSSFSheet = workbook.cloneSheet(Sheetno, newsheetname);
		FileOutputStream os = new FileOutputStream(new File(OutputFile));
		workbook.write(os);
		fsIP.close();
	}


	public static String stripNonDigits(
			final CharSequence input /* inspired by seh's comment */){
		final StringBuilder sb = new StringBuilder(
				input.length() /* also inspired by seh's comment */);
		for(int i = 0; i < input.length(); i++){
			final char c = input.charAt(i);
			if(c > 47 && c < 58){
				sb.append(c);
			}
		}
		return sb.toString();
	}

	@Keyword
	def readcsvfile(String OutputFile)
	{
		String SAMPLE_CSV_FILE_PATH = OutputFile;
		Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		for (CSVRecord csvRecord : csvParser)
		{
			if (csvRecord.recordNumber == 2)
			{
				String value = csvRecord.get(0);
				return value
			}
		}
	}

	@Keyword
	def readcsvfile_chart(String OutputFile)
	{
		String SAMPLE_CSV_FILE_PATH = OutputFile;
		Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		System.out.println(csvParser)
		for (CSVRecord csvRecord : csvParser)
		{
			String DischargeDate = csvRecord.get(0);
			String LOCCareType = csvRecord.get(1);
			String ALOS = csvRecord.get(2);

			System.out.println("Record No - " + csvRecord.getRecordNumber());
			System.out.println("DischargeDate : " + DischargeDate);
			System.out.println("LOCCareType : " + LOCCareType);
			System.out.println("ALOS : " + ALOS);
			/*
			 if (csvRecord.recordNumber == 3)
			 {
			 String value = csvRecord.get(2);
			 System.out.println(value)
			 }
			 */
		}
	}

	@Keyword
	def sheetcount (String OutputFile)
	{
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		int noofsheets = wb.getNumberOfSheets()
		return noofsheets
	}

	@Keyword
	def deleteexistsheets(String OutputFile, String sheetname)
	{
		FileInputStream fsIP= new FileInputStream(new File(OutputFile));
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		//XSSFSheet sh = wb.getSheetAt(Sheetno); //Access the worksheet, so that we can update / modify it.
		int noofsheets = wb.getNumberOfSheets()
		//System.out.println(noofsheets)
		for(int i = 0; i < noofsheets; i++)
		{
			XSSFSheet sh = wb.getSheetAt(i);
			String sheetname1 = sh.getSheetName()
			//System.out.println(sheetname1)
			if(sheetname1 == sheetname)
			{
				int index = wb.getSheetIndex(sheetname);
				//System.out.println(index)
				wb.removeSheetAt(index)
				//System.out.println("Sheet already exists, removed successfully")
				FileOutputStream os = new FileOutputStream(new File(OutputFile));
				wb.write(os);
				fsIP.close();
				break
			}
		}
	}

	@Keyword
	def globalwritetoexcel(String OutputFile, int Sheetno, int getRowno, int getCellNo, String inresult)  {
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
	def globalwritetoexcel1(File OutputFile, int Sheetno, int getRowno, int getCellNo, String inresult)  {
		FileInputStream fsIP= new FileInputStream(OutputFile);
		//File  file1 = new File(OutputFile);
		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
		XSSFSheet sh = wb.getSheetAt(Sheetno); //Access the worksheet, so that we can update / modify it.
		Cell cell = null;
		Row row = wb.getSheetAt(Sheetno).getRow(getRowno);
		sh.createRow(getRowno).createCell(getCellNo).setCellValue(inresult);
		fsIP.close()
		FileOutputStream fos = new FileOutputStream(OutputFile);
		wb.write(fos);
		fos.close()
	}


	@Keyword
	def actual_CompareExcel(String OutputFile, int Sheetno, String columnvalue) {

		File baseFile1 = new File("Excelworkbook1.xlsx");
		File baseFile2 = new File("Excelworkbook2.xlsx");
		File compareFile = new File("comparisonResult.xlsx");
		try {
			compareExcelSheets(baseFile1, baseFile2, compareFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Keyword
	def copyExcelwork (File excelFile1, File resultFile)
	{

		FileInputStream excelFile1IS = new FileInputStream(excelFile1);
		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook excel1WB = new XSSFWorkbook(excelFile1IS);

		List<String> headerList = getWorksheetHeader(excel1WB);
		XSSFWorkbook resultWb = new XSSFWorkbook();
		XSSFSheet resultDataSheet = resultWb.createSheet("Result");

		createHeader_copyexcel(resultDataSheet, headerList, FilenameUtils.getBaseName(excelFile1.getName()))
		WriteToFile1(getWorksheetData(excel1WB), resultDataSheet);

		excel1WB.close();
		resultWb.write(new FileOutputStream(resultFile));
		resultWb.close();

	}


	@Keyword
	def compareExcelSheets(File excelFile1, File excelFile2, File resultFile,int threshold ) throws IOException {

		FileInputStream excelFile1IS = new FileInputStream(excelFile1);
		FileInputStream excelFile2IS = new FileInputStream(excelFile2);

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook excel1WB = new XSSFWorkbook(excelFile1IS);
		XSSFWorkbook excel2WB = new XSSFWorkbook(excelFile2IS);
		List<String> headerList = getWorksheetHeader(excel1WB);

		if (headerList.size() != getWorksheetHeader(excel2WB).size()) {
			System.out.println("Column size is not same.");
			return;
		}


		XSSFWorkbook resultWb = new XSSFWorkbook();
		XSSFSheet resultDataSheet = resultWb.createSheet("Result");

		createHeader(resultDataSheet, headerList, FilenameUtils.getBaseName(excelFile1.getName()), FilenameUtils.getBaseName(excelFile2.getName()));
		compareAndWriteToFile(getWorksheetData(excel1WB), getWorksheetData(excel2WB), resultDataSheet,threshold);

		excel1WB.close();
		excel2WB.close();

		resultWb.write(new FileOutputStream(resultFile));
		resultWb.close();
	}

	def compareExcelSheetsupdate(File excelFile1, File excelFile2, File resultFile, String sheetname1, int threshold)
	throws IOException {
		FileInputStream excelFile1IS = new FileInputStream(excelFile1);
		FileInputStream excelFile2IS = new FileInputStream(excelFile2);
		FileInputStream excelFile2I3 = new FileInputStream(resultFile);

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook excel1WB = new XSSFWorkbook(excelFile1IS);
		XSSFWorkbook excel2WB = new XSSFWorkbook(excelFile2IS);
		XSSFWorkbook excel3WB = new XSSFWorkbook(excelFile2I3);

		List<String> headerList = getWorksheetHeader(excel1WB);

		if (headerList.size() != getWorksheetHeader(excel2WB).size()) {
			System.out.println("Column size is not same.");
			return;
		}

		XSSFSheet resultDataSheet = excel3WB.createSheet(sheetname1);
		createHeader(resultDataSheet, headerList, FilenameUtils.getBaseName(excelFile1.getName()), FilenameUtils.getBaseName(excelFile2.getName()));
		String resultdata = compareAndWriteToFile_Table(getWorksheetData(excel1WB), getWorksheetData(excel2WB), resultDataSheet, threshold);
		excel1WB.close();
		excel2WB.close();
		excel3WB.write(new FileOutputStream(resultFile));
		excel3WB.close();
		System.out.println(resultdata)
		return resultdata
	}
	/*********************** This keyword is used for handling only one table in the Addiction campus because of format change ---------------------/ - has the int i = datasheet.getFirstRowNum() + 2, changed *********************/

	def compareExcelSheetsupdate_Chart(File excelFile1, File excelFile2, File resultFile, String sheetname1, int threshold)

	throws IOException {
		FileInputStream excelFile1IS = new FileInputStream(excelFile1);
		FileInputStream excelFile2IS = new FileInputStream(excelFile2);
		FileInputStream excelFile2I3 = new FileInputStream(resultFile);

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook excel1WB = new XSSFWorkbook(excelFile1IS);
		XSSFWorkbook excel2WB = new XSSFWorkbook(excelFile2IS);
		XSSFWorkbook excel3WB = new XSSFWorkbook(excelFile2I3);

		List<String> headerList = getWorksheetHeader(excel1WB);

		if (headerList.size() != getWorksheetHeader(excel2WB).size()) {
			System.out.println("Column size is not same.");
			return;
		}

		XSSFSheet resultDataSheet = excel3WB.createSheet(sheetname1);
		createHeader(resultDataSheet, headerList, FilenameUtils.getBaseName(excelFile1.getName()), FilenameUtils.getBaseName(excelFile2.getName()));
		System.out.println("Completed creating header")
		String resultdata =  compareAndWriteToFile_case3(getWorksheetData2(excel1WB), getWorksheetData2(excel2WB), resultDataSheet, threshold);
		System.out.println("Completed creating worksheet")
		excel1WB.close();
		excel2WB.close();

		excel3WB.write(new FileOutputStream(resultFile));
		excel3WB.close();
		return resultdata
	}

	/*********************** This keyword is used for handling only one table in the Addiction campus because of format change ---------------------/ - has the int i = datasheet.getFirstRowNum() + 2, changed *********************/

	def compareExcelSheetsupdate_AC(File excelFile1, File excelFile2, File resultFile, String sheetname1, int threshold)

	throws IOException {
		FileInputStream excelFile1IS = new FileInputStream(excelFile1);
		FileInputStream excelFile2IS = new FileInputStream(excelFile2);
		FileInputStream excelFile2I3 = new FileInputStream(resultFile);

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook excel1WB = new XSSFWorkbook(excelFile1IS);
		XSSFWorkbook excel2WB = new XSSFWorkbook(excelFile2IS);
		XSSFWorkbook excel3WB = new XSSFWorkbook(excelFile2I3);

		List<String> headerList = getWorksheetHeader(excel1WB);

		if (headerList.size() != getWorksheetHeader(excel2WB).size()) {
			System.out.println("Column size is not same.");
			return;
		}

		XSSFSheet resultDataSheet = excel3WB.createSheet(sheetname1);
		createHeader(resultDataSheet, headerList, FilenameUtils.getBaseName(excelFile1.getName()), FilenameUtils.getBaseName(excelFile2.getName()));
		System.out.println("Completed creating header")
		String resultdata = compareAndWriteToFile_case3(getWorksheetData1(excel1WB), getWorksheetData1(excel2WB), resultDataSheet, threshold);
		System.out.println("Completed creating worksheet")
		excel1WB.close();
		excel2WB.close();
		excel3WB.write(new FileOutputStream(resultFile));
		excel3WB.close();
		return resultdata
	}
	/*********************** This keyword is used for handling only one table in the Addiction campus because of format change ---------------------/ - has the int i = datasheet.getFirstRowNum() + 2, changed *********************/


	@Keyword
	def compareExcelSheets(File excelFile1, File excelFile2, File resultFile, String sheetname, int threshold ) throws IOException {

		FileInputStream excelFile1IS = new FileInputStream(excelFile1);
		FileInputStream excelFile2IS = new FileInputStream(excelFile2);

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook excel1WB = new XSSFWorkbook(excelFile1IS);
		XSSFWorkbook excel2WB = new XSSFWorkbook(excelFile2IS);
		List<String> headerList = getWorksheetHeader(excel1WB);

		if (headerList.size() != getWorksheetHeader(excel2WB).size()) {
			System.out.println("Column size is not same.");
			return;
		}


		XSSFWorkbook resultWb = new XSSFWorkbook();
		XSSFSheet resultDataSheet = resultWb.createSheet(sheetname);

		createHeader(resultDataSheet, headerList, FilenameUtils.getBaseName(excelFile1.getName()), FilenameUtils.getBaseName(excelFile2.getName()));

		compareAndWriteToFile(getWorksheetData(excel1WB), getWorksheetData(excel2WB), resultDataSheet,threshold);

		excel1WB.close();
		excel2WB.close();

		resultWb.write(new FileOutputStream(resultFile));
		resultWb.close();
	}

	@Keyword
	def Map<String, List<Double>> getWorksheetData(XSSFWorkbook excelWB)
	{

		Map<String, List<Double>> wbData1 = new LinkedHashMap<>();

		XSSFSheet dataSheet = excelWB.getSheetAt(0);
		for (int i = dataSheet.getFirstRowNum() + 1; i <= dataSheet.getLastRowNum(); i++)
		{
			XSSFRow row = dataSheet.getRow(i);
			List<Double> dataPoints = new ArrayList<>();
			String dataKey = null;
			for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
				XSSFCell cell1 = row.getCell(j);
				if (j == 0) {
					dataKey = cell1.getStringCellValue();
				} else {
					dataPoints.add(cell1.getNumericCellValue());
				}
			}
			wbData1.put(dataKey, dataPoints);
		}
		return wbData1;
	}

	/*********************** This getWorksheetData1 - has the int i = datasheet.getFirstRowNum() + 2, changed *********************/

	@Keyword
	def Map<String, List<Double>> getWorksheetData1(XSSFWorkbook excelWB)
	{

		Map<String, List<Double>> wbData1 = new LinkedHashMap<>();

		XSSFSheet dataSheet = excelWB.getSheetAt(0);
		for (int i = dataSheet.getFirstRowNum() + 2; i <= dataSheet.getLastRowNum(); i++)
		{
			XSSFRow row = dataSheet.getRow(i);
			List<Double> dataPoints = new ArrayList<>();
			String dataKey = null;
			for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
				XSSFCell cell1 = row.getCell(j);
				if (j == 0) {
					dataKey = cell1.getStringCellValue();
				} else {
					dataPoints.add(cell1.getNumericCellValue());
				}
			}
			wbData1.put(dataKey, dataPoints);
		}
		return wbData1;
	}

	/*********************** This getWorksheetData2 , aded the else if (j == 1) to handle the string cell value, changed *********************/
	@Keyword
	def Map<String, List<Double>> getWorksheetData2(XSSFWorkbook excelWB)
	{
		Map<String, List<Double>> wbData1 = new LinkedHashMap<>();
		XSSFSheet dataSheet = excelWB.getSheetAt(0);
		for (int i = dataSheet.getFirstRowNum() + 1; i <= dataSheet.getLastRowNum(); i++)
		{
			XSSFRow row = dataSheet.getRow(i);
			List<Double> dataPoints = new ArrayList<>();
			String dataKey = null;
			for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++)
			{
				XSSFCell cell1 = row.getCell(j);

				if (j == 0) {
					dataKey = cell1.getStringCellValue();
				}
				else if (j == 1)
				{
					dataKey = cell1.getStringCellValue();
				}
				else
				{
					dataPoints.add(cell1.getNumericCellValue());
					System.out.println("Inside the Numeric Value loop" : cell1.getNumericCellValue())
				}
			}
			wbData1.put(dataKey, dataPoints);
		}
		return wbData1;
	}
	/*********************** This getWorksheetData2 , aded the else if (j == 1) to handle the string cell value, changed *********************/

	@Keyword
	def List<String> getWorksheetHeader(XSSFWorkbook excelWB) {
		List<String> headerList = new ArrayList<>();
		XSSFSheet dataSheet = excelWB.getSheetAt(0);
		XSSFRow row = dataSheet.getRow(0);
		for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
			XSSFCell cell1 = row.getCell(j);
			headerList.add(cell1.getStringCellValue());
		}
		return headerList;
	}

	@Keyword
	def formatCell(Cell cell, boolean isPass) {
		Workbook wb = cell.getRow().getSheet().getWorkbook();
		CellStyle changeStyle = wb.createCellStyle();
		if (isPass) {
			changeStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			changeStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellValue("Pass");
		} else {
			changeStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
			changeStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellValue("Fail");
		}
		cell.setCellStyle(changeStyle);
	}


	@Keyword
	def createHeader_copyexcel(XSSFSheet resultDataSheet, List<String> headerList, String file1Name)

	{
		List<String> resultHeaderList = new ArrayList<>();
		for (int i = 0; i < headerList.size(); i++) {
			String headerValue = headerList.get(i);
			if (i == 0) {
				resultHeaderList.add(headerValue);
			} else {
				resultHeaderList.add(headerValue + " in " + file1Name);
				resultHeaderList.add("Difference in " + headerValue);
				resultHeaderList.add(headerValue + " Status");
			}
		}
		Row row = resultDataSheet.createRow(0);

		for (int i = 0; i < resultHeaderList.size(); i++) {
			row.createCell(i).setCellValue(resultHeaderList.get(i));
		}
	}

	@Keyword
	def createHeader(XSSFSheet resultDataSheet, List<String> headerList, String file1Name, String file2Name)

	{
		List<String> resultHeaderList = new ArrayList<>();
		for (int i = 0; i < headerList.size(); i++) {
			String headerValue = headerList.get(i);
			if (i == 0) {
				resultHeaderList.add(headerValue);
			} else {
				resultHeaderList.add(headerValue + " in " + file1Name);
				resultHeaderList.add(headerValue + " in " + file2Name);
				resultHeaderList.add("Difference in " + headerValue);
				resultHeaderList.add("% Difference in " + headerValue);
				resultHeaderList.add(headerValue + " Status");
			}
		}
		Row row = resultDataSheet.createRow(0);

		for (int i = 0; i < resultHeaderList.size(); i++) {
			row.createCell(i).setCellValue(resultHeaderList.get(i));
		}
	}

	@Keyword
	def WriteToFile1(Map<String, List<Double>> worksheetData, XSSFSheet resultDataSheet)
	{
		int rowIndex = 1;

		for (Map.Entry<String, List<Double>> entry : worksheetData.entrySet()) {
			int cellIndex = 0;
			Row row = resultDataSheet.createRow(rowIndex);
			row.createCell(cellIndex).setCellValue(entry.getKey());
			cellIndex++;
			List<Double> list1 = entry.getValue();
			for (int i = 0; i < list1.size(); i++) {
				double value1 = list1.get(i);
				row.createCell(cellIndex).setCellValue(value1);
				cellIndex++;
			}
		}
		rowIndex++;
	}


	@Keyword
	def compareAndWriteToFile_case2(Map<String, List<Double>> worksheetData, Map<String, List<Double>> worksheetData1, XSSFSheet resultDataSheet ,int threshold)
	{
		int rowIndex = 1;

		for (Map.Entry<String, List<Double>> entry : worksheetData.entrySet()) {
			int cellIndex = 0;
			Row row = resultDataSheet.createRow(rowIndex);
			row.createCell(cellIndex).setCellValue(entry.getKey());
			cellIndex++;
			List<Double> list1 = entry.getValue();
			List<Double> list2 = worksheetData1.get(entry.getKey());

			for (int i = 0; i < list1.size(); i++) {
				double value1 = list1.get(i);
				//No Data Available for the reference point
				double value2;
				if (list2 == null) {
					value2 = 0;
				} else {
					value2 = list2.get(i);
				}

				double difference = value2 - value1;
				row.createCell(cellIndex).setCellValue(value1);
				cellIndex++;

				row.createCell(cellIndex).setCellValue(value2);
				cellIndex++;

				row.createCell(cellIndex).setCellValue(difference);
				cellIndex++;

				double percentageDifference;

				if (difference > 0) {
					percentageDifference = (difference / value2) * 100;

				}
				else if (difference == 0)
				{
					percentageDifference = 0;
				}
				else {
					percentageDifference = (-difference / value1) * 100;
				}

				String Per_result40 = String.valueOf(percentageDifference)
				String Per_result41 = (Per_result40 + '%')
				int decimalsToConsider = 2
				BigDecimal bigDecimal = new BigDecimal(percentageDifference)
				BigDecimal roundedWithScale = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP)
				String roundedWithScale1 = String.valueOf(roundedWithScale)
				String per_roundedWithScale1 = (roundedWithScale1 + '%')

				row.createCell(cellIndex).setCellValue(per_roundedWithScale1);
				cellIndex++;

				if (percentageDifference < threshold) {
					formatCell(row.createCell(cellIndex), true);
				} else {
					formatCell(row.createCell(cellIndex), false);
				}
				cellIndex++;

			}
			rowIndex++;

		}
	}

	@Keyword
	def compareAndWriteToFile(Map<String, List<Double>> worksheetData, Map<String, List<Double>> worksheetData1, XSSFSheet resultDataSheet ,int threshold)
	{
		int rowIndex = 1;
		int resultdata_int;
		for (Map.Entry<String, List<Double>> entry : worksheetData.entrySet()) {
			int cellIndex = 0;
			Row row = resultDataSheet.createRow(rowIndex);
			row.createCell(cellIndex).setCellValue(entry.getKey());
			cellIndex++;
			List<Double> list1 = entry.getValue();
			List<Double> list2 = worksheetData1.get(entry.getKey());

			for (int i = 0; i < list1.size(); i++) {
				double value1 = list1.get(i);
				//No Data Available for the reference point
				double value2;

				if (list2 == null) {
					value2 = 0;
				} else {
					value2 = list2.get(i);
				}

				double difference = value2 - value1;

				row.createCell(cellIndex).setCellValue(value1);
				cellIndex++;

				row.createCell(cellIndex).setCellValue(value2);
				cellIndex++;

				row.createCell(cellIndex).setCellValue(difference);
				cellIndex++;

				double percentageDifference;

				if (difference > 0) {
					percentageDifference = (difference / value2) * 100;
				}
				else if (difference == 0)
				{
					percentageDifference = 0;
				}
				else {
					percentageDifference = (-difference / value1) * 100;
				}

				String Per_result40 = String.valueOf(percentageDifference)
				String Per_result41 = (Per_result40 + '%')
				int decimalsToConsider = 2
				BigDecimal bigDecimal = new BigDecimal(percentageDifference)
				BigDecimal roundedWithScale = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP)
				String roundedWithScale1 = String.valueOf(roundedWithScale)
				String per_roundedWithScale1 = (roundedWithScale1 + '%')

				row.createCell(cellIndex).setCellValue(per_roundedWithScale1);
				cellIndex++;
				if (percentageDifference < threshold) {
					formatCell(row.createCell(cellIndex), true);
				} else {
					formatCell(row.createCell(cellIndex), false);
				}
				cellIndex++;

			}
			rowIndex++;

		}

	}

	@Keyword
	def compareAndWriteToFile_Table(Map<String, List<Double>> worksheetData, Map<String, List<Double>> worksheetData1, XSSFSheet resultDataSheet ,int threshold)
	{
		int rowIndex = 1;
		String resultdata_int;
		for (Map.Entry<String, List<Double>> entry : worksheetData.entrySet()) {
			int cellIndex = 0;
			Row row = resultDataSheet.createRow(rowIndex);
			row.createCell(cellIndex).setCellValue(entry.getKey());
			cellIndex++;
			List<Double> list1 = entry.getValue();
			List<Double> list2 = worksheetData1.get(entry.getKey());

			for (int i = 0; i < list1.size(); i++) {
				double value1 = list1.get(i);
				System.out.println(Value1: value1)
				//No Data Available for the reference point
				double value2;
				System.out.println(Value2: value2)

				if (list2 == null) {
					value2 = 0;
				} else {
					value2 = list2.get(i);
				}

				double difference = value2 - value1;

				row.createCell(cellIndex).setCellValue(value1);
				cellIndex++;

				row.createCell(cellIndex).setCellValue(value2);
				cellIndex++;

				row.createCell(cellIndex).setCellValue(difference);
				cellIndex++;

				double percentageDifference;

				if (difference > 0) {
					percentageDifference = (difference / value2) * 100;
				}
				else if (difference == 0)
				{
					percentageDifference = 0;
				}
				else {
					percentageDifference = (-difference / value1) * 100;
				}

				String Per_result40 = String.valueOf(percentageDifference)
				String Per_result41 = (Per_result40 + '%')
				int decimalsToConsider = 2
				BigDecimal bigDecimal = new BigDecimal(percentageDifference)
				BigDecimal roundedWithScale = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP)
				String roundedWithScale1 = String.valueOf(roundedWithScale)
				String per_roundedWithScale1 = (roundedWithScale1 + '%')

				row.createCell(cellIndex).setCellValue(per_roundedWithScale1);
				cellIndex++;
				if (percentageDifference < threshold) {
					formatCell(row.createCell(cellIndex), true);
				} else {
					formatCell(row.createCell(cellIndex), false);
					resultdata_int = "FAIL"
				}
				cellIndex++;
			}
			rowIndex++;
		}
		if (resultdata_int == "FAIL")
		{
			return resultdata_int
			new com.kf.Excel().writetoexcel_status('D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\06_AddictionCampusReports\\Dataknownfactors_Dashboard_GlobalSheet.xlsx', 0, 6, 0, resultdata_int)
			System.out.println(resultdata_int)
		}

		else
		{
			resultdata_int = "PASS"
			return resultdata_int
			new com.kf.Excel().writetoexcel_status('D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\06_AddictionCampusReports\\Dataknownfactors_Dashboard_GlobalSheet.xlsx', 0, 6, 0, resultdata_int)
			System.out.println(resultdata_int)
		}

	}

	/*************************** This keyword is used to handle the table - inpatient / outpatient (because of format change) ***************************/	
	@Keyword
	def compareAndWriteToFile_case3(Map<String, List<Double>> worksheetData, Map<String, List<Double>> worksheetData1, XSSFSheet resultDataSheet, int threshold)
	{
		int rowIndex = 1;
		String resultdata_int;
		for (Map.Entry<String, List<String>> entry : worksheetData.entrySet())
		{
			int cellIndex = 0;
			Row row = resultDataSheet.createRow(rowIndex);
			row.createCell(0).setCellValue(entry.getKey());
			row.createCell(1).setCellValue(entry.getKey());
			cellIndex++;

			List<Double> list1 = entry.getValue();
			List<Double> list2 = worksheetData1.get(entry.getKey());
			for (int i = 0; i < list1.size(); i++) {
				double value1 = list1.get(i);
				System.out.println(value1)
				//No Data Available for the reference point

				double value2;
				System.out.println(value2)

				if (list2 == null) {
					value2 = 0;
				} else {
					value2 = list2.get(i);
				}
				double difference = value2 - value1;

				row.createCell(cellIndex).setCellValue(value1);
				cellIndex++;

				row.createCell(cellIndex).setCellValue(value2);
				cellIndex++;

				row.createCell(cellIndex).setCellValue(difference);
				cellIndex++;

				double percentageDifference;

				if (difference > 0) {
					percentageDifference = (difference / value2) * 100;

				}
				else if (difference == 0)
				{
					percentageDifference = 0;
				}
				else {
					percentageDifference = (-difference / value1) * 100;
				}

				String Per_result40 = String.valueOf(percentageDifference)
				String Per_result41 = (Per_result40 + '%')
				int decimalsToConsider = 2
				BigDecimal bigDecimal = new BigDecimal(percentageDifference)
				BigDecimal roundedWithScale = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP)
				String roundedWithScale1 = String.valueOf(roundedWithScale)
				String per_roundedWithScale1 = (roundedWithScale1 + '%')

				row.createCell(cellIndex).setCellValue(per_roundedWithScale1);
				cellIndex++;

				if (percentageDifference < threshold) {
					formatCell(row.createCell(cellIndex), true);
				} else {
					formatCell(row.createCell(cellIndex), false);
					resultdata_int = "FAIL"
				}
				cellIndex++;
			}
			rowIndex++;
		}
		if (resultdata_int == 1)
		{
			return resultdata_int
			new com.kf.Excel().writetoexcel_status('D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\06_AddictionCampusReports\\Dataknownfactors_Dashboard_GlobalSheet.xlsx', 0, 6, 0, resultdata_int)
			System.out.println(resultdata_int)
		}
		else
		{
			resultdata_int = "PASS"
			return resultdata_int
			new com.kf.Excel().writetoexcel_status('D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\06_AddictionCampusReports\\Dataknownfactors_Dashboard_GlobalSheet.xlsx', 0, 6, 0, resultdata_int)
			System.out.println(resultdata_int)
		}
	}
	/*************************** This keyword is used to handle the table - inpatient / outpatient (because of format change) ***************************/


	@Keyword
	def Testmovefilesfromonefoldertoanother(String SourceFolder1, String DestinationFolder1, String filename)
	{
		File sourceFolder = new File(SourceFolder1);
		File destinationFolder = new File(DestinationFolder1);

		if (!destinationFolder.exists())
		{
			destinationFolder.mkdirs();
		}

		// Check weather source exists and it is folder.
		if (sourceFolder.exists() && sourceFolder.isDirectory())
		{
			// Get list of the files and iterate over them
			File[] listOfFiles = sourceFolder.listFiles();

			if (listOfFiles != null)
			{
				for (File child : listOfFiles )
				{
					// Move files to destination folder
					String child1  = child.getName()
					//System.out.println(child1)
					String Newfilename = destinationFolder.getPath()+'\\TEST_'+ filename + '_' + child1
					//System.out.println(Newfilename)
					child.renameTo(new File(Newfilename));
					/* Use it only if you want to rename the file
					 String Outputfilename = destinationFolder.getPath()+'\\'+ 'ProdOutputExcelWorkbook.xlsx'
					 File oldfile = new File(Newfilename);
					 File newfile = new File(Outputfilename);
					 oldfile.renameTo(newfile)	
					 */	
					// Add if you want to delete the source folder
					//sourceFolder.delete();
					return child1

				}

			}
			else
			{
				System.out.println(sourceFolder + "  Folder does not exists");
			}

		}

	}

	@Keyword
	def Prodmovefilesfromonefoldertoanother(String SourceFolder1, String DestinationFolder1, String filename)
	{
		File sourceFolder = new File(SourceFolder1);
		File destinationFolder = new File(DestinationFolder1);

		if (!destinationFolder.exists())
		{
			destinationFolder.mkdirs();
		}

		// Check weather source exists and it is folder.
		if (sourceFolder.exists() && sourceFolder.isDirectory())
		{
			// Get list of the files and iterate over them
			File[] listOfFiles = sourceFolder.listFiles();

			if (listOfFiles != null)
			{
				for (File child : listOfFiles )
				{
					// Move files to destination folder
					String child1  = child.getName()
					//System.out.println(child1)
					String Newfilename = destinationFolder.getPath()+'\\PROD_'+ filename + '_' + child1
					//System.out.println(Newfilename)
					child.renameTo(new File(Newfilename));
					return child1

				}

			}
			else
			{
				System.out.println(sourceFolder + "  Folder does not exists");
			}

		}

	}

	@Keyword
	def Resultfiles (String SourceFolder1, String DestinationFolder1)
	{
		File sourceFolder = new File(SourceFolder1);
		File destinationFolder = new File(DestinationFolder1);
		if (!destinationFolder.exists())
		{
			destinationFolder.mkdirs();
		}

		// Check weather source exists and it is folder.
		if (sourceFolder.exists() && sourceFolder.isDirectory())
		{
			// Get list of the files and iterate over them
			File[] listOfFiles = sourceFolder.listFiles();
			if (listOfFiles != null)
			{
				for (File child : listOfFiles )
				{
					// Move files to destination folder
					String child1  = child.getName()
					//System.out.println(child1)
					return child1

					String Newfilename = destinationFolder.getPath()+ child1
					//System.out.println(Newfilename)
					child.renameTo(new File(Newfilename));
				}

			}
			else
			{
				System.out.println(sourceFolder + "  Folder does not exists");
			}

		}

	}

	@Keyword
	def Renamefile(String Oldfilename, String Newfilename) {

		File oldfile = new File(Oldfilename);
		File newfile = new File(Newfilename);

		if(oldfile.renameTo(newfile)) {
			//System.out.println("File name changed succesful");
		} else {
			//System.out.println("Rename failed");
		}
	}

	@Keyword
	def  getFileSize(File file) {
		String modifiedFileSize = null;
		double fileSize = 0.0;
		if (file.isFile()) {
			fileSize = (double) file.length();//in Bytes

			if (fileSize < 1024) {
				modifiedFileSize = String.valueOf(fileSize).concat("B");
			} else if (fileSize > 1024 && fileSize < (1024 * 1024)) {
				modifiedFileSize = String.valueOf(Math.round((fileSize / 1024 * 100.0)) / 100.0).concat("KB");
			} else {
				modifiedFileSize = String.valueOf(Math.round((fileSize / (1024 * 1204) * 100.0)) / 100.0).concat("MB");
			}
		} else {
			modifiedFileSize = "Unknown";
		}

		return modifiedFileSize;
	}

	@Keyword
	def mouseGlide(int x1, int y1, int x2, int y2, int t, int n) {
		Robot r = new Robot();
		double dx = (x2 - x1) / ((double) n);
		double dy = (y2 - y1) / ((double) n);
		double dt = t / ((double) n);
		for (int step = 1; step <= n; step++) {
			Thread.sleep((int) dt);
			r.mouseMove((int) (x1 + dx * step), (int) (y1 + dy * step));
		}

	}

	@Keyword
	def Createexcelworkbook (String OutputFile)
	{

		Workbook wb1 = new XSSFWorkbook();
		FileOutputStream fileOut1 = new FileOutputStream(OutputFile);
		wb1.write(fileOut1);
		fileOut1.close();
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
}

