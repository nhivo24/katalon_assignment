package a1

import org.openqa.selenium.WebElement
import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper

import internal.GlobalVariable

public class A1_TC011 {
	@Keyword
	public static void verifyColumnSorted(TestObject testObject) {

		List<WebElement> columnValues = WebUiCommonHelper.findWebElements(testObject, GlobalVariable.LONG_WAIT_TIME);

		boolean isSorted = true;
		for (int i = 1; i < columnValues.size(); i++) {
			if (columnValues.get(i).getText().compareTo(columnValues.get(i - 1).getText()) < 0) {
				isSorted = false;
				break;
			}
		}
	}
}







