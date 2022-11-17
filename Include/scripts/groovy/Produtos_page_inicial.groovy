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

public class Produtos_page_inicial {
	@Dado("que eu esteja na area logada")
	public void que_eu_esteja_na_area_logada() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://www.demoblaze.com/')
		WebUI.maximizeWindow()
		WebUI.click(findTestObject('Object Repository/Page_login/btn_login'))

		//Usuario
		WebUI.setText(findTestObject('Object Repository/Page_login/username_login'), 'mariaa')
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_login/password_login'), '4nvbrPglk7k=')

		// Clicar em login
		WebUI.click(findTestObject('Object Repository/Page_login/btn_ConfirmarLogin'))

		// Validar login
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_usuario/li_Welcome'),2)
	}

	@Quando("clicar para proxima aba")
	public void clicar_para_proxima_aba() {
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/Page_usuario/Next_Page_inicial'))
		WebUI.delay(3)

		//Voltar ao Home
		WebUI.click(findTestObject('Object Repository/Page_usuario/Previous_Page_Inicial'))
	}

	@Entao("vou ter visto os produtos")
	public void vou_ter_visto_os_produtos() {
		WebUI.click(findTestObject('Object Repository/Page_usuario/Logout'))
		WebUI.delay(2)
		WebUI.closeBrowser()
	}
}
