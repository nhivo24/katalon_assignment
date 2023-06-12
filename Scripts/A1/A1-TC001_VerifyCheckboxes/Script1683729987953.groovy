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
'Click Checkboxes and Checkboxes header title is displayed'
WebUI.click(findTestObject('Object Repository/A1/CheckboxesPage/Checkboxes_Panel'))

'ER:'

'Checkboxes header title display correctly'
WebUI.verifyElementText(findTestObject('A1/CheckboxesPage/Checkboxs_Label'), 'Checkboxes')

'Step 2:'

'Click Checkboxes 1'
WebUI.click(findTestObject('Object Repository/A1/CheckboxesPage/RadioButton_checkbox'))

'ER:'

'Checkbox1 is checked'
WebUI.verifyElementChecked(findTestObject('Object Repository/A1/CheckboxesPage/Checked_Button'),GlobalVariable.MEDIUM_WAIT_TIME)

'Step 3:'

'Un-checked Checkboxes 2'
WebUI.click(findTestObject('A1/CheckboxesPage/Uncheck_Button'))

'ER:'

'Checkbox 2 is un-checked'
WebUI.verifyElementNotChecked(findTestObject('A1/CheckboxesPage/Unchecked_Button'),GlobalVariable.MEDIUM_WAIT_TIME)

'Step 4:'

'Close browser'
WebUI.closeBrowser()

'ER'

'Brower is closed'

