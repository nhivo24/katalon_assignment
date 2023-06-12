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
import a2.helper

'Login to the system successfully'
a2.CommonUse.loginWithValidAccount(GlobalVariable.A2_USER_NAME, GlobalVariable.A2_PASSWORD)

'Navigate to Admin page'
WebUI.click(findTestObject('Object Repository/A2/MainMenu/Admin_Panel'))

'Step 1:'
'Select Ascending sort for Username column'
WebUI.click(findTestObject('Object Repository/A2/AdminPage/SortName_Label', [('columnName'): "Username"]))
WebUI.click(findTestObject('Object Repository/A2/AdminPage/Asscending_Label'))

'ER:'
'The username column is sorted by Asc'
helper.verifyIsSorted(WebUI.getAttribute(findTestObject('Object Repository/A2/AdminPage/SortName_Label', [('columnName'): 'Username']), 'class').contains("bi-sort-alpha-down"))

'Step 2:'
'Select Descending sort for Username column'
WebUI.click(findTestObject('Object Repository/A2/AdminPage/SortName_Label', [('columnName'): "Username"]))
WebUI.click(findTestObject('Object Repository/A2/AdminPage/Decending_Label'))

'ER:'
'The username column is sorted by Dec'
helper.verifyIsSorted(WebUI.getAttribute(findTestObject('Object Repository/A2/AdminPage/SortName_Label', [('columnName'): 'Username']), 'class').contains("bi-sort-alpha-up"))

'Step 3:'
'Select Ascending sort for Employee Name column'
WebUI.click(findTestObject('Object Repository/A2/AdminPage/SortName_Label', [('columnName'): "Employee Name"]))
WebUI.click(findTestObject('Object Repository/A2/AdminPage/Asscending_Label'))

'ER:'
'The Employee Name column is sorted by Asc and the sort of Username column is removed'
helper.verifyIsSorted(WebUI.getAttribute(findTestObject('Object Repository/A2/AdminPage/SortName_Label', [('columnName'): 'Employee Name']), 'class').contains("bi-sort-alpha-down"))
helper.verifyIsSorted(WebUI.getAttribute(findTestObject('Object Repository/A2/AdminPage/SortName_Label', [('columnName'): 'Username']), 'class').contains("bi-sort-alpha-up"))

// Step 4: Count the total records



