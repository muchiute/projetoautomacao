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

public class ProdutosTelefone {

	@Dado("que esteja logado")
	public void que_esteja_logado() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://www.demoblaze.com/')
		WebUI.maximizeWindow()
		WebUI.click(findTestObject('Object Repository/Page_login/btn_login'))
		WebUI.setText(findTestObject('Object Repository/Page_login/username_login'), 'mariaa')
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_login/password_login'), '4nvbrPglk7k=')
		WebUI.click(findTestObject('Object Repository/Page_login/btn_ConfirmarLogin'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_usuario/li_Welcome'), 2)
	}

	@Quando("clicar em phones")
	public void clicar_em_phones() {
		WebUI.click(findTestObject('Object Repository/Page_usuario/btn_Phones'))
	}

	@Entao("ira aparecer os telefones a venda")
	public void ira_aparecer_os_telefones_a_venda() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_usuario/li_Phone_HTC'), 0)
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/Page_usuario/btn_Home'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_usuario/li_Welcome'), 2)
		WebUI.click(findTestObject('Object Repository/Page_usuario/Logout'))
		WebUI.closeBrowser()
	}
}
