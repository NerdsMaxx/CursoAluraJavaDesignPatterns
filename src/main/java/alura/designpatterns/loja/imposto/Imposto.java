package alura.designpatterns.loja.imposto;

import alura.designpatterns.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class Imposto {
    
    private Imposto outroImposto;
    
    public Imposto(Imposto outroImposto) {
        this.outroImposto = outroImposto;
    }
    
    public Imposto() {}
    
    protected abstract BigDecimal realizarCalculo(Orcamento orcamento);
    
    public BigDecimal calcular(Orcamento orcamento) {
        BigDecimal valorImposto = realizarCalculo(orcamento);
        Imposto proximo = outroImposto;
        
        //Isso lembra bastante lista encadeada
        while(proximo != null) {
            valorImposto = valorImposto.add(proximo.realizarCalculo(orcamento));
            proximo = proximo.outroImposto;
        }
        
        return valorImposto;
    }
}