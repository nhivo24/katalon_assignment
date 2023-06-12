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
'Click DropDown and Dropdown List header title is displayed'
WebUI.click(findTestObject('A1/DropdownPage/Dropdown_Panel'))

'ER:'
'Dropdown List is displayed is correctly'
WebUI.verifyElementText(findTestObject('A1/DropdownPage/DropDown_Label'), 'Dropdown List')

'Step 2:'
'Select item by label Option 2'
WebUI.selectOptionByValue(findTestObject('Object Repository/A1/DropdownPage/Menu_DropDownList'), '2', true)

'ER:'
'The current item is Option 2'
WebUI.verifyElementText(findTestObject('A1/DropdownPage/option2_Label'), 'Option 2')


'Step 3:'
'Select item by index 1'

WebUI.selectOptionByIndex(findTestObject('A1/DropdownPage/Menu_DropDownList'), 1)

'ER:'
'The current item is Option 1'

WebUI.verifyElementText(findTestObject('A1/DropdownPage/option1_Label'), 'Option 1')

'Step 4:'
'Select item by value 2'

WebUI.selectOptionByValue(findTestObject('A1/DropdownPage/Menu_DropDownList'), '2', true)

'ER:'
'The current item is Option 2'

WebUI.verifyElementText(findTestObject('A1/DropdownPage/option2_Label'), 'Option 2')


'Step 5:'
'Close browser'

WebUI.closeBrowser()

'ER'
'Brower is closed'


