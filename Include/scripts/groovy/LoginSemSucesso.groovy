import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.javafaker.Faker
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import cucumber.api.java.pt.Entao
import cucumber.api.java.pt.Quando
import cucumber.api.PendingException
import cucumber.api.java.pt.Dado
import cucumber.api.java.pt.E
import internal.GlobalVariable

public class LoginSemSucesso {
	
	@Quando("preencher os dados errado")
	public void preencher_os_dados_errado() {
		
		WebUI.click(findTestObject('Object Repository/Page_login/btn_login'))
		Faker faker = new Faker()
		String name = faker.address().firstName()
		WebUI.setText(findTestObject('Object Repository/Page_login/username_login'), name)
		WebUI.setText(findTestObject('Object Repository/Page_login/password_login'), '123')
	}
	
	@Entao("uma mensagem de erro é exibida")
	public void uma_mensagem_de_erro_é_exibida() {
		
		WebUI.delay(5)
		WebUI.closeBrowser()
	}
}
