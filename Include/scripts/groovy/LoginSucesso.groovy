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


public class LoginSucesso {

	@Dado("que eu esteja na pagina inicial")
	public void que_eu_esteja_na_pagina_inicial() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://www.demoblaze.com/')
		WebUI.maximizeWindow()
	}

	@Quando("clicar para fazer login")
	public void clicar_para_fazer_login() {
		WebUI.click(findTestObject('Object Repository/Page_login/btn_login'))
	}

	@E("preencher os dados")
	public void preencher_os_dados() {
		WebUI.setText(findTestObject('Object Repository/Page_login/username_login'), 'mariaa')
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_login/password_login'), '4nvbrPglk7k=')
	}

	@Entao("clico no botao logar")
	public void clico_no_botao_logar() {
		WebUI.click(findTestObject('Object Repository/Page_login/btn_ConfirmarLogin'))

		// E valido a mensagem Welcome
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_usuario/li_Welcome'),2)
		WebUI.closeBrowser()
	}
}
