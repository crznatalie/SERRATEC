/*
Um aluno, chamado Zé;
recebe duas notas;
o sistema calcula a média;
apresenta as notas e a média.

//tratar números negativos -------------------------------------------------------------------------------------------------------
//tratar números maiores que 10 --------------------------------------------------------------------------------------------------
//tratar caracteres diferentes de números ----------------------------------------------------------------------------------------
//tratar o "enter"    ------------------------------------------------------------------------------------------------------------
//arredondar as notas para 2 casa decimal-----------------------------------------------------------------------------------------
//arredondar a média para 1 casa  ------------------------------------------------------------------------------------------------
//caso o ponto flutuante da média seja >= 8, arredondar para o inteiro imediatamente superior-------------------------------------
//caso o ponto flutuante da média seja <= 2, arredondar para o inteiro imediatamente inferior-------------------------------------*/
programa
{
    inclua biblioteca Tipos --> t
    inclua biblioteca Matematica --> m
    inclua biblioteca Texto --> tex
    inclua biblioteca Util --> u
   
    const cadeia aluno = "Zé"
    cadeia notaD[2]
    caracter numD = 'a'
    logico verificaND = verdadeiro
    real notaR[2], notaRa[2]
    inteiro contagem = 0, verificaN[2]
   
    funcao inicio()
    {
        para(contagem = 0; contagem < 2; contagem++){
            escreva("Digite a ", contagem + 1, "ª nota: ")
            leia(notaD[contagem])
            limpa()
            verifCaracter()
            verificaMaior ()
        }
            limpa()
            calculo()
    }
    funcao verifCaracter(){
        se (notaD[contagem] == "" ou notaD[contagem] == " " ou notaD[contagem] == "--") {
            limpa()
            escreva ("Valor nulo. Por favor, tente novamente.\n")
            u.aguarde(1000)
            limpa()
            inicio()
        }
        senao{
            para(inteiro i = 0; i <= tex.numero_caracteres(notaD[contagem]) - 1; i++){
                numD = tex.obter_caracter(notaD[contagem], i)
                se (numD == '0' ou numD == '1' ou numD == '2' ou numD == '3' ou numD == '4' ou numD == '5'
                    ou numD == '6' ou numD == '7' ou numD == '8' ou numD == '9' ou numD == '.'){
                    verificaND = verdadeiro
                    verificaMaior ()
                }
                senao {
                    verificaND = falso
                    enquanto(verificaND == falso){
                        limpa()
                        escreva("Notas Inválidas, tente novamente\n\n")
                        u.aguarde(2000)
                        limpa()
                        inicio()
                        para( i = 0; i <= tex.numero_caracteres(notaD[contagem]) - 1; i++){
                            numD = tex.obter_caracter(notaD[contagem], i)
                            se (numD == '0' ou numD == '1' ou numD == '2' ou numD == '3' ou numD == '4' ou numD == '5'
                                ou numD == '6' ou numD == '7' ou numD == '8' ou numD == '9' ou numD == '.'){
                                verificaND = verdadeiro
                                limpa()
                                calculo()
                            }
                            senao{
                            verificaND = falso
                            }
                        }
                    }
                }
            }
        }
    }

    funcao calculo(){
        real  media = 0.0, soma = 0.0, mediaF = 0.0, somaF = 0.0
        inteiro verificaR = 0

        notaR[0] = t.cadeia_para_real(notaD[0])
        notaR[1] = t.cadeia_para_real(notaD[1])
        notaRa[0] = m.arredondar(notaR[0], 2)
        notaRa[1] = m.arredondar(notaR[1], 2)
        soma = notaRa[0] + notaRa[1]
        somaF = m.arredondar(soma, 2)
        media = (notaRa[0] + notaRa[1]) / 2
        mediaF = m.arredondar(media, 1)

        escreva(notaRa[0], " + ", notaRa[1], " = ", somaF, " ÷  2  = ", mediaF)
        verificaR = t.real_para_inteiro(media*10)
            se(verificaR % 10 >= 8){
                mediaF = m.arredondar(media, 0)
                escreva("\n\nA média de Zé foi: ", mediaF, "\n\n")
            }
                senao se(verificaR % 10 <= 2){
                    mediaF = m.arredondar(media, 0)
                    escreva("\n\nA média de Zé foi: ", mediaF, "\n\n")
                } senao se(verificaR % 10 > 2 ou verificaR % 10 <8){
                	escreva("\n\nA média de Zé foi: ", mediaF, "\n\n")
                }
            u.aguarde(5000)
        limpa()
        fim()
    }

    funcao verificaMaior () {
        real valor
        logico maiorQ10 = falso
        valor = t.cadeia_para_real(notaD[contagem])
        se (valor> 10) {
            maiorQ10 = verdadeiro
            enquanto (maiorQ10 == verdadeiro) {
            escreva ("Valor inválido. Voltando ao início.\n")
            u.aguarde(1000)
            limpa()
            escreva ("Valor inválido. Voltando ao início. .\n")
            u.aguarde(1000)
            limpa()escreva ("Valor inválido. Voltando ao início. . .\n")
            u.aguarde(1000)
            limpa()
            inicio()
            }
        }
        senao{
            maiorQ10 = falso
        }
    }
   
    funcao fim(){
        caracter resp

        limpa()
        escreva("Deseja reiniciar? (S/N): ")
        leia(resp)
        escolha(resp){
            caso 'S':
            limpa()
            inicio()
            caso 's':
            limpa()
            inicio()
            caso 'N':
            limpa()
            escreva("Muito obrigado por utilizar o nosso programa.")
            u.aguarde(1500)
            escreva("Até a próxima!")
            u.aguarde(2500)
            pare
            caso 'n':
            limpa()
            escreva("Muito obrigado por utilizar o nosso programa.\n\n")
            u.aguarde(1500)
            escreva("Até a próxima!\n\n")
            u.aguarde(2500)
            pare
        }
    }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 4643; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */