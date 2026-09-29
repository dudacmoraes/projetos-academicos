package model;

public class ContaBanco {
    // Atributos
    private final int numeroConta;
    private static int proximoNumero = 1;
    private final TipoConta tipoConta;
    private final String nomeTitular;
    private double saldoAtual;
    private boolean statusConta;
    private int valorMensalidade;

    // Construtor
    public ContaBanco(TipoConta tipoConta, String nomeTitular) {
        this.numeroConta = proximoNumero++;
        this.tipoConta = tipoConta;
        this.nomeTitular = nomeTitular;
    }

    // Formatação
    @Override
    public String toString() {
        String descricaoTipo;
        String descricaoStatus;

        if (tipoConta == TipoConta.CC) {
            descricaoTipo = "Conta corrente";
        } else {
            descricaoTipo = "Conta poupança";
        }

        if (statusConta) {
            descricaoStatus = "Aberta";
        } else {
            descricaoStatus = "Encerrada";
        }
        return String.format("Número da conta: %d\nStatus: %s\nTitular: %s\nTipo de conta: %s\nSaldo: R$%.2f", numeroConta, descricaoStatus, nomeTitular, descricaoTipo, saldoAtual);
    }

    // Getters
    public int getNumeroConta() {
        return numeroConta;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public boolean isStatusConta() {
        return statusConta;
    }

    public void abrirConta() {
        if (!statusConta) {
            statusConta = true;
            if (tipoConta == TipoConta.CC) {
                valorMensalidade = 15;
            } else if (tipoConta == TipoConta.CP) {
                valorMensalidade = 20;
            }
        }
    }

    public void depositar(double valorDeposito) {
        if (statusConta) {
            if (valorDeposito > 0) {
                saldoAtual += valorDeposito;
                System.out.println("Depósito realizado!");
            } else {
                System.out.println("Valor inválido.");
            }
        } else {
            System.out.println("Conta inexistente ou encerrada.");
        }
    }

    public void sacar(double valorSaque) {
        if (statusConta) {
            if (saldoAtual >= valorSaque) {
                if (valorSaque > 0) {
                    saldoAtual -= valorSaque;
                    System.out.println("Saque realizado!");
                } else {
                    System.out.println("Valor inválido.");
                }
            } else {
                System.out.println("Valor insuficiente para o saque desejado.");
            }
        } else  {
            System.out.println("Conta inexistente ou encerrada.");
        }
    }

    public void pagarMensalidade() {
        if (statusConta) {
            saldoAtual -= valorMensalidade;
            if (saldoAtual < 0) {
                System.out.println("Aviso! Você está negativado!");
            } else {
                System.out.println("Mensalidade paga!");
            }
        } else {
            System.out.println("Conta inexistente ou encerrada.");
        }
    }

    public boolean encerrarConta() {
        if (statusConta) {
            if (saldoAtual > 0) {
                System.out.println("Você não pode encerrar a conta com saldo.");
                return false;
            } else if (saldoAtual < 0) {
                System.out.println("Você não pode encerrar a conta negativada.");
                return false;
            } else {
                statusConta = false;
                System.out.println("Conta encerrada.");
                return true;
            }
        } else {
            System.out.println("Conta inexistente ou encerrada.");
        }
        return false;
    }
}
