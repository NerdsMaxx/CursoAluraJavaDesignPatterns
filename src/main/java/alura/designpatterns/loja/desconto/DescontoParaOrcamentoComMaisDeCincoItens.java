package alura.designpatterns.loja.desconto;

import alura.designpatterns.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoParaOrcamentoComMaisDeCincoItens extends Desconto {
    
    protected DescontoParaOrcamentoComMaisDeCincoItens(Desconto proximo) {
        super(proximo);
    }
    
    protected BigDecimal efetuarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }
    
    @Override
    protected boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getQuantidadeItens() > 5;
    }
}