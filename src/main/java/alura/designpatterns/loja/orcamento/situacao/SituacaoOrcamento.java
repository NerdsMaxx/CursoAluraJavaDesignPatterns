package alura.designpatterns.loja.orcamento.situacao;

import alura.designpatterns.loja.DomainException;
import alura.designpatterns.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class SituacaoOrcamento {
    
    private static final String FRASE_INICIAL = "O orçamento não pode ser ";
    
    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }

    public void aprovar(Orcamento orcamento) {
        throw new DomainException(FRASE_INICIAL + "aprovado!");
    }
    
    public void reprovar(Orcamento orcamento) {
        throw new DomainException(FRASE_INICIAL + "reprovado!");
    }
    
    public void finalizar(Orcamento orcamento) {
        throw new DomainException(FRASE_INICIAL + "finalizado!");
    }

}