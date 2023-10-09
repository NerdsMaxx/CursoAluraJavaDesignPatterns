package alura.designpatterns.loja.desconto;

import alura.designpatterns.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoParaOrcamentoComValorMaiorQueQuinhentos extends Desconto{
    
    protected DescontoParaOrcamentoComValorMaiorQueQuinhentos(Desconto proximo) {
        super(proximo);
    }
    
    protected BigDecimal efetuarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }
    
    @Override
    protected boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getValor().compareTo(new BigDecimal("500")) > 0;
    }
}