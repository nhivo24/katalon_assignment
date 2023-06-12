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
'Click WYSIWYG Editor and TinyMCE WYSIWYG Editor header title is displayed'

WebUI.click(findTestObject('Object Repository/A1/FramesPage/WYSIWYGEditor_Panel'))

'ER:'
'An iFrame containing the TinyMCE WYSIWYG Editor title is displayed correctly'
WebUI.verifyElementText(findTestObject('A1/FramesPage/MCE WYSIWYG_Label'), 'An iFrame containing the TinyMCE WYSIWYG Editor')

'Step 2:'
'Verify the default content'
'ER:'
'The default content body is Your content goes here.'
WebUI.verifyElementText(findTestObject('Object Repository/A1/FramesPage/Yourcontent_Label'), 'Your content goes here.')

'Step 3:'
'Clear the default content'
WebUI.clearText(findTestObject('A1/FramesPage/Yourcontent_Label'))

'Step 4:'
'Set new content "Hello, how are you?'
WebUI.setText(findTestObject('A1/FramesPage/Aria_Lablel'), 'Hello, how are you?')

'ER:'
'The content body is Hello, how are you?'
WebUI.verifyElementText(findTestObject('A1/FramesPage/Aria_Lablel'), 'Hello, how are you?')

'Step 5:'
'Close browser'

WebUI.closeBrowser()

'ER'
'Brower is closed'

