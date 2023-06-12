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
import a2.LoginHelper as LoginHelper
import org.openqa.selenium.Keys as Keys



'Step 1:'
'Login to the system successfully'
a2.CommonUse.loginWithValidAccount(GlobalVariable.A2_USER_NAME, GlobalVariable.A2_PASSWORD)

'ER:'
'The Dashboard page is loaded successfully'
WebUI.verifyElementText(findTestObject('A2/LoginFunction/Dashboard_Label'), 'Dashboard')

'Step 2:'
'Click to the toggle menu button to collapse the menu'
WebUI.click(findTestObject('Object Repository/A2/MainMenu/Toggle_Icon'))

'ER:'
'The menu will be collapsed completely'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/A2/MainMenu/Toggle_Icon'), GlobalVariable.MEDIUM_WAIT_TIME)

'Step 3:'
'Click to the un_toggle menu button to open the menu'
WebUI.click(findTestObject('Object Repository/A2/MainMenu/Un_Toggle_Icon'))

'Step 4:'
'Type to Search textbox "My Info"'
WebUI.setText(findTestObject('Object Repository/A2/MainMenu/Search_TextBox'), 'My Info')

'ER:'
'The menu can be filtered with My Info'
WebUI.verifyElementPresent(findTestObject('Object Repository/A2/MainMenu/ViewInfor_Panel'), GlobalVariable.MEDIUM_WAIT_TIME)

WebUI.clearText(findTestObject('A2/MainMenu/Search_TextBox'))

'Step 5:'
'Delete text Info and Type to Search textbox "D"'
WebUI.sendKeys(findTestObject('Object Repository/A2/MainMenu/Search_TextBox'), Keys.chord(Keys.CONTROL, "a", Keys.DELETE))
WebUI.setText(findTestObject('Object Repository/A2/MainMenu/Search_TextBox'), 'D')

'ER:'
'The menu can be filtered with "D"'
WebUI.verifyElementPresent(findTestObject('Object Repository/A2/MainMenu/Admin_Panel'), GlobalVariable.MEDIUM_WAIT_TIME)

WebUI.verifyElementPresent(findTestObject('Object Repository/A2/MainMenu/Dashboard_Panel'), GlobalVariable.MEDIUM_WAIT_TIME)

WebUI.verifyElementPresent(findTestObject('Object Repository/A2/MainMenu/Directory_Panel'), GlobalVariable.MEDIUM_WAIT_TIME)

'Step 6:'
'Click Dashboard Menu'
WebUI.click(findTestObject('Object Repository/A2/MainMenu/Dashboard_Panel'))

'ER:'
'The Dashboard page is loaded successfully'
WebUI.verifyElementText(findTestObject('A2/LoginFunction/Dashboard_Label'), 'Dashboard')
