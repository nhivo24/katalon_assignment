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
'Select Horizontal Slider and Horizontal Slider header title is displayed'
WebUI.click(findTestObject('A1/SliderPage/Horizontal_Slider_Panel'))



'Step 2'
'Set Slider to 1'
float slider = CustomKeywords.'a1.A1_TC009.getFloatValue'(findTestObject('A1/SliderPage/Label_Result'))
CustomKeywords.'a1.A1_TC009.setSlider'(findTestObject('A1/SliderPage/Slider_Button'), 1, slider)

'ER:'
'Slider value is 1'
WebUI.verifyElementText(findTestObject('A1/SliderPage/Label_Result'), '1')


'Step 3:'
'Set Slider to 2.5'
slider = CustomKeywords.'a1.A1_TC009.getFloatValue'(findTestObject('A1/SliderPage/Label_Result'))
CustomKeywords.'a1.A1_TC009.setSlider'(findTestObject('A1/SliderPage/Slider_Button'), 2.5, slider)

'ER:'
'Slider value is 2.5'

WebUI.verifyElementText(findTestObject('A1/SliderPage/Label_Result'), '2.5')

'Step 4:'
'Slider value is 4.5'
slider = CustomKeywords.'a1.A1_TC009.getFloatValue'(findTestObject('A1/SliderPage/Label_Result'))
CustomKeywords.'a1.A1_TC009.setSlider'(findTestObject('A1/SliderPage/Slider_Button'), 4.5, slider)

'ER:'
'Slider value is 4.5'

WebUI.verifyElementText(findTestObject('A1/SliderPage/Label_Result'), '4.5')

WebUI.closeBrowser()

