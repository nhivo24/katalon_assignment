package a1;

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.sql.Driver
import java.util.concurrent.ConcurrentHashMap.KeySetView

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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import ch.qos.logback.core.joran.conditional.ElseAction

import org.openqa.selenium.interactions.Actions
import internal.GlobalVariable
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.Keys

public class A1_TC009 {

	@Keyword
	def static void setSlider(TestObject sliderObject, float valueDesired, float valueCurrent) {
		WebElement slider = WebUI.findWebElement(sliderObject, 10)

		float min = slider.getAttribute("min") as Float
		float max = slider.getAttribute("max") as Float
		float step = slider.getAttribute("step") as Float

		int steps = Math.abs(((valueDesired - valueCurrent) / step) as int)

		for (int i = 0; i < steps; i++) {
			if (valueDesired > valueCurrent) {
				slider.sendKeys(Keys.ARROW_RIGHT)
			} else {
				slider.sendKeys(Keys.ARROW_LEFT)
			}
		}
	}

	@Keyword
	def static float getFloatValue(TestObject testObject) {
		def value = WebUI.getText(testObject)
		return Float.parseFloat(value)
	}
}
