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
        for (ContaBanco conta : listaContas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}

