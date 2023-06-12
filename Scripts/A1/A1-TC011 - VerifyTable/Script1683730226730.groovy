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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

'Open and navigate to url'
WebUI.openBrowser('')

WebUI.navigateToUrl('https://the-internet.herokuapp.com/')



'Step 1:'

'Select Sortable Data Tables link'
WebUI.click(findTestObject('Object Repository/A1/SortableDataTables/Sortable_Data_Tables_Panel'))

'Step 2:'

'Verify header at column 3 on Table 1'

'ER:'

'The header name is Email'
WebUI.verifyElementText(findTestObject('A1/SortableDataTables/Email_Label'), 'Email')

'Step 3:'

'Verify cell value (row 3, column 2) on Table 1'

'ER:'

'Cell value is Jason'
WebUI.verifyElementText(findTestObject('A1/SortableDataTables/Row3_Col2_Label'), 'Jason')

'Step 4:'
'Verify cell value (row 2, column 4) on Table 1'

'ER:'
'Cell value is $51.00'
WebUI.verifyElementText(findTestObject('A1/SortableDataTables/Row2_Col4_Label'), '$51.00')

WebUI.click(findTestObject('A1/SortableDataTables/Email_Label'))

'Step 5:'
'Click on Email header column on Table 2'
WebUI.click(findTestObject('A1/SortableDataTables/Table2_Email_Label'))

'ER:'
'The Email column sort by alphabetical from A-Z'
CustomKeywords.'a1.A1_TC011.verifyColumnSorted'(findTestObject('Object Repository/A1/SortableDataTables/Sort_Email_Label'))

WebUI.closeBrowser()

