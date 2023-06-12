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

'Click Drag and Drop and Drag and Drop header title is displayed'
WebUI.click(findTestObject('Object Repository/A1/DragandDrop/Drag_and_Drop_Panel'))

'ER:'
'Drag and Drop header title displayed correctly'

WebUI.verifyElementText(findTestObject('A1/DragandDrop/Drag_and_Drop_Label'), 'Drag and Drop')

'Step 2:'
'Drag and Drop column A to column B'

CustomKeywords.'a1.A1_TC002.dragAndDrop'(findTestObject('Object Repository/A1/DragandDrop/drag_colA'), 
    findTestObject('Object Repository/A1/DragandDrop/drag_colB'))

'ER:'
'Column A changed to column B'
WebUI.verifyElementText(findTestObject('A1/DragandDrop/headerA_Label'), 'B')

'ER:'
'Column A changed to column B'
WebUI.verifyElementText(findTestObject('A1/DragandDrop/headerB_Label'), 'A')

'Step 3:'
'Close browser'

WebUI.closeBrowser()

'ER'
'Brower is closed'

