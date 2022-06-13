package exercicios;

import java.util.Scanner;

public class RelatórioDeNotas {
	    
	    public static String [] NomesEstudantes (int QuantidadeEstudantes, Scanner input) {
	        String [] nomes = new String [QuantidadeEstudantes];

	        for (int i = 0; i < QuantidadeEstudantes; i++) {
	            System.out.print("Nome do(a) aluno(a): ");
	            nomes[i] = input.next();
	        }

	        System.out.print("\n");

	        return nomes;
	    }

	    public static double [] [] NotasEstudantes (String [] Estudantes, int QuantidadeProvas, Scanner input) {
	        double [] [] notas = new double [Estudantes.length] [QuantidadeProvas + 1];

	        for (int i = 0; i < Estudantes.length; i++) {
	            for (int j = 0; j < QuantidadeProvas; j++) {
	                System.out.printf("A %dª nota de \"%s\" é: ", (j + 1), Estudantes[i]);
	                notas[i][j] = input.nextDouble();

	                while (notas[i][j] < 0.0 || notas[i][j] > 10.0) {
	                    System.out.print("Nota inválida! Tente novamente: ");
	                    notas[i][j] = input.nextDouble();
	                }
	            }

	            System.out.print("\n");
	        }

	        System.out.print("\n");

	        return notas;
	    }

	    public static double [] Media (double [] [] notas, int QuantidadeProvas) {
	        double [] medias = new double [notas.length];

	        for (int i = 0; i < notas.length; i++) {
	            double Número = 0;

	            for (int j = 0; j < QuantidadeProvas; j++) {
	                Número += notas[i][j];
	            }

	            medias[i] = (Número / QuantidadeProvas);
	        }

	        return medias;
	    }

	    public static String [] Resultado (double [] Media, double Limite) {
	        String [] resultado = new String [Media.length];

	        for (int i = 0; i < Media.length; i++) {
	            if (Media[i] < Limite) {
	                resultado[i] = "REPROVADO";
	            } else {
	                resultado[i] = "APROVADO";
	            }
	        }

	        return resultado;
	    }

	    public static String [] Tabela (int QuantidadeProvas) {
	        String [] Tópicos = new String [QuantidadeProvas + 3];

	        Tópicos[0] = "Nome";
	        Tópicos[QuantidadeProvas + 1] = "Média";
	        Tópicos[QuantidadeProvas + 2] = "Situação";

	        for (int i = 1; i <= QuantidadeProvas; i++) {
	            Tópicos[i] = "Nota" + i;
	        }

	        return Tópicos;
	    }

	    public static void Preencher (int QuantidadeEstudantes, int QuantidadeProvas, double Limite, Scanner input) {
	        String [] Tópicos = Tabela(QuantidadeProvas);
	        String [] Estudantes = NomesEstudantes(QuantidadeEstudantes, input);
	        double [] [] notas = NotasEstudantes(Estudantes, QuantidadeProvas, input);
	        double [] Media = Media(notas, QuantidadeProvas);
	        String [] resultado = Resultado(Media, Limite);

	        String [] [] tabela1 = new String [QuantidadeEstudantes + 1] [Tópicos.length];

	        for (int i = 0; i < Tópicos.length; i++) {
	            tabela1[0][i] = Tópicos[i];
	        }

	        for (int i = 1; i <= QuantidadeEstudantes; i++) {
	        	tabela1[i][0] = Estudantes[i - 1];
	        	tabela1[i][QuantidadeProvas + 1] = Double.toString(Math.round(Media[i - 1] * 10.0) / 10.0);
	        	tabela1[i][QuantidadeProvas + 2] = resultado[i - 1];

	            for (int j = 0; j < QuantidadeProvas; j++) {
	                tabela1[i][j + 1] = Double.toString(notas[i - 1][j]);
	            }
	        }

	        Mostrar(tabela1);

	        Mostrar2(Media, resultado, QuantidadeEstudantes);
	    }

	    public static void Mostrar (String [] [] tabela1) {
	        for (int i = 0; i < tabela1.length; i++) {
	            System.out.print("\n");

	            for (int j = 0; j < tabela1[i].length; j++) {
	                System.out.print(tabela1[i][j] + "\t");
	            }

	            if (i == 0) {
	                System.out.print("\n");
	            }
	        }
	    }

	    public static void Mostrar2 (double [] Media, String [] resultado, int QuantidadeEstudantes) {
	        double MediaTurma = 0;
	        int contando = 0;

	        for (int i = 0; i < QuantidadeEstudantes; i++) {
	            MediaTurma += Media[i];

	            if (resultado[i].matches("APROVADO")) {
	                contando++;
	            }
	        }

	        System.out.println(
	            "\n\nMédia da turma: " + Math.round((MediaTurma / QuantidadeEstudantes) * 10.0) / 10.0 +
	            "\nPercentual de aprovados: " + Math.round((contando * 100.0 / QuantidadeEstudantes) * 100.0) / 100.0 + "%" +
	            "\nPercentual de reprovados: " + Math.round(((QuantidadeEstudantes - contando) * 100.0 / QuantidadeEstudantes) * 100.0) / 100.0 + "%"
	        );
	    }

	    public static void main(String[] args) {

	        Scanner input = new Scanner (System.in);

	        System.out.print("\n>> Sistema de Relatório de Notas <<");
	        System.out.print("\nInforme a quantidade de alunos: ");
	        int QuantidadeEstudantes = input.nextInt();

	        System.out.print("\nObrigado! Agora informe quantas provas foram feitas: ");
	        int QuantidadeProvas = input.nextInt();

	        System.out.print("\nEstamos quase acabando! Informe a nota de corte: ");
	        double Limite = input.nextDouble();
	        System.out.print("\n");

	        Preencher(QuantidadeEstudantes, QuantidadeProvas, Limite, input);
	    }
}
