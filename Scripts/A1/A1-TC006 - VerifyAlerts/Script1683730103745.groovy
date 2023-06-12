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
'Select JavaScript Alerts and JavaScript Alerts title is displayed'
WebUI.click(findTestObject('Object Repository/A1/AlertsPage/JavaScriptAlerts_Panel'))

'ER:'
'JavaScript Alerts header title is displayed correctly'
WebUI.verifyElementText(findTestObject('A1/AlertsPage/JS_Alert_Label'), 'JavaScript Alerts')


'Step 2: '
'Click for JS Alert button'
WebUI.click(findTestObject('Object Repository/A1/AlertsPage/Click_JS_Alert_Button'))

'ER:'
'Verify message is I am a JS Alert is displayed correctly'

WebUI.verifyMatch(WebUI.getAlertText(), 'I am a JS Alert', false)

'Step 3:'
'Click “OK” button to close Alert'
WebUI.acceptAlert()

'ER:'
'Result message: You successfully clicked an alert'
WebUI.verifyElementText(findTestObject('Object Repository/A1/AlertsPage/Results_Label'), 'You successfully clicked an alert')


'Step 3:'

'Click "I am a JS Confirm" button'
WebUI.click(findTestObject('A1/AlertsPage/Click_JS_Confirm_Button'))

WebUI.dismissAlert()

'ER:'
'Result message: You successfully clicked an alert is displayed correctly'
WebUI.verifyElementText(findTestObject('A1/AlertsPage/Results_Label'), 'You clicked: Cancel')


'Step 4:'
'Click "Click for JS Prompt" button'

WebUI.click(findTestObject('Object Repository/A1/AlertsPage/Click_JS_Prompt_Button'))
WebUI.setAlertText('Hello')
WebUI.acceptAlert()

'ER:'
'Result message: "You entered: Hello"'
WebUI.verifyElementText(findTestObject('A1/AlertsPage/Results_Label'), 'You entered: Hello')

WebUI.closeBrowser()

