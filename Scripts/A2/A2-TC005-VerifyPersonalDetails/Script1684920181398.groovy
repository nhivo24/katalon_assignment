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
import java.time.LocalDate
import java.time.format.DateTimeFormatter

'Login to the system successfully'
a2.CommonUse.loginWithValidAccount(GlobalVariable.A2_USER_NAME, GlobalVariable.A2_PASSWORD)

'Navigate to Recruitment page'
WebUI.click(findTestObject('Object Repository/A2/MainMenu/Recuitment_Panel'))

'Step 1:'
'Select a candidate filter as:'
'+ Vacancy: Sales Representative'
WebUI.click(findTestObject('Object Repository/A2/RecruitmentPage/Vacancy_DropDown'))
WebUI.click(findTestObject('Object Repository/A2/RecruitmentPage/Select_Item', ['value': 'Sales Representative']))

'+ Hiring manager: Linda Anderson'
WebUI.click(findTestObject('Object Repository/A2/RecruitmentPage/HiringMana_DropDown'))
WebUI.click(findTestObject('Object Repository/A2/RecruitmentPage/Select_Item', ['value': 'Linda Anderson']))

'+ Status: Interview Failed'
WebUI.click(findTestObject('Object Repository/A2/RecruitmentPage/Status_DropDown'))
WebUI.click(findTestObject('Object Repository/A2/RecruitmentPage/Select_Item', ['value': 'Interview Failed']))

WebUI.click(findTestObject('Object Repository/A2/RecruitmentPage/Search_Button'))

'ER:'
'The filter values are displayed correctly'
WebUI.verifyElementText(findTestObject('Object Repository/A2/RecruitmentPage/Vacancy_DropDown'), 'Sales Representative')
WebUI.verifyElementText(findTestObject('Object Repository/A2/RecruitmentPage/HiringMana_DropDown'), 'Linda Anderson')
WebUI.verifyElementText(findTestObject('Object Repository/A2/RecruitmentPage/Status_DropDown'), 'Interview Failed')

'Step 2:'
'Click Reset button'
WebUI.click(findTestObject('Object Repository/A2/RecruitmentPage/Reset_Button'))

'ER:'
'The filter values are reset'
WebUI.verifyElementText(findTestObject('Object Repository/A2/RecruitmentPage/Vacancy_DropDown'), '-- Select --')
WebUI.verifyElementText(findTestObject('Object Repository/A2/RecruitmentPage/HiringMana_DropDown'), '-- Select --')
WebUI.verifyElementText(findTestObject('Object Repository/A2/RecruitmentPage/Status_DropDown'), '-- Select --')

'Step 3:'
'Select Date of Application From with a current day value'
String now = helper.getDateTime('yyyy-MM-dd')
WebUI.setText(findTestObject('Object Repository/A2/RecruitmentPage/FromDate_DateTimePicker'), now)

'ER:'
'The datetime value is today'
ToDate = WebUI.getAttribute(findTestObject('Object Repository/A2/RecruitmentPage/FromDate_DateTimePicker'), 'value')
WebUI.verifyMatch(ToDate, now, false)
WebUI.sendKeys(findTestObject('Object Repository/A2/RecruitmentPage/FromDate_DateTimePicker'), Keys.chord(Keys.CONTROL, 'a', Keys.DELETE))


'Step 4:'
'Select Date of Application To with a next day value'
LocalDate tomorrow = LocalDate.now().plusDays(1)
String nextDate = tomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
WebUI.setText(findTestObject('Object Repository/A2/RecruitmentPage/ToDate_SelectDay'), nextDate)

'ER:'
'The datetime value is tomorrow'
String actualDate = WebUI.getAttribute(findTestObject('Object Repository/A2/RecruitmentPage/ToDate_SelectDay'), 'value')
WebUI.verifyMatch(actualDate, nextDate, false)

'Step 5:'
'Select Date of Application To with a previous day value'
WebUI.sendKeys(findTestObject('Object Repository/A2/RecruitmentPage/ToDate_SelectDay'), Keys.chord(Keys.CONTROL, 'a', Keys.DELETE))
LocalDate previousDay = LocalDate.now().minusDays(1)
String previousDate = previousDay.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
WebUI.setText(findTestObject('Object Repository/A2/RecruitmentPage/ToDate_SelectDay'), previousDate)

WebUI.setText(findTestObject('Object Repository/A2/RecruitmentPage/FromDate_DateTimePicker'), now)
WebUI.click(findTestObject('Object Repository/A2/RecruitmentPage/Search_Button'))


'ER:'
'An error is displayed "To date should be after from date"'	
WebUI.verifyElementText(findTestObject('Object Repository/A2/RecruitmentPage/Error_Label'), 'From date should be before to date')

'Step 6:'
'Create a candidate and save the data'

String firstName = 'Nheo'
String lastName = 'Nheo'
String email = 'nheo@gmail.com'

WebUI.click(findTestObject('Object Repository/A2/RecruitmentPage/AddRecruitment_Button'))
WebUI.setText(findTestObject('Object Repository/A2/RecruitmentPage/FirstN_TextBox'), firstName)
WebUI.setText(findTestObject('Object Repository/A2/RecruitmentPage/LastName_TextBox'), lastName)
WebUI.click(findTestObject('Object Repository/A2/RecruitmentPage/Vacancy_Dropdown'))
WebUI.click(findTestObject('Object Repository/A2/RecruitmentPage/Select_Item', ['value': 'Sales Representative']))
WebUI.setText(findTestObject('Object Repository/A2/RecruitmentPage/Email_TextBox'), email)
WebUI.click(findTestObject('Object Repository/A2/RecruitmentPage/Submit_Button'))

'ER:'
'The new candidate is created successfully'
WebUI.verifyTextPresent('Successfully Saved', false)
WebUI.waitForElementPresent(findTestObject('Object Repository/A2/RecruitmentPage/Reject_Button'), GlobalVariable.LONG_WAIT_TIME)
WebUI.verifyElementPresent(findTestObject('Object Repository/A2/RecruitmentPage/Reject_Button'), GlobalVariable.LONG_WAIT_TIME)
WebUI.verifyElementPresent(findTestObject('Object Repository/A2/RecruitmentPage/Short_Button'),  GlobalVariable.LONG_WAIT_TIME)

'Step 7:'
'Click to ShortList button, not change anything and click Save button'
WebUI.click(findTestObject('Object Repository/A2/RecruitmentPage/Short_Button'))
WebUI.waitForElementPresent(findTestObject('Object Repository/A2/RecruitmentPage/AddCandidatePage/Submit_Button'), GlobalVariable.LONG_WAIT_TIME)

'ER:'
'A Pop up is displayed with: '
WebUI.verifyElementPresent(findTestObject('Object Repository/A2/RecruitmentPage/Reject_Button'),  GlobalVariable.LONG_WAIT_TIME)
WebUI.verifyElementPresent(findTestObject('Object Repository/A2/RecruitmentPage/ScheduInter_Button'),  GlobalVariable.LONG_WAIT_TIME)

