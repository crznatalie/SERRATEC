/*
 Crie o programa “mini calculadora”, que após ler dois números inteiros
apresenta as operações de soma, subtração, multiplicação e divisão com
eles.
Obs.: Trate o maior número possível de erros (ex: operações com números
negativos, divisão por zero, uso de letras, etc).
*/
programa {

	inclua biblioteca Tipos --> t
	inclua biblioteca Texto --> tx
	inclua biblioteca Util --> u

	caracter digito, simNao
	cadeia vetorPNum[2], novoNum
	inteiro contador=0, verificaNum[2], numInt[2], verificaResult, resultadoInt=0
	real vetorNum[2], numReal[2], resultado = 0.0
	logico numero = verdadeiro
	

	funcao verificacaoCaracter() {
		se (vetorPNum[contador] == "" ou vetorPNum[contador] == " ") {
			limpa()
			escreva ("Valor nulo. Por favor, tente novamente.\n")
			u.aguarde(1000)
			escreva("Digite o ", contador+1 ,"° número: ")
			leia (vetorPNum[contador])
			verificacaoCaracter()
		}
		senao {
			para (inteiro indice=0; indice <= tx.numero_caracteres(vetorPNum[contador]) -1; indice++) {
				digito = tx.obter_caracter(vetorPNum[contador], indice)
				se (digito =='0' ou digito =='1' ou digito =='2' ou digito =='3' ou digito =='4' ou digito =='5' ou
			   	    digito =='6' ou digito =='7' ou digito =='8' ou digito =='9' ou digito =='.' ou digito =='-') {
					numero = verdadeiro
				}
				senao {
					numero = falso
					enquanto(numero == falso) {
						limpa()
						escreva ("A mini-calculadora não aceita letras. Por favor, tente novamente.\n")
						u.aguarde(1000)
						escreva("Digite o ", contador+1 ,"° número: ")
						leia (vetorPNum[contador])
						para (indice=0; indice <= tx.numero_caracteres(vetorPNum[contador]) -1; indice++) {
					     	digito = tx.obter_caracter(vetorPNum[contador], indice)
							se (digito =='0' ou digito =='1' ou digito =='2' ou digito =='3' ou digito =='4' ou digito =='5' ou
	                        	        digito =='6' ou digito =='7' ou digito =='8' ou digito =='9' ou digito == '.' ou digito == '-') {
								numero = verdadeiro
							}
							senao {
								numero = falso
							}
						}	  		
					}
				}
			}
		}
	}

	funcao menu() {
		caracter valor
		escreva("**************************\n")
		escreva("-Selecione uma operação-\n")
		escreva("**************************\n")
		escreva("[1] Soma\n")
		escreva("[2] Subtração\n")
		escreva("[3] Multiplicação\n")
		escreva("[4] Divisão\n")
		escreva("[5] Fechar Calculadora\n")
		leia(valor)
		limpa()
		se (valor=='1' ou valor=='2' ou valor =='3' ou valor=='4' ou valor=='5') {
			escolha (valor){
				caso '1':
				operacaoSoma()
				pare

				caso '2':
				operacaoSub()
				pare

				caso '3':
				operacaoMult()
				pare

				caso '4':
				operacaoDiv()
				pare

				caso '5':
				fim()
				pare
			}
		}
		senao {
			escreva("Opção inválida, tente novamente.\n")
			u.aguarde(1000)
			escreva("Aguarde .")
			u.aguarde(1000)
			limpa()
			escreva("Opção inválida, tente novamente.\n")
			escreva("Aguarde . .")
			u.aguarde(1000)
			limpa()
			escreva("Opção inválida, tente novamente.\n")
			escreva("Aguarde . . .")
			u.aguarde(1000)
			limpa()
			menu()	
	}
	}
	
	funcao novaOperacao() {
		escreva("O que gostaria de fazer agora?\n")
		escreva("[1] Nova operação a partir do resultado.\n")
		escreva("[2] Voltar ao início.\n")
		escreva("[3] Finalizar calculadora.\n")
		leia(simNao)
		se (simNao=='1' ou simNao=='2' ou simNao=='3') {
			escolha (simNao) {

			caso '1':
			limpa()
			escreva ("Insira o próximo valor: ")
			leia (novoNum)
			para (inteiro indice=0; indice <= tx.numero_caracteres(novoNum) -1; indice++) {
				digito = tx.obter_caracter(novoNum, indice)
				se (digito =='0' ou digito =='1' ou digito =='2' ou digito =='3' ou digito =='4' ou digito =='5' ou
			         digito =='6' ou digito =='7' ou digito =='8' ou digito =='9' ou digito =='.' ou digito =='-') {
					numero = verdadeiro
			      }
				senao {
					numero = falso
					enquanto(numero == falso) {
						limpa()
						escreva ("A mini-calculadora não aceita letras. Por favor, tente novamente.\n")
						u.aguarde(1000)
						escreva("Insira o próximo valor: ")
						leia (novoNum)
						para (indice=0; indice <= tx.numero_caracteres(novoNum) -1; indice++) {
					     	digito = tx.obter_caracter(vetorPNum[contador], indice)
							se (digito =='0' ou digito =='1' ou digito =='2' ou digito =='3' ou digito =='4' ou digito =='5' ou
	                        	        digito =='6' ou digito =='7' ou digito =='8' ou digito =='9' ou digito == '.' ou digito == '-') {
								numero = verdadeiro
							}
							senao {
								numero = falso
							}
						}	  		
					}
				}
			}
			limpa()
			vetorNum[0] = resultado
			vetorNum[1] = t.cadeia_para_real(novoNum)
			menu()
			pare

			caso '2':
			limpa()
			inicio()
			pare

			caso '3':
			limpa()
			fim()
			pare
			}
		}
			
		senao {
			limpa()
			escreva ("Opção inválida\n")
			escreva("Tente novamente .\n")
			u.aguarde(1000)
			limpa()
			escreva ("Opção inválida\n")
			escreva("Tente novamente . .\n")
			u.aguarde(1000)
			limpa()
			escreva ("Opção inválida\n")
			escreva("Tente novamente . . .\n")
			u.aguarde(1000)
			limpa()
			novaOperacao()
		}
	}
	
	funcao operacaoSoma() {
		resultado = vetorNum[0] + vetorNum[1]
		verificaNum[0] = t.real_para_inteiro(vetorNum[0]*10)
		verificaNum[1] = t.real_para_inteiro(vetorNum[1]*10)
		se (verificaNum[0]%10==0) {
			numInt[0] = t.real_para_inteiro(vetorNum[0])
			se (verificaNum[1]%10==0) {
			numInt[1] = t.real_para_inteiro(vetorNum[1])
			resultadoInt = t.real_para_inteiro(resultado)
			escreva ("O resultado da soma entre " + numInt[0] + " e " + numInt[1] + " é igual a " + resultadoInt + "\n")
			resultado = t.inteiro_para_real(resultadoInt)	
			}
			senao {
				escreva ("O resultado da soma entre " + numInt[0] + " e " + vetorNum[1] + " é igual a " + resultado + "\n")
			}
		}
		senao se (verificaNum[1]%10==0) {
			numInt[1] = t.real_para_inteiro(vetorNum[1])
			escreva ("O resultado da soma entre " + vetorNum[0] + " e " + numInt[1] + " é igual a " + resultado + "\n")
		}
		senao {
			verificaResult = t.real_para_inteiro(resultado*10)
			se (verificaResult%10==0) {
				resultadoInt = t.real_para_inteiro(resultado)
				escreva ("O resultado da soma entre " + vetorNum[0] + " e " + vetorNum[1] + " é igual a " + resultadoInt + "\n")
				resultado = t.inteiro_para_real(resultadoInt)
			}
			senao {
				escreva ("O resultado da soma entre " + vetorNum[0] + " e " + vetorNum[1] + " é igual a " + resultado + "\n")
			}	
		}
		u.aguarde(1000)
		novaOperacao()
	}
	
	funcao operacaoSub() {
		resultado = vetorNum[0] - vetorNum[1]
		verificaNum[0] = t.real_para_inteiro(vetorNum[0]*10)
		verificaNum[1] = t.real_para_inteiro(vetorNum[1]*10)
		se (verificaNum[0]%10==0) {
			numInt[0] = t.real_para_inteiro(vetorNum[0])
			se (verificaNum[1]%10==0) {
				numInt[1] = t.real_para_inteiro(vetorNum[1])
				resultadoInt = t.real_para_inteiro(resultado)
				escreva ("O resultado da subtração entre " + numInt[0] + " e " + numInt[1] + " é igual a " + resultadoInt + "\n")
				resultado = t.inteiro_para_real(resultadoInt)	
			}
			senao {
				escreva ("O resultado da subtração entre " + numInt[0] + " e " + vetorNum[1] + " é igual a " + resultado + "\n")
			}
		}
		senao se (verificaNum[1]%10==0) {
			numInt[1] = t.real_para_inteiro(vetorNum[1])
			escreva ("O resultado da subtração entre " + vetorNum[0] + " e " + numInt[1] + " é igual a " + resultado + "\n")
		}
		senao {
			verificaResult = t.real_para_inteiro(resultado*10)
			se (verificaResult%10==0) {
				resultadoInt = t.real_para_inteiro(resultado)
				escreva ("O resultado da subtração entre " + vetorNum[0] + " e " + vetorNum[1] + " é igual a " + resultadoInt + "\n")
				resultado = t.inteiro_para_real(resultadoInt)
			}
			senao {
				escreva ("O resultado da subtração entre " + vetorNum[0] + " e " + vetorNum[1] + " é igual a " + resultado + "\n")
			}	
		}
		u.aguarde(1000)
		novaOperacao()	
	}
	
	funcao operacaoMult() {
		resultado = vetorNum[0] * vetorNum[1]
		verificaNum[0] = t.real_para_inteiro(vetorNum[0]*10)
		verificaNum[1] = t.real_para_inteiro(vetorNum[1]*10)
		se (verificaNum[0]%10==0) {
			numInt[0] = t.real_para_inteiro(vetorNum[0])
			se (verificaNum[1]%10==0) {
				numInt[1] = t.real_para_inteiro(vetorNum[1])
				resultadoInt = t.real_para_inteiro(resultado)
				escreva ("O resultado da multiplicação entre " + numInt[0] + " e " + numInt[1] + " é igual a " + resultadoInt + "\n")
				resultado = t.inteiro_para_real(resultadoInt)	
			}
			senao {
				verificaResult = t.real_para_inteiro(resultado*10)
				se (verificaResult%10==0) {
					resultadoInt = t.real_para_inteiro(resultado)
					escreva ("O resultado da multiplicação entre " + numInt[0] + " e " + vetorNum[1] + " é igual a " + resultadoInt + "\n")
					resultado = t.inteiro_para_real(resultadoInt)
				}
				senao {
						escreva ("O resultado da multiplicação entre " + numInt[0] + " e " + vetorNum[1] + " é igual a " + resultado + "\n")
				}
			}
		}
		senao se (verificaNum[1]%10==0) {
			numInt[1] = t.real_para_inteiro(vetorNum[1])
			verificaResult = t.real_para_inteiro(resultado*10)
			se (verificaResult%10==0) {
				resultadoInt = t.real_para_inteiro(resultado)
				escreva ("O resultado da multiplicação entre " + vetorNum[0] + " e " + numInt[1] + " é igual a " + resultadoInt + "\n")
				resultado = t.inteiro_para_real(resultadoInt)
			}
			senao {
				escreva ("O resultado da multiplicação entre " + vetorNum[0] + " e " + numInt[1] + " é igual a " + resultado + "\n")
			}
		}
		senao {
			verificaResult = t.real_para_inteiro(resultado*10)
			se (verificaResult%10==0) {
				resultadoInt = t.real_para_inteiro(resultado)
				escreva ("O resultado da multiplicação entre " + vetorNum[0] + " e " + vetorNum[1] + " é igual a " + resultadoInt + "\n")
				resultado = t.inteiro_para_real(resultadoInt)
			}
			senao {
				escreva ("O resultado da multiplicação entre " + vetorNum[0] + " e " + vetorNum[1] + " é igual a " + resultado + "\n")
			}	
		}
		u.aguarde(1000)
		novaOperacao()
	}
	
	funcao operacaoDiv() {
		se (vetorNum[1] == 0) {
			escreva("ERRO! Impossível realizar a operação de divisão por 0.\n")
			escreva("Gostaria de retornar so inicio?\n")
			escreva("[1] Sim\n")
			escreva("[2] Não\n")
			leia(simNao)
			se (simNao =='1' ou simNao =='2') {
				escolha (simNao) {
				caso '1':
				limpa()
				inicio()
				pare

				caso '2':
				limpa()
				fim()
				pare
				}
			}
			senao {
			limpa()
			escreva ("Opção inválida\n")
			escreva("Tente novamente .\n")
			u.aguarde(1000)
			limpa()
			escreva ("Opção inválida\n")
			escreva("Tente novamente . .\n")
			u.aguarde(1000)
			limpa()
			escreva ("Opção inválida\n")
			escreva("Tente novamente . . .\n")
			u.aguarde(1000)
			limpa()
			operacaoDiv()
			}
				
		}
		senao {
			resultado = vetorNum[0] / vetorNum[1]
			verificaNum[0] = t.real_para_inteiro(vetorNum[0]*10)
			verificaNum[1] = t.real_para_inteiro(vetorNum[1]*10)
			se (verificaNum[0]%10==0) {
				numInt[0] = t.real_para_inteiro(vetorNum[0])
				se (verificaNum[1]%10==0) {
					numInt[1] = t.real_para_inteiro(vetorNum[1])
					resultadoInt = t.real_para_inteiro(resultado)
					verificaResult = t.real_para_inteiro(resultado*10)
					se (verificaResult%10==0) {
						resultadoInt = t.real_para_inteiro(resultado)
						escreva ("O resultado da divisão entre " + numInt[0] + " e " + numInt[1] + " é igual a " + resultadoInt + "\n")
						resultado = t.inteiro_para_real(resultadoInt)
					}
					senao {
						escreva ("O resultado da divisão entre " + numInt[0] + " e " + numInt[1] + " é igual a " + resultado + "\n")
					}
						
				}
				senao {
					verificaResult = t.real_para_inteiro(resultado*10)
					se (verificaResult%10==0) {
						resultadoInt = t.real_para_inteiro(resultado)
						escreva ("O resultado da divisão entre " + numInt[0] + " e " + vetorNum[1] + " é igual a " + resultadoInt + "\n")
						resultado = t.inteiro_para_real(resultadoInt)
					}
					senao {
						escreva ("O resultado da divisão entre " + numInt[0] + " e " + vetorNum[1] + " é igual a " + resultado + "\n")
					}
				}
			}
			senao se (verificaNum[1]%10==0) {
				numInt[1] = t.real_para_inteiro(vetorNum[1])
				verificaResult = t.real_para_inteiro(resultado*10)
				se (verificaResult%10==0) {
					resultadoInt = t.real_para_inteiro(resultado)
					escreva ("O resultado da divisão entre " + vetorNum[0] + " e " + numInt[1] + " é igual a " + resultadoInt + "\n")
					resultado = t.inteiro_para_real(resultadoInt)
				}
				senao {
					escreva ("O resultado da divisão entre " + vetorNum[0] + " e " + numInt[1] + " é igual a " + resultado + "\n")
				}
			}
				senao {
					verificaResult = t.real_para_inteiro(resultado*10)
					se (verificaResult%10==0) {
						resultadoInt = t.real_para_inteiro(resultado)
						escreva ("O resultado da divisão entre " + vetorNum[0] + " e " + vetorNum[1] + " é igual a " + resultadoInt + "\n")
						resultado = t.inteiro_para_real(resultadoInt)
					}
					senao {
						escreva ("O resultado da divisão entre " + vetorNum[0] + " e " + vetorNum[1] + " é igual a " + resultado + "\n")
					}	
				}
		}
		u.aguarde(1000)
		novaOperacao()
	}
	
	funcao inicio() {

		escreva("**************************\n")
		escreva("-----mini-calculadora-----\n")
		escreva("**************************\n")
		para (contador=0; contador <2; contador++){ 
			escreva("Digite o ", contador+1 ,"° número: ")
			leia (vetorPNum[contador])
			verificacaoCaracter()
			vetorNum[contador] = t.cadeia_para_real(vetorPNum[contador])
		}
		limpa()
		menu() 
		
		
	}	

	funcao fim() {
	escreva("Obrigada por usar a mini-calculadora! :)")
	u.aguarde(1000)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 887; 
 * @DOBRAMENTO-CODIGO = [60, 113, 189, 224, 259, 310, 425];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */