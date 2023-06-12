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

'Step 1: '
'Select JQuery UI Menus link'
WebUI.click(findTestObject('Object Repository/A1/UIMenus/JQuery_Menus_Panel'))


'Step 2:'
'Select Enabled -> JQuery UI menu'
WebUI.click(findTestObject('Object Repository/A1/UIMenus/Enabled_Label'))
WebUI.click(findTestObject('Object Repository/A1/UIMenus/Back_JQuery_UI_Panel'))

'ER:'
'JQuery UI header title is displayed'
WebUI.verifyElementText(findTestObject('A1/UIMenus/JQuery_Header_Label'), 'JQuery UI')

'Step 3:'
'Click on Menu link'

WebUI.click(findTestObject('Object Repository/A1/UIMenus/Menu_Panel'))

'ER:'
'JQueryUI - Menu header title is displayed'
WebUI.verifyElementText(findTestObject('A1/UIMenus/JQuery_UI_Header_Label'), 'JQueryUI - Menu')

'Step 3:'
'Select Enabled -> Downloads -> CSV menu'

WebUI.click(findTestObject('Object Repository/A1/UIMenus/Enabled_Label'))

WebUI.click(findTestObject('Object Repository/A1/UIMenus/Downloads_Panel'))

WebUI.click(findTestObject('Object Repository/A1/UIMenus/CSV_Panel'))

'ER:'
'The menu.csv file is saved to local'
String userDownloads = System.getProperty("user.home") + "/Downloads/"
CustomKeywords.'a1.A1_TC010.FileDownloaded'(userDownloads, 'menu.csv')

WebUI.closeBrowser()

