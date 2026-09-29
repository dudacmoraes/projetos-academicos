package service;
import model.ContaBanco;
import model.TipoConta;

import java.util.ArrayList;

public class ContaService {
    private final ArrayList<ContaBanco> listaContas = new ArrayList<>();

    public void criarConta(String nomeTitular, TipoConta tipoConta) {
        ContaBanco conta = new ContaBanco(tipoConta, nomeTitular);
        conta.abrirConta();
        listaContas.add(conta);
    }

    public ContaBanco buscarConta(int numeroConta) {
        ContaBanco conta = null;
        for (ContaBanco cadaConta : listaContas) {
            if (cadaConta.getNumeroConta() == numeroConta) {
                conta = cadaConta;
            }
        }
        if (conta == null || !conta.isStatusConta()) {
            System.out.println("Conta inexistente ou encerrada.");
        }
        return null;
    }
}

