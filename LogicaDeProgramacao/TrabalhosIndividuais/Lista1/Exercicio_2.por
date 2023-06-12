//O programa “Tempo de vida” irá imprimir a soma das idades de todos os colegas da sua equipe (6 pessoas). Pergunte a cada um a idade e não esqueça a sua! Depois faça a atribuição direta da expressão em uma variável inteira.
programa {
	
	inclua biblioteca Util --> u 
	
	inteiro idade, soma=0

	
	funcao inicio() {

		escreva("Olá, eu sou o programa \"tempo de vida!\"")
		u.aguarde(1000)
		escreva("\nAgora vou te fazer duas perguntas:")
		u.aguarde(1000)
		escreva("\nAguarde...")
		u.aguarde(5000)
		limpa()
	
		para(inteiro i=0; i<100; i++) {
			escreva("Qual é a idade do " + (i+1),  "o colega?\n")
			leia(idade)
			soma += idade
			u.aguarde(1000)
			limpa ()
		}
		escreva("Qual é a minha idade?\n")
		leia (idade)
		soma += idade
		u.aguarde(1000)
		limpa()
		escreva("O tempo de vida meu e dos meus colegas é " + soma)
		 
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 767; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */