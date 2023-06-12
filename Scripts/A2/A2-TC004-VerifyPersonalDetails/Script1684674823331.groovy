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
import static org.testng.Assert.assertEquals
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

'Step 1:'
'Login to the system successfully and Navigate to My Info page'
a2.CommonUse.loginWithValidAccount(GlobalVariable.A2_USER_NAME, GlobalVariable.A2_PASSWORD)

WebUI.click(findTestObject('Object Repository/A2/MainMenu/ViewInfor_Panel'))

WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Personal_Detail_Panel'))

'ER:'

'The Personal Details is displayed'
WebUI.verifyElementText(findTestObject('A2/PersonalPage/Personal_Detail_Label'), 'Personal Details')

'step 2:'

'Change the First name value and Click First Save button'
WebUI.sendKeys(findTestObject('Object Repository/A2/PersonalPage/First_Name_TextBox'), Keys.chord(Keys.CONTROL, 'a', Keys.DELETE))

WebUI.sendKeys(findTestObject('Object Repository/A2/PersonalPage/First_Name_TextBox'), 'Hehe')

'ER:'

'The First name value can be change to the new value'
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Save_FirstName_Button'))

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/A2/PersonalPage/First_Name_Textbox'), 'value'), 'Hehe', 
    false)

'Step 3:'

'Change the Blood Type to A+ and click the Second Save'
WebUI.scrollToElement(findTestObject('Object Repository/A2/PersonalPage/Blood_DropDown'), GlobalVariable.MEDIUM_WAIT_TIME)

WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Open_Blood_Dropdown'))

WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Blood_Item', [('value') : 'A+']))

WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Second_Saved_Button'))

'ER:'

'The Blood Type is changed'
WebUI.waitForElementPresent(findTestObject('Object Repository/A2/PersonalPage/Message_Popup'), GlobalVariable.MEDIUM_WAIT_TIME)

WebUI.verifyTextPresent('Successfully Saved', false)

WebUI.verifyElementText(findTestObject('Object Repository/A2/PersonalPage/Open_Blood_Dropdown'), 'A+')

'step 4:'

'Attach a file in the Attachments session'
WebUI.scrollToElement(findTestObject('Object Repository/A2/PersonalPage/Add_Button'), GlobalVariable.MEDIUM_WAIT_TIME)

'Click Add button'
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Add_Button'))

'Attach a file in the Attachments session'
String filePath = RunConfiguration.getProjectDir() + '/Images'

WebUI.uploadFile(findTestObject('Object Repository/A2/PersonalPage/Upload_Icon'), filePath + '/hinh1.png')

WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Third_Save_Button'))

'ER:'

'The attached file is loaded successfully'
WebUI.waitForElementPresent(findTestObject('Object Repository/A2/PersonalPage/Message_Popup'), GlobalVariable.MEDIUM_WAIT_TIME)

WebUI.verifyTextPresent('Successfully Saved', false)

'Step 5:'

'Re-attached another file'
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Add_Button'))

WebUI.uploadFile(findTestObject('Object Repository/A2/PersonalPage/Upload_Icon'), filePath + '/hoa.png')

'Click Save'
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Third_Save_Button'))

'ER:'

'The attached file is loaded successfully'
WebUI.waitForElementPresent(findTestObject('Object Repository/A2/PersonalPage/Message_Popup'), GlobalVariable.MEDIUM_WAIT_TIME)

WebUI.verifyTextPresent('Successfully Saved', false)

'Step 6:'

'Click to downloaded the latest attached file'
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/LastFile_Download'))

WebUI.waitForPageLoad(GlobalVariable.MEDIUM_WAIT_TIME)

'ER:'

'The file is downloaded successfully'
String userDownloads = System.getProperty('user.home') + '/Downloads/'

CustomKeywords.'a2.helper.FileDownloaded'(userDownloads, 'hoa.png')

'Step 7:'

'Click to Edit button of the first attached file'
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/First_Edit_Button'))

'ER:'

'The edited file name is correct'
WebUI.verifyElementText(findTestObject('Object Repository/A2/PersonalPage/Edit_Name_Label'), 'hinh1.png')

'The Save and Cancel button are displayed'
WebUI.verifyElementPresent(findTestObject('A2/PersonalPage/Third_Save_Button'), 0)

WebUI.verifyElementPresent(findTestObject('A2/PersonalPage/Third_Cancel_Button'), 0)

'Step 8:'

'Update the document to a new value (ex: ABC) and click Save button'
WebUI.uploadFile(findTestObject('Object Repository/A2/PersonalPage/Upload_Icon'), filePath + '/img.png')

'Click Save'
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Third_Save_Button'))

'ER:'

'The updated value can be saved successfully'
WebUI.verifyTextPresent('Successfully Updated', false)

WebUI.verifyTextPresent('img.png', false)

'Step 9:'

'Click to Delete button of the updated document file name'
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Delete_Button'))

'ER:'

'A modal displays'
WebUI.verifyTextPresent('Are you Sure?', false)

WebUI.verifyTextPresent('The selected record will be permanently deleted. Are you sure you want to continue?', false)

'Step 10:'

'Click Exit button'
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Exit_Button'))

'ER:'

'The modal is disappeared'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/A2/PersonalPage/Header_Model_Label'), GlobalVariable.MEDIUM_WAIT_TIME)

'Step 11:'

'Click to Delete button of the updated document file name'
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Delete_Button'))

'ER:'

'A modal displays'
WebUI.verifyTextPresent('Are you Sure?', false)

WebUI.verifyTextPresent('The selected record will be permanently deleted. Are you sure you want to continue?', false)

'Step 12:'

'Click No, Cancel button'
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/No_Popup_Button'))

'ER:'

'The modal is disappeared'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/A2/PersonalPage/Header_Model_Label'), GlobalVariable.MEDIUM_WAIT_TIME)

'Step 13:'

'Click to Delete button of the updated document file name'
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Delete_Button'))

'ER:'

'A modal displays'
WebUI.verifyTextPresent('Are you Sure?', false)

WebUI.verifyTextPresent('The selected record will be permanently deleted. Are you sure you want to continue?', false)

'Step 14:'

'Click Yes, Delete button'
WebUI.click(findTestObject('Object Repository/A2/PersonalPage/Yes_Delete_Button'))

'ER:'

'The attached file is deleted successfully'
WebUI.verifyTextPresent('Successfully Deleted', false)

