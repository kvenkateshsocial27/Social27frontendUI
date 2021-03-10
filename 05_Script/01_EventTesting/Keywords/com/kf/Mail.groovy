package com.kf

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.util.Date as Date
import java.util.Calendar as Calendar
import java.util.TimeZone as TimeZone
import java.text.DateFormat as DateFormat
import java.awt.event.InputEvent;
import java.text.CalendarBuilder as CalendarBuilder
import java.text.DateFormatSymbols as DateFormatSymbols
import java.text.SimpleDateFormat as SimpleDateFormat

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.annotation.Keyword

public class Mail {

	KeywordUtil keyword = new KeywordUtil()

	@Keyword
	def Maildate() {
		DateFormat dateFormat = new SimpleDateFormat('MMddYYYY')
		Date date = new Date()
		String date1 = dateFormat.format(date)
		return date1
	}

	@Keyword
	def FailMailReport() {
		DateFormat dateFormat = new SimpleDateFormat('MMddYYYY')
		Date date = new Date()
		String date1 = dateFormat.format(date)


		// Create object of Property file
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("dataknownfactorss@gmail.com", "data@123");
					}
				});

		try {
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dataknownfactorss@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("kvthganesan@gmail.com"));
			//message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("kvthganesan005@gmail.com"));
			message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse("kvthganesan@gmail.com"));
			message.setSubject("Katalon Automation - QA Dashboard Reports - EXECUTION ERROR - " + date1);
			String newline = System.getProperty("line.separator");
			String MessageSubject = "Hi Team," + newline + newline + newline + "QA Dashboard Report - Script did not run successfully." + newline  + "Please check the console and rerun the scripts if necessary or contact the automation team for support." + newline + newline  + newline  + "Regards," + newline + "Automation Team"
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText(MessageSubject);
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
			// set the content
			message.setContent(multipart)
			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}

	@Keyword
	def FailMailReport_Exportexcel() {

		DateFormat dateFormat = new SimpleDateFormat('dd/MM/YYYY')
		Date date = new Date()
		String date1 = dateFormat.format(date)

		// Create object of Property file
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("dataknownfactorss@gmail.com", "data@123");
					}
				});

		try {
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dataknownfactorss@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("kvenkatesh@social27.com"));
			//message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("kvthganesan005@gmail.com"));
			message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse("kvthganesan@gmail.com"));
			message.setSubject("***Menu Access Verification : " + date1 +"***");
			String newline = System.getProperty("line.separator");


			String MessageSubject = "Hi Team," + newline + newline + newline + "Failed to download Excel : An error occured when automation script tried to download the Excel File from the website." + newline  + "Please recheck the case manually. If you have any queries contact the automation team for support." + newline + newline  + newline  + "Regards," + newline + "Automation Team"
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText(MessageSubject);
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
			// set the content
			message.setContent(multipart)
			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}

	@Keyword
	def FailMailReport_DataRefresh(String Title, String LastRefreshedDate, int hours, String Login, String CubeName, String TestSuite, String locfile)
	{

		DateFormat dateFormat = new SimpleDateFormat('MMddYYYY')
		Date date = new Date()
		String date1 = dateFormat.format(date)

		// Create object of Property file
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("dataknownfactorss@gmail.com", "data@123");
					}
				});

		try {
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dataknownfactorss@gmail.com"));
			//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("kvthganesan@gmail.com"));
			//message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("kvthganesan005@gmail.com"));
			message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse("kvthganesan@gmail.com"));
			message.setSubject("***CUBE REFRESH ERROR***: Login <" + Login + "> Failed ; Cube " + CubeName + " last refreshed " + LastRefreshedDate + " which is more than the " + hours + " hours allowed.");
			String newline = System.getProperty("line.separator");
			//String MessageSubject = "Hi Team," + newline + newline + newline + "Data Refresh - Error - Data was last refreshed 24 hours ago for the Dashboard Title : " + Title   + newline + "Last Refreshed Date : " + LastRefreshedDate +  newline + "Please recheck the case. If you have any queries contact the automation team for support." + newline + newline  + newline  + "Regards," + newline + "Automation Team"
			String MessageSubject = "Hi Team," + newline + newline + "***CUBE REFRESH ERROR***: Cube " + CubeName + " last refreshed " + LastRefreshedDate + " which is more than the " + hours + " hours allowed." + newline +  newline + "Dashboard: " + Title + newline + "Login: " + Login  + newline + newline + "Test Script: " + TestSuite +  newline + newline + "Location File: " + locfile +  newline + newline + "If you have any queries contact the automation team for support." + newline + newline  + newline  + "Regards," + newline + "Automation Team"
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText(MessageSubject);
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
			// set the content
			message.setContent(multipart)
			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}

	@Keyword
	def ErrorMailReport_URL(String URL, String Login, String Dashboard, String errmessage)
	{
		DateFormat dateFormat = new SimpleDateFormat('MMddYYYY')
		Date date = new Date()
		String date1 = dateFormat.format(date)

		// Create object of Property file
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("dataknownfactorss@gmail.com", "data@123");
					}
				});

		try {
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dataknownfactorss@gmail.com"));
			//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("kvthganesan@gmail.com"));
			//message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("kvthganesan005@gmail.com"));
			message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse("kvthganesan@gmail.com"));
			message.setSubject("***DASHBOARD - ERROR*** - QA Reports");
			String newline = System.getProperty("line.separator");
			//String MessageSubject = "Hi Team," + newline + newline + newline + "Data Refresh - Error - Data was last refreshed 24 hours ago for the Dashboard Title : " + Title   + newline + "Last Refreshed Date : " + LastRefreshedDate +  newline + "Please recheck the case. If you have any queries contact the automation team for support." + newline + newline  + newline  + "Regards," + newline + "Automation Team"
			String MessageSubject = "Hi Team," + newline + newline + "***DASHBOARD - ERROR***" + newline  + newline + "URL : " +  URL + newline + "Login : " +  Login  + newline + "Dashboard : " + Dashboard + newline + "Error Message: " + errmessage + newline + newline + "If you have any queries contact the automation team for support." + newline + newline  + newline  + "Regards," + newline + "Automation Team"
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText(MessageSubject);
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
			// set the content
			message.setContent(multipart)
			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}

	@Keyword
	def ErrorMailReport_URL_Refresh(String URL, String Login, String Dashboard, String errmessage, String TestSuite, String locfile, String Attachment)
	{
		DateFormat dateFormat = new SimpleDateFormat('MMddYYYY')
		Date date = new Date()
		String date1 = dateFormat.format(date)

		// Create object of Property file
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,

				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("dataknownfactorss@gmail.com", "data@123");
					}
				});

		try {
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dataknownfactorss@gmail.com"));
			//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("kvthganesan@gmail.com"));
			//message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("kvthganesan005@gmail.com"));
			message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse("kvthganesan@gmail.com"));
			message.setSubject("***DASHBOARD - ERROR*** - Datarefresh- Login <" + Login + "> Failed ");
			String newline = System.getProperty("line.separator");
			//String MessageSubject = "Hi Team," + newline + newline + newline + "Data Refresh - Error - Data was last refreshed 24 hours ago for the Dashboard Title : " + Title   + newline + "Last Refreshed Date : " + LastRefreshedDate +  newline + "Please recheck the case. If you have any queries contact the automation team for support." + newline + newline  + newline  + "Regards," + newline + "Automation Team"
			String MessageSubject = "Hi Team," + newline + newline + "***DASHBOARD - ERROR***" + newline  + newline + "URL : " +  URL + newline + "Login : " +  Login  + newline + "Dashboard : " + Dashboard + newline + "Error Message: " + errmessage + newline + newline +  "Test Script: " + TestSuite + newline + newline + "Location File: " + locfile +  newline + newline + "If you have any queries contact the automation team for support." + newline + newline  + newline  + "Regards," + newline + "Automation Team"
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText(MessageSubject);
			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			String filename = Attachment
			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);
			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
			// set the file
			messageBodyPart2.setFileName(filename);
			System.out.println("=====Email Sent=====");

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
			//if (Errmessage == "")
			//{
			// add body part 1
			multipart.addBodyPart(messageBodyPart2);
			//}
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
			// set the content
			message.setContent(multipart)
			// finally send the email
			Transport.send(message);
			System.out.println("=====Email Sent=====");

			// finally send the email

			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}


	@Keyword
	def SuccessMailReport_DataRefresh(String Title, String LastRefreshedDate, int hours, String Login, String CubeName, String TestSuite, String locfile)
	{
		DateFormat dateFormat = new SimpleDateFormat('MMddYYYY')
		Date date = new Date()
		String date1 = dateFormat.format(date)

		// Create object of Property file
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("dataknownfactorss@gmail.com", "data@123");
					}
				});

		try {
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dataknownfactorss@gmail.com"));
			//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("kvthganesan@gmail.com"));
			//message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("kvthganesan005@gmail.com"));
			message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse("kvthganesan@gmail.com"));
			message.setSubject("CUBE REFRESH SUCCESS : Cube " + CubeName + " last refreshed " + LastRefreshedDate + "");
			String newline = System.getProperty("line.separator");
			//String MessageSubject = "Hi Team," + newline + newline + newline + "Data Refresh - Error - Data was last refreshed 24 hours ago for the Dashboard Title : " + Title   + newline + "Last Refreshed Date : " + LastRefreshedDate +  newline + "Please recheck the case. If you have any queries contact the automation team for support." + newline + newline  + newline  + "Regards," + newline + "Automation Team"
			String MessageSubject = "Hi Team," + newline + newline + "Cube " + CubeName + " last refreshed " + LastRefreshedDate + " which is within the allowed window of  " + hours + " hours allowed." + newline +  newline + "Dashboard: " + Title + newline + "Login: " + Login  + newline + newline  + "Test Script: " + TestSuite +  newline + newline + "Location File: " + locfile +  newline + newline + "If you have any queries contact the automation team for support." + newline + newline  + newline  + "Regards," + newline + "Automation Team"
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText(MessageSubject);
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
			// set the content
			message.setContent(multipart)
			// finally send the email
			Transport.send(message);
			System.out.println("=====Email Sent=====");


		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	@Keyword
	def SuccessMailReport(String ImportFilename, String Prod_refresh, String Test_refresh, String Result, String Reporttype, String Errmessage)
	{
		String Subject
		String Sourcefile
		String MsgSubject
		System.out.println(Errmessage);

		DateFormat dateFormat = new SimpleDateFormat('MM/dd/YYYY')
		Date date = new Date()
		String date1 = dateFormat.format(date)

		if (Reporttype == "FBReports")
		{
			if (Errmessage == "")
			{
				if (Result == "Pass")
				{
					Subject ="QA passed for Run: FB Report :  " +date1;
					Sourcefile = "";
				}
				else if (Result == "Fail")
				{
					Subject =	"**QA FAILED for Run: FB Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\02_FBReports\\01_DataKF_FBReports_TestData_MasterSheet.xlsx"
				}
			}
			else
			{

				if (Result == "NA")
				{
					Subject =	"**QA WARNING for Run: FB Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\02_FBReports\\01_DataKF_FBReports_TestData_MasterSheet.xlsx"
				}
				else if (Result == "Fail")
				{
					Subject =	"**QA FAILED for Run: FB Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\02_FBReports\\01_DataKF_FBReports_TestData_MasterSheet.xlsx"
				}


			}

			MsgSubject = "Dashboard : QA - FB Report."	;

		}

		if (Reporttype == "SelvaagReports")
		{
			if (Errmessage == "")
			{
				if (Result == "Pass")
				{
					Subject =	"QA passed for Run: Selvaag Report :  " +date1;
					Sourcefile = "";
				}
				else if (Result == "Fail")
				{
					Subject =	"**QA FAILED for Run: Selvaag Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\07_SelvaagReports\\01_DataKF_SelvaagReports_TestData_MasterSheet.xlsx"
				}
				else
				{
					Subject =	"QA passed for Run: Selvaag Report :  " +date1;
					Sourcefile = "";
				}
			}
			else
			{
				if (Result == "NA")
				{
					Subject =	"**QA WARNING for Run: Selvaag Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\07_SelvaagReports\\01_DataKF_SelvaagReports_TestData_MasterSheet.xlsx"
				}
				else if (Result == "Fail")
				{
					Subject =	"**QA FAILED for Run: Selvaag Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\07_SelvaagReports\\01_DataKF_SelvaagReports_TestData_MasterSheet.xlsx"
				}

			}

			MsgSubject = "Dashboard : QA - Selvaag Report."	;

		}

		if (Reporttype == "QAReports")
		{
			if (Errmessage == "")
			{
				if (Result == "Pass")
				{
					Subject =	"QA passed for Run: Camillo Report :  " +date1;
					Sourcefile = "";
				}
				else if (Result == "Fail")
				{
					Subject =	"**QA FAILED for Run: Camillo Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\01_QAReports\\DataKF_QAReports_TestData_MasterSheet.xlsx"
				}
			}
			else
			{

				if (Result == "NA")
				{
					Subject =	"**QA WARNING for Run: Camillo Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\01_QAReports\\DataKF_QAReports_TestData_MasterSheet.xlsx"
				}
				else if (Result == "Fail")
				{
					Subject =	"**QA FAILED for Run: Camillo Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\01_QAReports\\DataKF_QAReports_TestData_MasterSheet.xlsx"
				}


			}

			MsgSubject = "Dashboard : QA - Camillo Report."	;

		}

		if (Reporttype == "InnerChangeLegacyReports")
		{
			if (Errmessage == "")
			{
				if (Result == "Pass")
				{
					Subject =	"QA passed for Run: InnerChange Legacy Report :  " +date1;
					Sourcefile = "";
				}
				else if (Result == "Fail")
				{
					Subject =	"**QA FAILED for Run: InnerChange Legacy Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\03_InnerChangeLegacyReports\\01_DataKF_InnerChangeReports_TestData_MasterSheet.xlsx"

				}
				else
				{
					Subject =	"QA passed for Run: InnerChange Legacy Report :  " +date1;
					Sourcefile = "";
				}
			}
			else
			{
				if (Result == "NA")
				{
					Subject =	"**QA WARNING for Run: InnerChange Legacy Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\03_InnerChangeLegacyReports\\01_DataKF_InnerChangeReports_TestData_MasterSheet.xlsx"
				}
				else if (Result == "Fail")
				{
					Subject =	"**QA FAILED for Run: InnerChange Legacy Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\03_InnerChangeLegacyReports\\01_DataKF_InnerChangeReports_TestData_MasterSheet.xlsx"
				}



			}

			MsgSubject = "Dashboard : QA - InnerChange Legacy Report."	;
		}

		if (Reporttype == "InnerChangeincidentReports")
		{
			if (Errmessage == "")
			{
				if (Result == "Pass")
				{
					Subject =	"QA passed for Run: InnerChange Incidents Report :  " +date1;
					Sourcefile = "";
				}
				else if (Result == "Fail")
				{
					Subject =	"**QA FAILED for Run: InnerChange Incidents Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\04_InnerChangeIncidentReports\\01_DataKF_InnerChangeIncidentReports_TestData_MasterSheet.xlsx"
				}
			}
			else
			{

				if (Result == "NA")
				{
					Subject =	"**QA WARNING for Run: InnerChange Incidents Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\04_InnerChangeIncidentReports\\01_DataKF_InnerChangeIncidentReports_TestData_MasterSheet.xlsx"
				}
				else if (Result == "Fail")
				{
					Subject =	"**QA FAILED for Run: InnerChange Incidents Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\04_InnerChangeIncidentReports\\01_DataKF_InnerChangeIncidentReports_TestData_MasterSheet.xlsx"
				}
			}

			MsgSubject = "Dashboard : QA - InnerChange Incidents Report."	;

		}

		if ( Reporttype == "InnerChangeBHReports")
		{
			if (Errmessage == "")
			{
				if (Result == "Pass")
				{
					Subject =	"QA passed for Run: InnerChange BH Report :  " +date1;
					Sourcefile = "";
				}
				else if (Result == "Fail")
				{
					Subject =	"**QA FAILED for Run: InnerChange BH Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\05_InnerChangeBHReports\\01_DataKF_InnerChangeBHReports_TestData_MasterSheet.xlsx"

				}
			}
			else
			{
				if (Result == "NA")
				{
					Subject =	"**QA WARNING for Run: InnerChange BH Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\05_InnerChangeBHReports\\01_DataKF_InnerChangeBHReports_TestData_MasterSheet.xlsx"
				}
				else if (Result == "Fail")
				{
					Subject =	"**QA FAILED for Run: InnerChange BH Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\05_InnerChangeBHReports\\01_DataKF_InnerChangeBHReports_TestData_MasterSheet.xlsx"
				}

			}

			MsgSubject = "Dashboard : QA - InnerChange BH Campus Report."	;

		}


		if ( Reporttype == "AddictionCampusReports")
		{
			if (Errmessage == "")
			{
				if (Result == "Pass")
				{
					Subject =	"QA passed for Run: Addiction Campus Report :  " +date1;
					Sourcefile = "";
				}
				else if (Result == "Fail")
				{
					Subject =	"**QA FAILED for Run: Addiction Campus Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\06_AddictionCampusReports\\01_DataKF_InnerChangeACReports_TestData_MasterSheet.xlsx"

				}
			}
			else
			{

				if (Result == "NA")
				{
					Subject =	"**QA WARNING for Run: Addiction Campus Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\06_AddictionCampusReports\\01_DataKF_InnerChangeACReports_TestData_MasterSheet.xlsx"
				}
				else if (Result == "Fail")
				{
					Subject =	"**QA FAILED for Run: Addiction Campus Report : "+date1 +"**";
					Sourcefile = "Source File Location : D:\\KF_Automation\\01_Testdata\\Global_Master_Data\\01_DashboardReports\\06_AddictionCampusReports\\01_DataKF_InnerChangeACReports_TestData_MasterSheet.xlsx"
				}


			}

			MsgSubject = "Dashboard : QA - Addiction Campus Report."	;

		}

		// Create object of Property file
		Properties props = new Properties();
		//props.put("mail.smtp.host", "gmail.com");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("dataknownfactorss@gmail.com", "data@123");
					}
				});

		try {
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dataknownfactorss@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("qa@intrava.io"));
			//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("kvthganesan@gmail.com"));
			//message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("kvthganesan005@gmail.com"));
			message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse("kvthganesan@gmail.com"));

			System.out.println("Error message: " + Errmessage)
			message.setSubject(Subject);
			String newline = System.getProperty("line.separator");
			String MessageSubject;
			MessageSubject = "Hi Team," + newline + newline + MsgSubject + newline + newline  +  " Production Environment - Cube Refresh Date/Time : " + Prod_refresh  + newline  + newline + " Test Environment -  Cube Refresh Date/Time : "  + Test_refresh   +  newline  + newline + " Result: " + Result  + newline + newline + Sourcefile  + newline +  newline + Errmessage + newline + " Please find the attached file for your reference." + newline + newline + newline  + "Regards," + newline + "Automation Team"
			//MessageSubject = "Hi Team," + newline + newline + MsgSubject + newline + newline  +  " Production Environment - Cube Refresh Date/Time : " + Prod_refresh  + newline  + newline + " Test Environment -  Cube Refresh Date/Time : "  + Test_refresh   +  newline  + newline + Errmessage + newline + newline   + "Regards," + newline + "Automation Team"
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText(MessageSubject);
			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			String filename = ImportFilename
			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);
			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
			// set the file
			messageBodyPart2.setFileName(filename);
			System.out.println("=====Email Sent=====");

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
			//if (Errmessage == "")
			//{
			// add body part 1
			multipart.addBodyPart(messageBodyPart2);
			//}
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
			// set the content
			message.setContent(multipart)
			// finally send the email
			Transport.send(message);
			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);
		}

	}
	
	@Keyword
	def sendmail(String ImportFilename)
	{
		String Subject
		String Sourcefile
		String MsgSubject

		DateFormat dateFormat = new SimpleDateFormat('MM/dd/YYYY')
		Date date = new Date()
		String date1 = dateFormat.format(date)
		
		// Create object of Property file
		Properties props = new Properties();
		//props.put("mail.smtp.host", "gmail.com");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		Subject =	"**Access verification for upcoming & live events : "+date1 +"**";
		
		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("dataknownfactorss@gmail.com", "data@123");
					}
				});

		try {
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dataknownfactorss@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("kvenkatesh@social27.com"));
			message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse("kvthganesan@gmail.com"));
			message.setSubject(Subject);
			String newline = System.getProperty("line.separator");
			String MessageSubject;
			MessageSubject = "Hi Team," + newline + newline + MsgSubject + newline + newline  + " Please find the attached file for your reference." + newline + newline + newline  + "Regards," + newline + "Automation Team"
			//MessageSubject = "Hi Team," + newline + newline + MsgSubject + newline + newline  +  " Production Environment - Cube Refresh Date/Time : " + Prod_refresh  + newline  + newline + " Test Environment -  Cube Refresh Date/Time : "  + Test_refresh   +  newline  + newline + Errmessage + newline + newline   + "Regards," + newline + "Automation Team"
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText(MessageSubject);
			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			String filename = ImportFilename
			// Create data source and pass the filename
			DataSource source = new FileDataSource(ImportFilename);
			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
			// set the file
			messageBodyPart2.setFileName(filename);
			System.out.println("=====Email Sent=====");

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
			//if (Errmessage == "")
			//{
			// add body part 1
			multipart.addBodyPart(messageBodyPart2);
			//}
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
			// set the content
			message.setContent(multipart)
			// finally send the email
			Transport.send(message);
			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);
		}

	}

	/*
	 @Keyword
	 def SuccessMailReport(String ImportFilename, String Prod_refresh, String Test_refresh, String Result)
	 {
	 DateFormat dateFormat = new SimpleDateFormat('MMddYYYY')
	 Date date = new Date()
	 String date1 = dateFormat.format(date)
	 // Create object of Property file
	 Properties props = new Properties();
	 props.put("mail.smtp.host", "smtp.gmail.com");
	 props.put("mail.smtp.socketFactory.port", "465");
	 props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	 props.put("mail.smtp.auth", "true");
	 props.put("mail.smtp.port", "465");
	 // This will handle the complete authentication
	 Session session = Session.getDefaultInstance(props,
	 new javax.mail.Authenticator() {
	 protected PasswordAuthentication getPasswordAuthentication() {
	 return new PasswordAuthentication("dataknownfactorss@gmail.com", "data@123");
	 }
	 });
	 try {
	 // Create object of MimeMessage class
	 Message message = new MimeMessage(session);
	 message.setFrom(new InternetAddress("dataknownfactorss@gmail.com"));
	 //  message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("kvthganesan@gmail.com"));
	 message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("kvthganesan005@gmail.com"));
	 message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse("kvthganesan@gmail.com"));
	 message.setSubject("***Dashboard: QA - Test Report*** : " + date1);
	 String newline = System.getProperty("line.separator");
	 String MessageSubject = "Hi Team," + newline + newline + "Dashboard : QA - Test Report, Script ran successfully." + newline + newline  +  "Production Environment - Cube Refresh Date/Time : " + Prod_refresh  + newline +  "Test Environment -  Cube Refresh Date/Time : "  + Test_refresh   +  newline  + "Result (Widget's): " + Result  + newline + newline + " Please find attached 'QA Dashboard Report' file for your reference." + newline + newline + newline  + "Regards," + newline + "Automation Team"
	 // Create object to add multimedia type content
	 BodyPart messageBodyPart1 = new MimeBodyPart();
	 messageBodyPart1.setText(MessageSubject);
	 // Create another object to add another content
	 MimeBodyPart messageBodyPart2 = new MimeBodyPart();
	 String filename = ImportFilename
	 // Create data source and pass the filename
	 DataSource source = new FileDataSource(filename);
	 // set the handler
	 messageBodyPart2.setDataHandler(new DataHandler(source));
	 // set the file
	 messageBodyPart2.setFileName(filename);
	 // Create object of MimeMultipart class
	 Multipart multipart = new MimeMultipart();
	 // add body part 1
	 multipart.addBodyPart(messageBodyPart2);
	 // add body part 2
	 multipart.addBodyPart(messageBodyPart1);
	 // set the content
	 message.setContent(multipart)
	 // finally send the email
	 Transport.send(message);
	 System.out.println("=====Email Sent=====");
	 } catch (MessagingException e) {
	 throw new RuntimeException(e);
	 }
	 }
	 */
}