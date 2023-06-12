package a2

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.function.Function

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.FluentWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import internal.GlobalVariable


import groovy.time.Duration


public class helper {

	@Keyword
	boolean waitFileExist(String downloadPath, String fileName, long timeout, long pollingInterval) {
		String filePath = downloadPath + fileName;
		Path path = Paths.get(filePath);

		FluentWait<Path> wait = new FluentWait<>(path)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(pollingInterval))
				.ignoring(Exception.class);

		wait.until(new Function<Path, Boolean>(){
					public Boolean apply(Path p) {
						return Files.exists(p)
					}
				});
	}
	@Keyword
	static boolean FileDownloaded(String downloadPath, String fileName) {
		String filePath = downloadPath + fileName
		File downloadedFile = new File(filePath)

		if (downloadedFile.exists()) {
			KeywordUtil.markPassed("File downloaded successfully.")
			downloadedFile.delete()
			return true
		} else {
			KeywordUtil.markFailed("File not found.")
			return false
		}
	}

	@Keyword
	static String getDateTime(String format = "yyyy-MM-dd") {
		LocalDateTime now = LocalDateTime.now(ZoneId.of("America/New_York"))
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format)
		return now.format(formatter)
	}

	static void verifyIsSorted(boolean actualResult, FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {
		boolean expectedResult = true;

		if (actualResult == expectedResult) {
			KeywordUtil.markPassed("Expected result: PASSED");
		} else {
			KeywordUtil.markFailed("Expected result: FAILED");
		}
	}
}
