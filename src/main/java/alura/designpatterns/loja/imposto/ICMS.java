package alura.designpatterns.loja.imposto;

import alura.designpatterns.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class ICMS extends Imposto {
    
    public ICMS(Imposto outroImposto) {
        super(outroImposto);
    }
    
    public ICMS() {
    }
    
    @Override
    public BigDecimal realizarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }
}