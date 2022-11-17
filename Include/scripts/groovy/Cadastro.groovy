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

public class Cadastro {

	@Dado("que eu esteja no site")
	public void que_eu_esteja_no_site() {

		//Pagina Inicial
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://www.demoblaze.com/')
		WebUI.maximizeWindow()
	}

	@E("clicar para fazer cadastro")
	public void clicar_para_fazer_cadastro() {
		WebUI.click(findTestObject('Object Repository/Page_Cadastro/btn_singUp'))
	}

	@Quando("preencho os dados")
	public void preencho_os_dados() {
		Faker faker = new Faker()
		String name = faker.address().firstName()
		WebUI.setText(findTestObject('Object Repository/Page_Cadastro/username_cadastro'), name)
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_Cadastro/password_cadastro'), '4nvbrPglk7k=')
	}

	@Entao("clico no botao registrar")
	public void clico_no_botão_registrar() {
		WebUI.click(findTestObject('Object Repository/Page_Cadastro/btn_Cadastrar'))
		WebUI.delay(2)
		WebUI.closeBrowser()
	}
}
