package a2

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable


public class CommonUse {

	static def loginWithValidAccount(String username, String password) {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
		WebUI.setText(findTestObject('Object Repository/A2/LoginFunction/Username_TextBox'), username)
		WebUI.setText(findTestObject('Object Repository/A2/LoginFunction/Pass_TextBox'), password)
	}

	@Keyword
	def getListTestObjectByValue(TestObject testObject, String value) {
		def locator = testObject.getActiveProperties()[0].getValue()
		def elementLocator = locator + "//*[contains(., '${value}')]"
		TestObjectProperty newProperty = new TestObjectProperty("xpath", ConditionType.EQUALS, elementLocator)
		TestObject newObject = new TestObject(testObject.getObjectId())
		newObject.addProperty(newProperty)
		return newObject
	}
	
	public int countTotalRecords() {
		List<WebElement> rows = driver.findElements(By.xpath("//div[contains (@class, 'orangehrm-paper-container')]//div[contains (@class, 'orangehrm-horizontal-padding')]"));
		return rows.size();
	}
	public void verifyTotalRecords(int expectedCount) {
		int actualCount = countTotalRecords();
		if (actualCount == expectedCount) {
			System.out.println("The total records are displayed correctly.");
		} else {
			System.out.println("The total records are not displayed correctly. Expected count: " + expectedCount + ", Actual count: " + actualCount);
		}
	}
}
