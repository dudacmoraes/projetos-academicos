import model.ContaBanco;
import model.TipoConta;
import service.ContaService;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static TipoConta tipoConta = null;
    static String nomeTitular;
    static String entrada;
    static int escolha;

    public static void main(String[] args) {
        System.out.println("Bem vindo ao Banco!");
        ContaService service = new ContaService();

        while (true) {
            System.out.println("[1] Entrar na conta\n[2] Abrir uma conta\n[3] Sair");
            System.out.print("Sua escolha: ");
            entrada = scanner.nextLine();

            if (entrada.trim().isEmpty()) {
                System.out.println("Entrada inválida!");
                continue;
            }

            try {
                escolha = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
                continue;
            }

            if (escolha == 1) {
                int numeroConta;
                System.out.println("Entrar na conta");

                while (true) {
                    ContaBanco conta = null;
                    System.out.print("Número da conta: ");
                    entrada = scanner.nextLine();

                    if (entrada.trim().isEmpty()) {
                        System.out.println("Entrada inválida.");
                        continue;
                    }
                    try {
                        numeroConta = Integer.parseInt(entrada);
                        conta = service.buscarConta(numeroConta);
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida.");
                    }

                    if (conta == null || !conta.isStatusConta()) {
                        System.out.println("Conta inexistente ou encerrada.");
                        break;
                    }

                    while (true) {
                        System.out.println("-".repeat(20));
                        System.out.println(conta);
                        System.out.println("-".repeat(20));

                        System.out.println("[1] Sacar\n[2] Depositar\n[3] Pagar mensalidade\n[4] Encerrar conta\n[5] Sair da conta");
                        System.out.print("Escolha sua ação: ");
                        entrada = scanner.nextLine();

                        if (entrada.trim().isEmpty()) {
                            System.out.println("Entrada inválida.");
                            continue;
                        }

                        try {
                            escolha = Integer.parseInt(entrada);
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida.");
                        }

                        if (escolha == 1) {
                            double valorSaque;
                            System.out.print("Digite o valor do saque: R$");
                            entrada = scanner.nextLine();
                            if (entrada.trim().isEmpty()) {
                                System.out.println("Entrada inválida.");
                                continue;
                            }
                            try {
                                valorSaque = Double.parseDouble(entrada);
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida!");
                                continue;
                            }
                            conta.sacar(valorSaque);

                        } else if (escolha == 2) {
                            double valorDeposito;
                            System.out.print("Valor do depósito: R$");
                            entrada = scanner.nextLine();

                            if (entrada.trim().isEmpty()) {
                                System.out.println("Entrada inválida!");
                                continue;
                            }
                            try {
                                valorDeposito = Double.parseDouble(entrada);
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida!");
                                continue;
                            }
                            conta.depositar(valorDeposito);

                        } else if (escolha == 3) {
                            conta.pagarMensalidade();
                        }
                        else if (escolha == 4) {
                            boolean contaEncerrada = conta.encerrarConta();
                            if (contaEncerrada) {
                                break;
                            }
                        } else if (escolha == 5) {
                            break;
                        } else {
                            System.out.println("Escolha inválida.");
                        }
                    }
                    break;
                }
            } else if (escolha == 2) {
                System.out.println("Abertura de conta");

                while (true) {
                    System.out.print("Digite seu nome completo: ");
                    nomeTitular = scanner.nextLine();

                    if (nomeTitular.trim().isEmpty()) {
                        System.out.println("Entrada inválida.");
                    } else {
                        nomeTitular = nomeTitular.substring(0, 1).toUpperCase() + nomeTitular.substring(1).toLowerCase();

                        boolean verificacaoTexto = nomeTitular.matches("[a-zA-ZÀ-ÿ ]+");

                        if (!verificacaoTexto) {
                            System.out.println("Entrada inválida.");
                        } else {
                            break;
                        }
                    }
                }

                while (true) {
                    System.out.println("[1] Conta corrente\n[2] Conta poupança");
                    System.out.print("Qual o tipo de conta? ");
                    entrada = scanner.nextLine();

                    if (entrada.trim().isEmpty()) {
                        System.out.println("Escolha inválida.");
                        continue;
                    }
                    try {
                        escolha = Integer.parseInt(entrada);
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida.");
                    }

                    if (escolha == 1) {
                        tipoConta = TipoConta.CC;
                    } else if (escolha == 2) {
                        tipoConta = TipoConta.CP;
                    } else {
                        System.out.println("Escolha inválida.");
                        continue;
                    }
                    break;
                }
                service.criarConta(nomeTitular, tipoConta);

            } else if (escolha == 3) {
                System.out.println("Encerrando o programa...");
                break;
            }
        }
    }
}
