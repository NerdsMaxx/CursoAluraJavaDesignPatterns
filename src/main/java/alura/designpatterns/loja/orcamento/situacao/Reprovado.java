package alura.designpatterns.loja.orcamento.situacao;

import alura.designpatterns.loja.orcamento.Orcamento;

public class Reprovado extends SituacaoOrcamento{
    
    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacaoOrcamento(new Finalizado());
    }
}