import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

//a2.LoginHelper.loginWithValidAccount(GlobalVariable.A2_USER_NAME, GlobalVariable.A2_PASSWORD)
WebUI.openBrowser('')

WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index')

'Step 1:'
'Get username text from Login form to enter into Username textbox'
String username = WebUI.getText(findTestObject('Object Repository/A2/LoginFunction/Username_Info_Label'))
String[] split_username  = username.split(":")
String UserNameText = split_username[1].trim()

'ER:'
'User can enter the username successfully'
WebUI.setText(findTestObject('Object Repository/A2/LoginFunction/Username_TextBox'), UserNameText)

'Step 2:'
'Get password text from Login form to enter into Password textbox'
String passw = WebUI.getText(findTestObject('Object Repository/A2/LoginFunction/Pass_Info_Label'))
String[] split_pass  = passw.split(":")
String PassText = split_pass[1].trim()

'ER:'
'User can enter the password successfully'
WebUI.setText(findTestObject('Object Repository/A2/LoginFunction/Pass_TextBox'), PassText)

'Step 3:'
'Click Login button'
WebUI.click(findTestObject('A2/LoginFunction/Login_Button'))
WebUI.waitForElementVisible(findTestObject('Object Repository/A2/LoginFunction/Profile_User_Icon'), GlobalVariable.MEDIUM_WAIT_TIME)

'ER:'
'The Dashboard page is loaded successfully'
WebUI.verifyElementText(findTestObject('A2/LoginFunction/Dashboard_Label'), 'Dashboard')


'Step 4:'
'Select Logout in the User name control'
WebUI.click(findTestObject('Object Repository/A2/LoginFunction/Profile_User_Icon'))
WebUI.click(findTestObject('Object Repository/A2/LoginFunction/Logout_Button'))

'ER:'
'The user is logged out'
WebUI.verifyElementPresent(findTestObject('Object Repository/A2/LoginFunction/UserName_TextBox'), GlobalVariable.MEDIUM_WAIT_TIME)


