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
import org.testng.Assert
import com.kms.katalon.core.testobject.ResponseObject

'Step 1:'
'Send PUT request to URL'
ResponseObject response = WS.sendRequest(findTestObject('Object Repository/A4/API-04_UpdateProfile', [('tokenkey') : GlobalVariable.A4_TOKENKEY, ('id') : GlobalVariable.A4_PROFILE_ID, ('name') : GlobalVariable.A4_PROFILE_NAME]))

'Step 2:'
'Verify Response Status Code is correctly'
WS.verifyResponseStatusCode(response,200)

'Step 3:'
'Verify Id and Name value'

WS.verifyEqual(WS.getElementPropertyValue(response, 'id'), GlobalVariable.A4_PROFILE_ID)
WS.verifyEqual(WS.getElementPropertyValue(response, 'name'), GlobalVariable.A4_PROFILE_NAME)