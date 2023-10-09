package alura.designpatterns.loja.desconto;

import alura.designpatterns.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeDescontos {
    
    public BigDecimal calcular(Orcamento orcamento) {
        return new DescontoParaOrcamentoComMaisDeCincoItens(
               new DescontoParaOrcamentoComValorMaiorQueQuinhentos(
               new SemDesconto()))
                .calcular(orcamento);
    }
}