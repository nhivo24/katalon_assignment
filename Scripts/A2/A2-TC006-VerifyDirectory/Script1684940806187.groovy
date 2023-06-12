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

'Login to the system successfully'
a2.CommonUse.loginWithValidAccount(GlobalVariable.A2_USER_NAME, GlobalVariable.A2_PASSWORD)

'Navigate to Directory page'
WebUI.click(findTestObject('Object Repository/A2/DirectoryPage/Directory_Panel'))

'Step 1:'
'Search by Employee Name: Peter Mac Anderson (or any existing employee name)'

WebUI.sendKeys(findTestObject('Object Repository/A2/DirectoryPage/Employee_Name_Textbox'), "Peter")
WebUI.click(findTestObject('Object Repository/A2/DirectoryPage/Search_Bar',['value':'Peter Mac Anderson']))

'ER:'
'The employee name is displayed'
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/A2/DirectoryPage/Employee_Name_Textbox'), 'value'), "Peter Mac Anderson", false)


'Step 2'
'Remove the employee name and Search by Job Title'
WebUI.sendKeys(findTestObject('Object Repository/A2/DirectoryPage/Employee_Search_Textbox'), Keys.chord(Keys.CONTROL, "a", Keys.DELETE))
WebUI.click(findTestObject('Object Repository/A2/DirectoryPage/Title_DropDown'))
WebUI.click(findTestObject('Object Repository/A2/DirectoryPage/Search_Bar', ['value': 'Account Assistant']))
WebUI.verifyElementText(findTestObject('Object Repository/A2/DirectoryPage/Title_DropDown'), 'Account Assistant')

'Step 3'
'Remove the job title and search by Location: New York Sales Office (or any location has more 1 person)'
WebUI.sendKeys(findTestObject('Object Repository/A2/DirectoryPage/Title_DropDown'),Keys.chord(Keys.UP))
WebUI.click(findTestObject('Object Repository/A2/DirectoryPage/Location_Dropdown'))
WebUI.click(findTestObject('Object Repository/A2/DirectoryPage/Search_Bar', ['value': 'Canadian Regional HQ']))


'step 4:'
'Search by Job title and Location'
WebUI.sendKeys(findTestObject('Object Repository/A2/DirectoryPage/Title_DropDown'),Keys.chord(Keys.UP))
WebUI.click(findTestObject('Object Repository/A2/DirectoryPage/Title_DropDown'))
WebUI.click(findTestObject('Object Repository/A2/DirectoryPage/Search_Bar', ['value': 'Account Assistant']))
WebUI.click(findTestObject('Object Repository/A2/DirectoryPage/Location_Dropdown'))
WebUI.click(findTestObject('Object Repository/A2/DirectoryPage/Search_Bar', ['value': 'Canadian Regional HQ']))
WebUI.click(findTestObject('Object Repository/A2/DirectoryPage/Search_Button'))

'ER:'
'The employees display with a correct location and job title'
WebUI.verifyElementText(findTestObject('Object Repository/A2/DirectoryPage/Title_DropDown'), 'Account Assistant')
WebUI.verifyElementText(findTestObject('Object Repository/A2/DirectoryPage/Location_Dropdown'), 'Canadian Regional HQ')




