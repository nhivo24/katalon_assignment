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
import com.kms.katalon.core.configuration.RunConfiguration

'Step 1:'
'Login to the system successfully'
a2.CommonUse.loginWithValidAccount(GlobalVariable.A2_USER_NAME, GlobalVariable.A2_PASSWORD)

'Step 2'
'Click to My Info menu'
WebUI.click(findTestObject('Object Repository/A2/MainMenu/ViewInfor_Panel'))

'ER:'
'The PIM page is loaded successfully'
WebUI.verifyElementText(findTestObject('Object Repository/A2/PersonalPage/PIM_Label'), 'PIM')

'Step 3'
'Click to the user picture'
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/User_Picture'))

'ER:' 
'The change profile picture is displayed'
WebUI.verifyElementText(findTestObject('Object Repository/A2/PersonalPage/Change_Profile_Header'), 'Change Profile Picture')

'Step 4'
'Update a new profile picture and click Saved Button'
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Load_Img_Button'))
TestObject uploadfile = findTestObject('Object Repository/A2/PersonalPage/Upload_Img')
WebUI.uploadFile(uploadfile, RunConfiguration.getProjectDir()+'\\Data Files\\A1\\FileUpload\\img.png')
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Save_Img_Button'))

'ER:'
'The new picture is changed successfully'
WebUI.verifyTextPresent(('Success' + '\n') + 'Successfully Updated', false)

