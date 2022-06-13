package exercicios;

import java.util.Arrays;
import java.util.Random;

public class OrdenarVetor {

	    public static int [] criarVetor (int tamanho) {
	        Random r = new Random();

	        int [] vetor = new int [tamanho];

	        for (int i = 0; i < tamanho; i++) {
	            vetor[i] = r.nextInt(101);
	        }

	        return vetor;
	    }

	    public static int [] vetorMaiorMenor (int [] vetor) {
	        int [] vetorOrdenado = new int [vetor.length];
	        int index = 0;

	        int maiorValor;

	        do {
	            maiorValor = Integer.MIN_VALUE;

	            for (int i = 0; i < vetor.length; i++) {
	                if (vetor[i] > maiorValor) {
	                    maiorValor = vetor[i];
	                }
	            }

	            vetorOrdenado[index] = maiorValor;
	            index++;

	            for (int i = 0; i < vetor.length; i++) {
	                if (vetor[i] == maiorValor) {
	                    vetor[i] = Integer.MIN_VALUE;
	                    break;
	                }
	            }
	        } while (index < vetorOrdenado.length);

	        return vetorOrdenado;
	    }

	    public static void main(String[] args) {

	        int [] vetor = criarVetor(10);

	        System.out.println("\nVetor original:");
	        System.out.println(Arrays.toString(vetor));

	        System.out.println("\nVetor em ordem decrescente:");
	        System.out.println(Arrays.toString(vetorMaiorMenor(vetor)));
	    }
}
