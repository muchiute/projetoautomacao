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

public class RealizarCompra {

	@Dado("que eu esteja logado")
	public void que_eu_esteja_logado() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://www.demoblaze.com/')
		WebUI.maximizeWindow()
		WebUI.click(findTestObject('Object Repository/Page_login/btn_login'))
		WebUI.setText(findTestObject('Object Repository/Page_login/username_login'), 'mariaa')
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_login/password_login'), '4nvbrPglk7k=')
		WebUI.click(findTestObject('Object Repository/Page_login/btn_ConfirmarLogin'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_usuario/li_Welcome'),2)
	}

	@Quando("adicionar o celular no carrinho")
	public void adicionar_o_celular_no_carrinho() {
		WebUI.click(findTestObject('Object Repository/Page_usuario/Samsung_s6'))
		WebUI.click(findTestObject('Object Repository/Page_usuario/btn_add_carrinho'))
		WebUI.click(findTestObject('Object Repository/Page_login/btn_Car'))
	}

	@Entao("vou concluir a compra")
	public void vou_concluir_a_compra() {
		
		WebUI.click(findTestObject('Object Repository/Page_usuario/btn_place_order'))
		Faker faker = new Faker()
		String name = faker.address().firstName()
		String city = faker.address().cityName()
		String pais = faker.address().state()
		String card = faker.business().creditCardNumber()

		WebUI.setText(findTestObject('Object Repository/Page_usuario/txt_name_compra'), name)
		WebUI.setText(findTestObject('Object Repository/Page_usuario/txt_pais_compra'), pais)
		WebUI.setText(findTestObject('Object Repository/Page_usuario/txt_cidade_compra'), city)
		WebUI.setText(findTestObject('Object Repository/Page_usuario/txt_card_compra'), card)
		WebUI.setText(findTestObject('Object Repository/Page_usuario/txt_mes_compra'), 'novembro')
		WebUI.setText(findTestObject('Object Repository/Page_usuario/txt_ano_compra'), '2022')
		WebUI.click(findTestObject('Object Repository/Page_usuario/btn_confirmarCompra'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_usuario/li_CompraConfirmada'), 0)
		WebUI.click(findTestObject('Object Repository/Page_usuario/btn_Ok_compraConfirmada'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_usuario/li_Welcome'), 0)
		WebUI.click(findTestObject('Object Repository/Page_usuario/Logout'))
		WebUI.delay(2)
		WebUI.closeBrowser()
	}
}
