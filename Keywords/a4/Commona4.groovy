package a4

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import groovy.json.JsonSlurper
import java.nio.file.Files
import java.nio.file.Paths
import org.apache.commons.lang3.StringUtils


public class Commona4 {

	@Keyword
	public static boolean ProfileExist(ResponseObject response, int profileId, String profileName) {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonResponse;

		try {
			jsonResponse = objectMapper.readTree(response.getResponseBodyContent());
		} catch (Exception e) {
			return false;
		}

		boolean profileExists = false;
		if (jsonResponse.isArray()) {
			for (JsonNode profile : jsonResponse) {
				int id = profile.path("Id").asInt();
				String name = profile.path("Name").asText();
				if (id == profileId && name.equals(profileName)) {
					profileExists = true;
					break;
				}
			}
		}

		if (!profileExists) {
			System.out.println("User with ID " + profileId + " and name " + profileName + " does not exist in the response.");
		}

		return profileExists;
	}

	@Keyword
	String getToken() {
		def response = WS.sendRequest(findTestObject('Object Repository/A4/API-01_LogIn'))
		String token

		return token = WS.getElementPropertyValue(response, 'Token')
	}

	@Keyword
	public String RandomName(int minLength, int maxLength) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		Random random = new Random();

		int nameLength = random.nextInt(maxLength - minLength + 1) + minLength;

		StringBuilder randomNameBuilder = new StringBuilder();
		for (int i = 0; i < nameLength; i++) {
			int randomIndex = random.nextInt(characters.length());
			char randomChar = characters.charAt(randomIndex);
			randomNameBuilder.append(randomChar);
		}

		return randomNameBuilder.toString();
	}
	@Keyword
	public static String readValue() {
		String fileName = System.getProperty('user.dir') + '/DataProfiles/updatedProfile.xlsx'
		String text = ""

		try {
			text = new String(Files.readAllBytes(Paths.get(fileName)))
		} catch (Exception e) {
			// Handle exception if there's an error reading the file
			e.printStackTrace()
		}

		return text
	}
	@Keyword
	public static int getID() {
		String idText = StringUtils.isNotBlank(readValue().split("\\t", 3)[0]) ? readValue().split("\\t", 3)[0] : ""
		int id = 0

		if (!idText.isEmpty()) {
			try {
				id = Integer.parseInt(idText)
			} catch (NumberFormatException e) {
				// Handle exception if the string cannot be parsed as an integer
				e.printStackTrace()
			}
		}

		return id
	}

	@Keyword
	public static String getUsername() {
		String[] splitName = readValue().split("\\t", 3)
		String nameProfile = ""

		if (splitName.length >= 2) {
			nameProfile = splitName[1]
		}

		return nameProfile
	}


	@Keyword
	boolean BodyEmpty(ResponseObject response) {
		String responseBody = response.getResponseBodyContent()
		boolean isEmpty = responseBody.trim().isEmpty()

		if (isEmpty) {
			println('Response body is empty')
			return true
		} else {
			println('Response body is not empty')
			return false
		}
	}
}


