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

'Open and navigate to url'
WebUI.openBrowser('')

WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

'Step 1:'
'Click File Uploaded and File Uploaded header title is displayed'
WebUI.click(findTestObject('Object Repository/A1/FileUpload/File Upload_Panel'))

'ER:'
'File Uploader header title is displayed correctly'

WebUI.verifyElementText(findTestObject('A1/FileUpload/UploadHeader_Label'), 'File Uploader')

'Step 2:'
'Click on Choose File button and upload a png file '

WebUI.uploadFile(findTestObject('Object Repository/A1/FileUpload/File_Upload_Button'), RunConfiguration.getProjectDir() + '\\Data Files\\A1\\FileUpload\\img.png')
WebUI.click(findTestObject('Object Repository/A1/FileUpload/Submit_Button'))

'ER:'
'The png file is upload successful'
WebUI.verifyElementText(findTestObject('A1/FileUpload/Uploaded_Label'), 'File Uploaded!')


'Step 4:'
'Close browser'

WebUI.closeBrowser()

'ER'
'Brower is closed'

