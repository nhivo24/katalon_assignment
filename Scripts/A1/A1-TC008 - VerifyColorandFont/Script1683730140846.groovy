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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Open and navigate to url'
WebUI.openBrowser('')

WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

'Step 1:'

'Select DOM header  and DOM header header title is displayed'
WebUI.click(findTestObject('Object Repository/A1/ColorandFont/Challenging_DOM_Panel'))

'ER:'
'DOM header header title is displayed correctly'
WebUI.verifyElementText(findTestObject('A1/ColorandFont/ChallengingDOM_Label'), 'Challenging DOM')

'Step2'
'Verify font size of button 1'
String actualFontSize = WebUI.getCSSValue(findTestObject('A1/ColorandFont/Bar_Button'), 'font-size')

'ER:'
'Font size is 16px'
WebUI.verifyEqual(actualFontSize, '16px')

'Step3'
'Verify background-color of button 2'
String actualColor = WebUI.getCSSValue(findTestObject('A1/ColorandFont/Baz_Button'), 'background-color')

'ER:'
'Background-color is #c60f13 (hex) color'

WebUI.verifyMatch(actualColor, 'rgba(198, 15, 19, 1)', false)

'Step4'
'Verify border-color of button 3'

String actualBorderColor = WebUI.getCSSValue(findTestObject('A1/ColorandFont/Foo_Button'), 'border-color')


'ER:'
'Border-color is #457a1a (hex) color'
WebUI.verifyMatch(actualBorderColor, 'rgb(69, 122, 26)', false)

WebUI.closeBrowser()

