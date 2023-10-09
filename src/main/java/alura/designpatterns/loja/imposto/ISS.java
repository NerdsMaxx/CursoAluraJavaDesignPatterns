package alura.designpatterns.loja.imposto;

import alura.designpatterns.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class ISS extends Imposto{
    
    public ISS(Imposto outroImposto) {
        super(outroImposto);
    }
    
    public ISS() {
    }
    
    @Override
    public BigDecimal realizarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.06"));
    }
}