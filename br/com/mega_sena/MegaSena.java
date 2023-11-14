package br.com.mega_sena;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MegaSena {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		int[] numeros = new int[7];
		int contador = 1;
		int posicao = 0;
		int pontuacao = 0;
		Random sorteio = new Random();
		int[] sorteados = new int[7];
		int i = 1;
		
		System.out.println("--------------------------");
		System.out.println("BEM VINDO(A) AO MEGA SENA");
		System.out.println("--------------------------");
		System.out.println("Para participar é preciso escolher 7 números entre 0 a 100.");
		System.out.println("");
		

		do {
			
			try {
				// Recebimento dos 7 valores digitados pelo usuario
				System.out.println("Por favor digite o " + contador + "° número: ");
				numeros[6] = entrada.nextInt();				
				
				// Se  o número for maior ou igual a 0 e menor ou igual a 100, atribua o valor ao vetor
				if (numeros[6] >= 0 && numeros[6] <= 100) {
					numeros[posicao] = numeros[6];
					posicao++;
					
				} else {
					System.out.println("O número digitado é inválido, por favor digite um número inteiro entre 0 e 100");
					--contador;
				}
			
			// Captura a exceção e emite uma mensagem ao usuario
			} catch (InputMismatchException erro) {
				System.out.println("O número digitado é inválido, por favor digite um número inteiro entre 0 e 100");
				
				// Evita o looping e subrai o contador enquanto permanecer na exceção
				entrada.nextLine();
				--contador;

			}
			
			contador++;
		} while (contador < 8);
					
		// Fecha o scanner
		entrada.close();
		
		System.out.println("---------------------------------------------------");
		System.out.println("BEM VINDO(A) AO RESULTADO DO SORTEIO DA MEGA SENA");
		System.out.println("---------------------------------------------------");
		
		// Faz o sorteio dos números inteiros de 0 a 100 e atribui a um vetor
		for (int x = 0; x < 7; x++) {
			sorteados[x] = sorteio.nextInt(100);
			
			i++; // Imprime os números sorteados
			System.out.println("O " + i +"° número sorteado é: " + sorteados[x]);
			--i;
		}
		
		
		System.out.println("----------------------------------------------------");
		System.out.println("BEM VINDO(A) AO RESULTADO DA PREMIAÇÃO DA MEGA SENA");
		System.out.println("----------------------------------------------------");		
		
		// Verifica posição por posição dos vetor1 e do vetor2
		for (int k = 0; k < 7; k++) {			
			for (int j = 0; j < 7; j++) {
				
				if (numeros[k] == sorteados[j]) {
					pontuacao++;
				}
			}	
		}
		
		// Faz a verificação da pontuação
		if (pontuacao == 5) {
			
			System.out.println("Parabéns você acentou " + pontuacao);
			System.out.println("Você ganhou 10 mil reais !!!");
			
		} else if (pontuacao == 6) {
			
			System.out.println("Parabéns você acentou " + pontuacao);
			System.out.println("Você ganhou 50 mil reais !!!");
			
		} else if (pontuacao >= 7) {
			
			System.out.println("Parabéns você acentou " + pontuacao);
			System.out.println("Você ganhou 200 mil reais !!!");
		} else {
			System.out.println("A pontuação é: " + pontuacao);
			System.out.println("Que pena, mas continue tentando sua sorte pode mudar !");
		}
		
	}

}
