import Atividades.*;
import Entidades.Usuario;
import Gerenciadores.Usuarios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DietadExercicios {

    public static void main(String[] args) {

        boolean loop = true;                // Controlador de saída do loop principal
        Scanner entrada = new Scanner(System.in);

        Usuarios gerenciadorDUsuarios = new Usuarios();
        Usuario curUsuario = null;          // Usuario atualmente logado

        // Vars usadas pelo programa para determinadas perguntas
        int     loopResposta = -1;          // Controlador de resposta do switch dentro do loop
        int     IntResposta;                // Para respostas que são int

        // data = {dia, mes, ano}. Padrão e usado para todo o programa
        int[]   data = new int[3];
        int     minuto;                     // Usada para contagem de minutos por atividade

        // Para cadastros de pessoas
        String  nome;
        float   altura;
        float   peso;
        float   gordura;
        float   totaldGordura;              // Total de calorias gastas
        int     tempoTotal;                 // Total de horas gastas

        // Loop principal
        while (loop) {
            // Limpa o terminal e retorna o cursor pro início. Não funciona no console do IDEA
            System.out.print("\033[2J \033[H");

            // Cria um usuário se nenhum existir na lista
            if (curUsuario == null) {
                System.out.println("Nenhum usuário cadastrado");
                loopResposta = 6;  // Pula direto pra opção de criar um novo usuário

            } else if (data[0] == 0) {                  // Cadastro de data
                System.out.println("Data não cadastrada");
                System.out.print("Digite o dia: ");
                while (true) {
                    try {
                        data[0] = entrada.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.print("Digite um dia válido: ");
                        entrada.nextLine();
                    }
                    if (data[0] > 0 && data[0] < 32) {
                        break;
                    } else {
                        System.out.print("Digite um dia válido: ");
                    }
                }

                System.out.print("Digite o mês: ");
                while (true) {
                    try {
                        data[1] = entrada.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.print("Digite um mês válido: ");
                        entrada.nextLine();
                    }
                    if (data[1] > 0 && data[1] < 13) {
                        break;
                    } else {
                        System.out.print("Digite um mês válido: ");
                    }
                }

                System.out.print("Digite o ano: ");
                while (true) {
                    try {
                        data[2] = entrada.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.print("Digite um ano válido: ");
                        entrada.nextLine();
                    }
                    if (data[2] > 2000) {
                        break;
                    } else {
                        System.out.print("Digite um ano válido: ");
                    }
                }
                // End: Cadastro de data
            } else {
                // MENU
                System.out.println("MENU PRINCIPAL: ");

                // Informações da pessoa
                System.out.println(curUsuario.getNome() +
                        ", " + curUsuario.getAltura() + " m, " + curUsuario.getPeso() + " kg");

                System.out.println(data[0] + "/" + data[1] + "/" + data[2]);
                System.out.print("IMC: ");
                System.out.printf("%1.2f", curUsuario.getIMC());
                System.out.println(", " + curUsuario.getStatus());
                System.out.println("1 - Registrar atividade");
                System.out.println("2 - Resumo diário");
                System.out.println("3 - Ver atividades de hoje");
                System.out.println("4 - Ver todas atividades");
                System.out.println("5 - Terminar dia\n");
                System.out.println("-----USUÁRIOS-----");
                System.out.println("6 - Adicionar usuário");
                System.out.println("7 - Listar usuários");
                System.out.println("8 - Selecionar usuário");
                System.out.println("9 - Remover usuário");
                System.out.println("0 - Sair");

                System.out.print("Selecione uma opção: ");
                // Tenta pegar um número se ele já não tiver sido escolhido
                while (true) {
                    try {
                        loopResposta = entrada.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        // Retorna para pessoa e limpa o buf;
                        System.out.println("Digite um número válido: ");
                        entrada.nextLine();
                    }
                }
            }

            // Processamento do menu
            switch (loopResposta) {
                case 1 -> { // Registrar atividade
                    System.out.println("Selecione uma atividade: ");
                    System.out.println("1 - Corrida");
                    System.out.println("2 - Malhação");
                    System.out.println("3 - Levantamento de peso");
                    System.out.println("4 - Caminhada");
                    System.out.println("5 - Pedalada");
                    System.out.println("6 - Dança");
                    while (true) {
                        try {
                            IntResposta = entrada.nextInt();
                            if (IntResposta < 1 || IntResposta > 6) {
                                System.out.println("Digite uma opção válida");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("Digite um número válido: ");
                            entrada.nextLine();
                        }
                    }
                    System.out.print("Digite um nome específico para a tarefa: ");
                    nome = entrada.next();
                    System.out.print("Digite a quantidade de horas que a tarefa foi feita: ");
                    while (true) {
                        try {
                            minuto = entrada.nextInt() * 60;
                            break;
                        } catch (InputMismatchException e) {
                            System.out.print("Digite um número: ");
                            entrada.nextLine();
                        }
                    }
                    System.out.print("Digite a quantidade de minutos que a tarefa foi feita: ");
                    while (true) {
                        try {
                            minuto += entrada.nextInt(); // é somado com as horas
                            break;
                        } catch (InputMismatchException e) {
                            System.out.print("Digite um número: ");
                            entrada.nextLine();
                        }
                    }
                    switch (IntResposta) {
                        case 1 -> curUsuario.addAtividade(new Corrida(nome, data, minuto));
                        case 2 -> curUsuario.addAtividade(new Malhacao(nome, data, minuto));
                        case 3 -> curUsuario.addAtividade(new Levantamento(nome, data, minuto));
                        case 4 -> curUsuario.addAtividade(new Caminhada(nome, data, minuto));
                        case 5 -> curUsuario.addAtividade(new Pedalada(nome, data, minuto));
                        case 6 -> curUsuario.addAtividade(new Danca(nome, data, minuto));
                        default -> System.out.println("Atividade não existente");
                    }
                    System.out.println("Tarefa criada com sucesso");
                    entrada.nextLine();
                }
                case 2 -> { // Relatório do dia
                    if (curUsuario.getQuantAtividades() == 0) {
                        System.out.println("Nenhuma atividade cadastrada");
                        entrada.nextLine();
                        break;
                    }

                    // Reseta os status para soma
                    totaldGordura = 0;
                    tempoTotal = 0;
                    System.out.println("Relatório do dia " + data[0] + "/" + data[1] + "/" + data[2]);
                    for (Atividade a : curUsuario.getAtividades(data)) {
                        a.updateGastoCaloricoAprox();

                        // Soma os dois status
                        totaldGordura += a.getGastoCaloricoAprox();
                        tempoTotal += a.getTempo();

                        System.out.println(a);
                    }
                    System.out.println("Gasto calórico total: " + totaldGordura);
                    System.out.println("Tempo total gasto: " + tempoTotal + " minutos");
                    entrada.nextLine();
                }
                case 3 -> { // Ver atividades de hoje
                    if (curUsuario.getQuantAtividades() == 0) {
                        System.out.println("Nenhuma atividade cadastrada");
                        entrada.nextLine();
                        break;
                    }
                    System.out.println("Atividades cadastradas hoje: ");
                    for (Atividade a : curUsuario.getAtividades(data)) {
                        System.out.println(a);
                    }
                    entrada.nextLine();
                }
                case 4 -> { // Ver todas as atividades
                    if (curUsuario.getQuantAtividades() == 0) {
                        System.out.println("Nenhuma atividade cadastrada");
                        entrada.nextLine();
                        break;
                    }
                    System.out.println("Atividades cadastradas:");
                    for (int i = 0; i < curUsuario.getQuantAtividades(); i++) {
                        System.out.println("No dia " +
                                curUsuario.getAtividade(i).getData()[0] + "/" +
                                curUsuario.getAtividade(i).getData()[1] + "/" +
                                curUsuario.getAtividade(i).getData()[2] + ":");
                        System.out.println(curUsuario.getAtividade(i));
                    }
                    entrada.nextLine();
                }
                case 5 -> { // Terminar dia
                    System.out.println("Terminando dia  " + data[0] + "/" + data[1] + "/" + data[2]);
                    if (curUsuario.getQuantAtividades() > 0) {
                        System.out.println("Atividades do dia: ");
                        totaldGordura = 0;
                        tempoTotal = 0;
                        for (Atividade a : curUsuario.getAtividades(data)) {
                            a.updateGastoCaloricoAprox();
                            totaldGordura += a.getGastoCaloricoAprox();
                            tempoTotal += a.getTempo();
                            System.out.println(a);
                        }
                        System.out.println("Gasto calórico total: " + totaldGordura + " calorias");
                        System.out.println("Tempo total gasto: " + tempoTotal + " minutos");
                    }
                    data[0] = 0; // Reinicia o sistema de data
                    entrada.nextLine();
                }
                case 6 -> { // Adicionar usuário
                    System.out.println("Cadastrando novo usuário");
                    System.out.print("Digite o nome do usuário: ");
                    nome = entrada.next();

                    // altura
                    System.out.print("Digite a altura de " + nome + " em metros: ");
                    while (true) {  // Loop anti-falhas
                        try {
                            altura = entrada.nextFloat();
                            if (altura > 0) {
                                break;
                            } else {
                                System.out.print("Sua altura deve ser maior que 0: ");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("Digite um número: ");
                            entrada.nextLine();
                        }
                    }

                    // peso
                    System.out.print("Digite o peso de " + nome + " em kg: ");
                    while (true) {
                        try {
                            peso = entrada.nextFloat();
                            if (peso > 0) {
                                break;
                            } else {
                                System.out.print("Seu peso não pode ser 0: ");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("Digite um número: ");
                            entrada.nextLine();
                        }
                    }

                    // Gordura
                    System.out.print("Digite a % de gordura de " + nome + ": ");
                    while (true) {
                        try {
                            gordura = entrada.nextFloat();
                            if (gordura > 0) {
                                break;
                            } else {
                                System.out.print("Você não tem 0 de gordura: ");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("Digite um número: ");
                            entrada.nextLine();
                        }
                    }
                    gerenciadorDUsuarios.createUsuario(nome, altura, peso, gordura);
                    if (curUsuario == null) {
                        curUsuario = gerenciadorDUsuarios.getUsuario(nome);
                    }
                    System.out.println("Usuário criado com sucesso!");
                    entrada.nextLine();
                }
                case 7 -> { // Listar usuários
                    if (gerenciadorDUsuarios.getQuantUsuarios() == 0) {
                        System.out.println("Nenhum usuário cadastrado");
                        entrada.nextLine();
                        break;
                    }
                    System.out.println("Lista de usuários: ");
                    for (int i = 0; i < gerenciadorDUsuarios.getQuantUsuarios(); i++) {
                        System.out.println(i + "-" + gerenciadorDUsuarios.getUsuario(i));
                    }
                    entrada.nextLine();
                }
                case 8 -> { // Selecionar usuário
                    if (gerenciadorDUsuarios.getQuantUsuarios() == 0) {
                        System.out.println("Nenhum usuário cadastrado");
                        entrada.nextLine();
                        break;
                    }
                    System.out.println("Lista de usuários: ");
                    for (int i = 0; i < gerenciadorDUsuarios.getQuantUsuarios(); i++) {
                        System.out.println(i + "-" + gerenciadorDUsuarios.getUsuario(i));
                    }
                    System.out.print("Digite o numero do usuário:");
                    while (true) {
                        try {
                            IntResposta = entrada.nextInt();
                            if (IntResposta < gerenciadorDUsuarios.getQuantUsuarios()) {
                                break;
                            } else {
                                System.out.print("Digite um número válido: ");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("Digite um número válido: ");
                            entrada.nextLine();
                        }
                    }
                    curUsuario = gerenciadorDUsuarios.getUsuario(IntResposta);
                    System.out.println("Usuário " + curUsuario.getNome() + " selecionado");
                    entrada.nextLine();
                }
                case 9 -> {
                    if (gerenciadorDUsuarios.getQuantUsuarios() == 0) {
                        System.out.println("Nenhum usuário cadastrado");
                        entrada.nextLine();
                        break;
                    }
                    System.out.println("Lista de usuários: ");
                    for (int i = 0; i < gerenciadorDUsuarios.getQuantUsuarios(); i++) {
                        System.out.println(i + "-" + gerenciadorDUsuarios.getUsuario(i));
                    }
                    System.out.print("Digite o numero do usuário:");
                    while (true) {
                        try {
                            IntResposta = entrada.nextInt();
                            if (IntResposta <= gerenciadorDUsuarios.getQuantUsuarios()) {
                                break;
                            } else {
                                System.out.print("Digite um número válido: ");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("Digite um número válido: ");
                            entrada.nextLine();
                        }
                    }
                    nome = gerenciadorDUsuarios.getUsuario(IntResposta).getNome();
                    if (gerenciadorDUsuarios.getUsuario(IntResposta) == curUsuario) {
                        curUsuario = null;
                    }
                    gerenciadorDUsuarios.removerUsuario(IntResposta);
                    System.out.println("Usuário " + nome + " removido");
                    entrada.nextLine();
                }
                case 0 -> // Sai do programa
                        loop = false;
            }
            if (loop) {
                System.out.print("Pressione enter para continuar: ");
                entrada.nextLine();
                loopResposta = -1; // Retorna para o valor original
            }
        }
    }
}