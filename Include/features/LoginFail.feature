#language: pt
#encoding: UTF-8


Funcionalidade: Tentativa de login

	Cenario: Login sem sucesso
		Dado que eu esteja no site
		Quando preencher os dados errado
		Entao uma mensagem de erro é exibida