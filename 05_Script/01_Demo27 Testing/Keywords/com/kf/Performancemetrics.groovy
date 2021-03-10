package com.kf

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
import com.katalon.cdp.CdpUtils

import internal.GlobalVariable

public class Performancemetrics {


	def cdts = CdpUtils.getService()
/*
	def network = cdts.getNetwork()
	network.enable()

	def performance = cdts.getPerformance()
	performance.enable()

	network.onLoadingFinished({
		event ->
		def metrics = performance.getMetrics()

		try {
			metrics.each {
				metric ->
				println("${metric.getName()}: ${metric.getValue()}")
			}
			cdts.close()
			cdts.getPage().close();

			WebUI.closeBrowser()
		} catch (Exception e) {
			e.printStackTrace()
		}
	})
	*/
}
