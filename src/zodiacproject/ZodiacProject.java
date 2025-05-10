/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zodiacproject;

import java.util.Calendar;
import java.util.Scanner;

public class ZodiacProject {

    public static void main(String[] args) {

        String nome, sexo, saudacao, cor, azul, vermelho, verde, preto,
                branco, amarelo, roxo, laranja, Sr, Sra, signo, aries, touro,
                sagitario, gemeos, cancer, leao, virgem, libra, escorpiao, aquario, peixes;
        int codigoSexo, idade, diaNascimento = 0, mesNascimento = 0, anoNascimento = 0,
                diaAtual, mesAtual, anoAtual, numeroSorte, numCor;

        Scanner ler = new Scanner(System.in);

//sessão de identificação
        System.out.println("Informe seu nome:");
        nome = ler.nextLine();

// Remove caracteres especiais
        if (!nome.matches("[a-zA-ZáéíóúÁÉÍÓÚãõÃÕâêîôûÂÊÎÔÛçÇ\\s]+") || nome.length() < 8) {
            System.out.println("Nome inválido. Use apenas letras e espaços, com no mínimo 8 caracteres.");
            System.exit(0);
        }

// Normaliza cada palavra do nome: primeira letra maiúscula, resto minúsculo
        String[] palavras = nome.trim().toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();

        for (String palavra : palavras) {
            if (palavra.length() > 0) {
                nomeFormatado.append(Character.toUpperCase(palavra.charAt(0)))
                        .append(palavra.substring(1))
                        .append(" ");
            }
        }

        nome = nomeFormatado.toString().trim(); // Atualiza com nome formatado

//sessão "biológica"
        System.out.println("Informe seu sexo, sendo 1 para feminino e 2 para masculino:");
        codigoSexo = ler.nextInt(); //"codigoSexo" informação a ser digitada e "sexo" a informação armazenada
        if (codigoSexo == 1) {
            sexo = "feminino";
            saudacao = "Sra.";
        } else if (codigoSexo == 2) {
            sexo = "masculino";
            saudacao = "Sr.";
        } else {
            sexo = "masculino";
            saudacao = "Sr.";
        }
//sessão de datas

        boolean dataValida = false;
        while (!dataValida) {
            System.out.print("Informe o dia de nascimento: ");
            diaNascimento = ler.nextInt();
            System.out.print("Informe o mês de nascimento (1-12): ");
            mesNascimento = ler.nextInt();
            System.out.print("Informe o ano de nascimento: ");
            anoNascimento = ler.nextInt();

            if (anoNascimento < 1900 || anoNascimento > Calendar.getInstance().get(Calendar.YEAR)) {
                System.out.println("Ano inválido. Deve estar entre 1900 e o ano atual.");
                continue; // Volta para o começo do laço
            }
            // Verifica se o ano é bissexto
            boolean bissexto = (anoNascimento % 4 == 0 && anoNascimento % 100 != 0) || (anoNascimento % 400 == 0);
            int[] diasPorMes = {31, (bissexto ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (mesNascimento >= 1 && mesNascimento <= 12) {
                if (diaNascimento >= 1 && diaNascimento <= diasPorMes[mesNascimento - 1]) {
                    dataValida = true;
                } else {
                    System.out.println("Dia inválido para o mês informado.");
                }
            } else {
                System.out.println("Data inválida, escreva corretamente!!.");
            }
        }

        Calendar hoje = Calendar.getInstance();
        diaAtual = hoje.get(Calendar.DATE);
        mesAtual = hoje.get(Calendar.MONTH) + 1;
        anoAtual = hoje.get(Calendar.YEAR);
        idade = anoAtual - anoNascimento;
        if (mesNascimento > mesAtual || (mesNascimento == mesAtual && diaNascimento > diaAtual)) {
            idade--;
        }

// Se a idade ficou negativa, significa que a data é no futuro
        if (idade <= 0) {
            System.out.println("Data inválida."); //caso algum espertinho tente digitar q nasceu no ano atual, será barrado
            System.exit(0);
        }
        boolean bissexto = (anoNascimento % 4 == 0 && anoNascimento % 100 != 0) || (anoNascimento % 400 == 0); //verificação AnoBissexto

//sessão do zodíaco
        signo = "";
        if ((diaNascimento >= 21 && mesNascimento == 3) || (diaNascimento <= 19 && mesNascimento == 4)) {
            signo = "Áries";
        } else if ((diaNascimento >= 20 && mesNascimento == 4) || (diaNascimento <= 20 && mesNascimento == 5)) {
            signo = "Touro";
        } else if ((diaNascimento >= 21 && mesNascimento == 5) || (diaNascimento <= 20 && mesNascimento == 6)) {
            signo = "Gêmeos";
        } else if ((diaNascimento >= 21 && mesNascimento == 6) || (diaNascimento <= 22 && mesNascimento == 7)) {
            signo = "Câncer";
        } else if ((diaNascimento >= 23 && mesNascimento == 7) || (diaNascimento <= 22 && mesNascimento == 8)) {
            signo = "Leão";
        } else if ((diaNascimento >= 23 && mesNascimento == 8) || (diaNascimento <= 22 && mesNascimento == 9)) {
            signo = "Virgem";
        } else if ((diaNascimento >= 23 && mesNascimento == 9) || (diaNascimento <= 22 && mesNascimento == 10)) {
            signo = "Libra";
        } else if ((diaNascimento >= 23 && mesNascimento == 10) || (diaNascimento <= 21 && mesNascimento == 11)) {
            signo = "Escorpião";
        } else if ((diaNascimento >= 22 && mesNascimento == 11) || (diaNascimento <= 21 && mesNascimento == 12)) {
            signo = "Sagitário";
        } else if ((diaNascimento >= 22 && mesNascimento == 12) || (diaNascimento <= 19 && mesNascimento == 1)) {
            signo = "Capricórnio";
        } else if ((diaNascimento >= 20 && mesNascimento == 1) || (diaNascimento <= 18 && mesNascimento == 2)) {
            signo = "Aquário";
        } else if ((diaNascimento >= 19 && mesNascimento == 2 && !bissexto)
                || (diaNascimento >= 20 && mesNascimento == 2 && bissexto)
                || (diaNascimento <= 20 && mesNascimento == 3)) {
            signo = "Peixes";
        }

//sessão de números da sorte
        numeroSorte = 1 + (int) (Math.random() * 99);

//sessão de cores  da sorte        
        numCor = 1 + (int) (Math.random() * 5);
        cor = "azul";
        switch (numCor) {
            case 1:
                cor = "vermelho";
                break;
            case 2:
                cor = "verde";
                break;
            case 3:
                cor = "preto";
                break;
            case 4:
                cor = "branco";
                break;
            case 5:
                cor = "amarelo";
                break;
            case 6:
                cor = "roxo";
                break;
            case 7:
                cor = "laranja";
                break;
        }

        //saídas           
        System.out.println("Olá " + saudacao + nome + " você nasceu em " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + ", tem " + idade + " ano(s), seu signo é de " + signo + ", seu número da sorte é " + numeroSorte + " e sua cor da sorte é " + cor + " !!");

    }

}
