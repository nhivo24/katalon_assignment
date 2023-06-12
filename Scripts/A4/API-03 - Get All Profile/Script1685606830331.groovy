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


'Get token'
GlobalVariable.A4_TOKENKEY = CustomKeywords.'a4.Commona4.getToken'()
id = GlobalVariable.A4_PROFILE_ID = CustomKeywords.'a4.Commona4.getID'()
name = GlobalVariable.A4_PROFILE_NAME = CustomKeywords.'a4.Commona4.getUsername'()


'Step 1:'
'Send GET request to Profiles_V2'
res = WS.sendRequest(findTestObject('Object Repository/A4/API-03_GetAllProfile', [('token') : GlobalVariable.A4_TOKEN]))

'Step 2:'
'Verify Response Status Code is 200'
WS.verifyResponseStatusCode(res, 200)

'Step 3:'
'Verify Id and Name value exist in the response data'
WS.verifyEqual(CustomKeywords.'a4.Commona4.ProfileExist'(res, id, name), false)

