package alura.designpatterns.loja.desconto;

import alura.designpatterns.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class Desconto {
    
    protected Desconto proximo;
    
    protected Desconto(Desconto proximo) {
        this.proximo = proximo;
    }
    
    public BigDecimal calcular(Orcamento orcamento) {
        return deveAplicar(orcamento) ? efetuarCalculo(orcamento)
                                      : proximo.calcular(orcamento);
    }
    
    protected abstract BigDecimal efetuarCalculo(Orcamento orcamento) ;
    protected abstract boolean deveAplicar(Orcamento orcamento);
}