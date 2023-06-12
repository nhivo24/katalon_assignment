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


token = CustomKeywords.'a4.Commona4.getToken'()
'Generate a random profile name from 1 to 9 characters'
String NamePro = CustomKeywords.'a4.Commona4.RandomName'(1, 9)

'Step 1:'
'Send POST to create a new profile'
def resPost = WS.sendRequest(findTestObject('Object Repository/A4/API-02_AddsNewProfile', [('token') : token, ('name') : NamePro]))

'Get POST response data'
int id = WS.getElementPropertyValue(resPost, 'Id')
String name = WS.getElementPropertyValue(resPost, 'Name')

'ER:'
'HTTP code: 200 OK'
WS.verifyResponseStatusCode(resPost, 200)
WS.verifyNotEqual(id, null)
WS.verifyEqual(name, NamePro)

'Step 2:'
'Generate a new profile name from 1 to 9 characters'
String nameChange = CustomKeywords.'a4.Commona4.RandomName'(1, 9)
def responsePut = WS.sendRequest(findTestObject('Object Repository/A4/API-04_UpdateProfile', [('token') : token, ('id') : id, ('name') : nameChange]))

'ER:'
'HTTP code: 200 OK'
WS.verifyResponseStatusCode(responsePut, 200)
WS.verifyEqual(WS.getElementPropertyValue(responsePut, 'Name'), nameChange)

'Step 3:'
'Send GET to view the new update profile'
def resGet = WS.sendRequest(findTestObject('Object Repository/A4/API-03_GetAllProfile', [('token') : token]))

'ER:'
'HTTP code: 200 OK'
WS.verifyResponseStatusCode(resGet, 200)
WS.verifyEqual(CustomKeywords.'a4.Commona4.ProfileExist'(resGet, id, nameChange), true, FailureHandling.OPTIONAL)

'Step 4:'
'Send DELETE to delete the new update profile'
def resDelete = WS.sendRequest(findTestObject('Object Repository/A4/API-05_DeleteProfileById', [('token') : token, ('id') : id]))

'ER:'
'HTTP code: 204 No Content'
WS.verifyResponseStatusCode(resDelete, 204)
WS.verifyEqual(CustomKeywords.'a4.Commona4.BodyEmpty'(resDelete), true, FailureHandling.OPTIONAL)

'Step 5:'
'Send PUT to update the deleted profile'
resPut = WS.sendRequest(findTestObject('Object Repository/A4/API-04_UpdateProfile', [('token') : token, ('id') : id, ('name') : nameChange]))

'ER:'
'HTTP code: 200 OK'
WS.verifyResponseStatusCode(resPut, 200)
WS.verifyEqual(CustomKeywords.'a4.Commona4.BodyEmpty'(resPut), true, FailureHandling.OPTIONAL)

'Step 6:'
'Send GET to prove the deleted profile does NOT exist'
resGet = WS.sendRequest(findTestObject('Object Repository/A4/API-03_GetAllProfile'))

'ER:'
'HTTP code: 200 OK'
WS.verifyResponseStatusCode(resGet, 200)
WS.verifyEqual(CustomKeywords.'a4.Commona4.ProfileExist'(resGet,id, nameChange), true, FailureHandling.OPTIONAL)

'=== CLEAN UP ENVIRONMENT ==='